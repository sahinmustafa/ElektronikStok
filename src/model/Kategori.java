package model;

import helper.HbmIslemler;
import java.util.ArrayList;
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

    @Override
    public ArrayList<Kategori> tumunuGetir(){
        return  (ArrayList<Kategori>) new HbmIslemler().list("FROM Kategori");
        
    }
    
        @Override
    public void tumunuKaydet(String[][] array, int rows, int cols){
            for(int i = 0; i < rows; i ++){
                    this.setID(Integer.parseInt(array[i][0]));
                    this.setSilinmis(Integer.parseInt(array[i][1]));
                    this.setKategoriAdi(array[i][2]);
                    this.setAciklama(array[i][3]);
                    
                    ekle();
            } 
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
    @Override
    public String toString(){
        return super.toString() + "~" + getKategoriAdi() + "~" + getAciklama() ;
    }
    
}
