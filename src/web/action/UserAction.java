package web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.userService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	User user = new User();
	userService userService ;
	
	public String login() throws Exception{			
		//System.out.println("登陆=="+user);
		user.setUser_password(utils.MD5Utils.md5(user.getUser_password()));
		User userByCodePassword = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", userByCodePassword);
		return "toHome";
	}
	
	public String regist() throws Exception{
	try {
		//System.out.println("注册=="+user);
		userService.saveUser(user);
	} catch (Exception e) {
		ActionContext.getContext().put("error", e.getMessage());
		return "regist";
	}		
		return "toLogin";
	}
	
	
	@Override
	public User getModel() {

		return user;
	}

	
	public void setUserService(userService userService) {
		this.userService = userService;
	}
	

}
