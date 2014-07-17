package control;

import elektronikstok.view.Kategori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        kategori.btnKategoriEkle.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == kategori.btnKategoriEkle){
            model.Kategori k = new model.Kategori();
            
            k.setKategoriAdi(kategori.txtKategoriAdi.getText());
            k.setAciklama(kategori.txtKategoriAciklama.getText());
            
            k.ekle();
        }
    }
    
}
