package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer interface*/
import com.econny.webapp.CarStoreEntity.UserEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface CarTypeService {
	
	public void save(CarTypeEntity carTypeEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(CarTypeEntity carTypeEntity);
	
	public void update(CarTypeEntity carTypeEntity);
	
	public List<CarTypeEntity> findList(CarTypeEntity carTypeEntity);
}
