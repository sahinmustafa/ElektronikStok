package control;

import control.extra.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Kategori;
import model.Urun;
import view.AnaEkran;

/**
 *
 * Sorunlu yerler !!! ile işaretlenmiştir
 */
public class AnaEkranKontrol extends GenelKontrol implements ActionListener{
    
    AnaEkran anaEkran;  
    String aramaTextYazisi;
    
    public AnaEkranKontrol() {
        this.anaEkran = new AnaEkran();
        /*Açilişta da KategorileriListele ve urunleriGoster WindowActivate eventinde tekrar çağriliyor 
        ancak yapilandiricaki fonksiyonlar silindiğinde pencere açildiktan sonra listeleme yapiyor*/
        kategorileriListele();
        urunleriGoster("");
        actionAta();
        aramaTextYazisi = anaEkran.txtAra.getText();
        anaEkran.show();
    }
    
    public AnaEkranKontrol(AnaEkran anaEkran) {
        this.anaEkran = anaEkran;
    }

    public void kategorileriListele() {
        try{
            DefaultListModel listModel = new DefaultListModel();

            ArrayList <Kategori> kategoriler = new Kategori().listele(0);

            listModel.addElement("Tüm Ürünleri Gör");
            
            for(int i=0; i<kategoriler.size();i++){
                listModel.addElement(kategoriler.get(i).getKategoriAdi());
            }
            
            anaEkran.listkategori.setModel(listModel);
            
            //!!! ilk oluşturulduğu için daima seçili index olmaz ?
            if(anaEkran.listkategori.getSelectedIndex() < 0)
                anaEkran.listkategori.setSelectedIndex(0);

        }catch(Exception e){
            exceptionGoster("kategorileriListele", e);
        }
    }
    
    private void kategoriSil(){
        try{    
            if(anaEkran.listkategori.getSelectedIndex() > 0 ){
                String kategoriAdi = anaEkran.listkategori.getSelectedValue().toString();
                
                //Seçili satirin id'sini al 
                int kategoriId = new Kategori().kategoriAdindanIdBul(kategoriAdi);
                Kategori silinecekKategori = new Kategori().getir(kategoriId);
                        
                //emin misin sorusu sor; eminse sil değilse bir şey yapma 
                if(onayIstegi("Silme Onayı", "\""+silinecekKategori.getKategoriAdi()+"\" adlı kategori kalıcı olarak silinecektir. Silmek istediğinize emin misiniz ?"))
                    silinecekKategori.sil(kategoriId);
            }else{
                uyariMesaji("Kategori Seçmediniz !","Lütfen silmek istediğiniz kategoriyi seçili hale getiriniz !");
            }
             kategorileriListele();
        }catch(Exception e){
            exceptionGoster("kategoriSil", e);
        }
    }
    
    
    private void urunleriAra() {
        urunleriGoster(anaEkran.txtAra.getText());
        if(anaEkran.tblUrunOzellik.getModel().getRowCount() == 0)
            uyariMesaji("Ürün Bulunamadı", "Arama Kriterlerine Uygun Ürün Bulunamadı");
    }
    
    
    private void urunleriGoster(String aranan) {
        try{
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

            anaEkran.tblUrunOzellik.setDefaultRenderer(Object.class, new TableRenderer());
           
        }catch(Exception e){
            exceptionGoster("urunleriGoster", e);
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
                                  anaEkran.btnYeni,
                                  anaEkran.btnAlimSatim
                                };

            for (JButton buton : butonlar) {
                buton.addActionListener(this);
            } 
            
            ListSelectionListener listSelectionListener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    anaEkran.txtAra.setText(aramaTextYazisi);
                    urunleriGoster("");
                }
             };
             anaEkran.listkategori.addListSelectionListener(listSelectionListener);
        
             
             anaEkran.txtAra.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    if(aramaTextYazisi.equals(anaEkran.txtAra.getText())){
                        anaEkran.txtAra.setText("");
                        //anaEkran.txtAra.setForeground(Color.gray);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if("".equals(anaEkran.txtAra.getText())){
                        anaEkran.txtAra.setText(aramaTextYazisi);
                        //anaEkran.txtAra.setForeground(Color.black);
                    }
                }
            });
             
             
            JMenuItem m[] = {anaEkran.MItemAlimSatim, anaEkran.MItemHakkimizda,
            anaEkran.MItemKategoriEkle, anaEkran.MItemKategoriGuncelle, anaEkran.MItemKategoriSil,
            anaEkran.MItemUrunAl, anaEkran.MItemUrunGuncelle,
            anaEkran.MItemUrunSat, anaEkran.MItemUrunSil, anaEkran.MItemYedekleme, 
            anaEkran.MItemYedektenOkuma, anaEkran.MItemYeni};

            for(int i=0; i<m.length; i++) {
                m[i].addActionListener(this);
            }
        
        }catch(Exception e){
            exceptionGoster("actionAta", e);
        }
    }
    
     private void urunGuncelleEkraniAc(){
        try{
            if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
                //Seçili satirin id'sini al 
                int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);
                UrunEkleKontrol uek = new UrunEkleKontrol(urunId,this);
            }else{
                uyariMesaji("Ürün Seçmediniz !","Lütfen Güncellemek istediğiniz ürünü seçili hale getiriniz !");
            }
        }catch(Exception e){
            exceptionGoster("urunGuncelleEkraniAc", e);
        }
    }
  
    private void urunEkleEkraniGoster() {
        try{
            UrunEkleKontrol uek = new UrunEkleKontrol(Urun.YENI_URUN,this);
            uek.urunEkle.cmbxKategoriId.setSelectedItem(anaEkran.listkategori.getSelectedValue().toString());
        }catch(Exception e){
            exceptionGoster("urunEkleEkraniGoster", e);
        }
    }

    
    private void kategoriEkleEkraniGoster() {
        try{
            KategoriKontrol kk = new KategoriKontrol(model.Kategori.YENI_KATEGORI,this);
        }catch(Exception e){
            exceptionGoster("kategoriEkleEkraniGoster", e);
        }
    }
    
    private void urunAlimSatimGecmisiGoster(){
        AlimSatimKaydiKontrol askk = new AlimSatimKaydiKontrol();
    }
    
    private void kategoriGuncelleEkraniGoster() {
        try{
             if(anaEkran.listkategori.getSelectedIndex() > 0){
                String kategori = anaEkran.listkategori.getSelectedValue().toString();
                int kategoriId = new Kategori().kategoriAdindanIdBul(kategori);
                KategoriKontrol kk = new KategoriKontrol(kategoriId,this);
            }else{
                uyariMesaji("Kategori Seçmediniz !","Lütfen Güncellemek istediğiniz kategorinin adını seçili hale getiriniz !");
            }
        }catch(Exception e){
            exceptionGoster("kategoriGuncelleEkraniGoster", e);
        }
    }
    
    private void urunSatisEkraniGoster(String alVeyaSat) {
        try{
            if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
                //Seçili satirin id'sini al 
                int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);            
                UrunSatisKontrol usk = new UrunSatisKontrol(urunId,alVeyaSat,this);
            }else{
                uyariMesaji("Ürün Seçmediniz !","Lütfen "+alVeyaSat+"mak istediğiniz ürünü seçili hale getiriniz !");
            }
        }catch(Exception e){
            exceptionGoster("urunSatisEkraniGoster", e);
        }
    }

    private void urunSil(){
        try{
            if(anaEkran.tblUrunOzellik.getSelectedRow()>=0){
                //Seçili satirin id'sini al 
                int urunId = (int) anaEkran.tblUrunOzellik.getValueAt(anaEkran.tblUrunOzellik.getSelectedRow(), 0);

                //emin misin sorusu sor; eminse sil değilse bir şey yapma 
                if(onayIstegi("Silme Onayı", urunId+" numaralı ürün kalıcı olarak silinecektir. Silmek istediğinize emin misiniz ?")){
                    new Urun().sil(urunId);
                    kategorileriListele();
                }
            }else{
                uyariMesaji("Ürün Seçmediniz !","Lütfen silmek istediğiniz ürünü seçili hale getiriniz !");
            }
            
        }catch(Exception e){
            exceptionGoster("urunSil", e);
        }
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == anaEkran.btnAra){
            urunleriAra();
        }else if(ae.getSource() == anaEkran.btnGuncelle || ae.getSource() == anaEkran.MItemUrunGuncelle){
            urunGuncelleEkraniAc();
        }else if(ae.getSource() == anaEkran.btnKategoriEkle || ae.getSource() == anaEkran.MItemKategoriEkle){
            kategoriEkleEkraniGoster();
        }else if(ae.getSource() == anaEkran.btnKategoriGuncelle  || ae.getSource() == anaEkran.MItemKategoriGuncelle){
            kategoriGuncelleEkraniGoster();
        }else if(ae.getSource() == anaEkran.btnKategoriSil  || ae.getSource() == anaEkran.MItemKategoriSil){
            kategoriSil();
        }else if(ae.getSource() == anaEkran.btnSil  || ae.getSource() == anaEkran.MItemUrunSil){
            urunSil();
        }else if(ae.getSource() == anaEkran.btnUrunAl  || ae.getSource() == anaEkran.MItemUrunAl){
            urunSatisEkraniGoster("Al");
        }else if(ae.getSource() == anaEkran.btnAlimSatim || ae.getSource() == anaEkran.MItemAlimSatim){
            urunAlimSatimGecmisiGoster();
        }else if(ae.getSource() == anaEkran.btnUrunSat || ae.getSource() == anaEkran.MItemUrunSat){
            urunSatisEkraniGoster("Sat");
        }else if(ae.getSource() == anaEkran.btnYeni || ae.getSource() == anaEkran.MItemYeni){
            urunEkleEkraniGoster();
        }
    }   
}
