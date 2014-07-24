package control;

import elektronikstok.view.Kategori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KategoriKontrol extends GenelKontrol implements ActionListener{
    Kategori kategori;
    int kategoriId;
    
    public KategoriKontrol(int kategoriId) {
        this.kategori = new Kategori();
        this.kategoriId = kategoriId;
        txtDegerleriAta();
        actionAta();
        kategori.show();
    }

    public KategoriKontrol(Kategori kategori) {
        this.kategori = kategori;
    }
    

    private void txtDegerleriAta() {
        try{
            if(kategoriId == model.Kategori.YENI_KATEGORI){
                kategori.btnKategoriEkle.setText("Ekle");
            }else{
                model.Kategori k = new model.Kategori().getir(kategoriId);
                
                kategori.btnKategoriEkle.setText("Güncelle");
                kategori.txtKategoriAdi.setText(k.getKategoriAdi());
                kategori.txtKategoriAciklama.setText(k.getAciklama());
            }
        }catch(Exception e){
            exceptionGoster("txtDegerleriAta", e);
        }
    }
    
    
    private void actionAta() {
        try{
            kategori.btnKategoriEkle.addActionListener(this);
        }catch(Exception e){
            exceptionGoster("kategorileriListele", e);
        }
    }
    
    private void kategoriEkleVeyaGuncelle() {
        try{
            model.Kategori k = new model.Kategori();

            k.setKategoriAdi(kategori.txtKategoriAdi.getText());
            k.setAciklama(kategori.txtKategoriAciklama.getText());

            if(kategoriId == model.Kategori.YENI_KATEGORI)
                k.ekle();
            else
                k.guncelle(kategoriId, k);
               
            k.kategoriYedekle();
            kategori.hide();
        }catch(Exception e){
            exceptionGoster("kategoriEkle", e);
        }
    }
    
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == kategori.btnKategoriEkle){
            kategoriEkleVeyaGuncelle();
        }
    }


    
    
}
