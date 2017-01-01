package com.econny.webapp.CarStoreParam;

import java.util.List;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
import com.econny.webapp.CarStoreEntity.ServiceEntity;

/*
 * author: peter.li
 * date: 2016-12-30
 * purpose: class for display*/
public class ScheduleManagementParam {

	private List<CarTypeEntity> carTypeList;
	private List<ServiceEntity> serviceList;

	public ScheduleManagementParam() {

	}

	public ScheduleManagementParam(List<CarTypeEntity> carTypeList, List<ServiceEntity> serviceList) {
		super();
		this.carTypeList = carTypeList;
		this.serviceList = serviceList;
	}

	public List<CarTypeEntity> getCarTypeList() {
		return carTypeList;
	}

	public void setCarTypeList(List<CarTypeEntity> carTypeList) {
		this.carTypeList = carTypeList;
	}

	public List<ServiceEntity> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ServiceEntity> serviceList) {
		this.serviceList = serviceList;
	}

}
