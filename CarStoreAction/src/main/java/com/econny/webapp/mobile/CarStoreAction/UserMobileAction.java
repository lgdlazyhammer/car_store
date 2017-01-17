package com.econny.webapp.mobile.CarStoreAction;

import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.MobileParseEntity;
import com.econny.webapp.CarStoreEntity.UserCarEntity;
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEnum.UserRoleEnum;
import com.econny.webapp.CarStoreParam.UserBaseInfoParam;
import com.econny.webapp.CarStoreParam.UserCarParam;
import com.econny.webapp.CarStoreParam.UserParam;
import com.econny.webapp.CarStoreService.impl.UserCarServiceImpl;
import com.econny.webapp.CarStoreService.impl.UserServiceImpl;

import antlr.collections.Enumerator;

/*
 * author: peter.li
 * date: 20160-12-24
 * purpose: user action*/
@Controller
@RequestMapping("/mobile/user/action")
public class UserMobileAction {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserCarServiceImpl userCarServiceImpl;

	private ObjectMapper mapper = new ObjectMapper();

	/* 注册用户 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = true) MobileParseEntity mobileParseEntity) {

		try {
			/*转换Angularjs传入的值*/
			UserEntity userEntity = mapper.readValue(mobileParseEntity.getAjaxData(), UserEntity.class);
			userEntity.setId(UUID.randomUUID().toString());
			/* 设置用户角色为客户 */
			userEntity.setRoleId(UserRoleEnum.CUSTOMER.getRoleId());

			/* 保存客户注册信息 */
			userServiceImpl.save(userEntity);

			return new ApiResultEntity(true, userEntity.getId(), 200, "");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		}
	}

	/* 用户登录 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = true) MobileParseEntity mobileParseEntity) {

		try {
			/*转换Angularjs传入的值*/
			UserEntity userEntity = mapper.readValue(mobileParseEntity.getAjaxData(), UserEntity.class);
			/* 查找客户  */
			List<UserEntity> userEntityList = userServiceImpl.findList(userEntity);

			if (userEntityList.size() > 0) {
				return new ApiResultEntity(true, userEntityList.get(0).getId(), 200, "");
			} else {
				return new ApiResultEntity(false, "", 200, "");
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		}
	}

	/* 用户基础信息  */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/baseInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object baseInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = true) MobileParseEntity mobileParseEntity) {

		/* 获取用户id */
		String sessionId = mobileParseEntity.getToken();
		
		if (StringUtils.isEmpty(sessionId)) {
			// did not login
			return new ApiResultEntity(false, "", 200, "");
		} else {
			UserBaseInfoParam userBaseInfo = new UserBaseInfoParam();
			UserEntity userEntity = new UserEntity();
			/* search by user id */
			userEntity.setId(sessionId);
			List<UserParam> userParamList = userServiceImpl.findUesrDetailInfo(userEntity);
			/* set user base info */
			if (userParamList.size() > 0) {
				userBaseInfo.setUser(userParamList.get(0));
			} else {
				// can't find user info
			}

			UserCarEntity userCarEntity = new UserCarEntity();
			/* search by user id */
			userCarEntity.setUserId(sessionId);
			List<UserCarParam> userCarParamList = userCarServiceImpl.findCarDetailInfo(userCarEntity);
			/* set car list info */
			userBaseInfo.setCarList(userCarParamList);

			return new ApiResultEntity(true, userBaseInfo, 200, "");
		}
	}

}
