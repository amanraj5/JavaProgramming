/*
Create a class named "Employee" with the following attributes:

id (int)
name (String)
designation (String)
salary (double)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Employee class:

getSalary(): This method should return the salary of the employee.
getDesignation(): This method should return the designation of the employee.

Create a class named "Company" with the following attributes:

companyName (String)
employees (Employee array)
numEmployees (int)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Company class:

getAverageSalary(): This method should return the average salary of all the employees in the company.
getMaxSalary(): This method should return the highest salary of all the employees in the company.
getEmployeesByDesignation(String designation): This method should return an array of all employees with the given designation.

In the main method, use a Scanner object to read the values of the company name, number of employees, and the employee details
(id, name, designation, and salary) in a loop. Once all employee details have been read, create a Company object and pass the
appropriate parameters. Finally, call the three methods mentioned above and print the output.

Note:

All searches should be case-insensitive.
You may assume that the input is valid and in the correct format.

Sample input:
---------------------
Enter company name: ABC Company
Enter number of employees: 3
Enter employee details:
Employee 1:
Enter id: 101
Enter name: John Smith
Enter designation: Manager
Enter salary: 5000
Employee 2:
Enter id: 102
Enter name: Jane Doe
Enter designation: Engineer
Enter salary: 4000
Employee 3:
Enter id: 103
Enter name: Bob Johnson
Enter designation: Engineer
Enter salary: 4500

Sample Output:
--------------------
Average salary: 4500.0
Max salary: 5000.0
Employees with designation: Engineer
ID: 102, Name: Jane Doe, Designation: Engineer, Salary: 4000.0
ID: 103, Name: Bob Johnson, Designation: Engineer, Salary: 4500.0
 */
package CompanyEmployee;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Company Name: ");
        String companyName = sc.nextLine();
        System.out.println("Enter Number of Employees: ");
        int N = sc.nextInt();sc.nextLine();
        Employee [] emp = new Employee[N];
        System.out.println("Enter Employee Details:");
        for(int i=0;i<N;i++){
            System.out.println("Employee "+(i+1));
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            String designation = sc.nextLine();
            double salary = sc.nextDouble();sc.nextLine();
            emp[i] = new Employee(id,name,designation,salary);
        }
        String designation = sc.nextLine();
        Company company = new Company(companyName,emp,N);
        double ans1 = company.getAverageSalary();
        double ans2 = company.getMaxSalary();
        System.out.println("Average Salary: "+ans1);
        System.out.println("Max Salary: "+ans2);
        System.out.println("Employees with Designation: "+designation);
        Employee[] ans = company.getEmployeesByDesignation(emp, designation);
        for (Employee employee : ans){
            System.out.println("Id: "+employee.getId()+", Name: "+employee.getName()+", Designation: "+employee.getDesignation()+", Salary: "+employee.getSalary());
        }
    }

}
class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public String getDesignation() {
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
}

class Company {
    private String companyName;
    private Employee[] employees;
    private int numEmployees;

    public Company(String companyName, Employee[] employees, int numEmployees) {
        this.companyName = companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }

    public double getAverageSalary() {
        double avgSalary = 0;
        for(int i=0;i<numEmployees;i++){
            avgSalary += employees[i].getSalary();
        }
        avgSalary/=numEmployees;
        return avgSalary;
    }
    public double getMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        for(Employee employee : employees){
            if(employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }
    public Employee[] getEmployeesByDesignation(Employee[] e,String designation) {
        int cnt = 0;
        for (Employee emp:e){
            if(emp.getDesignation().equals(designation))
                cnt++;
        }
        if(cnt == 0) return null;
        Employee[] ans=new Employee[cnt];
        int idx=0;
        for(Employee emp : e){
            if(emp.getDesignation().equals(designation)){
                ans[idx++]=emp;
            }
        }
        return ans;
    }
}
