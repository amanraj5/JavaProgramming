/*
Create a class Player with below attributes:

playerId - int
skill - String
level - String
points - int

Write getters, setters and parameterized constructor in the above mentioned attribute
sequence as required.

Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.

findPointsForGivenSkill method:
------------------------------------
This method will take two input parameters - array of Player objects
and string parameter skill. The method will return the sum of the points attribute from player objects
for the skill passed as parameter. If no player with the given skill is present in the array of player
objects, then the method should return 0.

getPlayerBasedOnLevel method:
-------------------------------------
This method will take two String parameters level and skill, along with the array of Player objects.
The method will return the player object, if the input String parameters matches with the level and
skill attribute of the player object and its point attribute is greater than or equal to 20. If any
of the conditions are not met, then the method should return null.

Note : No two player object would have the same value for skill and level attribute. All player object
would have the points greater than 0. All the searches should be case-insensitive.

These above-mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned
price is greater than 0, or it should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object.
If the returned value is null then it should print "No player is available with specified level, skill
and eligibility points".

Before calling these static methods in main, use Scanner object to read the values of four Player objects
referring attributes in the above-mentioned attribute sequence. Next, read the value for skill and level.
Please consider the skill value read above as skill parameter for both the static methods.

Input:
-----------
101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate

Output:
--------------
45
102
*/


package Player;
import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Player[] players=new Player[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String skill=sc.nextLine();
            String level=sc.nextLine();
            int point=sc.nextInt();sc.nextLine();
            players[i]=new Player(id,skill,level,point);
        }
        String skill=sc.nextLine();
        String level=sc.nextLine();
        int ans1=findPointsForGivenSkill(players,skill);
        List<Player> ans2=getPlayerBasedOnLevel(players,level,skill);

        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("The given Skill is not available");
        }
        if(ans2!=null){
            for(Player p:ans2){
                System.out.println(p.getId());
            }
        }
        else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }
    public static int findPointsForGivenSkill(Player[] players,String skill) {
        int ans=0;
        for(Player p:players){
            if(p.getSkill().equalsIgnoreCase(skill)){
                ans+=p.getPoint();
            }
        }
        return ans;
    }
    public static List<Player> getPlayerBasedOnLevel(Player[] players,String level,String skill) {
        List<Player> li=new ArrayList<>();
        for(Player p:players){
            if(p.getLevel().equalsIgnoreCase(level) && p.getSkill().equalsIgnoreCase(skill) && p.getPoint()>20){
                li.add(p);
            }
        }
        if(li.size()==0)
            return null;
        return li;
    }
}

class Player {
    private int id;
    private String skill;
    private String level;
    private int point;

    public Player(int id,String skill,String level,int point){
        this.id=id;
        this.skill=skill;
        this.level=level;
        this.point=point;
    }
    public int getId(){
        return this.id;
    }
    public String getSkill(){
        return this.skill;
    }
    public String getLevel(){
        return this.level;
    }
    public int getPoint(){
        return this.point;
    }
}
