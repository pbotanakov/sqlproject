package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.User;
import repository.UserRepository;
import security.Sanitazer;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRep;
	@Autowired
	private Sanitazer sanitaze;
	@Transactional
	public User save(User user) {
		if(user.getLastLogin() == null)
			user.setLastLogin(new Date());
		return userRep.save(user);
	}

	public boolean findByLogin(String userName, String password) {
		User user = userRep.findByUserName(userName);
		if(sanitaze.inputCheck(userName) || sanitaze.inputCheck(password)) return false;
		if(user != null && user.getPassword().equals(password))
			return true;
		
		return false;
	}

	public boolean findByUsername(String userName) {
		if(sanitaze.inputCheck(userName)) return false;
		User user = userRep.findByUserName(userName);
		if(user != null) return true;
		return false;
	}

}
