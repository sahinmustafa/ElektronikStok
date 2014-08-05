package model;

import helper.ExcelIslmeler;
import helper.HbmIslemler;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
import org.hibernate.HibernateException; 

/**
 *
 * @author MustafaSahin
 */
public class Urun extends StokObject implements DatabaseI<StokObject>{
    
    public static final int YENI_URUN = Integer.MAX_VALUE;
    

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
        return hbm.sil(urunID, Urun.class);
    }
    
    @Override
    public ArrayList<Urun> listele(int kategoriID){
        String hql = "FROM Urun WHERE ID ='" + kategoriID + "' AND SILINMIS =" + SILINMEMIS;  
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
        double tutar = miktar * u.alisFiyati;
        
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
        
        double tutar = miktar * u.satisFiyati;
        StokDegisim stokDegisim = new StokDegisim(u, 
                u.getStokMiktar(), yeniMiktar, tutar, odemeSekli, aciklama);
        stokDegisim.ekle();
        
        u.setStokMiktar(yeniMiktar);
        guncelle(urunID, u);
        return Integer.MAX_VALUE;
    }
    
    public ArrayList<Urun> listele(int kategoriID, String aranacakMetin){
        String hql = "FROM Urun WHERE adi LIKE '%"+aranacakMetin + "%' AND SILINMIS = "+ SILINMEMIS;
        if(kategoriID != -1)
            hql += " AND kategori=" + kategoriID;
        
        HbmIslemler hbm = new HbmIslemler();
        return  (ArrayList<Urun>) hbm.list(hql);
    }
    
    public boolean kategoridekiUrunleriSil(int kategoriID){
        String sql = "UPDATE Urun SET silinmis=" + StokObject.SILINMIS + " WHERE kategori =" + kategoriID;
        HbmIslemler hbm = new HbmIslemler();
        return hbm.sorguCalistir(sql);
    }
    
    @Override
    public ArrayList<Urun> tumunuGetir(){
        return (ArrayList<Urun>) new HbmIslemler().list("FROM Urun");
    }
    
    @Override
    public void tumunuKaydet(String[][] array, int rows, int cols){
        for(int i = 0; i < rows; i ++){
                    this.setID(Integer.parseInt(array[i][0]));
                    this.setAdi((array[i][1]));
                    this.setOzellik(array[i][2]);
                    this.setAlisFiyati(Integer.parseInt(array[i][3]));
                    this.setSatisFiyati(Integer.parseInt(array[i][4]));
                    this.setKritikStokMiktar(Integer.parseInt(array[i][5]));
                    this.setAciklama(array[i][6]);
                    this.setRaf(array[i][7]);
                    this.setSilinmis(Integer.parseInt(array[i][8]));
                    Kategori u = new Kategori();
                    u.setID(Integer.parseInt(array[i][8]));
                    this.setKategori(u);
                    
                    ekle();
            } 
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

    @Override
    public String toString(){
        return super.toString() + "~" + getAdi() + "~" + getOzellik()  + "~" + getStokMiktar() + "~" + getAlisFiyati() + "~" + 
                getSatisFiyati() + "~" + getKritikStokMiktar() + "~" + getKategori().getID() + "~" + getRaf() + "~" + getAciklama();
    }
    
}
