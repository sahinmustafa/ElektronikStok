package control;

import elektronikstok.view.UrunSatis;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import model.Urun;

public class UrunSatisKontrol extends GenelKontrol implements ActionListener{
    UrunSatis urunSatis;
    int urunId;
    String alVeyaSat;
    
    public UrunSatisKontrol(int urunId, String alVeyaSat) {
        this.urunSatis = new UrunSatis();
        this.urunId = urunId;
        this.alVeyaSat = alVeyaSat;
        txtDegerleriAta();
        actionAta();
        urunSatis.show();
    }
    
    public UrunSatisKontrol(UrunSatis urunSatis) {
        this.urunSatis = urunSatis;
    }

    private void txtDegerleriAta() {
        try{
            Urun u = new Urun().getir(urunId);

            urunSatis.cmbxOdemeSekli.addItem("Nakit");
            urunSatis.cmbxOdemeSekli.addItem("Kredi Karti");
            urunSatis.cmbxOdemeSekli.addItem("Borç");
            
            urunSatis.txtSatUrunAdi.setText(u.getAdi());
            urunSatis.txtSatUrunAlisFiyati.setText(u.getAlisFiyati()+"");
            urunSatis.txtSatUrunSatisFiyati.setText(u.getSatisFiyati()+"");
            urunSatis.txtSatisAciklama.setText("");
            urunSatis.txtSatmakİstediginizMiktar.setText("");

            if("Al".equals(alVeyaSat)){
                urunSatis.btnSatisSat.setText("Al");
                urunSatis.lblSatmakİstediginizMiktar.setText("ALMAK İSTEDİĞİNİZ MİKTAR:");
                urunSatis.pnlUrunSatis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Alış", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
            }else
                urunSatis.btnSatisSat.setText("Sat");
        }catch(Exception e){
            exceptionGoster("txtDegerleriAta", e);
        }
    }

    private void actionAta() {
        try{
            urunSatis.btnSatisSat.addActionListener(this);
            urunSatis.btnSatisVazgec.addActionListener(this);
        }catch(Exception e){
            exceptionGoster("actionAta", e);
        }
    }
    
    private void urunAlVeyaSat() {
        try {
            String odemeSekli = urunSatis.cmbxOdemeSekli.getSelectedItem().toString();
            String satisAciklama = urunSatis.txtSatisAciklama.getText();
            int miktar = intKontrol(urunSatis.txtSatmakİstediginizMiktar.getText());
            
            String hata = zorunluAlanKontrol(miktar);
            
            if("".equals(hata)){
                if("Al".equals(alVeyaSat)){
                    if(new Urun().satinAl(urunId, miktar, odemeSekli, satisAciklama) == Integer.MAX_VALUE){
                        urunSatis.hide();
                        basariMesaji("BAŞARILI", miktar + " adet ürün başarıyla alındı");
                    }else
                        uyariMesaji("HATA","Ürün Bulunamadı");
                }else{
                    int sonuc = new Urun().sat(urunId, miktar, odemeSekli, satisAciklama);
                    if(sonuc == Integer.MAX_VALUE){
                        basariMesaji("BAŞARILI", miktar + " adet ürün başarıyla satıldı");
                        urunSatis.hide();
                    }else if(sonuc == Integer.MIN_VALUE )
                        uyariMesaji("HATA","Ürün Bulunamadı");
                    else{
                        uyariMesaji("HATA","Seçili Üründen Sadece "+ sonuc +" Adet Bulunmaktadır");
                        //!!! bu kadarıyla satmak ister misin diye sor
                    }
                }
            }else {
                uyariMesaji("Hatalı Alan(lar) Girildi !", hata);
            }
        }catch(Exception e){
            exceptionGoster("urunAlVeyaSat", e);
        }
    }
    
    private String zorunluAlanKontrol(int miktar) {
        String hata = "";
        
        if(miktar == 0)
            hata += "Miktar Girmediniz !\n";
        if(miktar < 0)
            hata += "Miktar Negatif Olamaz !\n";
    
        return hata;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == urunSatis.btnSatisSat){
            urunAlVeyaSat();
        }else if(ae.getSource() == urunSatis.btnSatisVazgec){
            urunSatis.hide();
        }
    }
}
