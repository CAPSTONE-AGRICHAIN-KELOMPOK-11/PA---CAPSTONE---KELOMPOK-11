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
import Model.Petani;
import java.util.List;

public class petaniController extends BaseController<Petani> {

    private final petaniService petaniSrv = new petaniService();

    public petaniController() {
        this.service = petaniSrv;
    }

    @Override
    public boolean insert(Petani p) {
        if (p == null) {
            log("Objek Petani kosong");
            return false;
        }
        if (isBlank(p.getNamaLengkap()) || isBlank(p.getUsername()) || isBlank(p.getPassword())) {
            log("Nama, username, dan password wajib diisi");
            return false;
        }
        p.setIdPetani(generateID.petani());
        if (isBlank(p.getRole())) p.setRole("petani");
        return petaniSrv.insert(p);
    }

    @Override
    public boolean update(Petani p) {
        if (p == null || isBlank(p.getIdPetani())) {
            log("Update gagal: ID Petani kosong");
            return false;
        }
        return petaniSrv.update(p);
    }

    @Override
    public boolean delete(String idPetani) {
        if (isBlank(idPetani)) {
            log("Hapus gagal: ID Petani kosong");
            return false;
        }
        return petaniSrv.delete(idPetani);
    }

    @Override
    public List<Petani> getAll() {
        return petaniSrv.getAll();
    }

  
    public boolean tambahPetani(Petani p) {
        return insert(p);
    }

    public boolean hapusPetani(String idPetani) {
        return delete(idPetani);
    }

    public boolean editPetani(Petani p) {
        System.out.println("[DEBUG] Edit Petani ID: " + p.getIdPetani());
        System.out.println("[DEBUG] Nama Baru: " + p.getNamaLengkap());
        return update(p);
    }


    public List<Petani> getAllPetaniWithSawah() {
        return petaniSrv.getAllWithSawah();
    }

    public boolean updateDataPetani(String idPetani, String noTelp, String namaSawah, String lokasi, String luasLahanStr) {
        if (noTelp == null || noTelp.isBlank() || namaSawah == null || namaSawah.isBlank() ||
            lokasi == null || lokasi.isBlank() || luasLahanStr == null || luasLahanStr.isBlank()) {
            System.err.println("[PetaniController] Field masih kosong");
            return false;
        }

        int luasLahan;
        try {
            luasLahan = Integer.parseInt(luasLahanStr);
        } catch (NumberFormatException e) {
            System.err.println("[PetaniController] Luas lahan bukan angka valid");
            return false;
        }

        Petani p = new Petani();
        p.setIdPetani(idPetani);
        p.setNoTelp(noTelp);
        p.setNamaSawah(namaSawah);
        p.setLokasi(lokasi);
        p.setLuasLahan(luasLahan);

        return petaniSrv.updateInfo(p);
    }
    public List<Object[]> getInfoPetani(String lokasi, String sortOrder) {
        return petaniSrv.getInfoPetani(lokasi, sortOrder);
    }
    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
