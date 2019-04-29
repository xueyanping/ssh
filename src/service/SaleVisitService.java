package service;

import org.hibernate.criterion.DetachedCriteria;

import domain.SaleVisit;
import utils.PageBean;

public interface SaleVisitService {
	//保存客户拜访记录
	void save(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer currentPage);

	SaleVisit getSaleVisitById(String visit_id);

	
}
