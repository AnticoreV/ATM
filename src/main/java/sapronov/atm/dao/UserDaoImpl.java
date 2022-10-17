package sapronov.atm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sapronov.atm.model.User;
import sapronov.atm.util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao{
    public User findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateUtil.getSessionFactory().openSession().createQuery("FROM User").list();
        return users;
    }
}
