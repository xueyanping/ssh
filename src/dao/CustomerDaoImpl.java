package dao;

import java.io.Serializable;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	@SuppressWarnings("all")
	public List getIndustryCount() {
		
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				String sql = " SELECT                                 "+
						"  bd.`dict_item_name`,                   "+
						"  COUNT(*) total                         "+
						"  FROM                                    "+
						"  cst_customer c,                        "+
						"  base_dict bd                           "+
						" WHERE c.`cust_industry` = bd.`dict_id`  "+
						" GROUP BY c.`cust_industry`              ";
				SQLQuery query =  session.createSQLQuery(sql );
				return query.list();
			}
		});
		  return list;
	}
	
		
}
