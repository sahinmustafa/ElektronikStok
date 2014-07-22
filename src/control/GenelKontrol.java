package control;

import javax.swing.JOptionPane;


public class GenelKontrol {

    public boolean onayIstegi(String baslik, String mesaj){
        return JOptionPane.showConfirmDialog(null, mesaj, baslik, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    public void exceptionGoster(String baslik, Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), baslik, JOptionPane.ERROR_MESSAGE);
        e.getSuppressed();
    }
    
    public void uyariMesaji(String baslik, String mesaj){
        JOptionPane.showMessageDialog(null, mesaj, baslik, JOptionPane.ERROR_MESSAGE);
    }
    
    public void basariMesaji(String baslik, String mesaj){
        JOptionPane.showMessageDialog(null, mesaj, baslik, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public double doubleKontrol(String ifade){
        try{
            return Double.parseDouble(ifade);
        }catch(Exception e){
            //exceptionGoster("doubleKontrol", e);
            return 0;
        }
    }
    
      public int intKontrol(String ifade){
        try{
            return Integer.parseInt(ifade);
        }catch(Exception e){
            //exceptionGoster("doubleKontrol", e);
            return 0;
        }
    }
}
