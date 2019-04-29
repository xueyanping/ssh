package web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.SaleVisit;
import domain.User;
import service.SaleVisitService;
import utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SaleVisit saleVisit = new SaleVisit();
	
	SaleVisitService saleVisitService;
	
	private Integer pageSize;
	private Integer currentPage;
	
	//添加客户拜访记录
	public String add() throws Exception{
		//1、取出已登录的用户id
		User user = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		//2、调用service保存用户拜访记录
		saleVisitService.save(saleVisit);
		//3、返回"add"重定向到拜访记录Action列表
		ActionContext.getContext().put("saleVisit", saleVisit);
		return "toList";//to标识重定向
	}
	
	//添加客户拜访记录列表
		public String list() throws Exception{
			//System.out.println(saleVisit);
			DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
			if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
				dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
			}
			
			PageBean pageList = saleVisitService.getPageBean(dc, pageSize, currentPage);
			System.out.println("111=="+pageList.getPageSize());
			ActionContext.getContext().put("list", pageList);
			return "list";
		}
	
		public String edit() throws Exception{
			SaleVisit s = saleVisitService.getSaleVisitById(saleVisit.getVisit_id());
			ActionContext.getContext().put("saleVisit", s);
			return "add";
		}
	
	
	@Override
	public SaleVisit getModel() {

		return saleVisit;
	}

	

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
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
