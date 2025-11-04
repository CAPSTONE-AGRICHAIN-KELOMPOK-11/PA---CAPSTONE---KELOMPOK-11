/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Session.UserSession;
import javax.swing.*;
import java.awt.*;
import view.HasilPanenForm;

/**
 *
 * @author Asus TUF
 */

public class MenuPetani extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPetani.class.getName());
    private final String idUser;
    private final String username;
    /**
     * Creates new form DashboardPetani
     */

    public MenuPetani() {
        initComponents();
        this.pack(); 
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.idUser = UserSession.getIdUser();
        this.username = UserSession.getUsername();
 
    java.net.URL panenURL = getClass().getResource("/TombolHasilPanen.png");
    if (panenURL != null) {
        javax.swing.ImageIcon panenIcon = new javax.swing.ImageIcon(panenURL);
        java.awt.Image imgPanen = panenIcon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        btnHasilPanen.setIcon(new javax.swing.ImageIcon(imgPanen));
        btnHasilPanen.setText("Hasil Panen");
        btnHasilPanen.setBorderPainted(false);
        btnHasilPanen.setContentAreaFilled(false);
        btnHasilPanen.setFocusPainted(false);
        btnHasilPanen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHasilPanen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHasilPanen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHasilPanen.setPreferredSize(new java.awt.Dimension(220, 240));
        btnHasilPanen.setSize(220, 240);
    } else {
        System.err.println("Gambar tidak ditemukan di /TombolHasilPanen.png");
    }

    java.net.URL permintaanURL = getClass().getResource("/TombolPermintaan.png");
    if (permintaanURL != null) {
        javax.swing.ImageIcon permintaanIcon = new javax.swing.ImageIcon(permintaanURL);
        java.awt.Image imgPermintaan = permintaanIcon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        btnPermintaan.setIcon(new javax.swing.ImageIcon(imgPermintaan));
        btnPermintaan.setText("Permintaan");

        btnPermintaan.setBorderPainted(false);
        btnPermintaan.setContentAreaFilled(false);
        btnPermintaan.setFocusPainted(false);
        btnPermintaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPermintaan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPermintaan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPermintaan.setPreferredSize(new java.awt.Dimension(220, 240));
        btnPermintaan.setSize(220, 240);
    } else {
        System.err.println("Gambar tidak ditemukan di /TombolPermintaan.png");
    }
    
    java.net.URL imgURL = getClass().getResource("/MenuPetaniBg.png");
    if (imgURL != null) {
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imgURL);
        java.awt.Image img = icon.getImage().getScaledInstance(
            800, 
            500, 
            java.awt.Image.SCALE_SMOOTH
        );
        lblPetaniBg.setIcon(new javax.swing.ImageIcon(img));
    } else {
        System.err.println("Gambar tidak ditemukan di /resources/MenuPetaniBg.png");
    }
}
    
public MenuPetani(String username) {
        this(); 
        setTitle("Dashboard Petani - " + username); 
        JLabel lblWelcome = new JLabel("Selamat datang, " + username + "!");
        lblWelcome.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBounds(30, 20, 400, 30);
        jPanel1.add(lblWelcome);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHasilPanen = new javax.swing.JButton();
        btnPermintaan = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        lblPetaniBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        btnHasilPanen.setText("Hasil Panen");
        btnHasilPanen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHasilPanenActionPerformed(evt);
            }
        });
        jPanel1.add(btnHasilPanen);
        btnHasilPanen.setBounds(150, 170, 250, 250);

        btnPermintaan.setText("Permintaan");
        btnPermintaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermintaanActionPerformed(evt);
            }
        });
        jPanel1.add(btnPermintaan);
        btnPermintaan.setBounds(410, 170, 250, 250);

        btnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(0, 102, 0));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar);
        btnKeluar.setBounds(660, 40, 90, 30);

        lblPetaniBg.setText("jLabel2");
        lblPetaniBg.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.add(lblPetaniBg);
        lblPetaniBg.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHasilPanenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHasilPanenActionPerformed
        new HasilPanenForm().setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_btnHasilPanenActionPerformed

    private void btnPermintaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermintaanActionPerformed
        PermintaanPetaniForm permintaan = new PermintaanPetaniForm();
        permintaan.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_btnPermintaanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Apakah Anda yakin ingin keluar?",
        "Konfirmasi Keluar",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    if (confirm == JOptionPane.YES_OPTION) {
        new DashboardLogin().setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_btnKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuPetani().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHasilPanen;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPermintaan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPetaniBg;
    // End of variables declaration//GEN-END:variables
}
