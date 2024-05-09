/*
Create a class Hotel with the below attributes:

hotelId - int
hotelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
wifiFacility – String
totalBill- double

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods – noOfRoomsBookedInGivenMonth and searchHotelByWifiOption in Solution class.

noOfRoomsBookedInGivenMonth method:
This method will take two input parameter - array of Hotel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Hotel objects for the given month(String parameter passed).
If no rooms are booked for the given month in the array of Hotel objects, then the method should return 0.

searchHotelByWifiOption method:
This method will take two input parameter - array of Hotel objects and a String parameter
The method will return Hotel object with second highest totalbill, from the array of Hotel objects where wifiFacility attribute
matches with the given wifi facility(String parameter passed).
If no Hotel with the given wifi option is present in the array of Hotel objects, then the method should return null.

Note :
No two Hotel object would have the same hotelId.
No two Hotel object would have the same totalbill.
The Array either has at least two objects with specified wifi option OR  no object with specified wifi option.
All the searches should be case insensitive.
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)

The above mentioned static methods should be called from the main method.

For noOfRoomsBookedInGivenMonth method - The main method should print the total number of booked rooms as it is,
if the returned value is greater than 0, else it should print "No rooms booked in the given month"

For searchHotelByWifiOption method - The main method should print the hotelId from the returned Hotel object if the returned value is not null.
If the returned value is null then it should print "No such option available".

Before calling these static methods in main, use Scanner object to read the values of four Hotel objects referring attributes in the above mentioned attribute sequence.
Next, read the value of two String parameters for capturing the month and wifi option .

Consider below sample input and output:

Input1:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May
Yes

Output1:
5
103


Input2:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May1
Yes1

Output2:
No rooms booked in the given month
No such option available
*/

package Hotel;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        Hotel[] hotels = new Hotel[n];
        for (int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String date=sc.nextLine();
            int rooms=sc.nextInt();sc.nextLine();
            String wifi=sc.nextLine();
            double bill=sc.nextDouble();sc.nextLine();
            hotels[i]= new Hotel(id,name,date,rooms,wifi,bill);
        }
        String month=sc.nextLine();
        String wifi=sc.nextLine();

        int ans1=noOfRoomsBookedInGivenMonth(hotels,month);
        int ans2=searchHotelByWifiOption(hotels,wifi);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("No rooms booked in the given month");
        }
        if(ans2>0){
            System.out.println(ans2);
        }
        else{
            System.out.println("No such option available");
        }
    }
    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels,String month){
        int count=0;
        for(Hotel h: hotels){
            String date = h.getDate();
            if(date.contains(month)){
                count+=h.getNumberOfRooms();
            }
        }
        return count;
    }
    public static int searchHotelByWifiOption(Hotel[] hotels,String wifi){
        List<Double>  li = new ArrayList<>();
        for(Hotel h: hotels){
            if(h.getWifi().equalsIgnoreCase(wifi)){
                li.add(h.getBill());
            }
        }
        Collections.sort(li);
        int n = li.size();
        if(n<2)
            return 0;
        double secondHighest=li.get(n-2);
        for(Hotel h: hotels){
            if(h.getBill()==secondHighest)
                return h.getId();
        }
        return 0;
    }
}

class Hotel {
    private int id;
    private String name;
    private String date;
    private int numberOfRooms;
    private String wifi;
    private double bill;

    public Hotel(int id,String name,String date,int numberOfRooms,String wifi,double bill){
        this.id=id;
        this.name=name;
        this.date=date;
        this.numberOfRooms=numberOfRooms;
        this.wifi=wifi;
        this.bill=bill;
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
    public int getNumberOfRooms(){
        return this.numberOfRooms;
    }
    public String getWifi(){
        return this.wifi;
    }
    public double getBill(){
        return this.bill;
    }
}
