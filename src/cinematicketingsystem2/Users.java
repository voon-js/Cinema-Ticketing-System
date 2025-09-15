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
public class Users {

    private String username;
    private String password;
    private int user_id;

    public static ArrayList<Users> user_list = new ArrayList<>();
    public static int current_id = 1;

    public Users(String username, String password, int user_id) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;

        user_list.add(this);
        current_id++;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean validateUsername(String newUsername) {
        for (Users u : Users.user_list) {
            if (newUsername.equals(u.getUsername())) {
                System.out.println("\nUsername is already taken. Please choose another username.\n");
                return true;
            }
        }
        return false;
    }

    public static boolean validatePassword(String newPassword) {
        if (newPassword.length() < 6) {
            System.out.println("\nPassword length less than 6. Please type a longer password.\n");
            return false;
        }
        return true;
    }

    public static void validatePassword(String currentUsername, String currentPassword, String newPassword, String confirmPassword) {
        for (Users u : Users.user_list) {
            if (currentUsername.equals(u.getUsername())) {
                if (currentPassword.equals(u.getPassword())) {
                    if (newPassword.equals(confirmPassword)) {
                        if (Users.validatePassword(newPassword) == true) {
                            u.setPassword(newPassword);
                            System.out.println("\nPassword successfully changed.\n");
                        }
                    } else {
                        System.out.println("\nNew password doesn't match. Please ensure you have typed the same password.\n");
                    }
                } else {
                    System.out.println("\nCurrent password is incorrect. Please ensure you have typed the correct password.\n");
                }
            }
        }
    }
    
    public static String validateAccount(String currentUsername, String currentPassword) {
        for (Admins a : Admins.admin_list) {
            if (currentUsername.equals(a.getUsername())) {
                if (currentPassword.equals(a.getPassword())) {
                    if (a.getAdminRole() == true) {
                        Main.clearScreen();
                        System.out.println("\nSuccessfully logged in as admin.\n");
                        return "Admin";
                    } else {
                        System.out.println("\nAdmin privileges is blocked for this account.\n");
                        return "None";
                    }
                }
            }
        }

        for (Users u : Users.user_list) {
            if (currentUsername.equals(u.getUsername())) {
                if (currentPassword.equals(u.getPassword())) {
                    Main.clearScreen();
                    System.out.println("\nSuccessfully logged in.\n");
                    return "User";
                } else {
                    System.out.println("\nPassword don't match. Please ensure you have typed the correct password.\n");
                    return "None";
                }
            }
        }
        System.out.println("\nUsername not found. Please ensure you have typed the correct username.\n");
        return "None";
    }

    public static void showAllUsers() {
        System.out.println("\n---------- USERS ----------\n");
        for (Users u : Users.user_list) {
            System.out.println("Username: " + u.getUsername() + " | User ID: " + u.getUserId());
        }
    }
}
