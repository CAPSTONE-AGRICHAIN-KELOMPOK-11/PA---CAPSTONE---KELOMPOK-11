/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id_admin", nullable = false, length = 10)
    private String idAdmin;

    @Column(name = "nama_lengkap", nullable = false, length = 100)
    private String namaLengkap;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "no_telp", length = 15)
    private String noTelp;

    @Column(name = "posisi", length = 50)
    private String posisi;

    @Column(name = "role", length = 20)
    private String role;

    public Admin() {}

    public Admin(String idAdmin, String namaLengkap, String username, String password,
                 String noTelp, String posisi, String role) {
        this.idAdmin = idAdmin;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.noTelp = noTelp;
        this.posisi = posisi;
        this.role = role;
    }

    // Getter & Setter
    public String getIdAdmin() { return idAdmin; }
    public void setIdAdmin(String idAdmin) { this.idAdmin = idAdmin; }
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    public String getPosisi() { return posisi; }
    public void setPosisi(String posisi) { this.posisi = posisi; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
