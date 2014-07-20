package model;

/**
 *
 * @author MustafaSahin
 */
public class StokObject {
    public static final int SILINMIS = 1;
    public static final int SILINMEMIS = 0;
    
    private int ID;
    private int silinmis;
    
    public StokObject(){
        silinmis = 0;
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
    
    
}
