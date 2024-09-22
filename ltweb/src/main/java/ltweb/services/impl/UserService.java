package ltweb.services.impl;

import ltweb.dao.IUserDao;
import ltweb.dao.impl.UserDaoImpl;
import ltweb.models.UserModel;
import ltweb.services.IUserService;

public class UserService implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.FindByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel FindByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void insert(UserModel user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        
        if (userDao.checkExistEmail(email)) {
            return false;
        }

        // Tạo người dùng mới
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        UserModel newUser = new UserModel();

        // Chèn người dùng mới vào cơ sở dữ liệu
        userDao.insert(newUser);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}
