/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */
import Model.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class adminService implements CRUDService<Admin> {
    private final Session session;

    public adminService() {
        this.session = Koneksi.getInstance().getSession();
    }

    @Override
    public boolean insert(Admin a) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[adminService.insert] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Admin a) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[adminService.update] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Admin a = session.get(Admin.class, id);
            if (a != null) session.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[adminService.delete] " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Admin> getAll() {
        return session.createQuery("from Admin", Admin.class).list();
    }

    public String login(String username, String password) {
        Query<Admin> q = session.createQuery(
            "FROM Admin WHERE username = :u AND password = :p", Admin.class);
        q.setParameter("u", username);
        q.setParameter("p", password);
        Admin result = q.uniqueResult();
        return (result != null) ? result.getIdAdmin() : null;
    }

    public boolean isExist(String username) {
        Query<Long> q = session.createQuery(
            "SELECT COUNT(a) FROM Admin a WHERE a.username = :u", Long.class);
        q.setParameter("u", username);
        return q.uniqueResult() > 0;
    }
}
