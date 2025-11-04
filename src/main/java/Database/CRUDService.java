/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ASUS
 */
import java.util.List;

public interface CRUDService<T> {
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(String id);
    List<T> getAll();
}
