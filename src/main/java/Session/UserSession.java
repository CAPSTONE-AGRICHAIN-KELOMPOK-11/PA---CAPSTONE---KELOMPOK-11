/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

/**
 *
 * @author ASUS
 */
public class UserSession {
    private static String idUser;
    private static String username;
    private static String role;

    public static void set(String idUser, String username, String role) {
        UserSession.idUser = idUser;
        UserSession.username = username;
        UserSession.role = role;
    }

    public static String getIdUser() { return idUser; }
    public static String getUsername() { return username; }
    public static String getRole() { return role; }

    public static void clear() {
        idUser = null;
        username = null;
        role = null;
    }
}