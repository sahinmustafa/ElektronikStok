package model;

import helper.ExcelIslmeler;
import helper.HbmIslemler;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author MustafaSahin
 */
public abstract class StokObject {
    public static final int SILINMIS = 1;
    public static final int SILINMEMIS = 0;
    
    private int ID;
    private int silinmis;
    
    public StokObject(){
        silinmis = 0;
    }
    
    public abstract ArrayList tumunuGetir();
    
    public void kategoriYedekle() throws IOException, BiffException, WriteException{
        
        StokObject[]  stokObjects = new StokObject[]{new Kategori(), new Urun(), new StokDegisim()};
        
        ExcelIslmeler ex = new ExcelIslmeler();
        
        for (StokObject o  : stokObjects){
            String[] columnName = new HbmIslemler().getColumnName(o.getClass());
            ex.yedekle(o.getClass().getName(), columnName, o.tumunuGetir());
        }
        ex.close();
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSilinmis() {
        return silinmis;
    }

    public void setSilinmis(int silinmis) {
        this.silinmis = silinmis;
    }
    
    @Override
    public String toString(){
        return getID() + "~" + getSilinmis();
    }
    
}
