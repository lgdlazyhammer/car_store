package com.econny.webapp.mobile.CarStoreAction;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.MobileParseEntity;
import com.econny.webapp.CarStoreService.impl.CarTypeServiceImpl;

/*
 * author: peter.li
 * date: 2017-01-17
 * purpose: car type mobile action*/
@Controller
@RequestMapping("/mobile/carType/action")
public class CarTypeMobileAction {

	@Autowired
	CarTypeServiceImpl carTypeServiceImpl;
	
	/* 获取车辆类型列表 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = true) MobileParseEntity mobileParseEntity) {
		
		/* 获取用户id */
		String sessionId = mobileParseEntity.getToken();
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 200, "");
		} else {
			CarTypeEntity carTypeEntity = new CarTypeEntity();
			List<CarTypeEntity> carTypeList = carTypeServiceImpl.findList(carTypeEntity);
			
			return new ApiResultEntity(true, carTypeList, 200, "");
		}
	}
}
