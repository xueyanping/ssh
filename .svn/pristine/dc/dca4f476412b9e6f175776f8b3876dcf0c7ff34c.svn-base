package web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import domain.BaseDict;
import net.sf.json.JSONArray;
import service.BaseDictSerice;

public class BaseDictAction extends ActionSupport{

	
	String dict_type_code;
	
	BaseDictSerice baseDictService;
	public String execute() throws Exception{
	
		List<BaseDict> dictList = baseDictService.getDictList(dict_type_code);		
		//将list转化为json格式
		JSONArray json = JSONArray.fromObject(dictList);
		//解决中文乱码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(json);
		return null;  //不需要进行结果处理
		
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	
	public void setBaseDictService(BaseDictSerice baseDictService) {
		this.baseDictService = baseDictService;
	}
	
}
