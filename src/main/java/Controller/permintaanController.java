/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Database.permintaanService;
import Model.Permintaan;
import Session.UserSession;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class permintaanController extends BaseController<Permintaan> {

    private final permintaanService permintaanSrv;

    public permintaanController() {
        this.permintaanSrv = new permintaanService();
        this.service = permintaanSrv;
    }

    @Override
    public boolean insert(Permintaan p) {
        if (p == null) {
            log("Data permintaan kosong");
            return false;
        }
        if (p.getIdPermintaan() == null || p.getIdPermintaan().isBlank()) {
            p.setIdPermintaan(generateID.permintaan());
        }
        return permintaanSrv.insert(p);
    }

    @Override
    public boolean update(Permintaan p) {
        if (p == null || p.getIdPermintaan() == null || p.getIdPermintaan().isBlank()) {
            log("ID permintaan kosong, update gagal");
            return false;
        }
        return permintaanSrv.update(p);
    }

    @Override
    public boolean delete(String id) {
        if (id == null || id.isBlank()) {
            log("ID permintaan kosong");
            return false;
        }
        return permintaanSrv.delete(id);
    }
    public List<Permintaan> getAllPermintaan() {
        return getAll();
    }

    
    public boolean ubahStatus(String idPermintaan, String statusBaru) {
        if (isBlank(idPermintaan)) {
            log("ID permintaan tidak boleh kosong");
            return false;
        }

        if (isBlank(statusBaru)) {
            log("Status baru tidak boleh kosong");
            return false;
        }

        String status = statusBaru.toLowerCase();
        if (!(status.equals("menunggu") || status.equals("disetujui") || status.equals("ditolak") || status.equals("dipenuhi"))) {
            log("Status tidak valid: " + status);
            return false;
        }

        String idAdmin = permintaanSrv.getDefaultAdminId();
        if (idAdmin == null) {
            JOptionPane.showMessageDialog(null, "Tidak ada admin terdaftar di database!");
            return false;
        }

        boolean success = permintaanSrv.updateStatus(idPermintaan, status, idAdmin);
        if (!success) return false;

        if (status.equals("dipenuhi")) {
            try (Session session = Database.Koneksi.getInstance().getSession()) {
                Transaction tx = session.beginTransaction();

                String idPetani = UserSession.getIdUser();

                Model.Permintaan permintaan = session.createQuery(
                    "FROM Permintaan p WHERE p.idPermintaan = :id",
                    Model.Permintaan.class
                )
                .setParameter("id", idPermintaan)
                .uniqueResult();

                if (permintaan == null) {
                    JOptionPane.showMessageDialog(null, "Data permintaan tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                    tx.rollback();
                    return false;
                }

                int jumlahPermintaan = permintaan.getJumlahPermintaan();

                Model.hasilPanen panenTerakhir = session.createQuery(
                    "FROM hasilPanen h WHERE h.idPetani = :idPetani ORDER BY h.tanggalPanen DESC",
                    Model.hasilPanen.class
                )
                .setParameter("idPetani", idPetani)
                .setMaxResults(1)
                .uniqueResult();

                if (panenTerakhir == null) {
                    JOptionPane.showMessageDialog(null,
                        "Data hasil panen untuk petani login tidak ditemukan!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    tx.rollback();
                    return false;
                }

                int stokSekarang = panenTerakhir.getStokGudang();
                int stokBaru = stokSekarang - jumlahPermintaan;

                if (stokBaru < 0) {
                    JOptionPane.showMessageDialog(null,
                        "Stok tidak mencukupi!\nTersedia: " + stokSekarang + " Kg\nDibutuhkan: " + jumlahPermintaan + " Kg",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
                    tx.rollback();
                    return false;
                }

                panenTerakhir.setStokGudang(stokBaru);
                session.merge(panenTerakhir);

                tx.commit();

                JOptionPane.showMessageDialog(null,
                    "Permintaan telah dipenuhi!\nStok gudang Anda kini: " + stokBaru + " Kg",
                    "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                log("[UPDATE STOK] Petani Login: " + idPetani + " | Stok lama: " + stokSekarang +
                    " Kg → Stok baru: " + stokBaru + " Kg (permintaan " + idPermintaan + ")");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan saat memperbarui stok gudang: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    public List<Permintaan> getPermintaanPetani(String idPetani) {
        if (isBlank(idPetani)) {
            log("ID Petani kosong!");
            return List.of();
        }
        return permintaanSrv.getForPetani(idPetani);
    }

    public List<Object[]> permintaanForDistributor() {
        return permintaanSrv.permintaanForDistributor();
    }

    public boolean tambahPermintaan(Permintaan p) {
    if (p == null) {
        JOptionPane.showMessageDialog(null, 
            "Data permintaan tidak boleh kosong!", 
            "Peringatan", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    if (p.getJumlahPermintaan() < 10) {
        JOptionPane.showMessageDialog(null, 
            "Jumlah permintaan minimal adalah 10 Kg!", 
            "Peringatan", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    if (p.getTanggalPermintaan() == null) {
        p.setTanggalPermintaan(new java.util.Date());
    }

    return insert(p);
    }

    public List<Object[]> permintaanForPetani() {
        return permintaanSrv.permintaanForPetani();
    }


    public boolean updatePermintaan(Permintaan p) {
        return update(p);
    }

    public boolean deletePermintaan(String idPermintaan) {
        return delete(idPermintaan);
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
    }
