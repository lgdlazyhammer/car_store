package com.econny.webapp.CarStoreEntity;
/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of service price of car for db persistence*/
public class ServiceCarPriceEntity {

	private String id;
	private String serviceId;
	private String carTypeId;
	private Double price;
	private Boolean delFlag;

	public ServiceCarPriceEntity() {
		super();
		this.delFlag = false;
	}

	public ServiceCarPriceEntity(String id, String serviceId, String carTypeId, Double price, Boolean delFlag) {
		super();
		this.id = id;
		this.serviceId = serviceId;
		this.carTypeId = carTypeId;
		this.price = price;
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
