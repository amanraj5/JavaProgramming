package USERSTORY1;
import java.util.*;

public class Electricity {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Customer> customers=new ArrayList<>();
        int choice;
        do {
            System.out.println("Enter 1 to add new customer.");
            System.out.println("Enter 2 to update email.");
            System.out.println("Enter 3 to delete customer.");
            System.out.println("Enter 4 to print all details.");
            System.out.println("Enter 5 to exit the program.");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    int id = sc.nextInt();
                    sc.nextLine();
                    int billNumber = sc.nextInt();
                    sc.nextLine();
                    String title = sc.nextLine();
                    String name = sc.nextLine();
                    String email = sc.nextLine();
                    String mobile = sc.nextLine();
                    String userId = sc.nextLine();
                    String password = sc.nextLine();
                    String confirmPassword = sc.nextLine();

                    customers.add(new Customer(id, billNumber, title, name, email, mobile, userId, password, confirmPassword));
                    System.out.println("Customer Registered Successfully.");
                    break;

                case 2:
                    System.out.println("Enter the consumer Id:");
                    int customerId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new email:");
                    String newEmail = sc.nextLine();
                    for (Customer c : customers) {
                        if (c.getId() == customerId) {
                            c.setEmail(newEmail);
                            System.out.println("Customer details are updated successfully.");
                            break;
                        }
                    }
                    System.out.println("Customer Id NOT FOUND in DATABASE!");
                    break;

                case 3:
                    System.out.println("Enter the customer id which you wants to be deleted:");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    Iterator<Customer> iterator = customers.iterator();
                    while (iterator.hasNext()) {
                        Customer c = iterator.next();
                        if (c.getId() == deleteId) {
                            iterator.remove();
                            System.out.println("Customer with ID " + deleteId + " has been deleted.");
                            break;
                        }
                    }
                    System.out.println("Customer Id NOT FOUND in DATABASE!");
                    break;
                case 4:
                    System.out.println("Customer Details:");
                    for (Customer c : customers) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }while(choice!=5);
        sc.close();
    }
}

class Customer {
    private int id;
    private int billNumber;
    private String title;
    private String name;
    private String email;
    private String mobile;
    private String userId;
    private String password;
    private String confirmPassword;

    public Customer(int id,int billNumber,String title,String name,String email,String mobile,String userId,String password,String confirmPassword){
        this.id=id;
        this.billNumber=billNumber;
        this.title=title;
        this.name=name;
        this.email=email;
        this.mobile=mobile;
        this.userId=userId;
        this.password=password;
        this.confirmPassword=confirmPassword;
    }

    public int getId(){
        return this.id;
    }

    void setEmail(String email){
        this.email=email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Bill Number: " + billNumber + ", Title: " + title + ", Name: " + name +
                ", Email: " + email + ", Mobile: " + mobile + ", User ID: " + userId;
    }
}
