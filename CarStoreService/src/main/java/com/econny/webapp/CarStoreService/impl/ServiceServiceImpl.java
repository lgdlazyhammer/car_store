package com.econny.webapp.CarStoreService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.ServiceMapper;
import com.econny.webapp.CarStoreEntity.ServiceEntity;
import com.econny.webapp.CarStoreService.inter.ServiceService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	ServiceMapper serviceMapper;
	
	@Transactional(readOnly=false)
	public void save(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		serviceMapper.save(serviceEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		serviceMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		serviceMapper.delete(serviceEntity);
	}
	@Transactional(readOnly=false)
	public void update(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		serviceMapper.update(serviceEntity);
	}

	public List<ServiceEntity> findList(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		return serviceMapper.findList(serviceEntity);
	}

}
