/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

/**
 *
 * @author User
 */
public class Seats extends Movies {

    private boolean[] standardSeats;
    private boolean[] vipSeats;

    private int standardSale = 0;
    private int vipSale = 0;
    
    public Seats(String title, String genre, String language, double rating, int duration, String description, int movie_id) {
        super(title, genre, language, rating, duration, description, movie_id);
        this.standardSeats = new boolean[40];
        this.vipSeats = new boolean[20];
    }

    public void showAllStandardSeats() {
        System.out.println("\n---------- STANDARD SEAT AVAILABILITY ----------\n");
        for (int i = 0; i < standardSeats.length; i++) {
            if (standardSeats[i] == true) {
                System.out.print("[ -- ]\t");
            } else {
                if ((i + 1) <= 9) {
                    System.out.print("[ 0" + (i + 1) + " ]\t");
                } else {
                    System.out.print("[ " + (i + 1) + " ]\t");
                }
            }

            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void showAllVipSeats() {
        System.out.println("\n---------- PREMIUM SEAT AVAILABILITY ----------\n");
        for (int i = 0; i < vipSeats.length; i++) {
            if (vipSeats[i] == true) {
                System.out.print("[ -- ]\t");
            } else {
                System.out.print("[ " + (i + 41) + " ]\t");
            }

            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void setSeat(int currentMovie, int currentSeat) {
       for (Movies m : Movies.movie_list) {
            if (m.getMovieId() == currentMovie) {
                if (m instanceof Seats s) {
                    if (currentSeat >= 1 && currentSeat <= 40) {
                        s.standardSeats[currentSeat - 1] = true;
                        s.standardSale++;
                    } else if (currentSeat >= 41 && currentSeat <= 60) {
                        s.vipSeats[currentSeat - 41] = true;
                        s.vipSale++;
                    }
                }
            }
        }
    }
    
    public static void showSales() {
        
        double totalStandard = 0.00;
        double totalPremium = 0.00;
        
        System.out.println("\n---------- MOVIE SALES ----------\n");
        System.out.printf("%-20s %10s %10s\n", "MOVIES", "STANDARD", "PREMIUM");
        for (Movies m : Movies.movie_list) {
            if (m instanceof Seats s) {
                System.out.printf("%-20s %10s %10s\n", m.getTitle(), s.standardSale, s.vipSale);
                totalStandard += (s.standardSale * 15.00);
                totalPremium += (s.vipSale * 30.00);
            }
        }
        System.out.printf("%-20s %10s %10s\n\n", "TOTAL SALES (RM)", totalStandard, totalPremium);
    }
    
    public static boolean validateSeat(int currentMovie, int currentSeat) {
        for (Movies m : Movies.movie_list) {
            if (m.getMovieId() == currentMovie) {
                if (m instanceof Seats s) {
                    if (currentSeat >= 1 && currentSeat <= 40) {
                        if (s.standardSeats[currentSeat - 1] == true) {
                            System.out.println("\nSeat is occupied. Please book another seat.\n");
                            return true;
                        }
                    } else if (currentSeat >= 41 && currentSeat <= 60) {
                        if (s.vipSeats[currentSeat - 41] == true) {
                            System.out.println("\nSeat is occupied. Please book another seat.\n");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void viewMovieSeats(int currentMovie) {
        for (Movies m : Movies.movie_list) {
            if (m.getMovieId() == currentMovie) {
                if (m instanceof Seats s) {
                    s.showAllStandardSeats();
                    System.out.println();
                    s.showAllVipSeats();
                }
            }
        }
    }
}
