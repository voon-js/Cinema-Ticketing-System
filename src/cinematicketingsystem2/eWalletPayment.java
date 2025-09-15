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
public class eWalletPayment extends Payment {

    public eWalletPayment(int chosenMovie, int chosenSeat, Food chosenFood, Drink chosenDrink) {
        super(chosenMovie, chosenSeat, chosenFood, chosenDrink);
    }

    @Override
    public boolean processPayment() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n---------- SCAN TO PAY ----------\n");
        System.out.println("██████████████████████████");
        System.out.println("█ ▄▄▄▄▄ █ ▄▄ █ ▄▄▄ █ ▄▄▄ █");
        System.out.println("█ █   █ █ ▄█ █ █ █ █ █▄█ █");
        System.out.println("█ █▄▄▄█ █ ▄▄ █ ▄▄█ █▄▄▄█ █");
        System.out.println("█▄▄▄▄▄█ ████ █████ ███████");
        System.out.println("█ ▄ █▄█ ▄▄ ▀▄█ ▄█ ▀█  ▄ ▄█");
        System.out.println("█▄█ ▄█▄▀ ▄ ▄ █▄█▄ ▀▄█▄█ ██");
        System.out.println("█ ▄▄▄▄▄ █ ▄▄ █ ▄▄▄ █ ▄▄▀ █");
        System.out.println("█ █   █ █ ▄█ █ █ █ █ ▄ █ █");
        System.out.println("█ █▄▄▄█ █ ▄▄ █ ▄▄█ █▄▄▄█ █");
        System.out.println("█▄▄▄▄▄█ ████ █████ ███████");
        System.out.println("██████████████████████████");

        System.out.println("\nPress enter to continue...");
        String continueBtn = input.nextLine();
        return true;
    }
}