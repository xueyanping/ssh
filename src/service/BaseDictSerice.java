package service;

import java.util.List;

import domain.BaseDict;

public interface BaseDictSerice {
	
	public List<BaseDict> getDictList(String dict_type_code);

}
