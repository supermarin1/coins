package coins.crud;

import coins.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoin {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Coin.class)
                .addAnnotatedClass(Series.class)
                .addAnnotatedClass(Metal.class)
                .addAnnotatedClass(Quality.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        
    }
}
