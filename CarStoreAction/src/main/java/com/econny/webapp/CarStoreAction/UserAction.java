package com.econny.webapp.CarStoreAction;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEnum.UserRoleEnum;
import com.econny.webapp.CarStoreService.impl.UserServiceImpl;

/*
 * author: peter.li
 * date: 20160-12-24
 * purpose: user action*/
@Controller
@RequestMapping("/user/action")
public class UserAction {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	private ObjectMapper mapper = new ObjectMapper();

	/*注册用户*/
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData){
		
		try {
			UserEntity userEntity = mapper.readValue(ajaxData, UserEntity.class);
			userEntity.setId(UUID.randomUUID().toString());
			/*设置用户角色为客户*/
			userEntity.setRoleId(UserRoleEnum.CUSTOMER.getRoleId());
			
			/*保存客户注册信息*/
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
		} catch (Exception e){
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		}
	}
	
	/*用户登陆*/
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData){
		
		try {
			UserEntity userEntity = mapper.readValue(ajaxData, UserEntity.class);
			
			List<UserEntity> userEntityList = userServiceImpl.findList(userEntity);
			
			if(userEntityList.size()>0){
				return new ApiResultEntity(true, userEntityList.get(0).getId(), 200, "");
			}else{
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
		} catch (Exception e){
			e.printStackTrace();
			return new ApiResultEntity(false, e, 200, "");
		}
	}
	
	/*检查用户名是否存在*/
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/checkUserExists", method = RequestMethod.POST)
	@ResponseBody
	public Object checkUserExists(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData){
		
		try {
			UserEntity userEntity = mapper.readValue(ajaxData, UserEntity.class);
			
			List<UserEntity> userList = userServiceImpl.findList(userEntity);
			
			if(userList.size()>0){
				return new ApiResultEntity(true, "", 200, "");
			}else{
				return new ApiResultEntity(false, "", 200, "");
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
		} catch (Exception e){
			e.printStackTrace();
			return new ApiResultEntity(false, e, 500, "");
		}
	}
		
}
