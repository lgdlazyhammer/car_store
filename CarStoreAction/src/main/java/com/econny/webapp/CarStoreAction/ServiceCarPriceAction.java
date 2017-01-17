package com.econny.webapp.CarStoreAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.ServiceCarPriceEntity;
import com.econny.webapp.CarStoreParam.CarTypeServicePriceParam;
import com.econny.webapp.CarStoreService.impl.ServiceCarPriceServiceImpl;

/*
 * author: peter.li
 * date: 2017-01-02
 * purpose: ServiceCarPrice action*/
@Controller
@RequestMapping("/serviceCarPrice/action")
public class ServiceCarPriceAction {

	@Autowired
	ServiceCarPriceServiceImpl serviceCarPriceServiceImpl;

	private ObjectMapper mapper = new ObjectMapper();

	/* 查询服务信息  */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Object search(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {
		
		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				ServiceCarPriceEntity serviceCarPriceEntity = mapper.readValue(ajaxData, ServiceCarPriceEntity.class);
				
				List<CarTypeServicePriceParam> serviceCarPriceList = serviceCarPriceServiceImpl.findServiceDetail(serviceCarPriceEntity);

				return new ApiResultEntity(true, serviceCarPriceList, 200, "");
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
