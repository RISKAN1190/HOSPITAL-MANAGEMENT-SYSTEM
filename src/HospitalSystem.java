import java.util.Scanner;

public class HospitalSystem {
    private static PatientBST patientBST = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentStack = new TreatmentStack();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n==========================================");
            System.out.println("  Mini Hospital Emergency Management System");
            System.out.println("==========================================");
            System.out.println("1. Patient Records (BST)");
            System.out.println("2. Emergency Queue");
            System.out.println("3. Treatment History (Stack)");
            System.out.println("4. Patient Visit History (Linked List)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    patientRecordMenu();
                    break;
                case 2:
                    emergencyQueueMenu();
                    break;
                case 3:
                    treatmentHistoryMenu();
                    break;
                case 4:
                    patientVisitHistoryMenu();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void patientRecordMenu() {
        System.out.println("\n--- Patient Records (BST) ---");
        System.out.println("1. Insert Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                insertPatient();
                break;
            case 2:
                searchPatient();
                break;
            case 3:
                deletePatient();
                break;
            case 4:
                patientBST.inOrderTraversal();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void insertPatient() {
        System.out.print("Enter Patient ID: ");
        int id = getIntInput();
        System.out.print("Enter Patient Name: ");
        String name = getStringInput();
        System.out.print("Enter Age: ");
        int age = getIntInput();
        System.out.print("Enter Contact Number: ");
        String contact = getStringInput();
        System.out.print("Enter Medical Condition: ");
        String condition = getStringInput();
        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
    }

    private static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = getIntInput();
        Patient patient = patientBST.search(id);
        if (patient != null) {
            System.out.println("Patient found:");
            System.out.println(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = getIntInput();
        patientBST.delete(id);
    }

    private static void emergencyQueueMenu() {
        System.out.println("\n--- Emergency Queue ---");
        System.out.println("1. Add Patient to Queue (Enqueue)");
        System.out.println("2. Remove Patient from Queue (Dequeue)");
        System.out.println("3. Display Queue");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                enqueuePatient();
                break;
            case 2:
                emergencyQueue.dequeue();
                break;
            case 3:
                emergencyQueue.display();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void enqueuePatient() {
        System.out.print("Enter Patient ID: ");
        int id = getIntInput();
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records. Please register the patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    private static void treatmentHistoryMenu() {
        System.out.println("\n--- Treatment History (Stack) ---");
        System.out.println("1. Add Completed Treatment (Push)");
        System.out.println("2. Remove Latest Treatment (Pop)");
        System.out.println("3. View Latest Treatment (Peek)");
        System.out.println("4. Display All Treatments");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                pushTreatment();
                break;
            case 2:
                treatmentStack.pop();
                break;
            case 3:
                String record = treatmentStack.peek();
                if (record != null) {
                    System.out.println(record);
                }
                break;
            case 4:
                treatmentStack.display();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void pushTreatment() {
        System.out.print("Enter Treatment ID: ");
        int treatmentId = getIntInput();
        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput();
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Treatment Description: ");
        String description = getStringInput();
        System.out.print("Enter Treatment Date (e.g., 2026-09-01): ");
        String date = getStringInput();
        treatmentStack.push(treatmentId, patientId, patient.getName(), description, date);
    }

    private static void patientVisitHistoryMenu() {
        System.out.println("\n--- Patient Visit History (Singly Linked List) ---");
        System.out.println("1. Add Visit");
        System.out.println("2. Remove Visit");
        System.out.println("3. Search Visit");
        System.out.println("4. Display Visit History");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                addVisit();
                break;
            case 2:
                removeVisit();
                break;
            case 3:
                searchVisit();
                break;
            case 4:
                displayVisitHistory();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addVisit() {
        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput();
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID: ");
        int visitId = getIntInput();
        System.out.print("Enter Visit Date (e.g., 2026-09-01): ");
        String date = getStringInput();
        System.out.print("Enter Doctor Name: ");
        String doctor = getStringInput();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = getStringInput();
        System.out.print("Enter Treatment: ");
        String treatment = getStringInput();
        patient.getVisitHistory().addVisit(visitId, date, doctor, diagnosis, treatment);
    }

    private static void removeVisit() {
        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput();
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID to remove: ");
        int visitId = getIntInput();
        patient.getVisitHistory().removeVisit(visitId);
    }

    private static void searchVisit() {
        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput();
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID to search: ");
        int visitId = getIntInput();
        VisitNode visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit != null) {
            System.out.println("Visit found:");
            System.out.println(visit);
        } else {
            System.out.println("Visit not found.");
        }
    }

    private static void displayVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput();
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Visit history for " + patient.getName() + ":");
        patient.getVisitHistory().displayHistory();
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static String getStringInput() {
        return scanner.nextLine().trim();
    }
}
