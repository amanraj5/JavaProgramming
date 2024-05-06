/*
Create the class RRT(Rapid response team) with the below attributes:
ticketNo-int
raisedBy-String
assignedTo-String
priority-int
project-String

All attributes should be private,write getters and setters and parameterized constructor as required.

Create class MyClass with main method. Implement a static method-getHighestPriorityTicket in MyClass class.
getHighestPriorityTicket method:
This method will take an array of RRT objects ,and a String value as parameters.This method will return the RRT
object with highest priority ticket from the array of the RRT objects for the given project(String parameter passed).
Highest priority is the one which has lesser value.

for example:1 is considered as high priority and 5 is considered as low priority.
If no RRT with the above condition is present in the array of the RRT objects,then the method should return null.
The main method should print the ticketNo,raisedBy and assignedTo from returned object if the returned object
is not null. if the returned object is null then main method should print "No such Ticket".

input1:
----------------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
AIG

output1:
------------------
234
Sathish
Akshaya

**************
Input2:
--------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
Xplore

output2:
--------------
No such ticket.
 */

package RapidResponseTeam;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        RRT[] obj = new RRT[n];
        for (int i = 0; i < n; i++) {
            int no = sc.nextInt();sc.nextLine();
            String raise = sc.nextLine();
            String assign = sc.nextLine();
            int priority = sc.nextInt();sc.nextLine();
            String project = sc.nextLine();
            obj[i] = new RRT(no,raise,assign,priority,project);
        }
        String givenProject = sc.nextLine();

        RRT ans = getHighestPriorityTicket(obj,givenProject);
        if(ans!=null){
            System.out.println(ans.getTno());
            System.out.println(ans.getRaisedBy());
            System.out.println(ans.getAssignedTo());
        }
        else{
            System.out.println("No such Ticket");
        }
    }
    public static RRT getHighestPriorityTicket(RRT[] r,String project){
        List<Integer> li = new ArrayList<>();
        for(RRT rt: r){
            if(rt.getProject().equals(project)){
                li.add(rt.getPriority());
            }
        }
        if(li.size()==0)
            return null;
        Collections.sort(li);
        int highestPriority = li.get(0);
        for(RRT rt : r){
            if(rt.getPriority() == highestPriority){
                return rt;
            }
        }
        return null;
    }
}

class RRT {
    private int tNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;

    RRT(int tNo,String raisedBy,String assignedTo,int priority,String project){
        this.tNo = tNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority=priority;
        this.project=project;
    }
    public int getTno() {
        return this.tNo;
    }
    public String getRaisedBy(){
        return this.raisedBy;
    }
    public String getAssignedTo(){
        return this.assignedTo;
    }
    public int getPriority(){
        return this.priority;
    }
    public String getProject(){
        return this.project;
    }
}
