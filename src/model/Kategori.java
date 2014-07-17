package model;

import helper.HbmIslemler;
import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author MustafaSahin
 */
public class Kategori extends StokObject implements DatabaseI<StokObject>{
    
    private String kategoriAdi;
    private String aciklama;
    
    public Kategori(){}

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
    public ArrayList<Kategori> listele(int kategoriID){
        String hql = "FROM Kategori";
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
        HbmIslemler hbm = new HbmIslemler();
        return hbm.guncelle(yeniBilgi);
    }
    
    public int kategoriAdindanIdBul(String kategoriAdi){
        String hql = "SELECT * FROM Kategori WHERE kategoriAdi ='" + kategoriAdi + "'";
        HbmIslemler hbm = new HbmIslemler();
        ArrayList<Kategori> kategoriList = (ArrayList<Kategori>) hbm.list(hql);
        if(kategoriList.isEmpty())
            return -1;
        return kategoriList.get(0).getID();
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
