package utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {

	private Integer currentPage;
	
	private Integer pageSize;
	
	private Integer totalCount;
	
	private Integer totalPage;

	
	
	private List list;
	
	
	public PageBean(Integer currentPage,Integer totalCount,Integer pageSize) {
		
		this.totalCount = totalCount;
		
		this.pageSize =  pageSize;
		
		this.currentPage = currentPage;
		
		if(this.currentPage == null){
			//如页面没有指定显示那一页.显示第一页.
			this.currentPage = 1;
		}
		
		if(this.pageSize == null){
			//如果每页显示条数没有指定,默认每页显示3条
			this.pageSize = 3;
		}
		
		//计算总页数
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//判断当前页数是否超出范围
		//不能小于1
		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		//不能大于总页数
		if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage;
		}
				
	}


	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}


	public Integer getStart() {
		return (this.currentPage-1)*this.pageSize;
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


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}	


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}	
	
	
}
