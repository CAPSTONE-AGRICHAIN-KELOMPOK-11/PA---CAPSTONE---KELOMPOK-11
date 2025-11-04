/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */

import Database.Koneksi;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class generateID {

    private static String getNextID(String entityName, String idColumn, String prefix) {
        try (Session session = Koneksi.getInstance().getSession()) {
            String hql = "SELECT " + idColumn + " FROM " + entityName + " ORDER BY " + idColumn + " DESC";
            Query<String> q = session.createQuery(hql, String.class);
            q.setMaxResults(1);
            String last = q.uniqueResult();
            if (last != null) {
                int num = Integer.parseInt(last.replace(prefix, "")) + 1;
                return prefix + String.format("%02d", num);
            }
        } catch (Exception e) {
            System.err.println("[generateID] " + e.getMessage());
        }
        return prefix + "01";
    }

    public static String admin() { return getNextID("Admin", "idAdmin", "ADM"); }
    public static String petani() { return getNextID("Petani", "idPetani", "PET"); }
    public static String distributor() { return getNextID("Distributor", "idDistributor", "DIS"); }
    public static String panen() { return getNextID("hasilPanen", "idPanen", "PAN"); }
    public static String permintaan() { return getNextID("Permintaan", "idPermintaan", "PRM"); }
}
