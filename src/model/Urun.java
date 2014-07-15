package model;

import helper.HbmIslemler;
import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author MustafaSahin
 */
public class Urun extends StokObject implements DatabaseI<StokObject>{
    
    private String adi;
    private String ozellik;
    private int stokMiktar;
    private double alisFiyati;
    private double satisFiyati;
    private int kritikStokMiktar;
    private Kategori kategori;
    private String aciklama;
    private String raf;
    
    public Urun(){}
    
        @Override
    public void ekle() throws HibernateException{
        HbmIslemler hbm = new HbmIslemler();
        hbm.ekle(this);
    }
    
    @Override
    public boolean sil(int urunID){
        HbmIslemler hbm = new HbmIslemler();
        
        return hbm.sil(urunID, this.getClass());
    }
    
    @Override
    public ArrayList<Urun> listele(int ururnID){
        String hql = "SELECT * FROM urun WHERE urun_id ='" + ururnID + "'";  
        HbmIslemler hbm = new HbmIslemler();
        return (ArrayList<Urun>) hbm.list(hql);
    }
    
    @Override
    public Urun getir(int urunID){
        HbmIslemler hbm = new HbmIslemler();
        return (Urun) hbm.bilgiGetir(urunID, this.getClass());
    }

    @Override
    public boolean guncelle(int ID, StokObject yeniBilgi) {
        HbmIslemler hbm = new HbmIslemler();
        return hbm.guncelle(yeniBilgi);
    }

    public int satinAl(int urunID, int miktar, String odemeSekli,String aciklama){
        Urun u = getir(urunID);
        
        if(u == null)
            return Integer.MIN_VALUE;
        
        int yeniMiktar = u.getStokMiktar() + miktar;
        double tutar = miktar * alisFiyati;
        
        StokDegisim stokDegisim = new StokDegisim(u, 
                u.getStokMiktar(), yeniMiktar, tutar, odemeSekli, aciklama);
        stokDegisim.ekle();
        
        u.setStokMiktar(yeniMiktar);
        guncelle(urunID, u);
        return Integer.MAX_VALUE;
    }
    
    public int sat(int urunID, int miktar, String odemeSekli,String aciklama){
        Urun u = getir(urunID);
        
        if(u == null)
            return Integer.MIN_VALUE;
        
        int yeniMiktar = u.getStokMiktar() - miktar;
        
        if(yeniMiktar < 0)
            return u.getStokMiktar();
        
        double tutar = miktar * satisFiyati;
        StokDegisim stokDegisim = new StokDegisim(u, 
                u.getStokMiktar(), yeniMiktar, tutar, odemeSekli, aciklama);
        stokDegisim.ekle();
        
        u.setStokMiktar(yeniMiktar);
        guncelle(urunID, u);
        return Integer.MAX_VALUE;
    }
    
    
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getOzellik() {
        return ozellik;
    }

    public void setOzellik(String ozellik) {
        this.ozellik = ozellik;
    }

    public int getStokMiktar() {
        return stokMiktar;
    }

    public void setStokMiktar(int stokMiktar) {
        this.stokMiktar = stokMiktar;
    }

    public double getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(double alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public double getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(double satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public int getKritikStokMiktar() {
        return kritikStokMiktar;
    }

    public void setKritikStokMiktar(int kritikStokMiktar) {
        this.kritikStokMiktar = kritikStokMiktar;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    
    
}
