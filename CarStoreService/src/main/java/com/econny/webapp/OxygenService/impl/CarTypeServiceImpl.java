package com.econny.webapp.OxygenService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.CarTypeMapper;
import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.OxygenService.inter.CarTypeService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class CarTypeServiceImpl implements CarTypeService {
	
	@Autowired
	CarTypeMapper carTypeMapper;
	
	@Transactional(readOnly=false)
	public void save(CarTypeEntity carTypeEntity) {
		// TODO Auto-generated method stub
		carTypeMapper.save(carTypeEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		carTypeMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(CarTypeEntity carTypeEntity) {
		// TODO Auto-generated method stub
		carTypeMapper.delete(carTypeEntity);
	}
	@Transactional(readOnly=false)
	public void update(CarTypeEntity carTypeEntity) {
		// TODO Auto-generated method stub
		carTypeMapper.update(carTypeEntity);
	}

	public List<CarTypeEntity> findList(CarTypeEntity carTypeEntity) {
		// TODO Auto-generated method stub
		return carTypeMapper.findList(carTypeEntity);
	}

}
