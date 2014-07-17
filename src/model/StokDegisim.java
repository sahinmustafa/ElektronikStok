package model;

import helper.HbmIslemler;
import java.util.ArrayList;
import java.util.Date;
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
