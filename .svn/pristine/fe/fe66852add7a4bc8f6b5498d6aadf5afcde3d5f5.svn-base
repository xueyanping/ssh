package web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Customer;
import domain.LinkMan;
import service.LinkManService;
import utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LinkMan linkMan = new LinkMan();
	LinkManService linkManService;
	
	private Integer pageSize;
	private Integer currentPage;
	
	public String saveLinkMan() throws Exception {
		
		linkManService.save(linkMan);
		System.out.println(linkMan);
		return "toList";
	}
	
	public String list() throws Exception {		
		
		
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			System.out.println(linkMan.getLkm_name());
			dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
			
		}
		/*if(linkMan.getCustomer() != null) {
			System.out.println("list");
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}*/
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			System.out.println("list");
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		
		
		
		PageBean pageList = linkManService.getPageBean(dc, pageSize, currentPage);
		
		ActionContext.getContext().put("list",pageList);
		
		return "list";
	}
	
	public String edit() throws Exception{
		System.out.println(linkMan.getLkm_id());
		LinkMan lkm = linkManService.getLinkManById(linkMan.getLkm_id());
		ActionContext.getContext().put("linkman", lkm);
		return "edit";
	}
	
	
	
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}	
	

}
