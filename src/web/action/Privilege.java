package web.action;

import java.util.Map;

import org.aopalliance.intercept.Invocation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import domain.User;

public class Privilege extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
//		1、获得session
		Map<String,Object> session = ActionContext.getContext().getSession();
//		2、获得登录标识
		User user = (User) session.get("user");
//		3、判断标识是否存在（存在则放行，否则重定向到登录页面）
		if(user==null) {
			
		}else {
			return invocation.invoke();
		}
		return "toLogin";
	}

}
