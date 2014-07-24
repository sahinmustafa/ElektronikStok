package control;

import elektronikstok.view.UrunEkle;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Kategori;
import model.Urun;

public class UrunEkleKontrol extends GenelKontrol implements ActionListener{
    
    AnaEkranKontrol aek;
    UrunEkle urunEkle;
    int urunId;
    
    public UrunEkleKontrol(int urunId,AnaEkranKontrol aek) {
        this.urunEkle = new UrunEkle();
        this.urunId = urunId;
        this.aek = aek;
        txtDegerleriAta();
        actionAta();
        urunEkle.show();
    }
    
    public UrunEkleKontrol(UrunEkle urunEkle,AnaEkranKontrol aek) {
        this.urunEkle = urunEkle;
        this.aek = aek;
    }

    

    private void txtDegerleriAta() {
        try{
            ArrayList <Kategori> kategoriler = new Kategori().listele(0);
            //Kategori değerleri olutşuruluyor
            for(Kategori kategori : kategoriler){
                urunEkle.cmbxKategoriId.addItem(kategori.getKategoriAdi());
            }   
            
            if(urunId == Urun.YENI_URUN){
                urunEkle.txtUrunId.setText("0");
                urunEkle.btnUrunkaydet.setText("Ekle");
            }else{
                Urun urun = new Urun().getir(urunId);
                
                urunEkle.cmbxKategoriId.setSelectedItem(urun.getKategori().getKategoriAdi());
                
                urunEkle.txtUrunAciklama.setText(urun.getAciklama());
                urunEkle.txtUrunAdi.setText(urun.getAdi());
                urunEkle.txtUrunAlisFiyati.setText(urun.getAlisFiyati()+"");
                urunEkle.txtUrunBulunduguRaf.setText(urun.getRaf());
                urunEkle.txtUrunId.setText(urun.getID()+"");
                urunEkle.txtUrunKritikStokSeviyesi.setText(urun.getKritikStokMiktar()+"");
                urunEkle.txtUrunMiktar.setText(urun.getStokMiktar()+"");
                urunEkle.txtUrunOzellik.setText(urun.getOzellik());
                urunEkle.txtUrunSatisFiyati.setText(urun.getSatisFiyati()+"");

                urunEkle.btnUrunkaydet.setText("Güncelle");
            }
        }catch(Exception e){
            exceptionGoster("actionAta", e);
        }
    }
    

    private void actionAta() {
        try{
            urunEkle.btnUrunkaydet.addActionListener(this);
            urunEkle.btnUrunVazgec.addActionListener(this);
        }catch(Exception e){
            exceptionGoster("actionAta", e);
        }
    }
    
   
   
    private void urunEkleVeyaGuncelle() {
        try{
            Urun u = new Urun();

            String urunAdi = urunEkle.txtUrunAdi.getText();
            double alisFiyati = doubleKontrol(urunEkle.txtUrunAlisFiyati.getText());
            double satisFiyati = doubleKontrol(urunEkle.txtUrunSatisFiyati.getText());
            int kritik = intKontrol(urunEkle.txtUrunKritikStokSeviyesi.getText());
            int stok = intKontrol(urunEkle.txtUrunMiktar.getText());
            
            String hata = zorunluAlanKontrol(urunAdi, alisFiyati, satisFiyati, kritik, stok);
            
            if("".equals(hata)){
                u.setAciklama(urunEkle.txtUrunAciklama.getText());
                u.setAdi(urunAdi);
                u.setAlisFiyati(alisFiyati);
                u.setID(intKontrol(urunEkle.txtUrunId.getText()));            
                u.setKritikStokMiktar(kritik);
                u.setOzellik(urunEkle.txtUrunOzellik.getText());
                u.setRaf(urunEkle.txtUrunBulunduguRaf.getText());
                u.setSatisFiyati(satisFiyati);
                u.setStokMiktar(stok);

                //id den kategor nesnesi çekilerek ataniyor
                int kategoriId = new Kategori().kategoriAdindanIdBul(urunEkle.cmbxKategoriId.getSelectedItem().toString());
                u.setKategori(new Kategori().getir(kategoriId));

                if(urunId == Urun.YENI_URUN){
                    u.ekle();
                }else{
                    u.guncelle(urunId, u);
                }
                
                aek.kategorileriListele();
                urunEkle.hide();
            }else {
                uyariMesaji("Hatalı Değer(ler) Girildi", hata);
            }
        }catch(Exception e){
            exceptionGoster("urunEkleVeyaGuncelle", e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == urunEkle.btnUrunkaydet){
            urunEkleVeyaGuncelle();
        }else if(ae.getSource() == urunEkle.btnUrunVazgec){
            urunEkle.hide();
        }
    }

    private String zorunluAlanKontrol(String urunAdi, double alisFiyati, double satisFiyati, int kritik, int stok) {
        String hata = "";
        
        if("".equals(urunAdi))
            hata += "Ürün Adı Girmediniz !\n";
        if(alisFiyati == 0)
            hata += "Geçerli Alış Fiyatı Girmediniz !\n";
        if(alisFiyati < 0)
            hata += "Alış Fiyatı Negatif Olamaz !\n";
        if(satisFiyati == 0)
            hata += "Geçerli Satış Fiyatı Girmediniz !\n";
        if(satisFiyati < 0)
            hata += "Satış Fiyatı Negatif Olamaz !\n";
        if(kritik == 0)
            hata += "Geçerli Kritik Stok Miktarı Belirtilmedi !\n";
        if(kritik < 0)
            hata += "Kritik Stok Miktarı Negatif Olamaz !\n";
        if(stok == 0)
            hata += "Geçerli Stok Miktarı Belirtilmedi !\n";
        if(stok < 0)
            hata += "Stok Miktarı Negatif Olamaz !\n";
            
        
        return hata;
    }

}
