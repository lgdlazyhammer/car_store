package com.econny.webapp.CarStoreAction;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.econny.webapp.CarStoreEntity.ApiResultEntity;
@Controller
@RequestMapping("/projectConfigService")
public class ProjectConfigAction {
	
	@RequestMapping(value = "/initRoleAndService", method = RequestMethod.POST)
	@ResponseBody
	public Object initRoleAndService(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) MultipartFile myfile) throws IOException {
		
		//list to save to database
		/*List<OauthUserEntity> oauthUserList = new ArrayList<OauthUserEntity>();
		List<OauthRoleEntity> oauthRoleList = new ArrayList<OauthRoleEntity>();
		List<OauthServiceEntity> oauthServiceList = new ArrayList<OauthServiceEntity>();*/
		
		//analysis the file
		InputStream is = new ByteArrayInputStream(myfile.getBytes());
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			if (hssfSheet.getSheetName().equals("user")) {
				//oauthUserList = getUserSheet(hssfSheet);
			}
			if (hssfSheet.getSheetName().equals("role")) {
				//oauthRoleList = getRoleSheet(hssfSheet);
			}
			if (hssfSheet.getSheetName().equals("service")) {
				//oauthServiceList = getServiceSheet(hssfSheet);
			}

		}
		
		//insert users
		Map<String, Object> mapUser = new HashMap<String, Object>();
		//mapUser.put("list",oauthUserList);
		
		//insert role
		Map<String, Object> mapRole = new HashMap<String, Object>();
		//mapRole.put("list",oauthRoleList);
		
		//insert services
		Map<String, Object> mapService = new HashMap<String, Object>();
		//mapService.put("list",oauthServiceList);
		
		return new ApiResultEntity(true, "", 200, "");
	}
	
	//generate user list form excel sheet user
	public <T> List<T> getUserSheet(HSSFSheet hssfSheet){
		
		List<T> list = new ArrayList<T>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			//T oauthUser = new T();
			// 循环列Cell
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			//oauthUser.setId(getValue(xhZero));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			//oauthUser.setName(getValue(xhOne));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			//oauthUser.setPassword(getValue(xhTwo));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhThree = hssfRow.getCell(3);
			//oauthUser.setGender(getValue(xhThree));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhFour = hssfRow.getCell(4);
			//oauthUser.setPhoneNumber(getValue(xhFour));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhFive = hssfRow.getCell(5);
			//oauthUser.setEmail(getValue(xhFive));
			
			// 0--ID 1--NAME 2--PASSWORD 3--GENDER 4--PHONE NUMBER 5--EMAIL 6--DESCRIPTION
			HSSFCell xhSix = hssfRow.getCell(6);
			//oauthUser.setDescription(getValue(xhSix));
			
			// 7--del flag
			HSSFCell xhSeven = hssfRow.getCell(7);
			//oauthUser.setDelFlag(getValue(xhSeven));
			
			//list.add(oauthUser);
		}
		
		return list;
	}
	
	//generate user list form excel sheet role
	public <T> List<T> getRoleSheet(HSSFSheet hssfSheet){
		
		List<T> list = new ArrayList<T>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			//T oauthRole = new T();
			// 循环列Cell
			// 0--ID 1--USER ID 2--DESCRIPTION
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			//oauthRole.setId(getValue(xhZero));
			
			// 循环列Cell
			// 0--ID 1--USER ID 2--DESCRIPTION
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			//oauthRole.setUserId(getValue(xhOne));
			
			// 循环列Cell
			// 0--ID 1--USER ID 2--DESCRIPTION
			HSSFCell xhTwo = hssfRow.getCell(2);
			//oauthRole.setDescription(getValue(xhTwo));
			
			// 循环列Cell
			// 3--del flag
			HSSFCell xhThree = hssfRow.getCell(3);
			//oauthRole.setDelFlag(getValue(xhThree));
			
			//list.add(oauthRole);
		}
		
		return list;
	}
	
	//generate user list form excel sheet role
	public <T> List<T> getServiceSheet(HSSFSheet hssfSheet){
		
		List<T> list = new ArrayList<T>();

		//row stats at one but we record from two
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			if (hssfRow == null) {
				continue;
			}
			
			//T oauthService = new OauthServiceEntity();
			// 循环列Cell
			// 0--ID 1--USER ID 3--DESCRIPTION
			HSSFCell xhZero = hssfRow.getCell(0);
			if (xhZero == null) {
				continue;
			}
			//oauthService.setId(getValue(xhZero));
			
			// 循环列Cell
			// 0--ID 1--USER ID 2--SERVICE TYPE 3--DESCRIPTION
			HSSFCell xhOne = hssfRow.getCell(1);
			if (xhOne == null) {
				continue;
			}
			//oauthService.setRoleId(getValue(xhOne));
			
			// 循环列Cell
			// 0--ID 1--USER ID  2--SERVICE TYPE 3--DESCRIPTION
			HSSFCell xhTwo = hssfRow.getCell(2);
			if (xhTwo == null) {
				continue;
			}
			//oauthService.setServiceType(Integer.valueOf(getValue(xhTwo)));
			
			// 循环列Cell
			// 0--ID 1--USER ID  2--SERVICE TYPE 3--DESCRIPTION
			HSSFCell xhThree = hssfRow.getCell(3);
			if (xhThree == null) {
				continue;
			}
			//oauthService.setDescription(getValue(xhThree));
			
			// 循环列Cell
			// 4--del flag
			HSSFCell xhFour = hssfRow.getCell(4);
			if (xhFour == null) {
				continue;
			}
			//oauthService.setDelFlag(getValue(xhFour));
			
			//list.add(oauthService);
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
