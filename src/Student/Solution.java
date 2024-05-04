/*
Create a class called Student with the below attributes:

rollNo - int
name - String
branch - String
score - double
dayScholar - boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods -findCountOfDayscholarStudents  and findStudentwithSecondHighestScore in Solution
class.

findCountOfDayscholarStudents:

This method will take an array of Student objects as an input parameter . This method will calculate and return
the count of Students whose score is greater than 80 and who are all from dayScholar.

If no Student scored greater than 80 and from dayScholar are present in the array of Student objects, then the
method should return 0.

findStudentwithSecondHighestScore:

This method will take an array of Student objects as an input parameter. This method will return the object
of the second highest score student from the array of Student objects who are not from the dayScholar.

If no Student is a dayScholar  in the array of Student objects, then the method should return null.

Note : All the searches should be case insensitive.

The combination of dayScholar and score for each student is always unique.

The above mentioned static methods should be called from the main method.

For findCountOfDayscholarStudents method - The main method should print the returned count as it is
if the returned value is greater than 0, else it should print "There are no such dayscholar students".

For findStudentwithSecondHighestScore method - The main method should print the rollNo, name and score
in the below format from the returned object if the retuned value is not null.

rollNo#name#score

If the returned value is null, then it should print ”There are no student from non day scholar”

Before calling these static methods in main, use Scanner object to read the values of four Student
objects referring attributes in the above mentioned attribute sequence.
Consider below sample input and output:

Input:

1001
Ashwa
IT
85
true
1002
Preeti
IT
70
false
1003
Uma
ECE
85
false
1004
Akash
EEE
90
true


Output:
2
1002#Preeti#70.0
 */

package Student;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Student[] students=new Student[n];

        for(int i=0;i<n;i++){
            int roll=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String branch=sc.nextLine();
            double score=sc.nextDouble();sc.nextLine();
            boolean scholar=sc.nextBoolean();
            students[i]=new Student(roll,name,branch,score,scholar);
        }

        int ans1=findCountOfDayscholarStudents(students);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("There are no such dayscholar students");
        }

        Student ans2 = findStudentwithSecondHighestScore(students);
        if(ans2!=null){
            System.out.println(ans2.getrNo()+"#"+ans2.getName()+"#"+ans2.getScore());
        }
        else{
            System.out.println("There are no student from non day scholar");
        }
    }
    public static int findCountOfDayscholarStudents(Student[] student){
        int count=0;
        for(Student s:student){
            double score=s.getScore();
            boolean scholar=s.getScholar();
            if(score>80 && scholar){
                count++;
            }
        }
        return count;
    }

    public static Student findStudentwithSecondHighestScore(Student[] s){
        int cnt = 0;
        for(Student student:s){
            boolean bool = student.getScholar();
            if(!bool){
                cnt++;
            }
        }
        Student[] res = new Student[cnt];
        int idx = 0;
        for(Student student : s){
            if(!student.getScholar()){
                res[idx]=student;
                idx++;
            }
        }
        double first = Double.MIN_VALUE;
        double second = Double.MIN_VALUE;
        for(Student student : res){
            double score=student.getScore();
            if(score>first){
                second = first;
                first = score;
            }
            else if(score>second && score!=first){
                second = score;
            }
        }
        for(Student student : res){
            if(student.getScore() == second){
                return student;
            }
        }
        return null;
    }
}

class Student {
    private int rNo;
    private String name;
    private String branch;
    private double score;
    private boolean scholar;

    public Student(int rNo,String name,String branch,double score,boolean scholar) {
        this.rNo = rNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.scholar = scholar;
    }

    public int getrNo(){
        return this.rNo;
    }
    public String getName(){
        return this.name;
    }
    public String getBranch(){
        return this.branch;
    }
    public double getScore(){
        return this.score;
    }
    public boolean getScholar(){
        return this.scholar;
    }
}
