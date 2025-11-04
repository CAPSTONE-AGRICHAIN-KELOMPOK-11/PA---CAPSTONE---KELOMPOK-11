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
import java.util.Date;

@Entity
@Table(name = "permintaan")
public class Permintaan {
    @Id
    @Column(name = "id_permintaan", nullable = false, length = 10)
    private String idPermintaan;

    @Column(name = "jumlah_permintaan", nullable = false)
    private int jumlahPermintaan;

    @Column(name = "id_panen", length = 10)
    private String idPanen;

    @Column(name = "id_distributor", length = 10)
    private String idDistributor;

    @Column(name = "id_admin", length = 10)
    private String idAdmin;

    @Column(name = "status", length = 20)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_permintaan")
    private Date tanggalPermintaan;

    public Permintaan() {}

    public Permintaan(String idPermintaan, int jumlahPermintaan, String idPanen,
                      String idDistributor, String idAdmin, String status, Date tanggalPermintaan) {
        this.idPermintaan = idPermintaan;
        this.jumlahPermintaan = jumlahPermintaan;
        this.idPanen = idPanen;
        this.idDistributor = idDistributor;
        this.idAdmin = idAdmin;
        this.status = status;
        this.tanggalPermintaan = tanggalPermintaan;
    }

    // Getter & Setter
    public String getIdPermintaan() { return idPermintaan; }
    public void setIdPermintaan(String idPermintaan) { this.idPermintaan = idPermintaan; }
    public int getJumlahPermintaan() { return jumlahPermintaan; }
    public void setJumlahPermintaan(int jumlahPermintaan) { this.jumlahPermintaan = jumlahPermintaan; }
    public String getIdPanen() { return idPanen; }
    public void setIdPanen(String idPanen) { this.idPanen = idPanen; }
    public String getIdDistributor() { return idDistributor; }
    public void setIdDistributor(String idDistributor) { this.idDistributor = idDistributor; }
    public String getIdAdmin() { return idAdmin; }
    public void setIdAdmin(String idAdmin) { this.idAdmin = idAdmin; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Date getTanggalPermintaan() { return tanggalPermintaan; }
    public void setTanggalPermintaan(Date tanggalPermintaan) { this.tanggalPermintaan = tanggalPermintaan; }
}
