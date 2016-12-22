package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.ServiceCarPriceEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface ServiceCarPriceService {

	public void save(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public void update(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public List<ServiceCarPriceEntity> findList(ServiceCarPriceEntity serviceCarPriceEntity);
}
