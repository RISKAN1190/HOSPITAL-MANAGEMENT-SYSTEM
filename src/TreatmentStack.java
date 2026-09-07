public class TreatmentStack {
    private class StackNode {
        int treatmentId;
        int patientId;
        String patientName;
        String treatmentDescription;
        String treatmentDate;
        StackNode next;

        StackNode(int treatmentId, int patientId, String patientName, String treatmentDescription, String treatmentDate) {
            this.treatmentId = treatmentId;
            this.patientId = patientId;
            this.patientName = patientName;
            this.treatmentDescription = treatmentDescription;
            this.treatmentDate = treatmentDate;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Treatment ID: " + treatmentId + " | Patient ID: " + patientId +
                   " | Patient: " + patientName + " | Treatment: " + treatmentDescription +
                   " | Date: " + treatmentDate;
        }
    }

    private StackNode top;

    public TreatmentStack() {
        this.top = null;
    }

    public void push(int treatmentId, int patientId, String patientName, String treatmentDescription, String treatmentDate) {
        StackNode newNode = new StackNode(treatmentId, patientId, patientName, treatmentDescription, treatmentDate);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record pushed successfully.");
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }
        String record = top.toString();
        top = top.next;
        System.out.println("Treatment record popped successfully.");
        return record;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }
        return top.toString();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return;
        }
        System.out.println("--- Treatment History (Most Recent First) ---");
        StackNode current = top;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
