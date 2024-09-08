package USERSTORY4;

import java.util.*;

class Customer {
    private int consumerId;
    private String customerName;
    private String mobileNumber;
    private String email;

    // Constructor
    public Customer(int consumerId, String customerName, String mobileNumber, String email) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    // Getters
    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%-12d| %-12s| %-15s| %-20s", consumerId, customerName, mobileNumber, email);
    }
}

public class ConsumerSearch {
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        // Adding some pre-configured customers to the list
        customers.add(new Customer(101, "John Doe", "9876543210", "john@example.com"));
        customers.add(new Customer(102, "Jane Doe", "9876543211", "jane@example.com"));
        customers.add(new Customer(103, "Alice Smith", "9876543212", "alice@example.com"));
        customers.add(new Customer(104, "Bob Johnson", "9876543213", "bob@example.com"));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer ID to search: ");
        int consumerId = sc.nextInt();

        searchCustomerById(consumerId);

        sc.close();
    }

    // Method to search and display customer details based on Consumer ID
    private static void searchCustomerById(int consumerId) {
        boolean found = false;

        System.out.println("Consumer ID | Customer Name | Mobile Number  | Email");
        System.out.println("---------------------------------------------------------");

        for (Customer customer : customers) {
            if (customer.getConsumerId() == consumerId) {
                System.out.println(customer);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No customer found with Consumer ID: " + consumerId);
        }
    }
}

