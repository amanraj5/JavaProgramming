/*
create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parameter passed)
This method will return Average if found. if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.
 */
package CourseProgram;
import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();sc.nextLine();
        Course[] courses=new Course[N];
        for(int i=0;i<N;i++){
            int cId=sc.nextInt();sc.nextLine();
            String cName=sc.nextLine();
            String cAdmin=sc.nextLine();
            int quiz=sc.nextInt();sc.nextLine();
            int hson=sc.nextInt();sc.nextLine();
            courses[i]=new Course(cId,cName,cAdmin,quiz,hson);
        }
        String cAdmin=sc.nextLine();
        int h=sc.nextInt();

        int ans1=findAvgOfQuizByAdmin(courses,cAdmin);
        Course[] ans2=sortCourseByHandsOn(courses,h);

        if(ans1==0){
            System.out.println("No course found.");
        }
        else{
            System.out.println(ans1);
        }

        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getCourseName());
            }
        }
        else{
            System.out.println("No course found with mentioned attributes.");
        }

    }
    public static int findAvgOfQuizByAdmin(Course[] courses,String cAdmin){
        int avg=0,count=0;
        for(Course c : courses) {
            if(c.getCourseAdmin().equals(cAdmin)) {
                avg+=c.getQuiz();
                count++;
            }
        }
        if(count==0)
            return 0;
        return avg/count;
    }

    public static Course[] sortCourseByHandsOn(Course[] courses,int h){
        int cnt=0;
        for(Course c:courses){
            if(c.getHandson()<h) cnt++;
        }
        Course[] res=new Course[cnt];
        int idx=0;
        for(Course c:courses){
            if(c.getHandson()<h){
                res[idx++]=c;
            }
        }
        if(cnt==0)
            return null;
        return res;
    }
}
class Course {
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    public Course(int courseId,String courseName,String courseAdmin,int quiz,int handson) {
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.quiz=quiz;
        this.handson=handson;
    }

    public int getCourseId() {
        return this.courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId=courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public String getCourseAdmin(){
        return this.courseAdmin;
    }
    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin=courseAdmin;
    }
    public int getQuiz() {
        return this.quiz;
    }
    public void setQuiz(int quiz) {
        this.quiz=quiz;
    }
    public int getHandson() {
        return this.handson;
    }
    public void setHandson(int handson) {
        this.handson=handson;
    }
}
