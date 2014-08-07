package control;

import elektronikstok.view.Kategori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListModel;

public class KategoriKontrol extends GenelKontrol implements ActionListener{
    AnaEkranKontrol aek;
    Kategori kategori;
    int kategoriId;
    
    public KategoriKontrol(int kategoriId,AnaEkranKontrol aek) {
        this.kategori = new Kategori();
        this.kategoriId = kategoriId;
        this.aek = aek;
        txtDegerleriAta();
        actionAta();
        kategori.show();
    }

    public KategoriKontrol(Kategori kategori, AnaEkranKontrol aek) {
        this.kategori = kategori;
        this.aek = aek;
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
            String hata = kategoriAdiKontrol();
            if("".equals(hata)){
                k.setKategoriAdi(kategori.txtKategoriAdi.getText());
                k.setAciklama(kategori.txtKategoriAciklama.getText());

                if(kategoriId == model.Kategori.YENI_KATEGORI)
                    k.ekle();
                else
                    k.guncelle(kategoriId, k);

                aek.kategorileriListele();

                k.kategoriYedekle();
                kategori.hide();
            }else{
                uyariMesaji("HATALI DEĞER", hata);
            }
        }catch(Exception e){
            exceptionGoster("kategoriEkle", e);
        }
    }
    
    private String kategoriAdiKontrol(){
        String yeniKategoriAdi = kategori.txtKategoriAdi.getText();
        if(!"".equals(yeniKategoriAdi)){
            ListModel kategoriModel = aek.anaEkran.listkategori.getModel();
            for(int i=0; i<kategoriModel.getSize(); i++){
                if(yeniKategoriAdi.equals(kategoriModel.getElementAt(i).toString()))
                    return "Kategori Adı Mevcut";
            }
        }else{
            return "Kategori Adı Boş Olamaz";
        }
        return "";
    }
    
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == kategori.btnKategoriEkle){
            kategoriEkleVeyaGuncelle();
        }
    }


    
    
}
