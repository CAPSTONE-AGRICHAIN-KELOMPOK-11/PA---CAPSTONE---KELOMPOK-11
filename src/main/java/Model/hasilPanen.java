package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hasil_panen")
public class hasilPanen {
    @Id
    @Column(name = "id_panen", nullable = false, length = 10)
    private String idPanen;

    @Column(name = "jumlah_panen", nullable = false)
    private int jumlahPanen;

    @Column(name = "stok_gudang")
    private int stokGudang;

    @Column(name = "satuan", length = 20)
    private String satuan;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_panen")
    private Date tanggalPanen;

    @Column(name = "id_petani", length = 10)
    private String idPetani;

    @Column(name = "id_admin", length = 10)
    private String idAdmin;

    public hasilPanen() {}

    public hasilPanen(String idPanen, int jumlahPanen, int stokGudang, String satuan,
                      Date tanggalPanen, String idPetani, String idAdmin) {
        this.idPanen = idPanen;
        this.jumlahPanen = jumlahPanen;
        this.stokGudang = stokGudang;
        this.satuan = satuan;
        this.tanggalPanen = tanggalPanen;
        this.idPetani = idPetani;
        this.idAdmin = idAdmin;
    }

    // Getters & Setters
    public String getIdPanen() { return idPanen; }
    public void setIdPanen(String idPanen) { this.idPanen = idPanen; }
    public int getJumlahPanen() { return jumlahPanen; }
    public void setJumlahPanen(int jumlahPanen) { this.jumlahPanen = jumlahPanen; }
    public int getStokGudang() { return stokGudang; }
    public void setStokGudang(int stokGudang) { this.stokGudang = stokGudang; }
    public String getSatuan() { return satuan; }
    public void setSatuan(String satuan) { this.satuan = satuan; }
    public Date getTanggalPanen() { return tanggalPanen; }
    public void setTanggalPanen(Date tanggalPanen) { this.tanggalPanen = tanggalPanen; }
    public String getIdPetani() { return idPetani; }
    public void setIdPetani(String idPetani) { this.idPetani = idPetani; }
    public String getIdAdmin() { return idAdmin; }
    public void setIdAdmin(String idAdmin) { this.idAdmin = idAdmin; }
}
