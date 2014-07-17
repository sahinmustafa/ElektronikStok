package control;

import elektronikstok.view.Kategori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class KategoriKontrol implements ActionListener{
    Kategori kategori;
    
    public KategoriKontrol() {
        this.kategori = new Kategori();
        actionAta();
    }

    public KategoriKontrol(Kategori kategori) {
        this.kategori = kategori;
    }
    

    private void actionAta() {
        try{
            kategori.btnKategoriEkle.addActionListener(this);
        }catch(Exception e){
            uyariMesaji("kategorileriListele", e.getMessage());
        }
    }
    
    private void kategoriEkle() {
        try{
            model.Kategori k = new model.Kategori();

            k.setKategoriAdi(kategori.txtKategoriAdi.getText());
            k.setAciklama(kategori.txtKategoriAciklama.getText());

            k.ekle();
        }catch(Exception e){
            uyariMesaji("kategoriEkle", e.getMessage());
        }
    }
    
    /* Araci fonksiyon ile çağrildiklari için try catch gerektirmeyenler */
    private void uyariMesaji(String baslik, String mesaj){
        JOptionPane.showConfirmDialog(kategori, mesaj, baslik, JOptionPane.OK_OPTION);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == kategori.btnKategoriEkle){
            kategoriEkle();
        }
    }

    
    
}
