package com.econny.webapp.CarStoreService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.ScheduleEntity;
import com.econny.webapp.CarStoreParam.ScheduleParam;
import com.econny.webapp.CarStoreParam.ScheduleSearchParam;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface ScheduleService {

	public void save(ScheduleEntity scheduleEntity);

	public void saveBatch(HashMap<String, Object> map);

	public void delete(ScheduleEntity scheduleEntity);

	public void update(ScheduleEntity scheduleEntity);

	/* update schedule time for reservation */
	public void updateScheduleTime(ScheduleEntity scheduleEntity);

	public List<ScheduleEntity> findList(ScheduleEntity scheduleEntity);

	/* find schedule price */
	public Double findSchedulePrice(ScheduleEntity scheduleEntity);

	/* find schedule detail information to display */
	public List<ScheduleParam> findScheduleDetail(ScheduleEntity scheduleEntity);

	/* find schedule detail information to display for management */
	public List<ScheduleParam> findListForManagement(ScheduleSearchParam scheduleSearchParam);
}
