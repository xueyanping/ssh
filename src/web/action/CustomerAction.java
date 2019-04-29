package web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.BaseDaoImpl;
import domain.Customer;
import service.CustomerService;
import utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CustomerService customerService;
	Customer customer = new Customer();
	private Integer pageSize;
	private Integer currentPage;
	
	private File upload;
	
	private String uploadFileName;//文件本来的名称
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String list() throws Exception {		
//		System.out.println("list");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
			
		}
		
		PageBean pageList = customerService.getPageBean(dc, pageSize, currentPage);
		
		ActionContext.getContext().put("list", pageList);
		return "list";
	}
	
	public String add() throws Exception{		
		//System.out.println("customer=="+customer);
		if(upload != null) {
			System.out.println("uploadFileFileName"+uploadFileName+"----uploadFileContentType"+uploadContentType);
			upload.renameTo(new File("F:/haha.jpg"));//相当于剪切

		}
		if(customer!=null) {
			System.out.println(customer);
		}
		
		customerService.save(customer);
		
		return "add";
	}
	
	public String edit() throws Exception {
		Customer c = customerService.getCustById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		return "edit";
	}
	
	public String industryCount() throws Exception {
		List list = customerService.getIndustryCount();
		ActionContext.getContext().put("list_industry", list);
		return "industryCount";
	}
	
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	
	

	
	@Override
	public Customer getModel() {

		return customer;
	}

}
