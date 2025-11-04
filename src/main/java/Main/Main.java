/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

/**
 *
 * @author ASUS
 */
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import view.DashboardLogin;

public class Main {
    public static void main(String[] args) {
        try {
            // Gunakan tema FlatLaf (modern, clean)
            UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacLightLaf());
        } catch (Exception e) {
            System.err.println("Gagal set Look and Feel FlatLaf!");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DashboardLogin().setVisible(true);
        });
    }
}
