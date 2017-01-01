package com.econny.webapp.CarStoreAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.ScheduleEntity;
import com.econny.webapp.CarStoreEntity.ServiceEntity;
import com.econny.webapp.CarStoreEntity.UserCarEntity;
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreParam.CarRegisterDisplayParam;
import com.econny.webapp.CarStoreParam.CarTypeServicePriceParam;
import com.econny.webapp.CarStoreParam.PreorderParam;
import com.econny.webapp.CarStoreParam.ScheduleManagementParam;
import com.econny.webapp.CarStoreParam.ScheduleParam;
import com.econny.webapp.CarStoreParam.UserBaseInfoParam;
import com.econny.webapp.CarStoreParam.UserCarParam;
import com.econny.webapp.CarStoreParam.UserParam;
import com.econny.webapp.CarStoreService.impl.CarTypeServiceImpl;
import com.econny.webapp.CarStoreService.impl.ScheduleServiceImpl;
import com.econny.webapp.CarStoreService.impl.ServiceCarPriceServiceImpl;
import com.econny.webapp.CarStoreService.impl.ServiceServiceImpl;
import com.econny.webapp.CarStoreService.impl.UserCarServiceImpl;
import com.econny.webapp.CarStoreService.impl.UserServiceImpl;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.generic.DateTool;
/*
 * author: peter.li
 * date: 20160-12-23
 * purpose: system index action*/
@Controller
@RequestMapping("/")
public class IndexAction {
	
	@Autowired
	CarTypeServiceImpl carTypeServiceImpl;
	
	@Autowired
	ServiceCarPriceServiceImpl serviceCarPriceServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	UserCarServiceImpl userCarServiceImpl;
	
	@Autowired
	ServiceServiceImpl serviceServiceImpl;
	
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/car_store/index");
	}
	
	@RequestMapping("/system/init")
	public ModelAndView systemInit() {
		return new ModelAndView("/car_store/system/init");
	}
	
	@RequestMapping("/user/register")
	public ModelAndView userRegister() {
		return new ModelAndView("/car_store/user/register");
	}
	
	@RequestMapping("/user/baseInfo")
	public ModelAndView userBaseInfo(HttpServletRequest request, HttpServletResponse response) {
		String sessionId = request.getParameter("sessionId");
		
		if(StringUtils.isEmpty(sessionId)){
			//did not login
		    return new ModelAndView("/car_store/user/baseInfo");
		}else{
			UserBaseInfoParam userBaseInfo = new UserBaseInfoParam();
			UserEntity userEntity = new UserEntity();
			/*search by user id*/
			userEntity.setId(sessionId);
			List<UserParam> userParamList = userServiceImpl.findUesrDetailInfo(userEntity);
			/*set user base info*/
			if(userParamList.size()>0){
				userBaseInfo.setUser(userParamList.get(0));
			}else{
				//can't find user info
			}
			
			UserCarEntity userCarEntity = new UserCarEntity();
			/*search by user id*/
			userCarEntity.setUserId(sessionId);
			List<UserCarParam> userCarParamList = userCarServiceImpl.findCarDetailInfo(userCarEntity);
			/*set car list info*/
			userBaseInfo.setCarList(userCarParamList);
			
			return new ModelAndView("/car_store/user/baseInfo", "userBaseInfo", userBaseInfo);
		}
	}
	
	@RequestMapping("/user/login")
	public ModelAndView userLogin() {
		return new ModelAndView("/car_store/user/login");
	}
	
	@RequestMapping("/schedule/reserve")
	public ModelAndView scheduleReserve(HttpServletRequest request, HttpServletResponse response) {
		
		String sessionId = request.getParameter("sessionId");
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/schedule/reserve");
		}else{
			/*get form to display*/
			PreorderParam preorderParam = new PreorderParam();
			UserCarEntity userCarEntity = new UserCarEntity();
			userCarEntity.setUserId(sessionId);
			
			List<UserCarParam> userCarList = userCarServiceImpl.findCarDetailInfo(userCarEntity);
			List<ServiceEntity> serviceList = serviceServiceImpl.findList(new ServiceEntity());
			
			/*set preorder page*/
			preorderParam.setUserCarList(userCarList);
			preorderParam.setServiceList(serviceList);
			return new ModelAndView("/car_store/schedule/reserve", "preorderParam", preorderParam);	
		}
	}
	
	@RequestMapping("/schedule/search")
	public ModelAndView scheduleSearch(HttpServletRequest request, HttpServletResponse response) {
		
		String sessionId = request.getParameter("sessionId");
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/schedule/search");
		}else{
			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setUserId(sessionId);
			
			List<ScheduleParam> scheduleList = scheduleServiceImpl.findScheduleDetail(scheduleEntity);
			return new ModelAndView("/car_store/schedule/search", "scheduleList", scheduleList);	
		}
	}
	
	@RequestMapping("/car/register")
	public ModelAndView carRegister(HttpServletRequest request, HttpServletResponse response) {
		/*查出所有车类型信息*//*查出所需信息*/
		String sessionId = request.getParameter("sessionId");
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/car/register");
		}else{
			CarTypeEntity carTypeEntity = new CarTypeEntity();
			List<CarTypeEntity> carTypeList = carTypeServiceImpl.findList(carTypeEntity);
			
			UserCarEntity userCarEntity = new UserCarEntity();
			/*search by user id*/
			userCarEntity.setUserId(sessionId);
			List<UserCarParam> userCarList = userCarServiceImpl.findCarDetailInfo(userCarEntity);
			
			CarRegisterDisplayParam carRegisterDisplayParam = new CarRegisterDisplayParam(carTypeList, userCarList);
			return new ModelAndView("/car_store/car/register", "carRegisterDisplayParam", carRegisterDisplayParam);
		}
	}
	
	@RequestMapping("/serviceCarPrice/detail")
	public ModelAndView serviceDetailList() {
		/*查出所有车类型信息*/
		List<CarTypeServicePriceParam> serviceCarPriceList = serviceCarPriceServiceImpl.findServiceDetail();
		
		return new ModelAndView("/car_store/service_car_price/detail", "serviceCarPriceList", serviceCarPriceList);
	}
	
	@RequestMapping("/schedule/management")
	public ModelAndView scheduleManagement(HttpServletRequest request, HttpServletResponse response) {
		/*查出所需信息*/
		String sessionId = request.getParameter("sessionId");
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/schedule/management");
		}else{
			
			List<CarTypeEntity> carTypeEntityList = carTypeServiceImpl.findList(new CarTypeEntity());
			List<ServiceEntity> serviceEntityList = serviceServiceImpl.findList(new ServiceEntity());
			
			ScheduleManagementParam scheduleManagementParam = new ScheduleManagementParam(carTypeEntityList, serviceEntityList);
			return new ModelAndView("/car_store/schedule/management","scheduleManagementParam",scheduleManagementParam);	
		}
	}
	
	@RequestMapping("/schedule/modify")
	public ModelAndView scheduleModify(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		/*查出所需信息*/
		String sessionId = request.getParameter("sessionId");
		String scheduleId = request.getParameter("scheduleId");
		
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/schedule/modify");
		}else{
			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setId(scheduleId);
			
			List<ScheduleParam> scheduleList = scheduleServiceImpl.findScheduleDetail(scheduleEntity);
			
			modelMap.put("date", new DateTool());
			
			if(scheduleList.size()>0){
				return new ModelAndView("/car_store/schedule/modify", "schedule", scheduleList.get(0));
			}else{
				return new ModelAndView("/car_store/schedule/modify");				
			}
		}
	}
	
	@RequestMapping("/schedule/calendar")
	public ModelAndView scheduleCalendar(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		/*查出所需信息*/
		String sessionId = request.getParameter("sessionId");
		
		if(StringUtils.isEmpty(sessionId)){
			return new ModelAndView("/car_store/schedule/calendar");
		}else{
			return new ModelAndView("/car_store/schedule/calendar");
		}
	}
}
