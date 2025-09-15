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
public abstract class Payment {

    protected int chosenMovie;
    protected int chosenSeat;
    protected Food chosenFood;
    protected Drink chosenDrink;

    double totalAmount = 0.00;

    public Payment(int chosenMovie, int chosenSeat, Food chosenFood, Drink chosenDrink) {
        this.chosenMovie = chosenMovie;
        this.chosenSeat = chosenSeat;
        this.chosenFood = chosenFood;
        this.chosenDrink = chosenDrink;
    }

    public void showInvoice() {
        double seatType = 0.00;
        double totalPrice = 0.00;
        int totalFood = 0;

        if (chosenSeat >= 1 && chosenSeat <= 40) {
            seatType = 15.00;
        } else if (chosenSeat >= 41 && chosenSeat <= 60) {
            seatType = 30.00;
        }
        totalPrice += seatType;

        System.out.println("\n---------- INVOICE ----------\n");
        System.out.printf("%-38s %-20s\n", "[MOVIES]", "PRICE");
        System.out.printf("%-38s %-20s\n", Movies.movie_list.get(chosenMovie - 1).getTitle() + "(SEAT NUM:  " + chosenSeat + ")", "RM" + seatType);
        System.out.printf("\n%-38s %-20s\n", "[FOOD & DRINK]", "");

        for (int i = 0; i < 3; i++) {
            if (chosenFood.showQuantity(i) >= 1) {
                System.out.printf("%-38s %-20s\n", chosenFood.showName(i) + " (x" + chosenFood.showQuantity(i) + ")", "RM" + chosenFood.calculateTotalPrice(i));
                totalPrice += chosenFood.calculateTotalPrice(i);
                totalFood++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (chosenDrink.showQuantity(i) >= 1) {
                System.out.printf("%-38s %-20s\n", chosenDrink.showName(i) + " (x" + chosenDrink.showQuantity(i) + ")", "RM" + chosenDrink.calculateTotalPrice(i));
                totalPrice += chosenDrink.calculateTotalPrice(i);
                totalFood++;
            }
        }

        if (totalFood == 0) {
            System.out.println("-");
        }

        System.out.printf("\n%-38s %-20s\n", "TOTAL AMOUNT: ", "RM" + totalPrice);
        totalAmount = totalPrice;
    }

    public double getAmount() {
        return totalAmount;
    }

    public void showReceipt(String paymentType) {
        double seatType = 0.00;
        double totalPrice = 0.00;
        int totalFood = 0;

        if (chosenSeat >= 1 && chosenSeat <= 40) {
            seatType = 15.00;
        } else if (chosenSeat >= 41 && chosenSeat <= 60) {
            seatType = 30.00;
        }
        totalPrice += seatType;

        System.out.println("\n---------- RECEIPT ----------\n");
        System.out.printf("%-38s %-20s\n", "[MOVIES]", "PRICE");
        System.out.printf("%-38s %-20s\n", Movies.movie_list.get(chosenMovie - 1).getTitle() + "(SEAT NUM:  " + chosenSeat + ")", "RM" + seatType);
        System.out.printf("\n%-38s %-20s\n", "[FOOD & DRINK]", "");

        for (int i = 0; i < 3; i++) {
            if (chosenFood.showQuantity(i) >= 1) {
                System.out.printf("%-38s %-20s\n", chosenFood.showName(i) + " (x" + chosenFood.showQuantity(i) + ")", "RM" + chosenFood.calculateTotalPrice(i));
                totalPrice += chosenFood.calculateTotalPrice(i);
                totalFood++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (chosenDrink.showQuantity(i) >= 1) {
                System.out.printf("%-38s %-20s\n", chosenDrink.showName(i) + " (x" + chosenDrink.showQuantity(i) + ")", "RM" + chosenDrink.calculateTotalPrice(i));
                totalPrice += chosenDrink.calculateTotalPrice(i);
                totalFood++;
            }
        }

        if (totalFood == 0) {
            System.out.println("-");
        }

        System.out.printf("\n%-38s %-20s\n", "TOTAL AMOUNT: ", "RM" + totalPrice);
        System.out.printf("%-38s %-20s\n", "PAYMENT METHOD: ", paymentType);

        Scanner input = new Scanner(System.in);
        System.out.println("\nPress enter to continue...");
        String continueBtn = input.nextLine();

    }

    public abstract boolean processPayment();

}
