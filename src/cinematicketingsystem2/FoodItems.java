/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinematicketingsystem2;

/**
 *
 * @author User
 */
public abstract class FoodItems {
    
    public abstract void showMenu();
    public abstract void setQuantity(int foodType, int quantity);
    public abstract double calculateTotalPrice(int foodType);
    
}
