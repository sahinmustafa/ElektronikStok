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
public class AnaEkran extends javax.swing.JFrame {

    /**
     * Creates new form AnaEkran
     */
    public AnaEkran() {
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

        pnlKategoriListesi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listkategori = new javax.swing.JList();
        btnKategoriEkle = new javax.swing.JButton();
        btnKategoriSil = new javax.swing.JButton();
        btnKategoriGuncelle = new javax.swing.JButton();
        pnlUrunBilgileri = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUrunOzellik = new javax.swing.JTable();
        btnYeni = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnUrunAl = new javax.swing.JButton();
        btnUrunSat = new javax.swing.JButton();
        txtAra = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlKategoriListesi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori Listesi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jScrollPane1.setViewportView(listkategori);

        btnKategoriEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elektronikstok/view/add (1).png"))); // NOI18N

        btnKategoriSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elektronikstok/view/refresh (1).png"))); // NOI18N
        btnKategoriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriSilActionPerformed(evt);
            }
        });

        btnKategoriGuncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elektronikstok/view/edit_delete (2).png"))); // NOI18N

        javax.swing.GroupLayout pnlKategoriListesiLayout = new javax.swing.GroupLayout(pnlKategoriListesi);
        pnlKategoriListesi.setLayout(pnlKategoriListesiLayout);
        pnlKategoriListesiLayout.setHorizontalGroup(
            pnlKategoriListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addGroup(pnlKategoriListesiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKategoriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKategoriGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKategoriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlKategoriListesiLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnKategoriEkle, btnKategoriGuncelle, btnKategoriSil});

        pnlKategoriListesiLayout.setVerticalGroup(
            pnlKategoriListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKategoriListesiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlKategoriListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnKategoriGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKategoriSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKategoriEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlUrunBilgileri.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        tblUrunOzellik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ÜRÜN ID", "ADI", "ÖZELLİK", "MİKTAR", "ALIŞ FİYATI", "SATIŞ FİYATI", "KRİTİK STOK SEVİYESİ", "KATEGORİ ID", "AÇIKLAMA", "BULUNDUĞU RAF"
            }
        ));
        jScrollPane2.setViewportView(tblUrunOzellik);

        btnYeni.setText("Yeni");

        btnGuncelle.setText("Güncelle");

        btnSil.setText("Sil");

        btnUrunAl.setText("Ürün Al");

        btnUrunSat.setText("Ürün Sat");
        btnUrunSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunSatActionPerformed(evt);
            }
        });

        txtAra.setText("Ara");

        btnAra.setText("Ara");

        javax.swing.GroupLayout pnlUrunBilgileriLayout = new javax.swing.GroupLayout(pnlUrunBilgileri);
        pnlUrunBilgileri.setLayout(pnlUrunBilgileriLayout);
        pnlUrunBilgileriLayout.setHorizontalGroup(
            pnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUrunBilgileriLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlUrunBilgileriLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(pnlUrunBilgileriLayout.createSequentialGroup()
                        .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUrunBilgileriLayout.createSequentialGroup()
                        .addComponent(btnYeni, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUrunAl, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUrunSat, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pnlUrunBilgileriLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGuncelle, btnSil, btnUrunAl, btnUrunSat, btnYeni});

        pnlUrunBilgileriLayout.setVerticalGroup(
            pnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUrunBilgileriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYeni, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunAl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunSat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlKategoriListesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlUrunBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlKategoriListesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUrunBilgileri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKategoriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriSilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriSilActionPerformed

    private void btnUrunSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunSatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUrunSatActionPerformed

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
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAra;
    public javax.swing.JButton btnGuncelle;
    public javax.swing.JButton btnKategoriEkle;
    public javax.swing.JButton btnKategoriGuncelle;
    public javax.swing.JButton btnKategoriSil;
    public javax.swing.JButton btnSil;
    public javax.swing.JButton btnUrunAl;
    public javax.swing.JButton btnUrunSat;
    public javax.swing.JButton btnYeni;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList listkategori;
    public javax.swing.JPanel pnlKategoriListesi;
    public javax.swing.JPanel pnlUrunBilgileri;
    public javax.swing.JTable tblUrunOzellik;
    public javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
