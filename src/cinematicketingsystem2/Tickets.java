/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Tickets {

    private String username;
    private int movieId;
    private double amount;
    private int ticketId;
    private int seatId;

    public static ArrayList<Tickets> ticket_list = new ArrayList<>();
    public static int current_id = 1;

    public Tickets(String username, int movieId, double amount, int ticketId, int seatId) {
        this.username = username;
        this.movieId = movieId;
        this.amount = amount;
        this.ticketId = ticketId;
        this.seatId = seatId;

        Seats.setSeat(movieId, seatId);
        ticket_list.add(this);
        current_id++;
    }

    public String getUsername() {
        return username;
    }

    public int getMovieId() {
        return movieId;
    }

    public double getAmount() {
        return amount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public static void showUserTickets(String username) {
        int currentNum = 0;
        for (Tickets t : Tickets.ticket_list) {
            if (username.equals(t.getUsername())) {
                currentNum++;
            }
        }

        if (currentNum == 0) {
            System.out.println("\nCurrently no ticket is bought.\n");
        } else {
            System.out.println("\n---------- BOUGHT TICKETS ----------\n");
            
            if (Movies.movieDeletion == true) {
                System.out.println("\n(some ticket will show wrong movie name due to movie deletion.)\n");
            }
            
            System.out.printf("%-25s %-15s %-15s %-15s\n", "Movie Name", "Amount", "Ticket ID", "Movie Seat");
            System.out.println();
            for (Tickets t : Tickets.ticket_list) {
                if (username.equals(t.getUsername())) {
                    String seatType;
                    if (t.getSeatId() <= 40) {
                        seatType = " (STANDARD)";
                    } else {
                        seatType = " (PREMIUM)";
                    }

                    int index = t.getMovieId() - 1;
                    if (index >= 0 && index < Movies.movie_list.size()) {
                        Movies movie = Movies.movie_list.get(index);
                        if (movie != null) {
                            System.out.printf("%-25s %-15s %-15s %-15s\n", Movies.movie_list.get(t.getMovieId() - 1).getTitle(), "RM" + t.getAmount(), "T" + t.ticketId, t.seatId + seatType);
                        } else {
                            System.out.printf("%-25s %-15s %-15s %-15s\n", "(movie deleted.)", "RM" + t.getAmount(), "T" + t.ticketId, t.seatId + seatType);
                        }
                    } else {
                        System.out.printf("%-25s %-15s %-15s %-15s\n", "(movie deleted.)", "RM" + t.getAmount(), "T" + t.ticketId, t.seatId + seatType);
                    }
 
                }
            }
            System.out.println("\n------------------------------------\n");
        }

    }
}
