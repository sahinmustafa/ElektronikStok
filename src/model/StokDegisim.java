package model;

import helper.ExcelIslmeler;
import helper.HbmIslemler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
import org.hibernate.HibernateException;

/**
 *
 * @author MustafaSahin
 */
public class StokDegisim extends StokObject implements DatabaseI<StokObject>{
    public static final String ODEME_SEKLI_NAKIT = "nakit";
    public static final String ODEME_SEKLI_KREDI_KARTI = "krediKarti";
    public static final String ODEME_SEKLI_TAKSIT = "taksit";
    
    private Urun urun;
    private int eskiMiktar;
    private int yeniMiktar;
    private double tutar;
    private String odemeSekli;
    private Date tarih;
    private String aciklama;
    
    public StokDegisim(){}

    public StokDegisim(Urun urun, int eskiMiktar, int yeniMiktar, double tutar,String odemeSekli, String aciklama) {
        this.urun = urun;
        this.eskiMiktar = eskiMiktar;
        this.yeniMiktar = yeniMiktar;
        this.odemeSekli = odemeSekli;
        this.tutar = tutar;
        //this.tarih = ;
        this.aciklama = aciklama;
    }

    
    
    @Override
    public void ekle() throws HibernateException{
    
        HbmIslemler hbm = new HbmIslemler();
        hbm.ekle(this);
    }
    
    @Override
    public boolean sil(int stokID){
        HbmIslemler hbm = new HbmIslemler();
        return hbm.sil(stokID, this.getClass());
    }
    
    @Override
    public ArrayList<StokDegisim> listele(int stokID){
        String hql = "SELECT * FROM StokDegisim WHERE ID ='" + stokID + "'";
        HbmIslemler hbm = new HbmIslemler();
        return (ArrayList<StokDegisim>) hbm.list(hql);
    }
    
    @Override
    public StokDegisim getir(int stokID){
        HbmIslemler hbm = new HbmIslemler();
        return (StokDegisim) hbm.bilgiGetir(stokID, this.getClass());
    }

    @Override
    public boolean guncelle(int ID, StokObject yeniBilgi) {
        HbmIslemler hbm = new HbmIslemler();
        return hbm.guncelle(yeniBilgi);
    }
    
    public void kategoriYedekle() throws WriteException, IOException, BiffException{
        ArrayList<StokDegisim> kategoriList = (ArrayList<StokDegisim>) new HbmIslemler().list("FROM StokDegisim");
        Label[] list = new Label[4];
        ExcelIslmeler ex = new ExcelIslmeler();
        
        list[0] = new Label(0, 0, "ID");
        list[1] = new Label(1, 0, "SILINMIS");
        list[2] = new Label(2, 0, "ESKI_MIKTAR");
        list[3] = new Label(3, 0, "YENI_MIKTAR");
        list[3] = new Label(4, 0, "TUTAR");
        list[3] = new Label(5, 0, "ODEME_SEKLI");
        list[3] = new Label(6, 0, "TARIH");
        list[3] = new Label(7, 0, "URUN_ID");
        list[3] = new Label(8, 0, "ACIKLAMA");
        
        ex.yaz("StokDegisim", list);
        
        for(int i = 0 ; i < kategoriList.size();  i ++){
            list[0] = new Label(0, i+1, kategoriList.get(i).getID()+"");
            list[1] = new Label(1, i+1, kategoriList.get(i).getSilinmis()+"");
            list[2] = new Label(2, i+1, kategoriList.get(i).getEskiMiktar()+"");
            list[3] = new Label(3, i+1, kategoriList.get(i).getYeniMiktar()+"");
            list[4] = new Label(4, i+1, kategoriList.get(i).getTutar()+"");
            list[5] = new Label(5, i+1, kategoriList.get(i).getOdemeSekli()+"");
            list[6] = new Label(6, i+1, kategoriList.get(i).getTarih()+"");
            list[7] = new Label(7, i+1, kategoriList.get(i).getUrun().getID()+"");
            list[8] = new Label(8, i+1, kategoriList.get(i).getAciklama()+"");
            
            
            ex.yaz("StokDegisim", list);
        }
        ex.close();
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getEskiMiktar() {
        return eskiMiktar;
    }

    public void setEskiMiktar(int eskiMiktar) {
        this.eskiMiktar = eskiMiktar;
    }

    public int getYeniMiktar() {
        return yeniMiktar;
    }

    public void setYeniMiktar(int yeniMiktar) {
        this.yeniMiktar = yeniMiktar;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public String getOdemeSekli() {
        return odemeSekli;
    }

    public void setOdemeSekli(String odemeSekli) {
        this.odemeSekli = odemeSekli;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    
    
}
