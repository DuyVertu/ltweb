package ltweb.services.impl;

import ltweb.dao.IUserDao;
import ltweb.dao.impl.UserDaoImpl;
import ltweb.models.UserModel;
import ltweb.services.IUserService;

public class UserService implements IUserService{

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

}
