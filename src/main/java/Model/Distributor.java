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
@Table(name = "distributor")
public class Distributor {
    @Id
    @Column(name = "id_distributor", nullable = false, length = 10)
    private String idDistributor;

    @Column(name = "nama_lengkap", nullable = false, length = 100)
    private String namaLengkap;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "no_telp", length = 15)
    private String noTelp;

    @Column(name = "nama_usaha", length = 100)
    private String namaUsaha;

    @Column(name = "wilayah_pasar", length = 150)
    private String wilayahPasar;

    @Column(name = "role", length = 20)
    private String role;

    public Distributor() {}

    public Distributor(String idDistributor, String namaLengkap, String username, String password,
                       String noTelp, String namaUsaha, String wilayahPasar, String role) {
        this.idDistributor = idDistributor;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.noTelp = noTelp;
        this.namaUsaha = namaUsaha;
        this.wilayahPasar = wilayahPasar;
        this.role = role;
    }

    // Getter & Setter
    public String getIdDistributor() { return idDistributor; }
    public void setIdDistributor(String idDistributor) { this.idDistributor = idDistributor; }
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    public String getNamaUsaha() { return namaUsaha; }
    public void setNamaUsaha(String namaUsaha) { this.namaUsaha = namaUsaha; }
    public String getWilayahPasar() { return wilayahPasar; }
    public void setWilayahPasar(String wilayahPasar) { this.wilayahPasar = wilayahPasar; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
