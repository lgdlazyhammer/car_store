package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.ScheduleEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface ScheduleService {

	public void save(ScheduleEntity scheduleEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ScheduleEntity scheduleEntity);
	
	public void update(ScheduleEntity scheduleEntity);
	
	public List<ScheduleEntity> findList(ScheduleEntity scheduleEntity);
}
