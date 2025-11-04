/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Database.petaniService;
import Database.distributorService;
import Model.Petani;
import Model.Distributor;
import Controller.generateID;

public class RegisterController {

    private final petaniService petaniSrv = new petaniService();
    private final distributorService distSrv = new distributorService();

    public String registerUser(String nama, String username, String password, String role) {
        if (isBlank(nama)) return "empty_name";
        if (isBlank(username)) return "empty_username";
        if (isBlank(password)) return "empty_password";

        switch (role.toLowerCase()) {
            case "petani" -> {
                if (petaniSrv.isExist(username)) return "username_exists";

                Petani p = new Petani();
                p.setIdPetani(generateID.petani());
                p.setNamaLengkap(nama);
                p.setUsername(username);
                p.setPassword(password);
                p.setNoTelp("-");
                p.setNamaSawah("-");
                p.setLokasi("-");
                p.setLuasLahan(0);
                p.setRole("petani");

                return petaniSrv.insert(p)
                        ? "success_petani:" + p.getIdPetani()
                        : "fail";
            }

            case "distributor" -> {
                if (distSrv.isExist(username)) return "username_exists";

                Distributor d = new Distributor();
                d.setIdDistributor(generateID.distributor());
                d.setNamaLengkap(nama);
                d.setUsername(username);
                d.setPassword(password);
                d.setNoTelp("-");
                d.setNamaUsaha("-");
                d.setWilayahPasar("-");
                d.setRole("distributor");

                return distSrv.insert(d)
                        ? "success_distributor:" + d.getIdDistributor()
                        : "fail";
            }

            default -> {
                return "invalid_role";
            }
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
