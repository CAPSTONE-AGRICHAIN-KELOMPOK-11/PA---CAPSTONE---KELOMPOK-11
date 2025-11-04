/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Database.distributorService;
import Model.Distributor;
import java.util.List;

public class distributorController {

    private final distributorService dao = new distributorService();

    public boolean login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            System.err.println("[Controller] Username/password tidak boleh kosong");
            return false;
        }

        try {
            Distributor d = dao.getByUsername(username);
            if (d == null) {
                System.err.println("[Controller] Username tidak ditemukan");
                return false;
            }
            return d.getPassword() != null && d.getPassword().equals(password);
        } catch (Exception e) {
            System.err.println("[Controller] Gagal login: " + e.getMessage());
            return false;
        }
    }

    public boolean register(Distributor d) {
        if (d.getUsername() == null || d.getUsername().isBlank() ||
            d.getPassword() == null || d.getPassword().isBlank()) {
            System.err.println("[Controller] Username dan Password wajib diisi");
            return false;
        }

        try {
            if (dao.getByUsername(d.getUsername()) != null) {
                System.err.println("[Controller] Username sudah terdaftar");
                return false;
            }
            return dao.insert(d);
        } catch (Exception e) {
            System.err.println("[Controller] Gagal register: " + e.getMessage());
            return false;
        }
    }

public boolean updateDataDistributor(String idDistributor, String noTelp, String namaUsaha, String wilayahPasar) {
    if (noTelp == null || noTelp.isBlank() ||
        namaUsaha == null || namaUsaha.isBlank() ||
        wilayahPasar == null || wilayahPasar.isBlank()) {
        System.err.println("[Controller] Field masih ada yang kosong");
        return false;
    }

    try {
        Distributor d = dao.getById(idDistributor);
        if (d == null) {
            System.err.println("[Controller] Data distributor tidak ditemukan dengan ID: " + idDistributor);
            return false;
        }

        d.setNoTelp(noTelp);
        d.setNamaUsaha(namaUsaha);
        d.setWilayahPasar(wilayahPasar);

        if (d.getNamaLengkap() == null || d.getNamaLengkap().isBlank()) {
            d.setNamaLengkap("Nama Belum Diisi"); 
        }

        return dao.updateInfo(d);
    } catch (Exception e) {
        System.err.println("[Controller] Gagal update data: " + e.getMessage());
        return false;
    }
}

    public List<Distributor> getAllDistributor() {
        try {
            return dao.getAll();
        } catch (Exception e) {
            System.err.println("[Controller] Gagal ambil data distributor: " + e.getMessage());
            return List.of();
        }
    }

    public boolean deleteDistributor(String idDistributor) {
        if (idDistributor == null || idDistributor.isBlank()) {
            System.err.println("[Controller] ID distributor kosong");
            return false;
        }

        try {
            return dao.delete(idDistributor);
        } catch (Exception e) {
            System.err.println("[Controller] Gagal menghapus distributor: " + e.getMessage());
            return false;
        }
    }

    public boolean tambahDistributor(String nama, String username, String password,
                                     String noTelp, String namaUsaha, String wilayahPasar) {

        if (nama == null || nama.isBlank() || username == null || username.isBlank() || password == null || password.isBlank()) {
            System.err.println("[Controller] Nama, username, dan password wajib diisi");
            return false;
        }

        try {
            if (dao.getByUsername(username) != null) {
                System.err.println("[Controller] Username sudah terdaftar");
                return false;
            }

            Distributor d = new Distributor();
            d.setIdDistributor(generateId());
            d.setNamaLengkap(nama);
            d.setUsername(username);
            d.setPassword(password);
            d.setNoTelp(noTelp);
            d.setNamaUsaha(namaUsaha);
            d.setWilayahPasar(wilayahPasar);
            d.setRole("distributor");

            return dao.insert(d);
        } catch (Exception e) {
            System.err.println("[Controller] Gagal menambah distributor: " + e.getMessage());
            return false;
        }
    }

    private String generateId() {
        try {
            List<Distributor> all = dao.getAll();
            int nextNum = (all != null ? all.size() : 0) + 1;
            return String.format("DIST%03d", nextNum);
        } catch (Exception e) {
            System.err.println("[Controller] Gagal generate ID: " + e.getMessage());
            return "DIST000";
        }
    }
}
