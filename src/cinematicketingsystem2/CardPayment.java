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
public class CardPayment extends Payment {

    public CardPayment(int chosenMovie, int chosenSeat, Food chosenFood, Drink chosenDrink) {
        super(chosenMovie, chosenSeat, chosenFood, chosenDrink);
    }

    @Override
    public boolean processPayment() {
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.print("\nPlease type your card number: ");
            String cardNumber = input.nextLine();

            if (cardNumber.length() == 16 && cardNumber.matches("\\d{16}")) {
                return true;
            } else {
                System.out.println("\nInvalid card number. Please type exactly 16 digits only.");
            }
        }
    }
}
