/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Movies {

    private String title;
    private String genre;
    private String language;
    private double rating;
    private int duration;
    private String description;
    private int movie_id;

    public static ArrayList<Movies> movie_list = new ArrayList<>();
    public static int current_id = 1;
    public static boolean movieDeletion = false;

    public Movies(String title, String genre, String language, double rating, int duration, String description, int movie_id) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.movie_id = movie_id;

        movie_list.add(this);
        current_id++;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public int getMovieId() {
        return movie_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMovieId(int movie_id) {
        this.movie_id = movie_id;
    }

    public static boolean validateMovie(int currentMovie) {
        for (Movies m : Movies.movie_list) {
            if (m.getMovieId() == currentMovie) {
                return true;
            }
        }
        System.out.println("\nNo movie found. Please ensure you have typed the correct movie number.\n");
        return false;
    }

    public static void editMovie(int currentMovie, int editType) {
        Scanner input = new Scanner(System.in);
        for (Movies m : Movies.movie_list) {
            if (m.getMovieId() == currentMovie) {

                switch (editType) {
                    case 1:
                        System.out.print("\nType new title: ");
                        String newTitle = input.nextLine();
                        m.setTitle(newTitle);
                        break;
                    case 2:
                        System.out.print("\nType new genre: ");
                        String newGenre = input.nextLine();
                        m.setGenre(newGenre);
                        break;
                    case 3:
                        System.out.print("\nType new language: ");
                        String newLanguage = input.nextLine();
                        m.setLanguage(newLanguage);
                        break;
                    case 4:
                        System.out.print("\nType new rating (double): ");
                        double newRating = input.nextDouble();
                        m.setRating(newRating);
                        break;
                    case 5:
                        System.out.print("\nType new duration (int): ");
                        int newDuration = input.nextInt();
                        m.setDuration(newDuration);
                        break;
                    case 6:
                        System.out.print("\nType new description: ");
                        String newDesc = input.nextLine();
                        m.setDescription(newDesc);
                        break;
                }
            }
        }
    }

    public static void deleteMovie(int currentMovie) {

        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure to delete this movie? (will cause inconsistent ticket information) [Y/N]: ");
        char confirmation = input.next().charAt(0);

        if (confirmation == 'Y' || confirmation == 'y') {
            Movies.movie_list.remove(currentMovie - 1);
            movieDeletion = true;
            System.out.println("\nSuccessfully deleted the movie.\n");
        } else if (confirmation == 'N' || confirmation == 'n') {
            System.out.println("\nOperation is cancelled.\n");
        } else {
            System.out.println("\nInvalid option. Operation is cancelled.\n");
        }

    }

    public static void showAllMovies() {
        int currentNum = 1;
        for (Movies m : Movies.movie_list) {
            System.out.println("\nMOVIE [" + currentNum + "]");
            System.out.println("Title: " + m.getTitle());
            System.out.println("Genre: " + m.getGenre());
            System.out.println("Language: " + m.getLanguage());
            System.out.println("Rating: " + m.getRating() + " / 10");
            System.out.println("Duration: " + m.getDuration() + "m");
            System.out.println("Description: " + m.getDescription());

            System.out.println("\n--------------------\n");
            currentNum++;
        }
    }
}
