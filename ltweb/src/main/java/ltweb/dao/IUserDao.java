package ltweb.dao;

import java.util.List;

import ltweb.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);
}
