/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */
import Model.Distributor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class distributorService implements CRUDService<Distributor> {

    private final Session session;

    public distributorService() {
        this.session = Koneksi.getInstance().getSession();
    }

    @Override
    public boolean insert(Distributor d) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(d);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[distributorService.insert] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Distributor d) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(d);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[distributorService.update] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Distributor d = session.find(Distributor.class, id);
            if (d != null) session.remove(d);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[distributorService.delete] " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Distributor> getAll() {
        return session.createSelectionQuery("from Distributor", Distributor.class).list();
    }

    public String login(String username, String password) {
        var q = session.createSelectionQuery(
            "FROM Distributor WHERE username = :u AND password = :p", Distributor.class);
        q.setParameter("u", username);
        q.setParameter("p", password);
        Distributor d = q.uniqueResult();
        return (d != null) ? d.getIdDistributor() : null;
    }

    public boolean isExist(String username) {
        var q = session.createSelectionQuery(
            "SELECT COUNT(d) FROM Distributor d WHERE username = :u", Long.class);
        q.setParameter("u", username);
        Long count = q.uniqueResult();
        return count != null && count > 0;
    }

    public Distributor getByUsername(String username) {
        var q = session.createSelectionQuery(
            "FROM Distributor WHERE username = :u", Distributor.class);
        q.setParameter("u", username);
        return q.uniqueResult();
    }

    public boolean updateInfo(Distributor d) {
        return update(d);
    }

public Distributor getById(String id) {
    return session.get(Distributor.class, id);
}

}