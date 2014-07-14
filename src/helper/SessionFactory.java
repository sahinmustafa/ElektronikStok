package helper;

import org.hibernate.cfg.Configuration;


/**
 *
 * @author MustafaS
 */
public class SessionFactory {
    private final static org.hibernate.SessionFactory sessionFak;
    
    static {
        sessionFak = new Configuration().configure().buildSessionFactory();
    }
    
    public static org.hibernate.SessionFactory getSessionFactory(){
        return sessionFak;
    }
}
