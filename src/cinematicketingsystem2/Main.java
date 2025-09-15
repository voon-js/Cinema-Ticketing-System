/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    static String currentAccount;
    static int loginChoice = 1;
    static int optionChoice = 1;
    static boolean tempLooper1 = true;
    static boolean tempLooper2 = false;
    static boolean tempLooper3 = false;
    static boolean tempLooper4 = false;
    static boolean tempLooper5 = false;
    static boolean tempLooper6 = false;
    static boolean tempLooper7 = false;
    static boolean tempLooper8 = false;

    public static void main(String[] args) {

        new Seats("The Silent Horizon", "Sci-Fi", "English", 8.3, 127, "In a future where sound is forbidden, a rebel scientist discovers the key to breaking the silence.", Movies.current_id);
        new Seats("Midnight Lotus", "Romance", "Mandarin", 7.6, 105, "Two souls meet at a night market in Taipei, discovering love under the glow of paper lanterns.", Movies.current_id);
        new Seats("The Last Serenade", "Drama", "French", 8.1, 112, "A retired pianist returns to the stage for one final performance that will change her life forever.", Movies.current_id);
        new Seats("Shadow Circuit", "Action", "English", 7.9, 134, "A rogue hacker uncovers a military AI conspiracy and becomes the most wanted man on Earth.", Movies.current_id);
        new Seats("Crimson Harvest", "Thriller", "Spanish", 8.0, 118, "A detective in rural Spain uncovers a dark secret behind a series of vineyard murders.", Movies.current_id);
        new Admins("tarumt", "tarumt", Users.current_id, true);

        DisplayLogo();

        while (tempLooper1 == true) {

            DisplayLogin(loginChoice);
            SystemProcess(loginChoice);

        }

    }

    public static void DisplayLogo() {
        System.out.println("___________.__        __           __ ___________.__                             ");
        System.out.println("\\__    ___/|__| ____ |  | __ _____/  |\\_   _____/|  |   ______  _  __    .__     ");
        System.out.println("  |    |   |  |/ ___\\|  |/ // __ \\   __\\    __)  |  |  /  _ \\ \\/ \\/ /  __|  |___ ");
        System.out.println("  |    |   |  \\  \\___|    <\\  ___/|  | |     \\   |  |_(  <_> )     /  /__    __/ ");
        System.out.println("  |____|   |__|\\___  >__|_ \\\\___  >__| \\___  /   |____/\\____/ \\/\\_/      |__|    ");
        System.out.println("                   \\/     \\/    \\/         \\/                                    ");
        System.out.println("Welcome to TicketFlow+ where you book movie tickets for accordable price!");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void DisplayLogin(int loginChoice) {
        switch (loginChoice) {
            case 1:
                System.out.println("[1] Login");
                System.out.println("[2] Register");
                System.out.println("[3] Exit");
                break;
            case 2:
                System.out.println("[1] Book a ticket");
                System.out.println("[2] View upcoming movies");
                System.out.println("[3] Go to account settings");
                System.out.println("[4] Logout");
                break;
            case 3:
                System.out.println("[1] Add new movie");
                System.out.println("[2] Edit movie details");
                System.out.println("[3] Delete a movie");
                System.out.println("[4] View sales record");
                System.out.println("[5] Go to account settings");
                System.out.println("[6] Logout");
                break;
            default:
                System.out.println("\nInvalid input. Please type again.\n");
        }
    }

    public static void DisplaySubOptions(int optionChoice) {
        switch (optionChoice) {
            case 1:
                // User account settings
                System.out.println("\n[1] Change password");
                System.out.println("[2] View bought tickets");
                break;
            case 2:
                // Movie details settings
                System.out.println("\n[1] Change title");
                System.out.println("[2] Change genre");
                System.out.println("[3] Change language");
                System.out.println("[4] Change rating");
                System.out.println("[5] Change duration");
                System.out.println("[6] Change description");
                break;
            case 3:
                // Admin account settings
                System.out.println("\n[1] Change password");
                System.out.println("[2] Add admin account");
                System.out.println("[3] Show all account");
                break;
            default:
                System.out.println("\nInvalid input. Please type again.\n");
        }
    }

    public static void SystemProcess(int loginChoice) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nChoose an option: ");
        if (input.hasNextInt()) {

            int choice = input.nextInt();

            switch (loginChoice) {
                case 1:

                    if (choice == 1) {

                        input.nextLine();

                        System.out.print("\nUsername: ");
                        String currentUsername = input.nextLine();

                        System.out.print("Password: ");
                        String currentPassword = input.nextLine();

                        String getValidation = Users.validateAccount(currentUsername, currentPassword);

                        if (getValidation.equals("User")) {
                            Main.currentAccount = currentUsername;
                            Main.loginChoice = 2;

                        } else if (getValidation.equals("Admin")) {
                            Main.currentAccount = currentUsername;
                            Main.loginChoice = 3;
                        }

                    } else if (choice == 2) {

                        Main.tempLooper2 = true;
                        while (tempLooper2 == true) {

                            input.nextLine();

                            System.out.print("\nType your username: ");
                            String newUsername = input.nextLine();

                            if (Users.validateUsername(newUsername) == false) {

                                System.out.print("Type your password: ");
                                String newPassword = input.nextLine();

                                if (Users.validatePassword(newPassword) == true) {
                                    new Users(newUsername, newPassword, Users.current_id);
                                    System.out.println("\nSuccessfully created your account.\n");
                                    Main.tempLooper2 = false;
                                    continue;
                                }

                            }

                            Main.tempLooper3 = true;
                            while (tempLooper3 == true) {
                                System.out.print("Restart registration? [Y/N]: ");
                                char confirmation = input.next().charAt(0);

                                if (confirmation == 'Y' || confirmation == 'y') {
                                    System.out.println("\nOperation restarted successfully.\n");
                                    Main.tempLooper3 = false;
                                } else if (confirmation == 'N' || confirmation == 'n') {
                                    System.out.println("\nOperation cancelled successfully.\n");
                                    Main.tempLooper2 = false;
                                    Main.tempLooper3 = false;
                                } else {
                                    System.out.println("\nInvalid input. Please type again.\n");
                                }
                            }

                        }

                    } else if (choice == 3) {
                        clearScreen();
                        System.out.println("\nThank you for using TicketFlow+\n");
                        tempLooper1 = false;
                    } else {
                        System.out.println("\nInvalid input. Please type again.\n");
                    }

                    break;

                case 2:

                    if (choice == 1) {
                        tempLooper5 = true;
                        while (tempLooper5 == true) {
                            Movies.showAllMovies();
                            System.out.print("\nChoose an option: ");

                            if (input.hasNextInt()) {
                                int subChoice = input.nextInt();
                                if (Movies.validateMovie(subChoice) == true) {
                                    Seats.viewMovieSeats(subChoice);

                                    int selectedSeat = 0;

                                    System.out.println("\nSTANDARD SEAT: RM15 | PREMIUM SEAT: RM30\n\n");
                                    System.out.print("Choose your seats [1-60]: ");
                                    int subChoice2 = input.nextInt();

                                    if (subChoice2 <= 0 || subChoice2 >= 61) {
                                        System.out.println("\nInvalid seat number. Please type again.\n");
                                        continue;
                                    }

                                    if (Seats.validateSeat(subChoice, subChoice2) == false) {
                                        System.out.print("\nConfirm seat selection? [Y/N] | Cancel operation [X]: ");
                                        char confirmation = input.next().charAt(0);

                                        if (confirmation == 'Y' || confirmation == 'y') {
                                            System.out.println("\nSeat successfully selected.");
                                            selectedSeat = subChoice2;
                                            tempLooper5 = false;
                                        } else if (confirmation == 'N' || confirmation == 'n') {
                                            continue;
                                        } else if (confirmation == 'X' || confirmation == 'x') {
                                            System.out.println();
                                            tempLooper5 = false;
                                            continue;
                                        } else {
                                            System.out.println("\nInvalid input. Please type again.\n");
                                            continue;
                                        }

                                    } else {
                                        System.out.println("\nSeat is occupied. Please try again.\n");
                                        continue;
                                    }

                                    tempLooper6 = true;
                                    while (tempLooper6 == true) {

                                        System.out.print("\nFood & Drinks add-on? [Y/N]: ");
                                        char confirmation = input.next().charAt(0);

                                        if (confirmation == 'Y' || confirmation == 'y') {
                                            tempLooper6 = false;
                                            tempLooper7 = true;
                                        } else if (confirmation == 'N' || confirmation == 'n') {
                                            tempLooper6 = false;
                                        } else {
                                            System.out.println("\nInvalid input. Please type again.\n");
                                            continue;
                                        }
                                    }

                                    Food newFood = new Food();
                                    Drink newDrink = new Drink();

                                    while (tempLooper7 == true) {

                                        newFood.showMenu();
                                        newDrink.showMenu();

                                        System.out.print("\nSelect a food or drink [1-7]: ");
                                        if (input.hasNextInt()) {
                                            int currentFood = input.nextInt();

                                            if (currentFood >= 1 && currentFood <= 7) {
                                                System.out.print("\nQuantity: ");
                                                int currentQuantity = input.nextInt();

                                                System.out.print("\nDo you want to order more? [Y/N]: ");
                                                char confirmation = input.next().charAt(0);

                                                if (confirmation == 'Y' || confirmation == 'y') {

                                                    if (currentFood >= 1 && currentFood <= 3) {
                                                        newFood.setQuantity(currentFood, currentQuantity);
                                                    } else {
                                                        newDrink.setQuantity(currentFood, currentQuantity);
                                                    }

                                                } else if (confirmation == 'N' || confirmation == 'n') {

                                                    if (currentFood >= 1 && currentFood <= 3) {
                                                        newFood.setQuantity(currentFood, currentQuantity);
                                                    } else {
                                                        newDrink.setQuantity(currentFood, currentQuantity);
                                                    }

                                                    tempLooper7 = false;
                                                } else {
                                                    System.out.println("\nInvalid input. Please type again.\n");
                                                }

                                            } else {
                                                System.out.println("\nInvalid option. PLease try again.\n");
                                            }
                                        } else {
                                            System.out.println("\nOnly numbers is allowed. Please type again.\n");
                                        }

                                    }

                                    System.out.println("\n[1] Debit Card");
                                    System.out.println("[2] Credit Card");
                                    System.out.println("[3] TNG eWallet");

                                    tempLooper8 = true;
                                    while (tempLooper8 == true) {

                                        System.out.print("\nPlease select a payment method: ");
                                        if (input.hasNextInt()) {
                                            int currentMethod = input.nextInt();

                                            if (currentMethod == 1 || currentMethod == 2) {
                                                CardPayment newPayment = new CardPayment(subChoice, selectedSeat, newFood, newDrink);
                                                newPayment.showInvoice();

                                                if (newPayment.processPayment() == true) {
                                                    new Tickets(currentAccount, subChoice, newPayment.getAmount(), Tickets.current_id, selectedSeat);
                                                    newPayment.showReceipt("Banking Card");
                                                    
                                                    clearScreen();
                                                    System.out.println("\nBooking is successful. Please check your tickets in the account settings.\n");
                                                    tempLooper8 = false;
                                                }

                                            } else if (currentMethod == 3) {
                                                eWalletPayment newPayment = new eWalletPayment(subChoice, selectedSeat, newFood, newDrink);
                                                newPayment.showInvoice();

                                                if (newPayment.processPayment() == true) {
                                                    new Tickets(currentAccount, subChoice, newPayment.getAmount(), Tickets.current_id, selectedSeat);
                                                    newPayment.showReceipt("TNG eWallet");
                                                    
                                                    clearScreen();
                                                    System.out.println("\nBooking is successful. Please check your tickets in the account settings.\n");
                                                    tempLooper8 = false;
                                                }
                                            } else {
                                                System.out.println("\nInvalid option. Please try again.\n");
                                            }

                                        } else {
                                            System.out.println("\nOnly numbers is allowed. Please type again.\n");
                                        }

                                    }

                                }

                            } else {
                                System.out.println("\nOnly numbers is allowed. Please type again.\n");
                            }
                        }

                    } else if (choice == 2) {
                        Movies.showAllMovies();
                    } else if (choice == 3) {
                        Main.optionChoice = 1;
                        DisplaySubOptions(optionChoice);

                        System.out.print("\nChoose an option: ");
                        if (input.hasNextInt()) {
                            int subChoice = input.nextInt();

                            if (subChoice == 1) {

                                input.nextLine();

                                System.out.print("\nType current password: ");
                                String currentPassword = input.nextLine();

                                System.out.print("Type new password: ");
                                String newPassword = input.nextLine();

                                System.out.print("Confirm new password: ");
                                String confirmPassword = input.nextLine();

                                Users.validatePassword(currentAccount, currentPassword, newPassword, confirmPassword);

                            } else if (subChoice == 2) {

                                Tickets.showUserTickets(currentAccount);

                            } else {
                                System.out.println("\nInvalid input. Please type again.\n");
                            }

                        } else {
                            System.out.println("\nOnly numbers is allowed. Please type again.\n");
                        }

                    } else if (choice == 4) {
                        clearScreen();
                        System.out.println("\nSuccessfully logged out.\n");
                        Main.loginChoice = 1;
                    } else {
                        System.out.println("\nInvalid input. Please type again.\n");
                    }

                    break;

                case 3:

                    if (choice == 1) {

                        input.nextLine();

                        System.out.print("\nMovie title: ");
                        String title = input.nextLine();

                        System.out.print("Genre: ");
                        String genre = input.nextLine();

                        System.out.print("Language: ");
                        String language = input.nextLine();

                        System.out.print("Rating (double): ");
                        double rating = input.nextDouble();

                        System.out.print("Duration (int): ");
                        int duration = input.nextInt();

                        input.nextLine();

                        System.out.print("Description: ");
                        String description = input.nextLine();

                        new Seats(title, genre, language, rating, duration, description, Movies.current_id);
                        System.out.println("\nSuccessfully added a new movie.\n");

                    } else if (choice == 2) {
                        Movies.showAllMovies();
                        System.out.print("\nChoose a movie to edit: ");
                        if (input.hasNextInt()) {

                            int subChoice = input.nextInt();
                            if (Movies.validateMovie(subChoice) == true) {
                                Main.optionChoice = 2;
                                DisplaySubOptions(optionChoice);

                                tempLooper4 = true;
                                while (tempLooper4 == true) {
                                    System.out.print("\nChoose an option: ");
                                    if (input.hasNextInt()) {
                                        int subChoice2 = input.nextInt();

                                        if (subChoice2 >= 1 && subChoice2 <= 6) {
                                            Movies.editMovie(subChoice, subChoice2);
                                            clearScreen();
                                            System.out.println("\nSuccessfully modified movie details.\n");
                                            tempLooper4 = false;
                                        } else {
                                            System.out.println("\nInvalid input. Please type again.\n");
                                        }

                                    } else {
                                        System.out.println("\nOnly numbers is allowed. Please type again.\n");
                                    }
                                }

                            }

                        } else {
                            System.out.println("\nOnly numbers is allowed. Please type again.\n");
                        }

                    } else if (choice == 3) {

                        Movies.showAllMovies();
                        System.out.print("Choose a movie to delete: ");

                        if (input.hasNextInt()) {
                            int subChoice = input.nextInt();
                            if (Movies.validateMovie(subChoice) == true) {
                                Movies.deleteMovie(subChoice);
                            }
                        }

                    } else if (choice == 4) {

                        Seats.showSales();
                        
                    } else if (choice == 5) {
                        Main.optionChoice = 3;
                        DisplaySubOptions(optionChoice);

                        System.out.print("\nChoose an option: ");
                        if (input.hasNextInt()) {
                            int subChoice = input.nextInt();

                            if (subChoice == 1) {

                                input.nextLine();

                                System.out.print("\nType current password: ");
                                String currentPassword = input.nextLine();

                                System.out.print("Type new password: ");
                                String newPassword = input.nextLine();

                                System.out.print("Confirm new password: ");
                                String confirmPassword = input.nextLine();

                                Users.validatePassword(currentAccount, currentPassword, newPassword, confirmPassword);

                            } else if (subChoice == 2) {

                                input.nextLine();

                                System.out.print("\nUsername: ");
                                String username = input.nextLine();

                                System.out.print("Password: ");
                                String password = input.nextLine();

                                Admins.addNewAdmin(username, password);

                            } else if (subChoice == 3) {

                                Users.showAllUsers();
                                Admins.showAllAdmins();

                            } else {
                                System.out.println("\nInvalid input. Please type again.\n");
                            }

                        } else {
                            System.out.println("\nOnly numbers is allowed. Please type again.\n");
                        }

                    } else if (choice == 6) {
                        clearScreen();
                        System.out.println("\nSuccessfully logged out.\n");
                        Main.loginChoice = 1;
                    } else {
                        System.out.println("\nInvalid input. Please type again.\n");
                    }

                    break;

                default:
                    System.out.println("\nAn error occured. Please restart the system.\n");
                    tempLooper1 = false;

            }

        } else {
            System.out.println("\nOnly numbers is allowed. Please type again.\n");
        }

    }
}
