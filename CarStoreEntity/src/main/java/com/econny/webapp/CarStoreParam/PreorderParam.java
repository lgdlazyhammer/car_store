package com.econny.webapp.CarStoreParam;

import java.util.List;

import com.econny.webapp.CarStoreEntity.ServiceEntity;
import com.econny.webapp.CarStoreEntity.UserCarEntity;

/*
 * author: peter.li
 * date: 2016-12-26
 * purpose: class for display*/
public class PreorderParam {

	private List<UserCarParam> userCarList;
	private List<ServiceEntity> serviceList;

	public PreorderParam() {
		super();
	}

	public PreorderParam(List<UserCarParam> userCarList, List<ServiceEntity> serviceList) {
		super();
		this.userCarList = userCarList;
		this.serviceList = serviceList;
	}

	public List<UserCarParam> getUserCarList() {
		return userCarList;
	}

	public void setUserCarList(List<UserCarParam> userCarList) {
		this.userCarList = userCarList;
	}

	public List<ServiceEntity> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ServiceEntity> serviceList) {
		this.serviceList = serviceList;
	}

}
