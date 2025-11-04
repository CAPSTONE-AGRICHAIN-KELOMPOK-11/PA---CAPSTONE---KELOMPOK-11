/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */
import Model.Petani;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class petaniService implements CRUDService<Petani> {

    private final Session session;

    public petaniService() {
        this.session = Koneksi.getInstance().getSession();
    }

    public String login(String username, String password) {
        try {
            var q = session.createSelectionQuery(
                "FROM Petani WHERE username = :u AND password = :p", Petani.class);
            q.setParameter("u", username);
            q.setParameter("p", password);
            Petani p = q.uniqueResult();
            return (p != null) ? p.getIdPetani() : null;
        } catch (Exception e) {
            System.err.println("[petaniService.login] " + e.getMessage());
            return null;
        }
    }

    public boolean isExist(String username) {
        try {
            var q = session.createSelectionQuery(
                "SELECT COUNT(p) FROM Petani p WHERE username = :u", Long.class);
            q.setParameter("u", username);
            Long count = q.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            System.err.println("[petaniService.isExist] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insert(Petani p) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[petaniService.insert] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Petani p) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[petaniService.update] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Petani p = session.find(Petani.class, id);
            if (p != null) session.remove(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[petaniService.delete] " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Petani> getAll() {
        try {
            return session.createSelectionQuery("FROM Petani", Petani.class).list();
        } catch (Exception e) {
            System.err.println("[petaniService.getAll] " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Petani> getAllWithSawah() {
        try {
            return session.createSelectionQuery("FROM Petani", Petani.class).list();
        } catch (Exception e) {
            System.err.println("[petaniService.getAllWithSawah] " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean updateInfo(Petani p) {
    Petani existing = session.find(Petani.class, p.getIdPetani());
    if (existing != null) {
        existing.setNoTelp(p.getNoTelp());
        existing.setNamaSawah(p.getNamaSawah());
        existing.setLokasi(p.getLokasi());
        existing.setLuasLahan(p.getLuasLahan());
        return update(existing);
    }
    return false;
    }

    public List<Object[]> getInfoPetani(String lokasi, String sortOrder) {
        try {
            String order = ("ASC".equalsIgnoreCase(sortOrder)) ? "ASC" : "DESC";
            String hql = """
                SELECT p.namaLengkap, p.noTelp, p.namaSawah, p.lokasi,
                       COALESCE(SUM(h.jumlahPanen), 0),
                       MAX(h.tanggalPanen)
                FROM Petani p
                LEFT JOIN hasilPanen h ON p.idPetani = h.idPetani
                WHERE p.lokasi LIKE :lok
                GROUP BY p.idPetani, p.namaLengkap, p.noTelp, p.namaSawah, p.lokasi
                ORDER BY COALESCE(SUM(h.jumlahPanen), 0) """ + order;

            var q = session.createSelectionQuery(hql, Object[].class);
            q.setParameter("lok", "%" + lokasi + "%");
            return q.list();
        } catch (Exception e) {
            System.err.println("[petaniService.getInfoPetani] " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
