package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import domain.Customer;
import utils.PageBean;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao;
	@Override
	public PageBean getPageBean(DetachedCriteria dc,Integer pageSize,Integer currentPage) {
		
		Integer totalCount = customerDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//System.out.println(pb);
		List<Customer> list = customerDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//System.out.println(list.get(0).getCust_name());
		pb.setList(list);
		return pb;
	}
	
// @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	@Override
	public void save(Customer customer) {
//		System.out.println("CustomerServiceImpl=="+customer);
		customerDao.saveaOrUpdate(customer);		
	}
 
  public Customer getCustById(Long cust_id) {
	 return customerDao.getById(cust_id);
  } 
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List getIndustryCount() {
		
		return customerDao.getIndustryCount();
	}	

}
