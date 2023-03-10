/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.praktikumpbo.crudmahasiswasederhana.views;

import edu.praktikumpbo.crudmahasiswasederhana.controller.MahasiswaController;
import edu.praktikumpbo.crudmahasiswasederhana.interfc.MahasiswaInterface;
import edu.praktikumpbo.crudmahasiswasederhana.models.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.lang.AbstractMethodError;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Febri S
 * 21103016
 * SI05A
 */
public class MahasiswaFrame extends javax.swing.JFrame {

    List<Mahasiswa> record = new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;

    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();

        mahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                row = mahasiswaTable.getSelectedRow();
                if (row != -1) {
                    isiText();
                }
            }

        });
        this.statusAwal();
    }

    void loadData() {
        try {
            record = mhsServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
  
        }
    }
    
    void isiTabel() {
        Object data[][] = new Object[record.size()][3];
        int x = 0;
        for (Mahasiswa mhs : record) {
            data[x][0] = mhs.getNim();
            data[x][1] = mhs.getNama();
            data[x][2] = mhs.getAlamat();
            x++;
        }
        String judul[] = {"nim", "nama", "alamat"};
        mahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(mahasiswaTable);
    }

    void isiText() {
        Mahasiswa mhs = record.get(row);
        nimText.setText(mhs.getNim());
        namaText.setText(mhs.getNama());
        alamatText.setText(mhs.getAlamat());
    }

    void kosongkanText() {
        nimText.setText("");
        namaText.setText("");
        alamatText.setText("");
    }

    void statusAwal() {
        kosongkanText();
        loadData();
        isiTabel();
    }
       
    void validasiInput(Mahasiswa o){
        if(nimText.getText().equals("")){
            nimValidasiLabel.setText("NIM belum diisi");
            nimValidasiLabel.setVisible(true);
        }else if (!nimText.getText().matches("[0-9]*")){
            nimValidasiLabel.setText("NIM harus berisi angka");
            nimValidasiLabel.setVisible(true);
        }else if (nimText.getText().length()<5){
            nimValidasiLabel.setText("NIM minimal berisi 5 angka");
            nimValidasiLabel.setVisible(true);
        }else if (nimText.getText().length()>12){
            nimValidasiLabel.setText("NIM maksimal berisi 12 angka");
            nimValidasiLabel.setVisible(true);
        }else {
            o.setNim(nimText.getText());
            nimValidasiLabel.setVisible(false);
        }
        
        if (namaText.getText().equals("")){
            namaValidasiLabel.setText("Nama belum diisi");
            namaValidasiLabel.setVisible(true);
        }else {
            o.setNama(namaText.getText());
            namaValidasiLabel.setVisible(false);
        }
        
        if (alamatText.getText().equals("")){
            alamatValidasiLabel.setText("Alamat belum diisi");
            alamatValidasiLabel.setVisible(true);
        }else {
            o.setAlamat(alamatText.getText());
            alamatValidasiLabel.setVisible(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nimText = new javax.swing.JTextField();
        namaText = new javax.swing.JTextField();
        tambahBtn = new javax.swing.JButton();
        ubahbBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mahasiswaTable = new javax.swing.JTable();
        alamatText = new javax.swing.JTextField();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        alamatValidasiLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nim");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        nimText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextActionPerformed(evt);
            }
        });

        namaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextActionPerformed(evt);
            }
        });

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        ubahbBtn.setText("Ubah");
        ubahbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahbBtnActionPerformed(evt);
            }
        });

        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        mahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(mahasiswaTable);

        alamatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatTextActionPerformed(evt);
            }
        });

        nimValidasiLabel.setForeground(new java.awt.Color(204, 0, 51));
        nimValidasiLabel.setText("jLabel4");

        namaValidasiLabel.setForeground(new java.awt.Color(204, 0, 51));
        namaValidasiLabel.setText("jLabel5");

        alamatValidasiLabel.setBackground(new java.awt.Color(255, 255, 255));
        alamatValidasiLabel.setForeground(new java.awt.Color(204, 0, 51));
        alamatValidasiLabel.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaText, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                    .addComponent(nimText)
                                    .addComponent(alamatText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tambahBtn)
                                    .addComponent(ubahbBtn)
                                    .addComponent(hapusBtn))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nimValidasiLabel)
                                    .addComponent(namaValidasiLabel)
                                    .addComponent(alamatValidasiLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahBtn))
                .addGap(1, 1, 1)
                .addComponent(nimValidasiLabel)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahbBtn))
                .addGap(2, 2, 2)
                .addComponent(namaValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hapusBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamatValidasiLabel)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        alamatText.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nimTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_nimTextActionPerformed

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        try {
            // TODO add your handling code here:
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data tidak berhasil tersimpan");
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void ubahbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahbBtnActionPerformed
        try {
            // TODO add your handling code here:
            Mahasiswa mhs = new Mahasiswa();
            
            validasiInput(mhs);
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data tidak berhasil diubah");
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ubahbBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        try {
            // TODO add your handling code here:
            String nim = nimText.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data tidak berhasil dihapus");
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void namaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextActionPerformed

    private void alamatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatTextActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatText;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mahasiswaTable;
    private javax.swing.JTextField namaText;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JTextField nimText;
    private javax.swing.JLabel nimValidasiLabel;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JButton ubahbBtn;
    // End of variables declaration//GEN-END:variables
}
