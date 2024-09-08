package USERSTORY2;

import java.util.*;

class Bill {
    private int consumerNumber;
    private double dueAmount;
    private double payableAmount;

    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    // Getters and Setters
    public int getConsumerNumber() {
        return consumerNumber;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "Consumer Number: " + consumerNumber + ", Due Amount: " + dueAmount + ", Payable Amount: " + payableAmount;
    }
}

public class BillManager {
    private static List<Bill> billList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- Bill Management System ---");
            System.out.println("1. Add Bill");
            System.out.println("2. Update Amount Details");
            System.out.println("3. Delete Bill Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBill(sc);
                    break;
                case 2:
                    updateBillDetails(sc);
                    break;
                case 3:
                    deleteBillDetails(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void addBill(Scanner sc) {
        System.out.print("Enter Consumer Number: ");
        int consumerNumber = sc.nextInt();

        System.out.print("Enter Due Amount: ");
        double dueAmount = sc.nextDouble();

        System.out.print("Enter Payable Amount: ");
        double payableAmount = sc.nextDouble();

        Bill newBill = new Bill(consumerNumber, dueAmount, payableAmount);
        billList.add(newBill);
        System.out.println("Bill details are added successfully.");
    }

    private static void updateBillDetails(Scanner sc) {
        System.out.print("Enter Consumer Number to update: ");
        int consumerNumber = sc.nextInt();

        Bill bill = findBillByConsumerNumber(consumerNumber);
        if (bill != null) {
            System.out.print("Enter new Due Amount: ");
            double newDueAmount = sc.nextDouble();

            System.out.print("Enter new Payable Amount: ");
            double newPayableAmount = sc.nextDouble();

            bill.setDueAmount(newDueAmount);
            bill.setPayableAmount(newPayableAmount);
            System.out.println("Bill details are updated successfully.");
        } else {
            System.out.println("Bill not found for Consumer Number: " + consumerNumber);
        }
    }

    private static void deleteBillDetails(Scanner sc) {
        System.out.print("Enter Consumer Number to delete: ");
        int consumerNumber = sc.nextInt();

        Bill bill = findBillByConsumerNumber(consumerNumber);
        if (bill != null) {
            billList.remove(bill);
            System.out.println("Bill details are deleted successfully.");
        } else {
            System.out.println("Bill not found for Consumer Number: " + consumerNumber);
        }
    }

    private static Bill findBillByConsumerNumber(int consumerNumber) {
        for (Bill bill : billList) {
            if (bill.getConsumerNumber() == consumerNumber) {
                return bill;
            }
        }
        return null;
    }
}

