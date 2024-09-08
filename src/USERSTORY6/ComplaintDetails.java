package USERSTORY6;

import java.util.Scanner;

public class ComplaintDetails {

    // Define a class to represent the complaint details
    static class Complaint {
        int consumerId;
        String customerName;
        String complaintType;
        String category;
        String problemDescription;
        String mobile;
        String status;

        Complaint(int consumerId, String customerName, String complaintType,
                  String category, String problemDescription,
                  String mobile, String status) {
            this.consumerId = consumerId;
            this.customerName = customerName;
            this.complaintType = complaintType;
            this.category = category;
            this.problemDescription = problemDescription;
            this.mobile = mobile;
            this.status = status;
        }

        @Override
        public String toString() {
            return consumerId + " | " + customerName + " | " + complaintType + " | "
                    + category + " | " + problemDescription + " | " + mobile + " | " + status;
        }
    }

    public static void main(String[] args) {
        // Preconfigured array of complaints
        Complaint[] complaints = {
                new Complaint(1, "John Doe", "Technical", "Internet", "Slow internet speed", "123-456-7890", "Resolved"),
                new Complaint(2, "Jane Smith", "Billing", "Overcharge", "Charged twice for the same service", "987-654-3210", "Pending"),
                new Complaint(3, "Jim Brown", "Technical", "Service Outage", "No service for the past 24 hours", "555-555-5555", "In Progress"),
                new Complaint(1, "John Doe", "Technical", "Modem Issue", "Modem not working", "123-456-7890", "Resolved")
        };

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Consumer ID to view complaints:");
        int consumerId = scanner.nextInt();

        boolean found = false;
        System.out.println("Consumer ID | CustomerName | Complaint Type | Category | Problem Description | Mobile | Status");
        for (Complaint complaint : complaints) {
            if (complaint.consumerId == consumerId) {
                // Display the details of the complaint
                System.out.println(complaint);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found for Consumer ID: " + consumerId);
        }

        scanner.close();
    }
}
