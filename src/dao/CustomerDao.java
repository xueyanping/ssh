package dao;

import java.util.List;

import domain.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	public List getIndustryCount();
	
}
