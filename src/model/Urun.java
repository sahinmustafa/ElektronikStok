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
    
    public void kategoriYedekle() throws WriteException, IOException, BiffException{
        ArrayList<Urun> kategoriList = (ArrayList<Urun>) new HbmIslemler().list("FROM Urun");
        Label[] list = new Label[4];
        ExcelIslmeler ex = new ExcelIslmeler();
        
        list[0] = new Label(0, 0, "ID");
        list[1] = new Label(1, 0, "SILINMIS");
        list[2] = new Label(2, 0, "URUN_ADI");
        list[3] = new Label(3, 0, "OZELLIK");
        list[3] = new Label(4, 0, "MIKTAR");
        list[3] = new Label(5, 0, "ALIS_FIYATI");
        list[3] = new Label(6, 0, "SATIS_FIYATI");
        list[3] = new Label(7, 0, "KRITIK_STOK");
        list[3] = new Label(8, 0, "ACIKLAMA");
        list[3] = new Label(9, 0, "KATEGORI_ID");
        
        ex.yaz("Urun", list);
        
        for(int i = 0 ; i < kategoriList.size();  i ++){
            list[0] = new Label(0, i+1, kategoriList.get(i).getID()+"");
            list[1] = new Label(1, i+1, kategoriList.get(i).getSilinmis()+"");
            list[2] = new Label(2, i+1, kategoriList.get(i).getAdi()+"");
            list[3] = new Label(3, i+1, kategoriList.get(i).getOzellik()+"");
            list[4] = new Label(4, i+1, kategoriList.get(i).getStokMiktar()+"");
            list[5] = new Label(5, i+1, kategoriList.get(i).getAlisFiyati()+"");
            list[6] = new Label(6, i+1, kategoriList.get(i).getSatisFiyati()+"");
            list[7] = new Label(7, i+1, kategoriList.get(i).getKritikStokMiktar()+"");
            list[8] = new Label(8, i+1, kategoriList.get(i).getAciklama()+"");
            list[9] = new Label(9, i+1, kategoriList.get(i).getKategori().getID()+"");
            
            
            ex.yaz("Urun", list);
        }
        ex.close();
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
