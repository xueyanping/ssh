package service;

import java.util.List;

import dao.BaseDictDao;
import domain.BaseDict;

public class BaseDictServiceImpl implements BaseDictSerice{

	BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> getDictList(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	
	

}
