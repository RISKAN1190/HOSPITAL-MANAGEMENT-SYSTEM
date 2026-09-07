public class PatientVisitHistory {
    private VisitNode head;

    public PatientVisitHistory() {
        this.head = null;
    }

    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newVisit = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newVisit;
        }
        System.out.println("Visit added successfully.");
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history found.");
            return false;
        }
        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return true;
        }
        VisitNode current = head;
        while (current.next != null && current.next.visitId != visitId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Visit not found.");
            return false;
        }
        current.next = current.next.next;
        System.out.println("Visit removed successfully.");
        return true;
    }

    public VisitNode searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visitId == visitId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }
        VisitNode current = head;
        System.out.println("--- Visit History ---");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
