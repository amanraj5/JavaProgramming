/*
Create a class Motel with the below attributes:

motelId - int
motelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
cabFacility – String
totalBill- double

The above attributes should be private, write getters, setters and parameterized constructor as required.
Create class Solution with main method.
Implement one static method – totalNoOfRoomsBooked in Solution class.
totalNoOfRoomsBooked method:
This method will take two input parameter - array of Motel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Motel objects if the cab facility
attribute matches with the given String parameter(cab facility) and the number of rooms booked is
greater than 5.
If no rooms are booked with the above criteria in the array of Motel objects, then the method should return 0.
Note :No two Motel object would have the same motelId.
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)
The above mentioned static method should be called from the main method.
For totalNoOfRoomsBooked method - The main method should print the total number of booked rooms as it is, if the
returned value is greater than 0, else it should print "No such rooms booked"
Before calling these static methods in main, use Scanner object to read the values of four Motel objects referring
attributes in the above mentioned attribute sequence. Next, read the value of one String parameter for capturing
the cab facility

Input
___________
1001
M&M
01-Dec-2022
5
Yes
30000
1002
BestStay
10-Jan-2022
3
Yes
27000
1003
Novatel
11-Jun-2022
5
Yes
25000
1004
Chola
01-Sep-2022
7
Yes
72000
Yes

OutPut
7
 */


package Motel;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        Motel[] motels = new Motel[n];

        for(int i=0;i<n;i++){
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            String date = sc.nextLine();
            int rooms = sc.nextInt();sc.nextLine();
            String cab = sc.nextLine();
            double bill = sc.nextDouble();sc.nextLine();
            motels[i] = new Motel(id, name, date, rooms, cab, bill);
        }
        String facility = sc.nextLine();
        int ans = totalNoOfRoomsBooked(motels,facility);
        if(ans > 0){
            System.out.println(ans);
        }
        else{
            System.out.println("No such rooms booked");
        }
    }
    public static int totalNoOfRoomsBooked(Motel[] motels,String facility){
        for(Motel m: motels){
            if(m.getCab().equalsIgnoreCase(facility) && m.getNoOfRooms()>5)
                return m.getNoOfRooms();
        }
        return 0;
    }
}

class Motel {
    private int id;
    private String name;
    private String date;
    private int noOfRooms;
    private String cab;
    private double bill;

    public Motel(int id, String name, String date, int noOfRooms, String cab, double bill) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.noOfRooms = noOfRooms;
        this.cab = cab;
        this.bill = bill;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDate(){
        return this.date;
    }
    public int getNoOfRooms(){
        return this.noOfRooms;
    }
    public String getCab(){
        return this.cab;
    }
    public double getBill(){
        return this.bill;
    }
}
