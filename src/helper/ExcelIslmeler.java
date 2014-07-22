package helper;

import com.sun.corba.se.spi.ior.Writeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StokObject;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author MustafaSahin
 */
public class ExcelIslmeler {
    
    public static String dosyaYolu = "D:\\elektronikStokYedek.xls";
    
    private WritableWorkbook workBook;
    
    public ExcelIslmeler() throws IOException, BiffException{
        init();
    }
    
    public void init() throws IOException, BiffException{
        if(!dosyaVarmi(dosyaYolu))
            dosyaOlustur();
            
        workBook = Workbook.createWorkbook(new File(getDosyaYolu()));
    }
    
    
    public void dosyaOlustur() throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(new File(dosyaYolu));     
        fos.close();
    }
    
    public boolean dosyaVarmi(String dosyaYolu){
        File file = new File(dosyaYolu);        
        return file.isFile();
    }
    
    public String getDosyaYolu(){
        return dosyaYolu;
    }
    
    public WritableSheet calismaKitabiOlustur(String kitapAdi){
            return workBook.createSheet(kitapAdi, 0);
    }
    
    public WritableSheet getCalismaKitabi(String kitapAdi){
        return workBook.getSheet(kitapAdi);
    }
    
    public void yaz(String calismaKitabi, Label[] list) throws WriteException{
        WritableSheet shet = getCalismaKitabi(calismaKitabi);
        if(shet == null)
            shet = calismaKitabiOlustur(calismaKitabi);
        
        for(Label lbl : list){  
            shet.addCell(lbl);
        }
    }
    
    public void close() throws IOException, WriteException{
        workBook.write();
        workBook.close();
    }
    
}
