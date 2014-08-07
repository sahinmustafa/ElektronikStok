package control;

import control.extra.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.StokDegisim;
import model.Urun;
import view.AlimSatimKaydi;

public class AlimSatimKaydiKontrol implements ActionListener{
    AlimSatimKaydi alimSatimKaydiEkrani;
    //Ürünlerin idsini bulmak için 
    private ArrayList <Urun> urunler;

    public AlimSatimKaydiKontrol(AlimSatimKaydi alimSatimKaydiEkrani) {
        this.alimSatimKaydiEkrani = alimSatimKaydiEkrani;
    }

    public AlimSatimKaydiKontrol() {
        this.alimSatimKaydiEkrani = new AlimSatimKaydi();
        txtDegerAta();
        actionAta();
        ekraniGuncelle();
        this.alimSatimKaydiEkrani.show();
    }
    
    private void ekraniGuncelle(){
        int urunId = -1;
       
        if(alimSatimKaydiEkrani.cmbxUrunSec.getSelectedIndex() > 0)
            urunId = urunler.get(alimSatimKaydiEkrani.cmbxUrunSec.getSelectedIndex()-1).getID();
        
        
        ArrayList <StokDegisim> stokDegisim = new StokDegisim().tariheGoreListele(
                urunId, 
                alimSatimKaydiEkrani.dtİlkTarih.getDate(), 
                alimSatimKaydiEkrani.dtSonTarih.getDate());
        
        alimSatimTablosuOlustur(stokDegisim);
    }
    
    public void alimSatimTablosuOlustur(ArrayList <StokDegisim> stokDegisim){
        
        DefaultTableModel tableModel = new DefaultTableModel();

        String kolonAdlari [] = {
            "ÜRÜN ADI",
            "TARİH",
            "ALIŞ",
            "SATIŞ",
            "DEĞİŞİM MİKTARI",
            "TUTAR",
            "ÖDEME ŞEKLİ"                
        };

        Object [][] data = new Object[stokDegisim.size()][kolonAdlari.length];

        int toplamAlim = 0, toplamSatim = 0;
        double toplamAlimTutari = 0 , toplamSatisTutari = 0;
        
        for(int i=0;i<stokDegisim.size(); i++){
            int stokDegisimMiktari = stokDegisim.get(i).getYeniMiktar() - stokDegisim.get(i).getEskiMiktar();
            
            data[i][0] = stokDegisim.get(i).getUrun().getAdi();
            data[i][1] = stokDegisim.get(i).getTarih();
            data[i][2] = stokDegisim.get(i).getUrun().getAlisFiyati();
            data[i][3] = stokDegisim.get(i).getUrun().getSatisFiyati();
            data[i][4] = stokDegisimMiktari;
            data[i][5] = stokDegisim.get(i).getTutar();
            data[i][6] = stokDegisim.get(i).getOdemeSekli();
            
            if(stokDegisimMiktari < 0){
                toplamSatim += stokDegisimMiktari;
                toplamSatisTutari += stokDegisim.get(i).getTutar();
            }else{
                toplamAlim += stokDegisimMiktari;
                toplamAlimTutari += stokDegisim.get(i).getTutar();
            }
        }

        alimSatimKaydiEkrani.txtToplamAlim.setText(toplamAlim+"");
        alimSatimKaydiEkrani.txtToplamSatis.setText(Math.abs(toplamSatim)+"");
        alimSatimKaydiEkrani.txtGelir.setText(toplamSatisTutari+"");
        alimSatimKaydiEkrani.txtToplamGider.setText(toplamAlimTutari+"");
        
        tableModel.setDataVector(data, kolonAdlari);
        alimSatimKaydiEkrani.tblAlimSatim.setModel(tableModel);
        alimSatimKaydiEkrani.tblAlimSatim.setDefaultRenderer(Object.class, new TableRenderer());

    }
    
    private void txtDegerAta(){
        urunler = new Urun().tumunuGetir();
        //Kategori değerleri olutşuruluyor
        alimSatimKaydiEkrani.cmbxUrunSec.addItem("Tümü");
        for(Urun urun : urunler){
            alimSatimKaydiEkrani.cmbxUrunSec.addItem(urun.getAdi());
        }   
        
        int ilkVarsayilanOncekiGunSayisi = 30;
        // get Calendar instance
        Calendar cal = Calendar.getInstance();
        // substract 7 days
        cal.set(Calendar.DATE, -ilkVarsayilanOncekiGunSayisi+5);
        // convert to date
        Date ilkTarih = cal.getTime();
        alimSatimKaydiEkrani.dtİlkTarih.setDate(ilkTarih);
        alimSatimKaydiEkrani.dtSonTarih.setDate(new Date());
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == alimSatimKaydiEkrani.cmbxUrunSec)
            ekraniGuncelle();
    }

    private void actionAta() {
        alimSatimKaydiEkrani.cmbxUrunSec.addActionListener (this);
        PropertyChangeListener dtChangeListener = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ekraniGuncelle();
            }
        };
        
        alimSatimKaydiEkrani.dtİlkTarih.addPropertyChangeListener(dtChangeListener);
        alimSatimKaydiEkrani.dtSonTarih.addPropertyChangeListener(dtChangeListener);
    }
        
}
