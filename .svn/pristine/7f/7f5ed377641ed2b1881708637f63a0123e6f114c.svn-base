package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;
import utils.PageBean;

public interface CustomerService {

	public PageBean getPageBean(DetachedCriteria dc,Integer pageSize,Integer currentPage);

	public void save(Customer customer);

	public Customer getCustById(Long cust_id);
	public List getIndustryCount();
}
