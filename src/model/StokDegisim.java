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
    
    private int urunID;
    private int eskiMiktar;
    private int yeniMiktar;
    private int tutar;
    private String odemeSekli;
    private Date tarih;
    private String aciklama;
    
    public StokDegisim(){}

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
        String hql = "SELECT * FROM stokdegisim WHERE stok_id ='" + stokID + "'";
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

    public int getUrunID() {
        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
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

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
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
