 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */

import Model.hasilPanen;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class hasilPanenService implements CRUDService<hasilPanen> {

    private final Session session;

    public hasilPanenService() {
        this.session = Koneksi.getInstance().getSession();
    }

    @Override
    public boolean insert(hasilPanen h) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(h);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[hasilPanenService.insert] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(hasilPanen h) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(h);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[hasilPanenService.update] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            hasilPanen h = session.find(hasilPanen.class, id);
            if (h != null) session.remove(h);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[hasilPanenService.delete] " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<hasilPanen> getAll() {
        return session.createSelectionQuery("from hasilPanen", hasilPanen.class).list();
    }

    public hasilPanen getById(String id) {
        return session.find(hasilPanen.class, id);
    }

    public String getLastPanenId() {
        Query<String> q = session.createQuery(
            "SELECT h.idPanen FROM hasilPanen h ORDER BY h.idPanen DESC", String.class);
        q.setMaxResults(1);
        return q.uniqueResult();
    }

public int getStokTerakhirByPetani(String idPetani) {
    session.clear();
    try (Session session = Koneksi.getInstance().getSession()) {
        String hql = "SELECT h.stokGudang FROM hasilPanen h WHERE h.idPetani = :id ORDER BY h.tanggalPanen DESC";
        var q = session.createSelectionQuery(hql, Integer.class);
        q.setParameter("id", idPetani);
        q.setMaxResults(1);
        Integer stok = q.uniqueResult();
        return stok != null ? stok : 0;
    } catch (Exception e) {
        System.err.println("[hasilPanenService.getStokTerakhirByPetani] " + e.getMessage());
        return 0;
    }
}

public List<hasilPanen> getByPetani(String idPetani) {
    try (Session session = Koneksi.getInstance().getSession()) {
        String hql = "FROM hasilPanen WHERE idPetani = :id";
        var q = session.createSelectionQuery(hql, hasilPanen.class);
        q.setParameter("id", idPetani);
        return q.list();
    } catch (Exception e) {
        System.err.println("[hasilPanenService.getByPetani] " + e.getMessage());
        return new ArrayList<>();
    }
}

    public String getDefaultPetaniId() {
        Query<String> q = session.createQuery(
            "SELECT p.idPetani FROM Petani p ORDER BY p.idPetani ASC", String.class);
        q.setMaxResults(1);
        return q.uniqueResult();
    }

    public String getDefaultAdminId() {
        Query<String> q = session.createQuery(
            "SELECT a.idAdmin FROM Admin a ORDER BY a.idAdmin ASC", String.class);
        q.setMaxResults(1);
        return q.uniqueResult();
    }

}