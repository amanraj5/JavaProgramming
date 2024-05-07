/*
Create a class Sim with below attributes:
simId - int
customerName - String
balance - double
ratePerSecond - double
circle - String

Write getters, setters and parameterized constructor as required.

Public class Solution is already created with main method.

Code inside main method should not be altered else your solution might be scored as zero.You may copy the code
from main method in eclipse to verify your implementation.

Implement static method - transferCustomerCircle in Solution class.

This method will take first parameter as array of Sim class objects, second parameter as circle to be transferred
(which is String parameter circle1) and third parameter as new circle (which is String parameter circle2).

Method will transfer the customer to new circle (circle2), where the circle attribute would match second parameter (circle1).

Method will return array of Sim objects for which circle is transferred.
Return array should be sorted in descending order of ratePerSecond (assuming ratePerSecond is not same for any of the Sim objects).

This method should be called from main method and display the simId, customerName,circle and ratePerSecond of
returned objects (as per sample output).

Main method mentioned above already has Scanner code to read values, create objects and test above methods. Hence do not modify it.
************************************************************************
Consider below sample input and output:
Input:

1
raj
100
1.5
KOL
2
chetan
200
1.6
AHD
3
asha
150
1.7
MUM
4
kiran
50
2.2
AHD
5
vijay
130
1.8
AHD
AHD
KOL

Output:
4 kiran KOL 2.2
5 vijay KOL 1.8
2 chetan KOL 1.6
*/

package Sim;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        Sim[] sim = new Sim[n];
        for(int i=0 ; i<n ; i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            double balance=sc.nextDouble();sc.nextLine();
            double rate=sc.nextDouble();sc.nextLine();
            String circle=sc.nextLine();
            sim[i]=new Sim(id,name,balance,rate,circle);
        }
        String circle1=sc.nextLine();
        String circle2=sc.nextLine();
        Sim[] ans = transferCustomerCircle(sim,circle1,circle2);

        for(int i= ans.length-1 ; i>=0 ; i--){
            System.out.println(ans[i].getId()+" "+ans[i].getName()+" "+circle2+" "+ans[i].getPower());
        }

    }
    public static Sim[] transferCustomerCircle(Sim[] sim,String c1,String c2){
        int cnt = 0;
        for(Sim s : sim){
            if(s.getCircle().equalsIgnoreCase(c1)){
                cnt++;
            }
        }
        Sim[] ans = new Sim[cnt];
        int idx=0;
        for(Sim s : sim) {
            if(s.getCircle().equalsIgnoreCase(c1)){
                ans[idx++] = s;
            }
        }
        for(int i=0 ; i<cnt ; i++){
            for(int j=i+1 ; j<cnt ; j++){
                if(ans[i].getPower()>ans[j].getPower()){
                    Sim temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        if(cnt>0){
            return ans;
        }
        else {
            return null;
        }
    }
}

class Sim {
    private int id;
    private String name;
    private double balance;
    private double power;
    private String circle;

    public Sim(int id,String name,double balance,double power,String circle) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.power = power;
        this.circle = circle;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getBalance() {
        return this.balance;
    }
    public double getPower() {
        return this.power;
    }
    public String getCircle() {
        return this.circle;
    }
}