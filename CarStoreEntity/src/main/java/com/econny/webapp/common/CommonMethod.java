package com.econny.webapp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.econny.webapp.CarStoreEntity.UserCarEntity;

public class CommonMethod {
	public static String getValid(String param) {

		if (param == null) {
			return "";
		}

		return param;
	}

	public static Integer getValid(Integer param) {

		if (param == null) {
			return 0;
		}

		return param;
	}

	public static Double getValid(Double param) {

		if (param == null) {
			return 0.0;
		}

		return param;
	}

	public static Float getValid(Float param) {

		if (param == null) {
			return (float) 0.0;
		}

		return param;
	}

	public static Byte getValid(Byte param) {

		if (param == null) {
			return new Byte("");
		}

		return param;
	}

	public static Long getValid(Long param) {

		if (param == null) {
			return (long) 0;
		}

		return param;
	}

	public static Boolean getValid(Boolean param) {

		if (param == null) {
			return false;
		}

		return param;
	}

	public static Short getValid(Short param) {

		if (param == null) {
			return 0;
		}

		return param;
	}

	public static Boolean isValid(String param) {
		if (param.equals("") || param.equals("0") || param == null) {
			return false;
		}
		return true;
	}

	public static String selectSettleDate(Date date, int param) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);

		switch (param) {
		case 0:
			return "";
		case 1:
			return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		case 2:
			c.set(Calendar.DATE, day + 1);
			return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		case 3:
			c.set(Calendar.DATE, day + 2);
			return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		}
		return "";
	}

	public static int dayForWeek(Date date) throws Throwable {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static String[] getDateArray(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String temp = format.format(date);
		return temp.split("-");
	}

	public static String dateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static Date stringToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}

	public static int getMaxDayNumber(int year, int month) {

		int count = year % 4;

		switch (month) {
		case 1:
			return 31;
		case 2:
			if (count == 0) {
				return 29;
			} else {
				return 28;
			}
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		}

		return 0;
	}
	
	public static Integer[] makeTimeLine(Integer startHour, Integer endHour){
		
		Integer[] timeLine = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		Integer count = endHour - startHour;
		for(int i=0;i<count;i++){
			timeLine[startHour+i]++;
		}
		return timeLine;
	}
	
	public static Integer[][] makeTimeTable(Integer[] timeLine, Integer[][] timeTable){
		
		for(int i=0;i<timeLine.length;i++){
			if(timeLine[i]==1){
				timeTable[i/6][i%6]++;
			}
		}
		
		return timeTable;
	}
	
	public static UserCarEntity checkCarExist(String carId, List<UserCarEntity> list){
		
		for(UserCarEntity temp : list){
			if(temp.getId().equals(carId)){
				return temp;
			}
		}
		
		return null;
	}
}
