package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import utils.PageBean;


public interface BaseDao<T> {
		
	public void save(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	public void saveaOrUpdate(T t);
	 
	public T get(T t);
	
	public T getById(Serializable id);
	
	public List<T> getPageList(DetachedCriteria dc,Integer pageSize,Integer currentPage); 
	
	public Integer getTotalCount(DetachedCriteria dc);
	

}
