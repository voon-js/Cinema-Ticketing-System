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
public class Admins extends Users {

    private boolean adminRole;
    public static ArrayList<Admins> admin_list = new ArrayList<>();

    public Admins(String username, String password, int user_id, boolean adminRole) {
        super(username, password, user_id);
        this.adminRole = adminRole;

        admin_list.add(this);
    }

    public boolean getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(boolean adminRole) {
        this.adminRole = adminRole;
    }

    public static void addNewAdmin(String username, String password) {
        for (Users u : Users.user_list) {
            if (username.equals(u.getUsername())) {
                System.out.println("\nUsername exist. Please ensure you typed a new username.\n");
                return;
            }
        }

        new Admins(username, password, Users.current_id, true);
        System.out.println("\nSuccessfully created a new admin account.\n");
    }

    public static void showAllAdmins() {
        System.out.println("\n---------- ADMINS ----------\n");
        for (Admins a : Admins.admin_list) {
            System.out.println("(ADMIN) Username: " + a.getUsername() + " | User ID: " + a.getUserId());
        }
        System.out.println();
    }
}
