/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */

import Model.Permintaan;
import static java.rmi.server.LogStream.log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import javax.swing.JOptionPane;

public class permintaanService implements CRUDService<Permintaan> {

    private final Session session;

    public permintaanService() {
        this.session = Koneksi.getInstance().getSession();
    }

    @Override
    public boolean insert(Permintaan p) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[permintaanService.insert] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Permintaan p) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[permintaanService.update] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Permintaan p = session.find(Permintaan.class, id);
            if (p != null) session.remove(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[permintaanService.delete] " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Permintaan> getAll() {
        return session.createSelectionQuery("from Permintaan", Permintaan.class).list();
    }



    public String getDefaultAdminId() {
        Query<String> q = session.createQuery(
            "SELECT a.idAdmin FROM Admin a ORDER BY a.idAdmin ASC", String.class);
        q.setMaxResults(1);
        return q.uniqueResult();
    }

    public boolean updateStatus(String idPermintaan, String status, String idAdmin) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Permintaan p = session.find(Permintaan.class, idPermintaan);
            if (p != null) {
                p.setStatus(status);
                p.setIdAdmin(idAdmin);
                session.merge(p);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[permintaanService.updateStatus] " + e.getMessage());
            return false;
        }
    }

    public boolean ubahStatus(String idPermintaan, String statusBaru) {
        if (idPermintaan == null || idPermintaan.isBlank()) {
            System.err.println("[permintaanService.ubahStatus] ID permintaan tidak boleh kosong");
            return false;
        }

        if (statusBaru == null || statusBaru.isBlank()) {
            System.err.println("[permintaanService.ubahStatus] Status baru tidak boleh kosong");
            return false;
        }

        String status = statusBaru.toLowerCase();
        if (!(status.equals("menunggu") || status.equals("disetujui") || status.equals("ditolak") || status.equals("dipenuhi"))) {
            System.err.println("[permintaanService.ubahStatus] Status tidak valid: " + status);
            return false;
        }

        String idAdmin = getDefaultAdminId();
        if (idAdmin == null) {
            JOptionPane.showMessageDialog(null, "Tidak ada admin terdaftar di database!");
            return false;
        }

        try (Session newSession = Koneksi.getInstance().getSession()) {
            Transaction tx = newSession.beginTransaction();

            // Ambil data permintaan
            Permintaan permintaan = newSession.get(Permintaan.class, idPermintaan);
            if (permintaan == null) {
                System.err.println("[permintaanService.ubahStatus] Data permintaan tidak ditemukan untuk ID: " + idPermintaan);
                return false;
            }

            permintaan.setStatus(status);
            permintaan.setIdAdmin(idAdmin);
            newSession.merge(permintaan);

            if (status.equals("dipenuhi")) {
                String idPanen = permintaan.getIdPanen();
                int jumlahPermintaan = permintaan.getJumlahPermintaan();

                String hql = """
                    SELECT h.stokGudang
                    FROM hasilPanen h
                    WHERE h.idPanen = :idPanen
                """;
                Integer stokTerkini = newSession.createQuery(hql, Integer.class)
                        .setParameter("idPanen", idPanen)
                        .uniqueResult();

                if (stokTerkini == null) stokTerkini = 0;
                int stokBaru = stokTerkini - jumlahPermintaan;

                if (stokBaru < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Stok gudang tidak mencukupi untuk memenuhi permintaan ini!\n" +
                            "Stok saat ini: " + stokTerkini + " Kg",
                            "Stok Tidak Cukup",
                            JOptionPane.WARNING_MESSAGE);
                    tx.rollback();
                    return false;
                }

                // Update stok di tabel hasil_panen
                newSession.createMutationQuery("""
                    UPDATE hasilPanen
                    SET stokGudang = :stokBaru
                    WHERE idPanen = :idPanen
                """)
                .setParameter("stokBaru", stokBaru)
                .setParameter("idPanen", idPanen)
                .executeUpdate();

                System.out.println("[INFO] Stok dikurangi sebesar " + jumlahPermintaan + 
                                   " Kg. Sisa stok: " + stokBaru + " Kg");
            }

            tx.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan saat memperbarui status: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public List<Permintaan> getForPetani(String idPetani) {
        Query<Permintaan> q = session.createQuery(
            "SELECT p FROM Permintaan p JOIN p.hasilPanen h WHERE h.idPetani = :p", Permintaan.class);
        q.setParameter("p", idPetani);
        return q.list();
    }

    public List<Object[]> getInfoPermintaan() {
        String hql = """
            SELECT p.idPermintaan, pt.namaLengkap, d.namaLengkap, 
                   p.jumlahPermintaan, p.status, p.tanggalPermintaan
            FROM Permintaan p
            JOIN p.hasilPanen h
            JOIN h.petani pt
            JOIN p.distributor d
            ORDER BY p.tanggalPermintaan DESC
        """;
        Query<Object[]> q = session.createQuery(hql, Object[].class);
        return q.list();
    }

    public List<Object[]> permintaanForDistributor() {
        String hql = """
            SELECT d.namaLengkap, d.namaUsaha, 
                   p.jumlahPermintaan, p.status, p.tanggalPermintaan
            FROM Permintaan p
            JOIN Distributor d ON p.idDistributor = d.idDistributor
            ORDER BY p.tanggalPermintaan DESC
        """;
        Query<Object[]> q = session.createQuery(hql, Object[].class);
        return q.list();
    }
public List<Object[]> permintaanForPetani() {
    List<Object[]> hasil = List.of();

    try (org.hibernate.Session session = Database.Koneksi.getInstance().getSession()) {
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = """
            SELECT 
                p.idPermintaan,
                d.namaUsaha,
                d.noTelp,
                d.wilayahPasar,
                p.jumlahPermintaan,
                p.status,
                p.tanggalPermintaan
            FROM Permintaan p
            JOIN Distributor d ON p.idDistributor = d.idDistributor
            """;

    hasil = session.createQuery(hql, Object[].class).getResultList();
    tx.commit();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return hasil;
}

    
}