package com.econny.webapp.CarStoreService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.ScheduleMapper;
import com.econny.webapp.CarStoreEntity.ScheduleEntity;
import com.econny.webapp.CarStoreParam.ScheduleParam;
import com.econny.webapp.CarStoreParam.ScheduleSearchParam;
import com.econny.webapp.CarStoreService.inter.ScheduleService;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly = true)
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleMapper scheduleMapper;

	@Transactional(readOnly = false)
	public void save(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		scheduleMapper.save(scheduleEntity);
	}

	@Transactional(readOnly = false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		scheduleMapper.saveBatch(map);
	}

	@Transactional(readOnly = false)
	public void delete(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		scheduleMapper.delete(scheduleEntity);
	}

	@Transactional(readOnly = false)
	public void update(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		scheduleMapper.update(scheduleEntity);
	}
	
	@Transactional(readOnly = false)
	public void updateScheduleTime(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		scheduleMapper.updateScheduleTime(scheduleEntity);
	}

	public List<ScheduleEntity> findList(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		return scheduleMapper.findList(scheduleEntity);
	}

	public Double findSchedulePrice(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		return scheduleMapper.findSchedulePrice(scheduleEntity);
	}

	public List<ScheduleParam> findScheduleDetail(ScheduleEntity scheduleEntity) {
		// TODO Auto-generated method stub
		return scheduleMapper.findScheduleDetail(scheduleEntity);
	}

	public List<ScheduleParam> findListForManagement(ScheduleSearchParam scheduleSearchParam) {
		// TODO Auto-generated method stub
		return scheduleMapper.findListForManagement(scheduleSearchParam);
	}

}
