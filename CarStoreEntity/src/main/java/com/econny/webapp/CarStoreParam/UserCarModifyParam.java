package com.econny.webapp.CarStoreParam;

import java.util.List;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.UserCarEntity;

/*
 * author: peter.li
 * date: 2017-01-04
 * purpose: class for display*/
public class UserCarModifyParam {

	private UserCarEntity userCar;
	private List<CarTypeEntity> carTypeList;

	public UserCarModifyParam() {

	}

	public UserCarModifyParam(UserCarEntity userCar, List<CarTypeEntity> carTypeList) {
		super();
		this.userCar = userCar;
		this.carTypeList = carTypeList;
	}

	public UserCarEntity getUserCar() {
		return userCar;
	}

	public void setUserCar(UserCarEntity userCar) {
		this.userCar = userCar;
	}

	public List<CarTypeEntity> getCarTypeList() {
		return carTypeList;
	}

	public void setCarTypeList(List<CarTypeEntity> carTypeList) {
		this.carTypeList = carTypeList;
	}

}
