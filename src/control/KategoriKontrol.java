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
        kategori.show();
    }

    public KategoriKontrol(Kategori kategori) {
        this.kategori = kategori;
    }
    

    private void actionAta() {
        try{
            kategori.btnKategoriEkle.addActionListener(this);
        }catch(Exception e){
            uyariMesaji("kategorileriListele", e);
        }
    }
    
    private void kategoriEkle() {
        try{
            model.Kategori k = new model.Kategori();

            k.setKategoriAdi(kategori.txtKategoriAdi.getText());
            k.setAciklama(kategori.txtKategoriAciklama.getText());

            k.ekle();
        }catch(Exception e){
            uyariMesaji("kategoriEkle", e);
        }
    }
    
    /* Araci fonksiyon ile çağrildiklari için try catch gerektirmeyenler */
    private void uyariMesaji(String baslik, Exception e){
        JOptionPane.showConfirmDialog(kategori, e.toString(), baslik, JOptionPane.OK_OPTION);
        e.getSuppressed();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == kategori.btnKategoriEkle){
            kategoriEkle();
        }
    }

    
    
}
