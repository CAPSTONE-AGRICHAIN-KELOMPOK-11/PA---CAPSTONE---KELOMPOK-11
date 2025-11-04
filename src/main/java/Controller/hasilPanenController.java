    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controller;

    /**
     *
     * @author ASUS
     */
import Database.hasilPanenService;
import Database.Koneksi;
import Model.hasilPanen;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
    

public class hasilPanenController extends BaseController<hasilPanen> {

    private final hasilPanenService dao;
    
    public hasilPanenController() {
        this.dao = new hasilPanenService();
        this.service = dao;
    }

    @Override
    public boolean insert(hasilPanen h) {
        if (h == null) {
            log("Data panen kosong!");
            return false;
        }
        return dao.insert(h);
    }

    @Override
    public boolean update(hasilPanen h) {
        if (h == null || h.getIdPanen() == null) {
            log("ID Panen tidak boleh kosong untuk update!");
            return false;
        }
        return dao.update(h);
    }

    @Override
    public boolean delete(String idPanen) {
        if (idPanen == null || idPanen.isBlank()) {
            log("ID Panen kosong!");
            return false;
        }
        return dao.delete(idPanen);
    }

    public boolean tambahPanen(String idPetani, double jumlah, String satuan) {
        if (idPetani == null || idPetani.isEmpty()) {
            idPetani = dao.getDefaultPetaniId();
            if (idPetani == null) {
                log("Tidak ada data petani ditemukan di DB!");
                return false;
            }
        }

        if (jumlah <= 0) {
            log("Jumlah panen harus lebih dari 0!");
            return false;
        }

        String idAdmin = dao.getDefaultAdminId();
        if (idAdmin == null) {
            log("Tidak ada admin ditemukan di DB!");
            return false;
        }

        String newIdPanen = Controller.generateID.panen();

        double jumlahKg = satuan.equalsIgnoreCase("Ton") ? jumlah * 1000 : jumlah;
        int jumlahInt = (int) Math.round(jumlahKg);

        int stokLama = dao.getStokTerakhirByPetani(idPetani);
        int stokBaru = stokLama + jumlahInt;

        hasilPanen h = new hasilPanen();
        h.setIdPanen(newIdPanen);
        h.setIdPetani(idPetani);
        h.setIdAdmin(idAdmin);
        h.setJumlahPanen(jumlahInt);
        h.setSatuan("Kg");

        LocalDate today = LocalDate.now();
        h.setTanggalPanen(java.sql.Date.valueOf(today));

        h.setStokGudang(stokBaru);

        return insert(h);
    }
    public List<hasilPanen> getPanenByPetani(String idPetani) {
        return dao.getByPetani(idPetani);
    }

    public List<hasilPanen> getAllPanen() {
    try (Session session = Koneksi.getInstance().getSession()) {
        session.clear(); 
        return session.createQuery("from hasilPanen", hasilPanen.class).list();
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
    }

    public boolean editPanen(String idPanen, int jumlah, String satuan, LocalDate selectedDate, String idAdmin) {
        try (Session session = Koneksi.getInstance().getSession()) {
            Transaction tx = session.beginTransaction();
            hasilPanen hp = session.get(hasilPanen.class, idPanen);

            if (hp != null) {
                hp.setJumlahPanen(jumlah);
                hp.setSatuan(satuan);

                if (selectedDate != null) {
                    hp.setTanggalPanen(java.sql.Date.valueOf(selectedDate));
                } else {
                    hp.setTanggalPanen(java.sql.Date.valueOf(LocalDate.now()));
                }

                hp.setIdAdmin(idAdmin);
                session.merge(hp);
                tx.commit();
                session.close();
                return true;
            }

        } catch (Exception e) { 
            System.err.println("[hasilPanenService.update] " + e.getMessage());
        }
        return false;
    }
}