package control;

import elektronikstok.view.UrunEkle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Kategori;
import model.Urun;

public class UrunEkleKontrol implements ActionListener{
    
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
            if(urunId == Urun.YENI_URUN){
                urunEkle.btnUrunkaydet.setText("Ekle");
            }else{
                Urun urun = new Urun().getir(urunId);

                urunEkle.txtKategoriId.setText(urun.getKategori().getID()+"");
                urunEkle.txtUrunAciklama.setText(urun.getAciklama());
                urunEkle.txtUrunAdi.setText(urun.getAdi());
                urunEkle.txtUrunAlisFiyati.setText(urun.getAlisFiyati()+"");
                urunEkle.txtUrunBulunduguRaf.setText(urun.getRaf());
                urunEkle.txtUrunId.setText(urun.getID()+"");
                urunEkle.txtUrunKritikStokSeviyesi.setText(urun.getStokMiktar()+"");
                urunEkle.txtUrunMiktar.setText(urun.getKritikStokMiktar()+"");
                urunEkle.txtUrunOzellik.setText(urun.getOzellik());
                urunEkle.txtUrunSatisFiyati.setText(urun.getSatisFiyati()+"");

                urunEkle.btnUrunkaydet.setText("Güncelle");
            }
        }catch(Exception e){
            uyariMesaji("actionAta", e);
        }
    }
    

    private void actionAta() {
        try{
            urunEkle.btnUrunkaydet.addActionListener(this);
        }catch(Exception e){
            uyariMesaji("actionAta", e);
        }
    }
    
    /* Araci fonksiyon ile çağrildiklari için try catch gerektirmeyenler */
    private void uyariMesaji(String baslik, Exception e){
        JOptionPane.showConfirmDialog(urunEkle, e.toString(), baslik, JOptionPane.OK_OPTION);
        e.getSuppressed();
    }
    
   
    private void urunEkleVeyaGuncelle() {
        try{
            Urun u = new Urun();

            u.setAciklama(urunEkle.txtUrunAciklama.getText());
            u.setAdi(urunEkle.txtUrunAdi.getText());
            u.setAlisFiyati(Integer.parseInt(urunEkle.txtUrunAlisFiyati.getText()));
            u.setID(Integer.parseInt(urunEkle.txtUrunId.getText()));            
            u.setKritikStokMiktar(Integer.parseInt(urunEkle.txtUrunKritikStokSeviyesi.getText()));
            u.setOzellik(urunEkle.txtUrunOzellik.getText());
            u.setRaf(urunEkle.txtUrunBulunduguRaf.getText());
            u.setSatisFiyati(Integer.parseInt(urunEkle.txtUrunSatisFiyati.getText()));
            u.setStokMiktar(Integer.parseInt(urunEkle.txtUrunMiktar.getText()));

            //id den kategor nesnesi çekilerek ataniyor
            int kategoriId = Integer.parseInt(urunEkle.txtKategoriId.getText());
            u.setKategori(new Kategori().getir(kategoriId));

            if(urunId == Urun.YENI_URUN){
                u.ekle();
            }else{
                u.guncelle(urunId, u);
            }
        }catch(Exception e){
            uyariMesaji("urunEkleVeyaGuncelle", e);
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
