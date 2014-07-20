package control;

import elektronikstok.view.UrunEkle;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Kategori;
import model.Urun;

public class UrunEkleKontrol extends GenelKontrol implements ActionListener{
    
    UrunEkle urunEkle;
    int urunId;
    
    public UrunEkleKontrol(int urunId) {
        this.urunEkle = new UrunEkle();
        this.urunId = urunId;
        txtDegerleriAta();
        actionAta();
        urunEkle.show();
    }
    
    public UrunEkleKontrol(UrunEkle urunEkle) {
        this.urunEkle = urunEkle;
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
                
                //urunEkle.cmbxKategoriId.setSelectedItem(urun.getKategori().getKategoriAdi());
                System.out.println(urun.getKategori());
                
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

            u.setAciklama(urunEkle.txtUrunAciklama.getText());
            u.setAdi(urunEkle.txtUrunAdi.getText());
            u.setAlisFiyati(doubleKontrol(urunEkle.txtUrunAlisFiyati.getText()));
            u.setID(intKontrol(urunEkle.txtUrunId.getText()));            
            u.setKritikStokMiktar(intKontrol(urunEkle.txtUrunKritikStokSeviyesi.getText()));
            u.setOzellik(urunEkle.txtUrunOzellik.getText());
            u.setRaf(urunEkle.txtUrunBulunduguRaf.getText());
            u.setSatisFiyati(doubleKontrol(urunEkle.txtUrunSatisFiyati.getText()));
            u.setStokMiktar(intKontrol(urunEkle.txtUrunMiktar.getText()));

            //id den kategor nesnesi çekilerek ataniyor
            int kategoriId = new Kategori().kategoriAdindanIdBul(urunEkle.cmbxKategoriId.getSelectedItem().toString());
            u.setKategori(new Kategori().getir(kategoriId));

            if(urunId == Urun.YENI_URUN){
                u.ekle();
            }else{
                u.guncelle(urunId, u);
            }
            urunEkle.hide();
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

}
