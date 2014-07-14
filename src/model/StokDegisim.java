package model;

import java.util.Date;

/**
 *
 * @author MustafaSahin
 */
public class StokDegisim {
    private static final String ODEME_SEKLI_NAKIT = "nakit";
    private static final String ODEME_SEKLI_KREDI_KARTI = "krediKarti";
    private static final String ODEME_SEKLI_TAKSIT = "taksit";
    
    
    private int degisimID;
    private int urunID;
    private int eskiMiktar;
    private int yeniMiktar;
    private int tutar;
    private String odemeSekli;
    private Date tarih;
    private String aciklama;
    
    public StokDegisim(){}
}
