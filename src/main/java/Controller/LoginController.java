/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Database.adminService;
import Database.petaniService;
import Database.distributorService;
import Session.UserSession;

public class LoginController {

    private final adminService adminSrv = new adminService();
    private final petaniService petaniSrv = new petaniService();
    private final distributorService distSrv = new distributorService();

    public String login(String username, String password) {
        if (isBlank(username) || isBlank(password)) return null;

        try {
            if (adminSrv.isExist(username)) {
                String id = adminSrv.login(username, password);
                if (id != null) {
                    UserSession.set(id, username, "admin");
                    return "admin";
                }
                return null;
            }

            if (petaniSrv.isExist(username)) {
                String id = petaniSrv.login(username, password);
                if (id != null) {
                    UserSession.set(id, username, "petani");
                    return "petani";
                }
                return null;
            }

            if (distSrv.isExist(username)) {
                String id = distSrv.login(username, password);
                if (id != null) {
                    UserSession.set(id, username, "distributor");
                    return "distributor";
                }
                return null;
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}