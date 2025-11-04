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
@Table(name = "petani")
public class Petani {
    @Id
    @Column(name = "id_petani", nullable = false, length = 10)
    private String idPetani;

    @Column(name = "nama_lengkap", nullable = false, length = 100)
    private String namaLengkap;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "no_telp", length = 15)
    private String noTelp;

    @Column(name = "nama_sawah", length = 100)
    private String namaSawah;

    @Column(name = "lokasi", length = 150)
    private String lokasi;

    @Column(name = "luas_lahan")
    private int luasLahan;

    @Column(name = "role", length = 20)
    private String role;

    public Petani() {}

    public Petani(String idPetani, String namaLengkap, String username, String password,
                  String noTelp, String namaSawah, String lokasi, int luasLahan, String role) {
        this.idPetani = idPetani;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.noTelp = noTelp;
        this.namaSawah = namaSawah;
        this.lokasi = lokasi;
        this.luasLahan = luasLahan;
        this.role = role;
    }

    // Getter & Setter
    public String getIdPetani() { return idPetani; }
    public void setIdPetani(String idPetani) { this.idPetani = idPetani; }
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    public String getNamaSawah() { return namaSawah; }
    public void setNamaSawah(String namaSawah) { this.namaSawah = namaSawah; }
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public int getLuasLahan() { return luasLahan; }
    public void setLuasLahan(int luasLahan) { this.luasLahan = luasLahan; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
