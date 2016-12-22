package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user*/
@Repository
public interface CarTypeMapper {

	public void save(CarTypeEntity carTypeEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(CarTypeEntity carTypeEntity);
	
	public void update(CarTypeEntity carTypeEntity);
	
	public List<CarTypeEntity> findList(CarTypeEntity carTypeEntity);
}
