package com.econny.webapp.CarStoreParam;

/*
 * author: peter.li
 * date: 2016-12-25
 * purpose: class for display*/
public class CarTypeServicePriceParam {

	private String carTypeName;
	private String serviceName;
	private Double price;

	public CarTypeServicePriceParam() {
		super();
	}

	public CarTypeServicePriceParam(String carTypeName, String serviceName, Double price) {
		super();
		this.carTypeName = carTypeName;
		this.serviceName = serviceName;
		this.price = price;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
