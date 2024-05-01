package JavaOOPS;
import java.sql.SQLOutput;
import java.util.*;
public class Store {
    private String name;
    private float price;
    private int quantity;
    Store(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> mp=new HashMap<>();
        Scanner input = new Scanner(System.in);
        int N=input.nextInt();
        input.nextLine(); // Consume newline character
        float totalPrice=0;
        String product = "";
        float maxSales=0;
        for(int i=1;i<=N;i++){
            String n=input.nextLine();
            float p=input.nextFloat();
            int q=input.nextInt();
            input.nextLine(); // Consume newline character
            float sales=p*q;
            
            totalPrice+=sales;
            if(sales>maxSales){
                maxSales=sales;
                product=n;
            }
        }
        String newPrice=String.format("%.2f",totalPrice);
        String newAvg=String.format("%.2f",totalPrice/N);
        System.out.println("Total Sales: "+newPrice+" Average Sales: "+newAvg+" Most Buying Product: "+product);
    }
}

