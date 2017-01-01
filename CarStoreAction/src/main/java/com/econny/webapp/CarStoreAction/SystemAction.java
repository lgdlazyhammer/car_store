package com.econny.webapp.CarStoreAction;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.ServiceCarPriceEntity;
import com.econny.webapp.CarStoreEntity.ServiceEntity;
import com.econny.webapp.CarStoreEntity.UserRoleEntity;
import com.econny.webapp.CarStoreEntity.UserRoleServiceEntity;
import com.econny.webapp.CarStoreService.impl.CarTypeServiceImpl;
import com.econny.webapp.CarStoreService.impl.ServiceCarPriceServiceImpl;
import com.econny.webapp.CarStoreService.impl.ServiceServiceImpl;
import com.econny.webapp.CarStoreService.impl.SystemServiceImpl;
import com.econny.webapp.CarStoreService.impl.UserRoleServiceImpl;
import com.econny.webapp.CarStoreService.impl.UserRoleServiceServiceImpl;

/*
 * author: peter.li
 * date: 20160-12-23
 * purpose: system init action*/
@Controller
@RequestMapping("/system")
public class SystemAction {
	
	@Autowired
	CarTypeServiceImpl carTypeServiceImpl;
	
	@Autowired
	ServiceServiceImpl serviceServiceImpl;
	
	@Autowired
	UserRoleServiceImpl userRoleServiceImpl;
	
	@Autowired
	UserRoleServiceServiceImpl userRoleServiceServiceImpl;
	
	@Autowired
	ServiceCarPriceServiceImpl serviceCarPriceServiceImpl;
	
	@Autowired
	SystemServiceImpl systemServiceImpl;

	@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	@ResponseBody
	public Object fileUploadSingle(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) MultipartFile myfile){
		// 获取文件暂存和保存路径
		Properties prop = new Properties();
		InputStream in = request.getSession().getServletContext()
				.getResourceAsStream("/WEB-INF/fileService.properties");
		try {
			prop.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ApiResultEntity(false, e, 500, "io exception");
		}
		
		// 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
		// 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
		// 并且上传多个文件时，前台表单中的所有
		// <input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
		if (myfile.isEmpty()) {
			return new ApiResultEntity(false, "", 400, "no file uploaded");
		} else {
			//clear the tables
			systemServiceImpl.truncTables();
			
			//analysis the file
			InputStream is;
			try {
				is = new ByteArrayInputStream(myfile.getBytes());
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
				for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
					HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
					if (hssfSheet == null) {
						continue;
					}
					if (hssfSheet.getSheetName().equals("car_type")) {
						List<CarTypeEntity> carTypeList = getCarTypeSheet(hssfSheet);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("list",carTypeList);
						
						carTypeServiceImpl.saveBatch(map);
					}
					if (hssfSheet.getSheetName().equals("service")) {
						List<ServiceEntity> serviceList = getServiceSheet(hssfSheet);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("list",serviceList);
						
						serviceServiceImpl.saveBatch(map);
					}
					if (hssfSheet.getSheetName().equals("user_role")) {
						List<UserRoleEntity> userRoleList = getUserRoleSheet(hssfSheet);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("list",userRoleList);
						
						userRoleServiceImpl.saveBatch(map);
					}
					if (hssfSheet.getSheetName().equals("user_role_service")) {
						List<UserRoleServiceEntity> userRoleServiceList = getUserRoleServiceSheet(hssfSheet);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("list",userRoleServiceList);
						
						userRoleServiceServiceImpl.saveBatch(map);
					}
					if (hssfSheet.getSheetName().equals("service_car_price")) {
						List<ServiceCarPriceEntity> serviceCarPriceList = getServiceCarPriceSheet(hssfSheet);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("list",serviceCarPriceList);
						
						serviceCarPriceServiceImpl.saveBatch(map);
					}
				}
				
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ApiResultEntity(false, e, 500, "io exception");
			} catch (Exception ee){
				ee.printStackTrace();
				return new ApiResultEntity(false, ee, 500, "data format error");
			}
			
		};

		return new ApiResultEntity(true, "", 200, "");
	}

	// parse a multipart File to File
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}
	
	public List<CarTypeEntity> getCarTypeSheet(HSSFSheet hssfSheet){
		
		List<CarTypeEntity> list = new ArrayList<CarTypeEntity>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			CarTypeEntity carType = new CarTypeEntity();
			// 循环列Cell
			// 0--ID 1--NAME ID 2--DESCRIPTION 3--DELFLAG
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			String id = getValue(xhZero);
			if (id.isEmpty()) {
				continue;
			}
			carType.setId(id);
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			carType.setName(getValue(xhOne));
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			carType.setDescription(getValue(xhTwo));
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			carType.setDelFlag(Boolean.valueOf(getValue(xhThree)));
			
			list.add(carType);
		}
		
		return list;
	}
	
	public List<ServiceEntity> getServiceSheet(HSSFSheet hssfSheet){
		
		List<ServiceEntity> list = new ArrayList<ServiceEntity>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			ServiceEntity service = new ServiceEntity();
			// 循环列Cell
			// 0--ID 1--NAME ID 2--DESCRIPTION 3--DELFLAG
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			String id = getValue(xhZero);
			if (id.isEmpty()) {
				continue;
			}
			service.setId(id);
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			service.setName(getValue(xhOne));
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			service.setDescription(getValue(xhTwo));
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			service.setDelFlag(Boolean.valueOf(getValue(xhThree)));
			
			list.add(service);
		}
		
		return list;
	}
	
	public List<UserRoleEntity> getUserRoleSheet(HSSFSheet hssfSheet){
		
		List<UserRoleEntity> list = new ArrayList<UserRoleEntity>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			UserRoleEntity userRole = new UserRoleEntity();
			// 循环列Cell
			// 0--ID 1--NAME ID 2--DESCRIPTION 3--DELFLAG
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			String id = getValue(xhZero);
			if (id.isEmpty()) {
				continue;
			}
			userRole.setId(id);
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			userRole.setName(getValue(xhOne));
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			userRole.setDescription(getValue(xhTwo));
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			userRole.setDelFlag(Boolean.valueOf(getValue(xhThree)));
			
			list.add(userRole);
		}
		
		return list;
	}
	
	public List<UserRoleServiceEntity> getUserRoleServiceSheet(HSSFSheet hssfSheet){
		
		List<UserRoleServiceEntity> list = new ArrayList<UserRoleServiceEntity>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			UserRoleServiceEntity userRoleServiceEntity = new UserRoleServiceEntity();
			// 循环列Cell
			// 0--ID 1--USER_ROLE_ID 2--SERVICE_ID 3--DESCRIPTION 4--DELFLAG
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			String id = getValue(xhZero);
			if (id.isEmpty()) {
				continue;
			}
			userRoleServiceEntity.setId(id);
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			userRoleServiceEntity.setUserRoleId(getValue(xhOne));
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			userRoleServiceEntity.setServiceId(getValue(xhTwo));
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			userRoleServiceEntity.setDescription(getValue(xhThree));
			HSSFCell xhFour = hssfRow.getCell(4);
			if (xhFour == null) {
				continue;
			}
			userRoleServiceEntity.setDelFlag(Boolean.valueOf(getValue(xhFour)));
			
			list.add(userRoleServiceEntity);
		}
		
		return list;
	}
	
	public List<ServiceCarPriceEntity> getServiceCarPriceSheet(HSSFSheet hssfSheet){

		List<ServiceCarPriceEntity> list = new ArrayList<ServiceCarPriceEntity>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			ServiceCarPriceEntity serviceCarPriceEntity = new ServiceCarPriceEntity();
			// 循环列Cell
			// 0--ID 1--SERVICE_ID 2--CAR_TYPE_ID 3--PRICE 4--DELFLAG
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			String id = getValue(xhZero);
			if (id.isEmpty()) {
				continue;
			}
			serviceCarPriceEntity.setId(id);
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			serviceCarPriceEntity.setServiceId(getValue(xhOne));
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			serviceCarPriceEntity.setCarTypeId(getValue(xhTwo));
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			serviceCarPriceEntity.setPrice(Double.valueOf(getValue(xhThree)));
			HSSFCell xhFour = hssfRow.getCell(4);
			if (xhFour == null) {
				continue;
			}
			serviceCarPriceEntity.setDelFlag(Boolean.valueOf(getValue(xhFour)));
			
			list.add(serviceCarPriceEntity);
		}
		
		return list;
	}
	
	/**
	 * 得到Excel表中的值
	 * 
	 * @param hssfCell
	 *            Excel中的每一个格子
	 * @return Excel中每一个格子中的值
	 */
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}
		
}
