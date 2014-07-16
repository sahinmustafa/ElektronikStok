
package control;

import elektronikstok.view.UrunEkle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Urun;

public class UrunEkleKontrol implements ActionListener{
    
    UrunEkle urunEkle;
    
    public UrunEkleKontrol() {
        this.urunEkle = new UrunEkle();
        txtDegerleriAta();
        actionAta();
    }
    
    public UrunEkleKontrol(UrunEkle urunEkle) {
        this.urunEkle = urunEkle;
    }

    

    private void txtDegerleriAta() {
        int urunId = 0;
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
        
    }

    private void actionAta() {
        urunEkle.btnUrunEkle.addActionListener(new UrunEkleKontrol(urunEkle));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == urunEkle.btnUrunEkle){
        
        }
    }
}
