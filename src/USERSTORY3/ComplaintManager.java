package USERSTORY3;

import java.util.*;

class Complaint {
    private static int idCounter = 1; // Auto-incremented complaint ID
    private int complaintId;
    private String complaintType;
    private String category;
    private String landmark;
    private String customerName;
    private String problem;
    private int consumerNumber;
    private String address;
    private String mobileNumber;

    // Constructor
    public Complaint(String complaintType, String category, String landmark, String customerName, String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintId = idCounter++;
        this.complaintType = complaintType;
        this.category = category;
        this.landmark = landmark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public int getComplaintId() {
        return complaintId;
    }

    @Override
    public String toString() {
        return "Complaint ID: " + complaintId + ", Complaint Type: " + complaintType + ", Category: " + category +
                ", Landmark: " + landmark + ", Customer Name: " + customerName + ", Problem: " + problem +
                ", Consumer Number: " + consumerNumber + ", Address: " + address + ", Mobile Number: " + mobileNumber;
    }
}

public class ComplaintManager {
    private static List<Complaint> complaintList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- Complaint Management System ---");
            System.out.println("1. Register Complaint");
            System.out.println("2. Delete Complaint");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerComplaint(sc);
                    break;
                case 2:
                    deleteComplaint(sc);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Method to register a new complaint
    private static void registerComplaint(Scanner sc) {
        System.out.println("Enter Complaint Type: ");
        String complaintType = sc.nextLine();

        System.out.println("Enter Category: ");
        String category = sc.nextLine();

        System.out.println("Enter Landmark: ");
        String landmark = sc.nextLine();

        System.out.println("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.println("Enter Problem: ");
        String problem = sc.nextLine();

        System.out.println("Enter Consumer Number: ");
        int consumerNumber = sc.nextInt(); sc.nextLine(); // Consume newline

        System.out.println("Enter Address: ");
        String address = sc.nextLine();

        System.out.println("Enter 10-digit Mobile Number: ");
        String mobileNumber = sc.nextLine();

        // Basic validation to check if mobile number is 10 digits
        if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
            System.out.println("Invalid mobile number. Please enter a valid 10-digit number.");
            return;
        }

        // Create a new Complaint object and add it to the complaint list
        Complaint newComplaint = new Complaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
        complaintList.add(newComplaint);
        System.out.println("Successfully registered Complaint.");
    }

    // Method to delete a complaint by complaint ID
    private static void deleteComplaint(Scanner sc) {
        System.out.print("Enter Complaint ID to delete: ");
        int complaintId = sc.nextInt();
        sc.nextLine();  // Consume newline

        boolean found = false;
        Iterator<Complaint> iterator = complaintList.iterator();
        while (iterator.hasNext()) {
            Complaint complaint = iterator.next();
            if (complaint.getComplaintId() == complaintId) {
                iterator.remove();
                found = true;
                System.out.println("Complaint details are deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Complaint with ID " + complaintId + " not found.");
        }
    }
}

