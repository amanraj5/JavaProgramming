/*
Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
4
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2
*/
package SecondHighestSalary;
import java.util.*;

public class LowestSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();sc.nextLine();
        Employee[] emp = new Employee[N];
        for(int i=0;i<N;i++){
            int id=sc.nextInt();sc.nextLine();
            String n=sc.nextLine();
            int a=sc.nextInt();sc.nextLine();
            char g=sc.next().charAt(0);sc.nextLine();
            double s=sc.nextDouble();sc.nextLine();

            emp[i]=new Employee(id,n,a,g,s);
        }
        int age=sc.nextInt();
        Employee[] ans1 = getEmployeeWithSecondLowestSalary(emp);
        if(ans1!=null){
            for (Employee employee : ans1) {
                System.out.println(employee.getId() + "#" + employee.getName());
            }
        }
        else{
            System.out.println("Null");
        }
        int ans2=countEmployeesBasedOnAge(emp,age);
        if(ans2>0){
            System.out.println(ans2);
        }
        else{
                System.out.println("No employee found for the given age");
        }
    }
    public static Employee[] getEmployeeWithSecondLowestSalary(Employee[] e) {
        Employee[] ans=new Employee[1];
        if(e.length<2)
            return null;
        double firstMax = Double.MIN_VALUE;
        double secondMax = Double.MIN_VALUE;
        for(int i=0;i<e.length;i++){
            double salary = e[i].getSalary();
            if(salary > firstMax){
                secondMax = firstMax;
                firstMax = salary;
            }
            else if(salary > secondMax && salary != firstMax){
                secondMax = salary;
            }
        }
        int idx = 0;
        for(Employee emp:e){
            if(emp.getSalary() == secondMax){
                ans[idx] = emp;
            }
        }
        return ans;
    }
    public static int countEmployeesBasedOnAge(Employee[] e, int age) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<e.length;i++){
            int a=e[i].getAge();
            map.put(a,map.getOrDefault(a,0)+1);
        }
        if(map.containsKey(age))
            return map.get(age);
        return 0;
    }
}
class Employee {
    private int id;
    private String name;
    private int age;
    private char gender;
    private double salary;

    public Employee(int id, String name, int age, char gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return this.gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}