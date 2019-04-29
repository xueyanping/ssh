package service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;


//@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class userServiceImpl implements userService{

	UserDao userDao;
	@Override
	public User getUserByCodePassword(User u) {
		
		User user = userDao.getByUserCode(u.getUser_code());
		if(user==null) {
			throw new RuntimeException("用户名不存在!");
			
		}
		
		if(!user.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误!");
		}
		return user;
	}

	
//	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void saveUser(User u) {
		System.out.println("u=="+u);
		User isExist = userDao.getByUserCode(u.getUser_code());
		if(isExist!=null) {
			throw new RuntimeException("用户已存在");
		}else {
			u.setUser_password(utils.MD5Utils.md5(u.getUser_password()));
			userDao.save(u);
		}
		
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getByUser(User u) {
		User user = userDao.getByUser(u);
		System.out.println("user==="+user);
		if(user==null) {
			throw new RuntimeException("用户名不存在!");			
		}
		
		if(!user.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误!");
		}
		return user;
	}
	
	
}
