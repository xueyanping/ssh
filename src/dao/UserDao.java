package dao;

import domain.User;

public interface UserDao {
	//根据登陆名称查询user对象
		User getByUserCode(String usercode);
		//保存用户
		void save(User u);
		User getByUser(User u);

}
