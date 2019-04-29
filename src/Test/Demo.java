package Test;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.UserDao;
import domain.Customer;
import domain.User;
import service.CustomerService;
import service.userService;
import utils.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class Demo {
	@Resource(name="sessionFactory")
	SessionFactory sf;

	@Test
	// 单独测试Hibernate
	public void Demo01() {

		Configuration congfig = new Configuration().configure();
		SessionFactory sessionFactory = congfig.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*
		 * User u = new User(); u.setUser_code("xue"); u.setUser_name("li");
		 * u.setUser_password("1234"); session.save(u);
		 */

		transaction.commit();
		session.close();
	}

	@Test
	//测试Spring管理sessionFactory	
	public void Demo02() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		  User u = new User();
		  u.setUser_code("tom"); 
		  u.setUser_name("汤姆");
		  u.setUser_password("123456"); 
		  session.save(u);
		 
		
		tx.commit();
		session.close();
	}

	/*@Resource(name="userDao")
	UserDao user ;
	@Test
	//测试Hibernate模板
	public void Demo03() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		  User u = new User();
		  u.setUser_code("tom"); 
		  u.setUser_name("汤姆");
		  u.setUser_password("123456"); 
		  session.save(u);
		 User byUserCode = user.getByUserCode("tom");
		 	System.out.println(byUserCode);
		tx.commit();
		session.close();
	}*/
	
	
	/*@Resource(name="userService")
	userService userService;
	
	//测试aop事务	
	public void Demo04() {
		User u = new User();
		u.setUser_code("hqy");
		u.setUser_name("郝强勇");
		u.setUser_password("1234");
		
		
		userService.saveUser(u);
	
	}*/
	
	@Resource(name="customerService")
	CustomerService customerService;
	@Test
	public void testSaveCust() {
		Customer c = new Customer();
		c.setCust_name("xue");
		c.setCust_mobile("123");
		c.setCust_phone("456");
		customerService.save(c);
	}
	
	
	
	
}
