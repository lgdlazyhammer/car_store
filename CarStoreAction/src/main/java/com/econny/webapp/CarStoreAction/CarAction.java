package com.econny.webapp.CarStoreAction;

import java.io.IOException;
import java.util.UUID;

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
import com.econny.webapp.CarStoreEntity.UserCarEntity;
import com.econny.webapp.CarStoreService.impl.UserCarServiceImpl;

/*
 * author: peter.li
 * date: 20160-12-24
 * purpose: car action*/
@Controller
@RequestMapping("/car/action")
public class CarAction {

	@Autowired
	UserCarServiceImpl userCarServiceImpl;

	private ObjectMapper mapper = new ObjectMapper();

	/* 注册用户 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {
		
		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {
				UserCarEntity userCarEntity = mapper.readValue(ajaxData, UserCarEntity.class);

				userCarEntity.setId(UUID.randomUUID().toString());

				userCarServiceImpl.save(userCarEntity);

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

}
