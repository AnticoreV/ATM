package sapronov.atm.service;

import sapronov.atm.dao.UserDaoImpl;
import sapronov.atm.model.User;

public class UserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    public UserService() {}
    public void saveUser(User user){userDao.save(user);}
    public void updateUser(User user){userDao.update(user);}
    public void deleteUser(User user){userDao.delete(user);}
    public User findUser(int id){return userDao.findById(id);}
    public void showUsers(){userDao.findAll();}
    public int countUsers(){return userDao.count();}
}
