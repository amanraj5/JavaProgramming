/*
Create a class College with the below attributes.
 id-int
 name -String
 contactNo-int
 address-String
 pinCode-int

Write the getters and setters and parametrized constructor in the above-mentioned sequence as required.

Create the class Solution with the main method.
Implement the two static methods:
 1.findCollegeWithMaximumPincode
 2.searchCollegeByAddress

findCollegeWithMaximumPin code method:
Create the Static method in the Solution Class. This method will take array of the College objects and return the
College object having maximum pin code if found else return null if not found.
for this method ,main method will print College object with maximum pin code if the returned value is not null.
if the returned value is null ,then the main method will print "No college found with mentioned attribute".

searchCollegeByAddress method:
Create the Static method in the Solution Class. This method will take array of College objects as input and address
as input and return College object having the mentioned address if found else return null if not found.
for this method main method will print College object details as it is ,if the returned value is not null.
if the returned value is null then ,main method will print "No college found with mentioned attribute".

***************************************************************************
input 1:

4
109
ACT
2500256
mumbai
695001
107
MCE
2500254
malapuram
612354
113
CTE
2500252
chennai
623145
102
SCT
2500255
AP
523641
AP

OUTPUT1:

id-109
name-ACT
contactNo-2500256
address-mumbai
pincode-695001
id-102
name-SCT
contactNo-2500255
address-AP
pincode-523641

INPUT2:
4
111
MJT
2500251
Calicut
401235
105
MET
2500256
kochi
668745
115
IIT
2500262
banglore
569874
110
ACT
2500263
delhi
687945
delhi

output2:
id-110
name-ACT
contactNo-2500263
address-delhi
pincode-687945
id-110
name-ACT
contactNo-2500263
address-delhi
pincode-687945
*/

package College;
import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        College[] clg = new College[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            int cNo=sc.nextInt();sc.nextLine();
            String address=sc.nextLine();
            int pCode=sc.nextInt();sc.nextLine();
            clg[i]=new College(id,name,cNo,address,pCode);
        }
        String address=sc.nextLine();

        College ans1=findCollegeWithMaximumPincode(clg);
        College ans2=searchCollegeByAddress(clg,address);

        if(ans1!=null){
            System.out.println("id-"+ans1.getId());
            System.out.println("name-"+ans1.getName());
            System.out.println("contact-no-"+ans1.getContactNo());
            System.out.println("address-"+ans1.getAddress());
            System.out.println("pincode-"+ans1.getPinCode());
        }
        else{
            System.out.println("No college found with mentioned attribute");
        }
        if(ans2!=null){
            System.out.println("id-"+ans2.getId());
            System.out.println("name-"+ans2.getName());
            System.out.println("contact-no-"+ans2.getContactNo());
            System.out.println("address-"+ans2.getAddress());
            System.out.println("pincode-"+ans2.getPinCode());
        }
        else{
            System.out.println("No college found with mentioned attribute");
        }
    }
    public static College findCollegeWithMaximumPincode(College[] c){
        int n=c.length;
        int[] pCode=new int[n];
        for(int i=0;i<n;i++){
            int code=c[i].getPinCode();
            pCode[i]=code;
        }
        Arrays.sort(pCode);
        for(College clg:c){
            if(clg.getPinCode()==pCode[n-1]){
                return clg;
            }
        }
        return null;
    }
    public static College searchCollegeByAddress(College[] c,String address){
        for(College clg:c){
            if(clg.getAddress().equalsIgnoreCase(address))
                return clg;
        }
        return null;
    }
}

class College {
    private int id;
    private String name;
    private int contactNo;
    private String address;
    private int pinCode;

    public College(int id,String name,int contactNo,String address,int pinCode){
        this.id=id;
        this.name=name;
        this.contactNo=contactNo;
        this.address=address;
        this.pinCode=pinCode;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getContactNo(){
        return this.contactNo;
    }
    public String getAddress(){
        return this.address;
    }
    public int getPinCode(){
        return this.pinCode;
    }
}
