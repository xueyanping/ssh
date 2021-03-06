package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;



public class BaseDaoImpl<T> extends HibernateDaoSupport  implements BaseDao<T> {
	
	private Class clazz;
	
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) type.getActualTypeArguments()[0];//只有一个泛型
	
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T get(T t) {
		
		return t;

	}

	@Override
	public T getById(Serializable id) {
		return  (T) getHibernateTemplate().get(clazz, id);
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		
		return (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		 dc.setProjection(Projections.rowCount());
		 List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		 
		//清空聚合函数
		dc.setProjection(null);
		if(list != null && list.size() > 0)  {
			
			return list.get(0).intValue();
		
		}
		
		return null;
	}

	@Override
	public void saveaOrUpdate(T t) {
		System.out.println("saveaOrUpdate"+t);
			getHibernateTemplate().saveOrUpdate(t);
	}

}
