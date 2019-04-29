package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.LinkManDao;
import domain.Customer;
import domain.LinkMan;
import utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	LinkManDao  linkManDao;
	
	//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.saveaOrUpdate(linkMan);

	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc,Integer pageSize,Integer currentPage) {
		
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//System.out.println(pb);
		List<LinkMan> list = linkManDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//System.out.println(list.get(0).getCust_name());
		pb.setList(list);
		return pb;
	}
	
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public LinkMan getLinkManById(Long lkm_id) {
		LinkMan lkm = linkManDao.getById(lkm_id);
		return lkm;
	}
	
	
	

}
