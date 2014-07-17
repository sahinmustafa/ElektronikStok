package control;

import elektronikstok.view.AnaEkran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Kategori;
import model.Urun;

/**
 *
 * Sorunlu yerler !!! ile işaretlenmiştir
 */
public class AnaEkranKontrol implements ActionListener{
    
    AnaEkran anaEkran;  
    
    public AnaEkranKontrol() {
        this.anaEkran = new AnaEkran();
        kategorileriListele();
        urunleriGoster();
        actionAta();
        anaEkran.show();
    }
    
    public AnaEkranKontrol(AnaEkran anaEkran) {
        this.anaEkran = anaEkran;
    }

    private void kategorileriListele() {
        try{
            DefaultListModel listModel = new DefaultListModel();

            ArrayList <Kategori> kategoriler = new Kategori().listele(0);

            for(int i=0; i<kategoriler.size();i++){
                listModel.addElement(kategoriler.get(i).getKategoriAdi());
            }

            anaEkran.listkategori.setModel(listModel);
        }catch(Exception e){
            uyariMesaji("kategorileriListele", e);
        }
    }
    
    private void kategoriSil(){
        try{    
            if(anaEkran.listkategori.getSelectedIndex() >= 0 ){
                String kategoriAdi = anaEkran.listkategori.getSelectedValue().toString();
                
                //Seçili satirin id'sini al 
                int kategoriId = new Kategori().kategoriAdindanIdBul(kategoriAdi);
                Kategori silinecekKategori = new Kategori().getir(kategoriId);
                        
                //emin misin sorusu sor; eminse sil değilse bir şey yapma 
                if(onayIstegi("Silme Onayı", "\""+silinecekKategori.getKategoriAdi()+"\" adlı kategori kalıcı olarak silinecektir. Silmek istediğinize emin misiniz ?"))
                    silinecekKategori.sil(kategoriId);
            }
        }catch(Exception e){
            uyariMesaji("kategoriSil", e);
        }
    }

    private void urunleriGoster() {
        try{
            String aranan   = anaEkran.txtAra.getText();
            int kategoriId = -1;
            ArrayList <Urun> urunler;

            //kategori seçili ise isimden kategori id bul, bulunamazsa da kategoriId = -1 olur.
            if(anaEkran.listkategori.getSelectedIndex() >= 0){
                String kategori = anaEkran.listkategori.getSelectedValue().toString();
                kategoriId = new Kategori().kategoriAdindanIdBul(kategori);
            }

            urunler = new Urun().listele(kategoriId, aranan);

            DefaultTableModel tableModel = new DefaultTableModel();

            String kolonAdlari [] = {
                "ÜRÜN ID",
                "ADI",
                "ÖZELLİK",
                "MİKTAR",
                "ALIŞ",
                "SATIŞ",
                "KRİTİK STOK",
                "AÇIKLAMA",
                "BULUNDUĞU RAF"
            };

            Object [][] data = new Object[urunler.size()][kolonAdlari.length];

            for(int i=0;i<urunler.size(); i++){
                data[i][0] = urunler.get(i).getID();
                data[i][1] = urunler.get(i).getAdi();
                data[i][2] = urunler.get(i).getOzellik();
                data[i][3] = urunler.get(i).getStokMiktar();
                data[i][4] = urunler.get(i).getAlisFiyati();
                data[i][5] = urunler.get(i).getSatisFiyati();
                data[i][6] = urunler.get(i).getKritikStokMiktar();
                data[i][7] = urunler.get(i).getAciklama();
                data[i][8] = urunler.get(i).getRaf();
            }

            tableModel.setDataVector(data, kolonAdlari);

            anaEkran.tblUrunOzellik.setModel(tableModel);
        }catch(Exception e){
            uyariMesaji("urunleriGoster", e);
        }
    }

    
   

    private void actionAta() {
        try{
            //Ana Ekrandaki Butonlara Action Listener Ekleme 
            JButton[] butonlar = {anaEkran.btnAra,
                                  anaEkran.btnGuncelle,
                                  anaEkran.btnKategoriEkle,
                                  anaEkran.btnKategoriGuncelle,
                                  anaEkran.btnKategoriSil,
                                  anaEkran.btnSil,
                                  anaEkran.btnUrunAl,
                                  anaEkran.btnUrunSat,
                                  anaEkran.btnYeni
                                };

            for (JButton buton : butonlar) {
                buton.addActionListener(this);
            } 
            
            ListSelectionListener listSelectionListener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    urunleriGoster();
                }
             };
             anaEkran.listkategori.addListSelectionListener(listSelectionListener);
        
        }catch(Exception e){
            uyariMesaji("actionAta", e);
        }
    }
    
     private void urunGuncelleEkraniAc(){
        try{
            if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
                //Seçili satirin id'sini al 
                int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);
                UrunEkleKontrol uek = new UrunEkleKontrol(urunId);
            }
        }catch(Exception e){
            uyariMesaji("urunGuncelleEkraniAc", e);
        }
    }
  
    private void urunEkleEkraniGoster() {
        try{
            UrunEkleKontrol uek = new UrunEkleKontrol(Urun.YENI_URUN);
        }catch(Exception e){
            uyariMesaji("urunEkleEkraniGoster", e);
        }
    }

    
    private void kategoriEkleEkraniGoster() {
        try{
            KategoriKontrol kk = new KategoriKontrol();
        }catch(Exception e){
            uyariMesaji("kategoriEkleEkraniGoster", e);
        }
    }
    
    
    private void urunSil(){
        try{
            if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
                //Seçili satirin id'sini al 
                int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);

                //emin misin sorusu sor; eminse sil değilse bir şey yapma 
                if(onayIstegi("Silme Onayı", urunId+" numaralı ürün kalıcı olarak silinecektir. Silmek istediğinize emin misiniz ?"))
                    new Urun().sil(urunId);
            }
        }catch(Exception e){
            uyariMesaji("urunSil", e);
        }
    }
    
    /* Araci fonksiyon ile çağrildiklari için try catch gerektirmeyenler */
    private boolean onayIstegi(String baslik, String mesaj){
        return JOptionPane.showConfirmDialog(anaEkran, baslik, mesaj, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    private void uyariMesaji(String baslik, Exception e){
        JOptionPane.showConfirmDialog(anaEkran, e.getMessage(), baslik, JOptionPane.OK_OPTION);
        e.getSuppressed();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == anaEkran.btnAra){
            urunleriGoster();
        }else if(ae.getSource() == anaEkran.btnGuncelle){
            urunGuncelleEkraniAc();
        }else if(ae.getSource() == anaEkran.btnKategoriEkle){
            kategoriEkleEkraniGoster();
        }else if(ae.getSource() == anaEkran.btnKategoriGuncelle){
            //!!!Kategori View in değişmesi gerek
        }else if(ae.getSource() == anaEkran.btnKategoriSil){
            kategoriSil();
        }else if(ae.getSource() == anaEkran.btnSil){
            urunSil();
        }else if(ae.getSource() == anaEkran.btnUrunAl){
            //!!!Urun viewi gerek
        }else if(ae.getSource() == anaEkran.btnUrunSat){
            //!!!Urun viewi gerek
        }else if(ae.getSource() == anaEkran.btnYeni){
            urunEkleEkraniGoster();
        }
    }

 
    
   
}
