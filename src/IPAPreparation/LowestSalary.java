package IPAPreparation;
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
        Employee[] ans1=getEgetEmployeeWithSecondLowestSalary(emp);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getId()+"#"+ans1[i].getName());
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
    public static Employee[] getEgetEmployeeWithSecondLowestSalary(Employee[] e) {
        Employee[] ans=new Employee[1];
        if(e.length<2)
            return null;
        double firstMax = Double.MIN_VALUE;
        double secondMax = Double.MIN_VALUE;
        for(int i=0;i<e.length;i++){
            double salary=e[i].getSalary();
            if(salary>firstMax){
                secondMax=firstMax;
                firstMax=salary;
            }
            else if(salary>secondMax && salary!=firstMax){
                secondMax=salary;
            }
        }
        int idx=0;
        for(Employee emp:e){
            if(emp.getSalary()==secondMax){
                ans[idx]=emp;
            }
        }
        return ans;
    }
    public static int countEmployeesBasedOnAge(Employee [] e,int age) {

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
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}