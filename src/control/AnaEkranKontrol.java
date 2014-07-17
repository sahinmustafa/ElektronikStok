
package control;

import elektronikstok.view.AnaEkran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.Kategori;
import model.Urun;

/**
 *
 * @author haye
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
        
        ArrayList <Urun> urunler = new Urun().listele(0);
        
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
            buton.addActionListener(new AnaEkranKontrol(anaEkran));
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == anaEkran.btnAra){
            
        }else if(ae.getSource() == anaEkran.btnGuncelle){
        
        }else if(ae.getSource() == anaEkran.btnKategoriEkle){
        
        }else if(ae.getSource() == anaEkran.btnKategoriGuncelle){
        
        }else if(ae.getSource() == anaEkran.btnKategoriSil){
        
        }else if(ae.getSource() == anaEkran.btnSil){
        
        }else if(ae.getSource() == anaEkran.btnUrunAl){
        
        }else if(ae.getSource() == anaEkran.btnUrunSat){
        
        }else if(ae.getSource() == anaEkran.btnYeni){
            UrunEkleKontrol uek = new UrunEkleKontrol();
        }
    }
}
