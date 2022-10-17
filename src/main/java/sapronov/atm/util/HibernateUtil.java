package sapronov.atm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import sapronov.atm.model.Account;
import sapronov.atm.model.Role;
import sapronov.atm.model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Account.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Config Error!" + e);
            }
        }
        return sessionFactory;
    }
}
