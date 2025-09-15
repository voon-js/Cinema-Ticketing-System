/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

/**
 *
 * @author User
 */
public class Food extends FoodItems {
    
    public static String[] food_list = {"[1] Popcorn", "[2] Burger", "[3] French Fries"};
    public static double[] food_price = {3.0, 4.0, 3.5};
    
    public static int[] totalSales = {0, 0, 0};
    private int[] quantity = new int[3];
    
    public Food() {
        quantity[0] = 0;
        quantity[1] = 0;
        quantity[2] = 0;
    }
    
    public int showQuantity(int foodType) {
        return quantity[foodType];
    }
    
    public String showName(int foodType) {
        return food_list[foodType];
    }
    
    @Override
    public void showMenu() {
        System.out.println("\n---------- FOOD LIST ----------\n");
        System.out.printf("%-20s %6s\n", "Food", "Price");
        System.out.printf("%-20s %6s\n", food_list[0], food_price[0]);
        System.out.printf("%-20s %6s\n", food_list[1], food_price[1]);
        System.out.printf("%-20s %6s\n", food_list[2], food_price[2]);
    }
    
    @Override
    public void setQuantity(int foodType, int quantity) {
        this.quantity[foodType - 1] += quantity;
    }
    
    @Override
    public double calculateTotalPrice(int foodType) {
       return (food_price[foodType] * quantity[foodType]);
    }
    
}