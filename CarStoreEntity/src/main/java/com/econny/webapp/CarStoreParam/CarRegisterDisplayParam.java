package com.econny.webapp.CarStoreParam;

import java.util.List;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;

/*
 * author: peter.li
 * date: 2016-12-25
 * purpose: class for display*/
public class CarRegisterDisplayParam {

	private List<CarTypeEntity> carTypeList;
	private List<UserCarParam> userCarList;

	public CarRegisterDisplayParam() {

	}

	public CarRegisterDisplayParam(List<CarTypeEntity> carTypeList, List<UserCarParam> userCarList) {
		super();
		this.carTypeList = carTypeList;
		this.userCarList = userCarList;
	}

	public List<CarTypeEntity> getCarTypeList() {
		return carTypeList;
	}

	public void setCarTypeList(List<CarTypeEntity> carTypeList) {
		this.carTypeList = carTypeList;
	}

	public List<UserCarParam> getUserCarList() {
		return userCarList;
	}

	public void setUserCarList(List<UserCarParam> userCarList) {
		this.userCarList = userCarList;
	}

}
