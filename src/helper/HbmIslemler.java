
package helper;

import java.util.List;
import model.StokObject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MustafaS
 */
public class HbmIslemler {
        
    public void ekle(Object o) throws HibernateException{
        
        Session sesion = SessionFactory.getSessionFactory()
                .openSession();
        
        Transaction tr = sesion.beginTransaction();        
        try{
            sesion.save(o);
            tr.commit();
        }catch(HibernateException ex){
            tr.rollback();
            throw ex;
        }finally{
            sesion.close();
        }    
    }
       
    public boolean tamamenSil(int id, Class clas)throws HibernateException{
        
        Session sesion = SessionFactory.getSessionFactory()
                .openSession();
        
        Transaction tr = sesion.beginTransaction();        
        try{
            Object obj = sesion.get(clas, id);
            if(obj != null){
                sesion.delete(obj);
                tr.commit();
                return true;
            }
            return false;
        }catch(HibernateException ex){
            tr.rollback();
            throw ex;
        }finally{
            //sesion.close();
        }
    }
    
    public List<? extends Object> list(String hql)throws HibernateException{
        
        Session sesion = SessionFactory.getSessionFactory()
                .openSession();
        
        Transaction tr = sesion.beginTransaction();        
        try{
            List list = sesion.createQuery(hql).list();
            tr.commit();
            return list;            
        }catch(HibernateException ex){
            tr.rollback();
            throw ex;
        }finally{
            sesion.close();
        }        
    }
    
    public boolean guncelle(Object obj) throws HibernateException{
    
        Session sesion = SessionFactory.getSessionFactory()
                .openSession();
        
        Transaction tr = sesion.beginTransaction();        
        try{
            sesion.update(obj);
            tr.commit();
            return true;
        }catch(HibernateException ex){
            tr.rollback();
            throw ex;
        }finally{
            sesion.close();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public Object bilgiGetir(int id, Class clas){

        Session sesion = SessionFactory.getSessionFactory()
                .openSession();

        Transaction tr = sesion.beginTransaction();
        try {            
            Object obj = sesion.get(clas, id);
            tr.commit();
            return obj;
        } catch (HibernateException ex) {
            tr.rollback();
            throw ex;
        }finally{
            //sesion.close();
        }
    }
    
    public boolean sil(int ID, Class clas){
        String sql = "UPDATE " + clas.getName() + " SET silinmis=" + StokObject.SILINMIS + " WHERE ID =" + ID;        
        return sorguCalistir(sql);
    }
    
    public boolean sorguCalistir(String sql){
        Session sesion = SessionFactory.getSessionFactory()
                .openSession();
        Transaction tr = sesion.beginTransaction();
        try {           
            int result = sesion.createQuery(sql).executeUpdate();
            tr.commit();
            return result > -1;            
        } catch (HibernateException ex) {
            tr.rollback();
            throw ex;
        }finally{
            sesion.close();
        }
    }
}

