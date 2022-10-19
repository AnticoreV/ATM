package sapronov.atm.service;

import sapronov.atm.dao.UserDaoImpl;
import sapronov.atm.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    public UserService() {}
    public void saveUser(User user){userDao.save(user);}
    public void updateUser(User user){userDao.update(user);}
    public void deleteUser(User user){userDao.delete(user);}
    public User findUser(int id){return userDao.findById(id);}
    public List <User> getUsers(){return userDao.findAll();}
    public int getUsersCount(){return userDao.count();}
}
