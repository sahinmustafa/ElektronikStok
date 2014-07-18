package control;

import elektronikstok.view.UrunSatis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.StokDegisim;
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

            urunSatis.txtOdemeSekli.setText("Nakit");
            urunSatis.txtSatUrunAdi.setText(u.getAdi());
            urunSatis.txtSatUrunAlisFiyati.setText(u.getAlisFiyati()+"");
            urunSatis.txtSatUrunSatisFiyati.setText(u.getSatisFiyati()+"");
            urunSatis.txtSatisAciklama.setText("");
            urunSatis.txtSatmakİstediginizMiktar.setText("");

            if("Al".equals(alVeyaSat))
                urunSatis.btnSatisSat.setText("Al");
            else
                urunSatis.btnSatisSat.setText("Sat");
        }catch(Exception e){
            exceptionGoster("txtDegerleriAta", e);
        }
    }

    private void actionAta() {
        try{
            urunSatis.setDefaultCloseOperation(urunSatis.HIDE_ON_CLOSE);
            urunSatis.btnSatisSat.addActionListener(this);
            urunSatis.btnSatisVazgec.addActionListener(this);
        }catch(Exception e){
            exceptionGoster("actionAta", e);
        }
    }
    
    private void urunAlVeyaSat() {
        try {
            String odemeSekli = urunSatis.txtOdemeSekli.getText();
            String satisAciklama = urunSatis.txtSatisAciklama.getText();
            int miktar = Integer.parseInt(urunSatis.txtSatmakİstediginizMiktar.getText());

            if("Al".equals(alVeyaSat)){
                if(new Urun().satinAl(urunId, miktar, odemeSekli, satisAciklama) == Integer.MAX_VALUE)
                    uyariMesaji("BAŞARILI","Ürün Alım İşlemi Başarıyla Gerçekleşti");
                else
                    uyariMesaji("HATA","Ürün Bulunamadı");
            }else{
                int sonuc = new Urun().sat(urunId, miktar, odemeSekli, satisAciklama);
                if(sonuc == Integer.MAX_VALUE)
                    uyariMesaji("BAŞARILI","Ürün Satım İşlemi Başarıyla Gerçekleşti");
                else if(sonuc == Integer.MIN_VALUE )
                    uyariMesaji("HATA","Ürün Bulunamadı");
                else{
                    uyariMesaji("HATA","Seçili Üründen Sadece "+ sonuc +" Adet Bulunmaktadır");
                    //!!! bu kadarıyla satmak ister misin diye sor
                }
            }
        }catch(Exception e){
            exceptionGoster("urunAlVeyaSat", e);
        }
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
