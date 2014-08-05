package model;

import helper.HbmIslemler;
import java.text.SimpleDateFormat;
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
        this.tarih = new Date();
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
        String hql = "FROM StokDegisim WHERE ID ='" + stokID + "'";
        HbmIslemler hbm = new HbmIslemler();
        return (ArrayList<StokDegisim>) hbm.list(hql);
    }
    
    public ArrayList<StokDegisim> tariheGoreListele(int urunID, Date baslangicTarih, Date bitisTarih){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String hql = "FROM StokDegisim WHERE  tarih between '" + f.format(baslangicTarih) + 
                "' and '" +  f.format(bitisTarih) + "'";
        
        if(urunID != -1)
            hql += " AND urun =" + urunID;
        hql += " ORDER BY id DESC";
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
    
    @Override
    public ArrayList<StokDegisim> tumunuGetir(){
        return (ArrayList<StokDegisim>) new HbmIslemler().list("FROM StokDegisim");
    }

        @Override
    public void tumunuKaydet(String[][] array, int rows, int cols){
            for(int i = 0; i < rows; i ++){
                    this.setID(Integer.parseInt(array[i][0]));
                    this.setEskiMiktar(Integer.parseInt(array[i][1]));
                    this.setYeniMiktar(Integer.parseInt(array[i][2]));
                    this.setTutar(Integer.parseInt(array[i][3]));
                    this.setOdemeSekli(array[i][4]);
                    this.setTarih(null);
                    this.setAciklama(array[i][6]);
                    this.setSilinmis(Integer.parseInt(array[i][7]));
                    Urun u = new Urun();
                    u.setID(Integer.parseInt(array[i][8]));
                    this.setUrun(u);
                    
                    ekle();
            } 
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

    @Override
    public String toString(){
        return super.toString() + "~" + getUrun().getID()  + "~" +  getEskiMiktar()  + "~" +  getYeniMiktar()
                 + "~" + "tarih"  + "~" +  getTutar()  + "~" + getAciklama()  + "~" +  getOdemeSekli();
    }
    
    
}
