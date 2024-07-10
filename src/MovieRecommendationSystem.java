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
    for(int i=0;i<Math.min(5, movieList.size()); i++){
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
    switch(choice){
        case 1:
            System.out.print("Enter movie title");
            String title=scanner.nextLine();
            System.out.print("Enter movie director: ");
            String director = scanner.nextLine();
            System.out.print("Enter release year: ");
            int releaseYear = scanner.nextInt();
            addMovie(title, director, releaseYear);
            System.out.println("Movie added successfully!");
            break;
        case 2:
            System.out.print("Enter movie title to rate: ");
            String rateTitle = scanner.nextLine();
            System.out.print("Enter rating (out of 10): ");
            double newRating = scanner.nextDouble();
            rateMovie(rateTitle, newRating);
            break;
        case 3:
            System.out.print("Enter movie title to search: ");
            String searchTitle = scanner.nextLine();
            Movie foundMovie = searchMovie(searchTitle);
            if (foundMovie != null) {
                System.out.println("Movie found: " + foundMovie);
            } else {
                System.out.println("Movie not found.");
            }
            break;
        case 4:
            System.out.println("List of all movies:");
            displayMovies();
            break;
        case 5:
            displayTopRatedMovies();
            break;
        case 6:
            System.out.println("Exiting program...");
            break;
        default:
            System.out.println("Invalid choice. Please enter again.");
    }
}
public static void main(String[] args) {
    MovieRecommendationSystem system=new MovieRecommendationSystem();
    system.run();
}
}
