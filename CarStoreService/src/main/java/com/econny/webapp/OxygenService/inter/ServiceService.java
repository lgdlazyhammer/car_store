package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.ServiceEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface ServiceService {

	public void save(ServiceEntity serviceEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ServiceEntity serviceEntity);
	
	public void update(ServiceEntity serviceEntity);
	
	public List<ServiceEntity> findList(ServiceEntity serviceEntity);
}
