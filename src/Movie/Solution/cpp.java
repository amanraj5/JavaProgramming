/*
Create class Movie with below attributes:

movieName - String
company - String
genre - String
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie
objects where the searchGenre String matches with the original array of Movie object's genre attribute
(case-insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
*/


package Movie.Solution;
import java.util.*;
public class cpp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Movie[] movies=new Movie[4];
        for(int i=0;i<4;i++){
            String n=sc.nextLine();
            String c=sc.nextLine();
            String g=sc.nextLine();
            int b=sc.nextInt();sc.nextLine();

            movies[i]=new Movie(n,c,g,b);
        }
        String genre = sc.nextLine();
        List<Movie> ans=getMovieByGenre(movies,genre);

        for(Movie m:ans){
            if(m.getBudget()>80000000){
                System.out.println("High Budget Movie");
            }
            else{
                System.out.println("Low Budget Movie");
            }
        }
    }
    public static List<Movie> getMovieByGenre(Movie[] movies,String searchGenre){
        List<Movie> li=new ArrayList<>();
        for(Movie m:movies){
            if(m.getGenre().equalsIgnoreCase(searchGenre)){
                li.add(m);
            }
        }
        return li;
    }
}

class Movie {
    private String name;
    private String comp;
    private String genre;
    private int budget;

    public Movie(String name,String comp,String genre,int budget) {
        this.name=name;
        this.comp=comp;
        this.genre=genre;
        this.budget=budget;
    }

    public String getName(){
        return this.name;
    }
    public String getComp(){
        return this.comp;
    }
    public String getGenre(){
        return this.genre;
    }
    public int getBudget(){
        return this.budget;
    }
}
