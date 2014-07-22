package model;

import helper.ExcelIslmeler;
import helper.HbmIslemler;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
import static model.StokObject.SILINMIS;
import org.hibernate.HibernateException;

/**
 *
 * @author MustafaSahin
 */
public class Kategori extends StokObject implements DatabaseI<StokObject>{
    
    public static final int YENI_KATEGORI = Integer.MAX_VALUE;
    
    private String kategoriAdi;
    private String aciklama;
    
    public Kategori(){}

        @Override
    public void ekle() throws HibernateException{
    
        HbmIslemler hbm = new HbmIslemler();
        hbm.ekle(this);
    }
    
    @Override
    public boolean sil(int kategoriID){
        HbmIslemler hbm = new HbmIslemler();        
        if(hbm.sil(kategoriID, Kategori.class))
            new Urun().kategoridekiUrunleriSil(kategoriID);
        return false;
    }
    
    @Override
    public ArrayList<Kategori> listele(int kategoriID){
        String hql = "FROM Kategori WHERE SILINMIS = "+ SILINMEMIS;
        HbmIslemler hbm = new HbmIslemler();
        return (ArrayList<Kategori>) hbm.list(hql);
    }
    
    @Override
    public Kategori getir(int kategoriID){
        HbmIslemler hbm = new HbmIslemler();
        return (Kategori) hbm.bilgiGetir(kategoriID, this.getClass());
    }

    @Override
    public boolean guncelle(int ID, StokObject yeniBilgi) {
        System.out.println("ID : "  + ID);
        yeniBilgi.setID(ID);
        HbmIslemler hbm = new HbmIslemler();
        return hbm.guncelle(yeniBilgi);
    }
    
    public int kategoriAdindanIdBul(String kategoriAdi){
        String hql = "FROM Kategori WHERE kategoriAdi ='" + kategoriAdi + "'";
        HbmIslemler hbm = new HbmIslemler();
        ArrayList<Kategori> kategoriList = (ArrayList<Kategori>) hbm.list(hql);
        if(kategoriList.isEmpty())
            return -1;
        return kategoriList.get(0).getID();
    }

    public void kategoriYedekle() throws WriteException, IOException, BiffException{
        ArrayList<Kategori> kategoriList = (ArrayList<Kategori>) new HbmIslemler().list("FROM Kategori");
        Label[] list = new Label[4];
        ExcelIslmeler ex = new ExcelIslmeler();
        
        list[0] = new Label(0, 0, "ID");
        list[1] = new Label(1, 0, "SILINMIS");
        list[2] = new Label(2, 0, "KATEGORIADI");
        list[3] = new Label(3, 0, "ACIKLAMA");
            
        ex.yaz("Kategori", list);
        
        for(int i = 0 ; i < kategoriList.size();  i ++){
            list[0] = new Label(0, i+1, kategoriList.get(i).getID()+"");
            list[1] = new Label(1, i+1, kategoriList.get(i).getSilinmis()+"");
            list[2] = new Label(2, i+1, kategoriList.get(i).getKategoriAdi()+"");
            list[3] = new Label(3, i+1, kategoriList.get(i).getAciklama()+"");
            
            ex.yaz("Kategori", list);
        }
        ex.close();
    }
    
    
    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }    
}
