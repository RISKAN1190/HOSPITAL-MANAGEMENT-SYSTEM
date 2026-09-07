public class PatientBST {
    private class BSTNode {
        Patient patient;
        BSTNode left, right;

        BSTNode(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private BSTNode root;

    public PatientBST() {
        this.root = null;
    }

    public void insert(Patient patient) {
        root = insertRec(root, patient);
        System.out.println("Patient " + patient.getPatientId() + " inserted successfully.");
    }

    private BSTNode insertRec(BSTNode root, Patient patient) {
        if (root == null) {
            return new BSTNode(patient);
        }
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists.");
            return root;
        }
        return root;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(BSTNode root, int patientId) {
        if (root == null) {
            return null;
        }
        if (patientId == root.patient.getPatientId()) {
            return root.patient;
        }
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return;
        }
        root = deleteRec(root, patientId);
        System.out.println("Patient ID " + patientId + " deleted successfully.");
    }

    private BSTNode deleteRec(BSTNode root, int patientId) {
        if (root == null) {
            return root;
        }
        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.patient = findMin(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient findMin(BSTNode root) {
        Patient min = root.patient;
        while (root.left != null) {
            min = root.left.patient;
            root = root.left;
        }
        return min;
    }

    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        System.out.println("--- Patient Records (Sorted by ID) ---");
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}
