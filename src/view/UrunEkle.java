/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elektronikstok.view;

/**
 *
 * @author tuba
 */
public class UrunEkle extends javax.swing.JFrame {

    /**
     * Creates new form UrunEkle
     */
    public UrunEkle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUrunKritikStokSeviyesi9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblUrunId = new javax.swing.JLabel();
        lblUrunAdi = new javax.swing.JLabel();
        txtUrunId = new javax.swing.JTextField();
        txtUrunAdi = new javax.swing.JTextField();
        lblUrunMiktar = new javax.swing.JLabel();
        lblUrunOzellik = new javax.swing.JLabel();
        lblUrunAlisFiyati = new javax.swing.JLabel();
        lblUrunSatisFiyati = new javax.swing.JLabel();
        lblUrunKritikStokSeviyesi = new javax.swing.JLabel();
        lblKategoriId = new javax.swing.JLabel();
        lblBulunduguRaf = new javax.swing.JLabel();
        lblUrunBulunduguRaf = new javax.swing.JLabel();
        txtUrunMiktar = new javax.swing.JTextField();
        txtUrunOzellik = new javax.swing.JTextField();
        txtUrunAlisFiyati = new javax.swing.JTextField();
        txtUrunSatisFiyati = new javax.swing.JTextField();
        txtUrunKritikStokSeviyesi = new javax.swing.JTextField();
        txtUrunBulunduguRaf = new javax.swing.JTextField();
        btnUrunkaydet = new javax.swing.JButton();
        btnUrunVazgec = new javax.swing.JButton();
        lblUrunAciklama = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUrunAciklama = new javax.swing.JTextArea();
        cmbxKategoriId = new javax.swing.JComboBox();

        jLabel2.setText("jLabel2");

        jTextField8.setText("jTextField8");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ÜRÜN EKLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUrunId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunId.setText("ÜRÜN ID                        :");

        lblUrunAdi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunAdi.setText("ADI                                :");

        txtUrunId.setEditable(false);
        txtUrunId.setEnabled(false);

        txtUrunAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrunAdiActionPerformed(evt);
            }
        });

        lblUrunMiktar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunMiktar.setText("MİKTAR                         :");

        lblUrunOzellik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunOzellik.setText("ÖZELLİK                        :");

        lblUrunAlisFiyati.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunAlisFiyati.setText("ALIŞ FİYATI                    :");

        lblUrunSatisFiyati.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunSatisFiyati.setText("SATIŞ FİYATI                 :");

        lblUrunKritikStokSeviyesi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunKritikStokSeviyesi.setText("KRİTİK STOK SEVİYESİ  :");

        lblKategoriId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKategoriId.setText("KATEGORİ ID                 :");

        lblBulunduguRaf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBulunduguRaf.setText("BULUNDUĞU RAF          :");

        lblUrunBulunduguRaf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtUrunOzellik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrunOzellikActionPerformed(evt);
            }
        });

        txtUrunAlisFiyati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrunAlisFiyatiActionPerformed(evt);
            }
        });

        txtUrunSatisFiyati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrunSatisFiyatiActionPerformed(evt);
            }
        });

        btnUrunkaydet.setText("Kaydet");
        btnUrunkaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunkaydetActionPerformed(evt);
            }
        });

        btnUrunVazgec.setText("Vazgeç");
        btnUrunVazgec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunVazgecActionPerformed(evt);
            }
        });

        lblUrunAciklama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUrunAciklama.setText("AÇIKLAMA                     :");

        txtUrunAciklama.setColumns(20);
        txtUrunAciklama.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtUrunAciklama.setRows(5);
        jScrollPane1.setViewportView(txtUrunAciklama);

        cmbxKategoriId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxKategoriIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblUrunBulunduguRaf))
                    .addComponent(lblBulunduguRaf)
                    .addComponent(lblKategoriId)
                    .addComponent(lblUrunSatisFiyati)
                    .addComponent(lblUrunAlisFiyati)
                    .addComponent(lblUrunOzellik)
                    .addComponent(lblUrunMiktar)
                    .addComponent(lblUrunAdi)
                    .addComponent(lblUrunId)
                    .addComponent(lblUrunAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUrunKritikStokSeviyesi))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUrunKritikStokSeviyesi)
                    .addComponent(txtUrunSatisFiyati)
                    .addComponent(txtUrunAlisFiyati)
                    .addComponent(txtUrunOzellik)
                    .addComponent(txtUrunMiktar)
                    .addComponent(txtUrunAdi)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUrunkaydet)
                        .addGap(18, 18, 18)
                        .addComponent(btnUrunVazgec))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUrunId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(txtUrunBulunduguRaf, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cmbxKategoriId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(55, 55, 55))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblBulunduguRaf, lblKategoriId, lblUrunAciklama, lblUrunAdi, lblUrunAlisFiyati, lblUrunBulunduguRaf, lblUrunId, lblUrunKritikStokSeviyesi, lblUrunMiktar, lblUrunOzellik, lblUrunSatisFiyati});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUrunVazgec, btnUrunkaydet});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunId)
                    .addComponent(txtUrunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunAdi)
                    .addComponent(txtUrunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunMiktar)
                    .addComponent(txtUrunMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunOzellik)
                    .addComponent(txtUrunOzellik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunAlisFiyati)
                    .addComponent(txtUrunAlisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunSatisFiyati)
                    .addComponent(txtUrunSatisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUrunKritikStokSeviyesi)
                    .addComponent(txtUrunKritikStokSeviyesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKategoriId)
                    .addComponent(cmbxKategoriId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBulunduguRaf)
                    .addComponent(txtUrunBulunduguRaf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUrunVazgec)
                            .addComponent(btnUrunkaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblUrunAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUrunBulunduguRaf)
                        .addContainerGap(92, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUrunVazgec, btnUrunkaydet});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUrunAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrunAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrunAdiActionPerformed

    private void txtUrunOzellikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrunOzellikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrunOzellikActionPerformed

    private void txtUrunAlisFiyatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrunAlisFiyatiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrunAlisFiyatiActionPerformed

    private void txtUrunSatisFiyatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrunSatisFiyatiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrunSatisFiyatiActionPerformed

    private void btnUrunkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunkaydetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunkaydetActionPerformed

    private void btnUrunVazgecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunVazgecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunVazgecActionPerformed

    private void cmbxKategoriIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxKategoriIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxKategoriIdActionPerformed

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
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnUrunVazgec;
    public javax.swing.JButton btnUrunkaydet;
    public javax.swing.JComboBox cmbxKategoriId;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField8;
    public javax.swing.JLabel lblBulunduguRaf;
    public javax.swing.JLabel lblKategoriId;
    public javax.swing.JLabel lblUrunAciklama;
    public javax.swing.JLabel lblUrunAdi;
    public javax.swing.JLabel lblUrunAlisFiyati;
    public javax.swing.JLabel lblUrunBulunduguRaf;
    public javax.swing.JLabel lblUrunId;
    public javax.swing.JLabel lblUrunKritikStokSeviyesi;
    public javax.swing.JLabel lblUrunMiktar;
    public javax.swing.JLabel lblUrunOzellik;
    public javax.swing.JLabel lblUrunSatisFiyati;
    public javax.swing.JTextArea txtUrunAciklama;
    public javax.swing.JTextField txtUrunAdi;
    public javax.swing.JTextField txtUrunAlisFiyati;
    public javax.swing.JTextField txtUrunBulunduguRaf;
    public javax.swing.JTextField txtUrunId;
    public javax.swing.JTextField txtUrunKritikStokSeviyesi;
    private javax.swing.JTextField txtUrunKritikStokSeviyesi9;
    public javax.swing.JTextField txtUrunMiktar;
    public javax.swing.JTextField txtUrunOzellik;
    public javax.swing.JTextField txtUrunSatisFiyati;
    // End of variables declaration//GEN-END:variables
}
