public class EmergencyQueue {
    private class QueueNode {
        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.getPatientId() + " added to emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("Patient " + patient.getPatientId() + " removed from emergency queue.");
        return patient;
    }

    public Patient peek() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }
        return front.patient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        QueueNode current = front;
        System.out.println("--- Emergency Queue ---");
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }
}
