package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import dao.SaleVisitDao;
import domain.Customer;
import domain.SaleVisit;
import utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	SaleVisitDao saleVisitDao;
	
	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.saveaOrUpdate(saleVisit);

	}

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc,Integer pageSize,Integer currentPage) {
		
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//System.out.println(pb);
		List<SaleVisit> list = saleVisitDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//System.out.println(list.get(0).getCust_name());
		pb.setList(list);
		return pb;
	}

	@Override
	public SaleVisit getSaleVisitById(String visit_id) {
			
		return saleVisitDao.getById(visit_id);
	}

}
