package com.econny.webapp.OxygenService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.ServiceCarPriceMapper;
import com.econny.webapp.CarStoreEntity.ServiceCarPriceEntity;
import com.econny.webapp.OxygenService.inter.ServiceCarPriceService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class ServiceCarPriceServiceImpl implements ServiceCarPriceService {

	@Autowired
	ServiceCarPriceMapper serviceCarPriceMapper;
	
	@Transactional(readOnly=false)
	public void save(ServiceCarPriceEntity serviceCarPriceEntity) {
		// TODO Auto-generated method stub
		serviceCarPriceMapper.save(serviceCarPriceEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		serviceCarPriceMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(ServiceCarPriceEntity serviceCarPriceEntity) {
		// TODO Auto-generated method stub
		serviceCarPriceMapper.delete(serviceCarPriceEntity);
	}
	@Transactional(readOnly=false)
	public void update(ServiceCarPriceEntity serviceCarPriceEntity) {
		// TODO Auto-generated method stub
		serviceCarPriceMapper.update(serviceCarPriceEntity);
	}

	public List<ServiceCarPriceEntity> findList(ServiceCarPriceEntity serviceCarPriceEntity) {
		// TODO Auto-generated method stub
		return serviceCarPriceMapper.findList(serviceCarPriceEntity);
	}

}
