package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.ServiceCarPriceEntity;
import com.econny.webapp.CarStoreParam.CarTypeServicePriceParam;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for service*/
@Repository
public interface ServiceCarPriceMapper {

	public void save(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public void update(ServiceCarPriceEntity serviceCarPriceEntity);
	
	public List<ServiceCarPriceEntity> findList(ServiceCarPriceEntity serviceCarPriceEntity);
	
	/*find car type and service price to display*/
	public List<CarTypeServicePriceParam> findServiceDetail(ServiceCarPriceEntity serviceCarPriceEntity);
}
