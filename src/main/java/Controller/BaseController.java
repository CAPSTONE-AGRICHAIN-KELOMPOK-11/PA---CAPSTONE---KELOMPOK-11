/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Database.CRUDService;
import java.util.List;

public abstract class BaseController<T> {
    
    protected CRUDService<T> service;

    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public abstract boolean delete(String id);

    public List<T> getAll() {
        return service.getAll();
    }
    public T findById(String id) {
        log("findById belum diimplementasikan di subclass");
        return null;
    }

    protected void log(String message) {
        System.out.println("[Controller Log] " + message);
    }
}