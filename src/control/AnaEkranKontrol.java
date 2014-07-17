package control;

import elektronikstok.view.AnaEkran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    }
    
    public AnaEkranKontrol(AnaEkran anaEkran) {
        this.anaEkran = anaEkran;
    }

    private void kategorileriListele() {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList <Kategori> kategoriler = new Kategori().listele(0);
        
        for(int i=0; i<kategoriler.size();i++){
            listModel.addElement(kategoriler.get(i).getKategoriAdi());
        }
        
        anaEkran.listkategori.setModel(listModel);
    }

    private void urunleriGoster() {
        String kategori = anaEkran.listkategori.getSelectedValue().toString();
        String aranan   = anaEkran.txtAra.getText();
        int kategoriId = new Kategori().kategoriAdindanIdBul(kategori);
        
        /*
            !!!
            Kategori içerisinde kategoriAdindanIdBul fonksiyonu gerekli
            Bütün kategorideki ürünleri listelemek için bir yöntem belirlemek gerek,
            Bunun dışında ürün görüntüleme işlemlerine (Arama, kategori ürünlerini gösterde, kategoride arama) cevap verir gibi duruyor.
            Bir de actionPerformed biraz karişik duruyor sanki
        */
        ArrayList <Urun> urunler = new Urun().listele(kategoriId, aranan);
        
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
    }

    
   

    private void actionAta() {
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
    }
    
     private void urunGuncelleEkraniAc(){
        if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
            //Seçili satirin id'sini al 
            int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);
            UrunEkleKontrol uek = new UrunEkleKontrol(urunId);
        }
    }
  
    private void urunSil(){
        if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
            //Seçili satirin id'sini al 
            int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);
            
            //emin misin sorusu sor; eminse sil değilse bir şey yapma 
            if(onayIstegi("Silme Onayı", urunId+" numaralı ürün kalıcı olarak silinecektir. Silmek istediğinize emin misiniz ?"))
                new Urun().sil(urunId);
        }
    }
    
    private boolean onayIstegi(String baslik, String mesaj){
        return JOptionPane.showConfirmDialog(anaEkran, baslik, mesaj, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == anaEkran.btnAra){
            urunleriGoster();
        }else if(ae.getSource() == anaEkran.btnGuncelle){
            urunGuncelleEkraniAc();
        }else if(ae.getSource() == anaEkran.btnKategoriEkle){
            KategoriKontrol kk = new KategoriKontrol();
        }else if(ae.getSource() == anaEkran.btnKategoriGuncelle){
            //!!!Kategori View in değişmesi gerek
        }else if(ae.getSource() == anaEkran.btnKategoriSil){
            String kategoriAdi = anaEkran.listkategori.getSelectedValue().toString();
        }else if(ae.getSource() == anaEkran.btnSil){
            urunSil();
        }else if(ae.getSource() == anaEkran.btnUrunAl){
            //!!!Urun viewi gerek
        }else if(ae.getSource() == anaEkran.btnUrunSat){
            //!!!Urun viewi gerek
        }else if(ae.getSource() == anaEkran.btnYeni){
            UrunEkleKontrol uek = new UrunEkleKontrol(Urun.YENI_URUN);
        }
    }
    
   
}
