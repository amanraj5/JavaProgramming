/*
Create a class Book with below attributes

id - int
pages - int
title - String
author - String
price - double

The above attributes should be private, write getters and setters and parameterized constructor as required.

Create a class Solution with main method
--------------------------------------------
Implement two static methods - findBookWithMaximumPrice and searchBookByTitle in Solution class.

findBookWithMaximumPrice :
=============================
Create a static method findBookWithMaximumPrice in the Solution class. This method will take array of Book objects and
returns the Book object having the maximum Price if found else return null if not found.

searchBookByTitle :
=============================
Create a static method searchBookByTitle in the Solution class. This method will take array of Book objects and Title as
input and returns the Book object having the mentioned Title if found else return null if not found.

These methods should be called from the main method.

write code to perform the following tasks.

1. Take necessary input variable and call findBookWithMaximumPrice. For this method - The main method should print the Book
 object with the maximum of mentioned attribute as it is if the returned value is not null, or it should print
 "No Book found with mentioned attribute."

2. Take necessary input variable and call searchBookByTitle. For this method - The main method should print the Book object
details as it is, if the returned value is not null or it should print "No Book found with mentioned attribute."

The above mentioned static methods should be called from the main method. Also write the code for accepting the inputs and
printing the outputs. Don't use any static test or formatting for printing the result. Just invoke the method and print the
result.

All String comparison needs to be in case sensitive.

Input:

1
845
Bengali
Arijit
525.50
2
456
English
Raju
412.30
3
1022
History
Kaka
525.50
4
125
geography
MN
524
English

Output:

1 Bengali
3 History
2
456
 */


package Book;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        Book[] books = new Book[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            int page=sc.nextInt();sc.nextLine();
            String title=sc.nextLine();
            String author=sc.nextLine();
            double price=sc.nextDouble();sc.nextLine();
            books[i] = new Book(id,page,title,author,price);
        }
        String title = sc.nextLine();
        Book[] ans1 = findBookWithMaximumPrice(books);
        Book ans2 = searchBookByTitle(books,title);

        if(ans1!=null){
            for(int i=0;i<ans1.length;i++) {
                System.out.println(ans1[i].getId() + " " + ans1[i].getTitle());
            }
        }
        else{
            System.out.println("No Book found with mentioned attribute.");
        }
        if(ans2!=null){
            System.out.println(ans2.getId());
            System.out.println(ans2.getPage());
        }

    }
    public static Book[] findBookWithMaximumPrice(Book[] books){
        List<Double> li = new ArrayList<>();
        for(Book b:books){
            li.add(b.getPrice());
        }
        Collections.sort(li);
        int cnt=0;
        double maxPrice = li.get(li.size()-1);
        for(Book b:books){
            if(b.getPrice()==maxPrice)
                cnt++;
        }
        Book[] res = new Book[cnt];
        int ind = 0;
        for(Book b:books){
            if(b.getPrice()==maxPrice)
                res[ind++]=b;
        }

        return res;
    }
    public static Book searchBookByTitle(Book[] books,String title){
        for(Book b:books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }
}

class Book {
    private int id;
    private int page;
    private String title;
    private String author;
    private double price;

    public Book (int id,int page,String title,String author,double price){
        this.id=id;
        this.page=page;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public int getId(){
        return this.id;
    }
    public int getPage(){
        return this.page;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public double getPrice(){
        return this.price;
    }
}
