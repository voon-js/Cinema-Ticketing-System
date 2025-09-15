/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

/**
 *
 * @author User
 */
public class Drink extends FoodItems {

    public static String[] drink_list = {"[4] Coca-Cola", "[5] Sprite", "[6] Pepsi", "[7] Water"};
    public static double[] drink_price = {3.5, 2.5, 3.0, 2.0};

    public static int[] totalSales = {0, 0, 0, 0};
    private int[] quantity = new int[4];

    public Drink() {
        quantity[0] = 0;
        quantity[1] = 0;
        quantity[2] = 0;
        quantity[3] = 0;
    }

    public int showQuantity(int foodType) {
        return quantity[foodType];
    }

    public String showName(int foodType) {
        return drink_list[foodType];
    }
    
    @Override
    public void showMenu() {
        System.out.println("\n---------- DRINK LIST ----------\n");
        System.out.printf("%-20s %6s\n", "Drink", "Price");
        System.out.printf("%-20s %6s\n", drink_list[0], drink_price[0]);
        System.out.printf("%-20s %6s\n", drink_list[1], drink_price[1]);
        System.out.printf("%-20s %6s\n", drink_list[2], drink_price[2]);
        System.out.printf("%-20s %6s\n", drink_list[3], drink_price[3]);
    }

    @Override
    public void setQuantity(int foodType, int quantity) {
        this.quantity[foodType - 4] += quantity;
    }

    @Override
    public double calculateTotalPrice(int foodType) {
        return (drink_price[foodType] * quantity[foodType]);
    }

}
