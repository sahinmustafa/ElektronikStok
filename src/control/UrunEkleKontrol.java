package control;

import elektronikstok.view.UrunEkle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Urun;

public class UrunEkleKontrol implements ActionListener{
    
    UrunEkle urunEkle;
    int urunId;
    
    public UrunEkleKontrol(int urunId) {
        this.urunEkle = new UrunEkle();
        this.urunId = urunId;
        txtDegerleriAta();
        actionAta();
    }
    
    public UrunEkleKontrol(UrunEkle urunEkle) {
        this.urunEkle = urunEkle;
    }

    

    private void txtDegerleriAta() {
        if(urunId == Urun.YENI_URUN){
            urunEkle.btnUrunEkle.setText("Ekle");
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
            
            urunEkle.btnUrunEkle.setText("Güncelle");
        }
    }

    private void actionAta() {
        urunEkle.btnUrunEkle.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == urunEkle.btnUrunEkle){
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
            
            //!!! içerisindeki kategori id'ye txt den gelen id yi atadım
            u.getKategori().setID(Integer.parseInt(urunEkle.txtKategoriId.getText()));
            
            if(urunId == Urun.YENI_URUN){
                u.ekle();
            }else{
                u.guncelle(urunId, u);
            }
        }
    }
}
