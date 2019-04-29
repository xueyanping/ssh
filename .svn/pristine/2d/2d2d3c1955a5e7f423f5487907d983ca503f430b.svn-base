package service;

import org.hibernate.criterion.DetachedCriteria;

import domain.LinkMan;
import utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer currentPage);

	LinkMan getLinkManById(Long lkm_id);
 
}
