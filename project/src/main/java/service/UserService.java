package service;

import model.User;

public interface UserService {
	User save(User user);
	boolean findByLogin(String userName,String password);
	boolean findByUsername(String userName);
}
