package JavaBasics;
import java.util.Scanner;
public class sumInput {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the first Number:");
        int num1= sc.nextInt();
        System.out.println("Enter the second Number:");
        int num2=sc.nextInt();
        int sum=num2+num1;
        System.out.println("The sum of two number is "+sum);
    }
}
