package USERSTORY5;

import java.util.Scanner;


class Bill {
    private int consumerId;
    private String customerName;
    private double dueAmount;
    private double payableAmount;

    public Bill(int consumerId, String customerName, double dueAmount, double payableAmount) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public int getConsumerId(){
        return this.consumerId;
    }
    @Override
    public String toString() {
        return consumerId + " | " + customerName + " | " + dueAmount + " | " + payableAmount;
    }
}
public class UnpaidBillSearch {
    public static void main(String[] args) {
        // Preconfigured array of bills
        Bill[] bills = {
                new Bill(1, "John Doe", 100.0, 50.0),
                new Bill(2, "Jane Smith", 200.0, 150.0),
                new Bill(3, "Jim Brown", 300.0, 300.0),
                new Bill(1, "John Doe", 400.0, 400.0)
        };

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Consumer ID to search for unpaid bills:");
        int consumerId = scanner.nextInt();

        boolean found = false;
        System.out.println("Consumer ID | CustomerName | Due Amount | Payable Amount");
        for (Bill bill : bills) {
            if (bill.getConsumerId() == consumerId) {
                // Display the details of the unpaid bill
                System.out.println(bill);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No unpaid bills found for Consumer ID: " + consumerId);
        }

        scanner.close();
    }
}

