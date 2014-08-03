package control;

import control.extra.TableRenderer;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.StokDegisim;
import view.AlimSatimKaydi;

public class AlimSatimKaydiKontrol {
    AlimSatimKaydi alimSatimKaydiEkrani;

    public AlimSatimKaydiKontrol(AlimSatimKaydi alimSatimKaydiEkrani) {
        this.alimSatimKaydiEkrani = alimSatimKaydiEkrani;
    }

    public AlimSatimKaydiKontrol() {
        this.alimSatimKaydiEkrani = new AlimSatimKaydi();
        alimSatimTablosuOlustur();
    }
    
    public void alimSatimTablosuOlustur(){
        ArrayList<StokDegisim> stokDegisim = new StokDegisim().tumunuGetir();
        
        DefaultTableModel tableModel = new DefaultTableModel();

        String kolonAdlari [] = {
            "ÜRÜN ADI",
            "ALIŞ FİYATI",
            "SATIŞ FİYATI",
            "DEĞİŞİM MİKTARI",
            "TUTAR",
            "ÖDEME ŞEKLİ"                
        };

        Object [][] data = new Object[stokDegisim.size()][kolonAdlari.length];

        for(int i=0;i<stokDegisim.size(); i++){
            data[i][0] = stokDegisim.get(i).getUrun().getAdi();
            data[i][1] = stokDegisim.get(i).getUrun().getAlisFiyati();
            data[i][2] = stokDegisim.get(i).getUrun().getSatisFiyati();
            data[i][3] = stokDegisim.get(i).getYeniMiktar() - stokDegisim.get(i).getEskiMiktar();
            data[i][4] = stokDegisim.get(i).getTutar();
            data[i][5] = stokDegisim.get(i).getOdemeSekli();
        }


        tableModel.setDataVector(data, kolonAdlari);

        alimSatimKaydiEkrani.tblAlimSatim.setModel(tableModel);

        alimSatimKaydiEkrani.tblAlimSatim.setDefaultRenderer(Object.class, new TableRenderer());

    }
    
}
