package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.ScheduleEntity;
import com.econny.webapp.CarStoreParam.ScheduleParam;
import com.econny.webapp.CarStoreParam.ScheduleSearchParam;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for schedule*/
@Repository
public interface ScheduleMapper {

	public void save(ScheduleEntity scheduleEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ScheduleEntity scheduleEntity);
	
	public void update(ScheduleEntity scheduleEntity);
	
	public void updateScheduleTime(ScheduleEntity scheduleEntity);
	
	public List<ScheduleEntity> findList(ScheduleEntity scheduleEntity);
	
	public Double findSchedulePrice(ScheduleEntity scheduleEntity);
	
	public List<ScheduleParam> findScheduleDetail(ScheduleEntity scheduleEntity);
	
	public List<ScheduleParam> findListForManagement(ScheduleSearchParam scheduleSearchParam);
}
