/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Koneksi {
    private static Koneksi instance;
    private static SessionFactory sessionFactory;
    
    private Koneksi() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("[Koneksi] Hibernate SessionFactory berhasil dibuat.");
        } catch (Exception e) {
            System.err.println("[Koneksi] Gagal membuat SessionFactory: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Gagal inisialisasi Hibernate SessionFactory", e);
        }
    }

    public static synchronized Koneksi getInstance() {
        if (instance == null) {
            instance = new Koneksi();
        }
        return instance;
    }

    public Session getSession() {
        if (sessionFactory == null) {
            throw new IllegalStateException("SessionFactory belum diinisialisasi!");
        }
        return sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory factory) {
        if (factory != null) {
            sessionFactory = factory;
        }
    }

    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("[Koneksi] SessionFactory ditutup.");
        }
    }
}