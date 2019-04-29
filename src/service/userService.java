package service;

import domain.User;

public interface userService {
	
	//登陆方法
		User	getUserByCodePassword(User u);
		//注册用户
		void saveUser(User u);
		
		User getByUser(User u);

}
