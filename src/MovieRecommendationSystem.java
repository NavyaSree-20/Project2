package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MovieRecommendationSystem {
    private List<Movie> movieList;
    private Scanner scanner;
public MovieRecommendationSystem(){
    movieList=new ArrayList<>();
    scanner=new Scanner(System.in);
}
public void addMovie(String title,String director,int releaseYear){
    Movie newMovie=new Movie(title,director,releaseYear);
    movieList.add(newMovie);
}
public void rateMovie(String title,double rating){
    Movie movie=searchMovie(title);
    if(movie!=null){
        movie.addRating(rating);
        System.out.println("Rating added");
    }
    else{
        System.out.println("Movie not added");
    }
}
public Movie searchMovie(String title){
    for(Movie movie:movieList){
        if(movie.getTitle().equalsIgnoreCase(title)){
            return movie;
        }
    }
    return null;
}
public void displayMovies(){
    for(Movie movie:movieList){
        System.out.println(movie);
    }
}
public void displayTopRatedMovies(){
    System.out.println("Top rated movies");
    for(int i=0;i<Math.min(5, movieList.size())); i++){
        System.out.println(movieList.get(i));
    }
}
public void run(){
    int choice=0;
    while(choice!=6){
        System.out.println("Movie Recommendation System");
        System.out.println("1.Add a movie");
        System.out.println("2.Rate a movie");
        System.out.println("3.Search");
        System.out.println("4.Display all");
        System.out.println("5.Display TopRated");
        System.out.println("6.Exit");
        System.out.print("Enter");
        choice=scanner.nextInt();
        scanner.nextLine();
    }
}
}
