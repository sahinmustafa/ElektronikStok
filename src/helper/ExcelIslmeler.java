package helper;

import com.sun.corba.se.spi.ior.Writeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.StokObject;
import jxl.*;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
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
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        dosyaYolu = chooser.getSelectedFile().getAbsolutePath();
        System.out.println("Dosya Yolu : " + dosyaYolu);
        
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
    
    
    public void yaz(String calismaKitabi, Label[][] list, int rowCount, int collCount) throws WriteException{
        WritableSheet shet = getCalismaKitabi(calismaKitabi);
        if(shet == null)
            shet = calismaKitabiOlustur(calismaKitabi);
        
        for(int i = 0 ; i < rowCount; i ++)
            for(int j = 0 ; j < collCount; j++){  
                shet.addCell(list[i][j]);
        }
    }
    
    public void yedekle(String calismaKitabiAdi, String[] columnName, 
            ArrayList<? extends StokObject> dataList) throws WriteException, IOException{
        
        Label[][] lbl = new Label[dataList.size() + 1][columnName.length+1];
        WritableCellFormat format = new WritableCellFormat(
                                new WritableFont(WritableFont.ARIAL,12, WritableFont.BOLD,false, UnderlineStyle.SINGLE));
        
        lbl[0][0] = new Label(0,0,"ID", format);
        for(int coll = 0 ; coll < columnName.length; coll ++){
            lbl[0][coll+1] = new Label(coll+1, 0, columnName[coll],format);
        }
        for(int row = 0 ; row < dataList.size();  row ++){
            String[] data = dataList.get(row).toString().split("~");
            for(int coll = 0 ; coll < data.length ; coll ++){
                lbl[row+1][coll] = new Label(coll, row+1, data[coll]);
            }
        }
        
        yaz(calismaKitabiAdi, lbl, dataList.size()+1, columnName.length+1);

    }
    
    public void close() throws IOException, WriteException{
        workBook.write();
        workBook.close();
    }
    
}
