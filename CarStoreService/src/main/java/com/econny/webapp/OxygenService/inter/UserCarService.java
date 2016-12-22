package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.UserCarEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UserCarService {

	public void save(UserCarEntity userCarEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserCarEntity userCarEntity);
	
	public void update(UserCarEntity userCarEntity);
	
	public List<UserCarEntity> findList(UserCarEntity userCarEntity);
}
