package com.econny.webapp.CarStoreAction;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.ScheduleEntity;
import com.econny.webapp.CarStoreParam.ScheduleParam;
import com.econny.webapp.CarStoreParam.ScheduleSearchParam;
import com.econny.webapp.CarStoreService.impl.ScheduleServiceImpl;
import com.econny.webapp.common.CommonMethod;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * author: peter.li
 * date: 20160-12-26
 * purpose: schedule action*/
@Controller
@RequestMapping("/schedule/action")
public class ScheduleAction {

	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;

	private ObjectMapper mapper = new ObjectMapper();

	/* 预约 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	@ResponseBody
	public Object reserve(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				ScheduleEntity scheduleEntity = mapper.readValue(ajaxData, ScheduleEntity.class);

				Double price = scheduleServiceImpl.findSchedulePrice(scheduleEntity);

				if (price.isNaN()) {
					return new ApiResultEntity(false, "", 500, "");
				}
				scheduleEntity.setId(UUID.randomUUID().toString());
				scheduleEntity.setPrice(price);

				scheduleServiceImpl.save(scheduleEntity);

				return new ApiResultEntity(true, "", 200, "");
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (Exception e) {
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			}
		}
	}

	/* 预约管理详细信息查询 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/management/search", method = RequestMethod.POST)
	@ResponseBody
	public Object managementSearch(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				ScheduleSearchParam scheduleSearchParam = mapper.readValue(ajaxData, ScheduleSearchParam.class);

				/*
				 * if(StringUtils.isEmpty(scheduleSearchParam.getUserName())){
				 * scheduleSearchParam.setUserName(UUID.randomUUID().toString())
				 * ; }
				 */

				List<ScheduleParam> scheduleList = scheduleServiceImpl.findListForManagement(scheduleSearchParam);

				return new ApiResultEntity(true, scheduleList, 200, "");
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (Exception e) {
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			}
		}
	}

	/* 预约管理详细信息管理 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/management/modify", method = RequestMethod.POST)
	@ResponseBody
	public Object managementModify(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				ScheduleEntity scheduleEntity = mapper.readValue(ajaxData, ScheduleEntity.class);

				scheduleServiceImpl.updateScheduleTime(scheduleEntity);
				return new ApiResultEntity(true, "", 200, "");
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (Exception e) {
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			}
		}
	}

	/* 预约管理预约日历 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/management/calendar", method = RequestMethod.POST)
	@ResponseBody
	public Object managementCalendar(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				ScheduleEntity scheduleEntity = mapper.readValue(ajaxData, ScheduleEntity.class);

				List<ScheduleEntity> scheduleList = scheduleServiceImpl.findList(scheduleEntity);
				
				Integer[][] timeTable = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0 } };

				if (scheduleList.size() > 0) {
					for (ScheduleEntity schedule : scheduleList) {
						Date startTime = schedule.getTimeStart();
						Date endTime = schedule.getTimeEnd();

						int startHour = startTime.getHours();
						int endHour = endTime.getHours();

						Integer[] timeLine = CommonMethod.makeTimeLine(startHour, endHour);
						timeTable = CommonMethod.makeTimeTable(timeLine, timeTable);
					}
					
					return new ApiResultEntity(true, timeTable, 200, "");
				}else{
					return new ApiResultEntity(true, null, 200, "");
				}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			} catch (Exception e) {
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "");
			}
		}
	}

}
