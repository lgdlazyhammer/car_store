package com.econny.webapp.CarStoreAction;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.UserCarEntity;
import com.econny.webapp.CarStoreParam.UserCarModifyParam;
import com.econny.webapp.CarStoreService.impl.UserCarServiceImpl;
import com.econny.webapp.common.CommonMethod;

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

	/* 用户增加车辆信息 */
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

	/* 用户更新车辆信息 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public Object modify(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {

			try {
				UserCarEntity userCarEntity = mapper.readValue(ajaxData, UserCarEntity.class);
				// check if user own this car
				UserCarEntity userCarQry = new UserCarEntity();
				userCarQry.setUserId(sessionId);

				List<UserCarEntity> userCarList = userCarServiceImpl.findList(userCarQry);

				if (userCarList.size() > 0) {
					//user own this car
					UserCarEntity userCar = CommonMethod.checkCarExist(userCarEntity.getId(), userCarList);
					if (userCar != null) {

						userCarServiceImpl.updateCarInfo(userCarEntity);

						return new ApiResultEntity(true, "", 200, "");
					} else {
						// user do not own this car
						return new ApiResultEntity(false, "", 404, "");
					}
				} else {
					// user do not have cars
					return new ApiResultEntity(false, "", 403, "");
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

	/* 用户更新车辆信息 */
	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String ajaxData) {

		String sessionId = request.getParameter("sessionId");
		if (StringUtils.isEmpty(sessionId)) {
			return new ApiResultEntity(false, "", 403, "");
		} else {
			try {

				UserCarEntity userCarEntity = mapper.readValue(ajaxData, UserCarEntity.class);
				// check if user own this car
				UserCarEntity userCarQry = new UserCarEntity();
				userCarQry.setUserId(sessionId);

				List<UserCarEntity> userCarList = userCarServiceImpl.findList(userCarQry);
				
				if (userCarList.size() > 0) {
					//user own this car
					UserCarEntity userCar = CommonMethod.checkCarExist(userCarEntity.getId(), userCarList);
					if (userCar != null) {

						userCarServiceImpl.delete(userCarEntity);

						return new ApiResultEntity(true, "", 200, "");
					} else {
						// user do not own this car
						return new ApiResultEntity(false, "", 404, "");
					}
				} else {
					// user do not have cars
					return new ApiResultEntity(false, "", 403, "");
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
