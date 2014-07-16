package model;

import java.util.ArrayList;

/**
 *
 * @author MustafaSahin
 * @param <T>
 */
public interface DatabaseI<T extends StokObject> {
    
    public void ekle();
    
    public boolean sil(int ID);
    
    public boolean guncelle(int ID, T yeniBilgi);
    
    public ArrayList<? extends StokObject> listele(int ID);
    
    public T getir(int ID);
    
}
