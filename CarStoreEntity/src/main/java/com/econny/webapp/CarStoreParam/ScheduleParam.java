package com.econny.webapp.CarStoreParam;

import java.util.Date;

import com.econny.webapp.common.CustomJsonDateDeserializer;
import com.econny.webapp.common.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * author: peter.li
 * date: 2016-12-26
 * purpose: class for display*/
public class ScheduleParam {

	private String id;
	private String userName;
	private String serviceName;
	private String carType;
	private Double price;
	private Date timeStart;
	private Date timeEnd;

	public ScheduleParam() {

	}

	public ScheduleParam(String id, String userName, String serviceName, String carType, Double price, Date timeStart,
			Date timeEnd) {
		super();
		this.id = id;
		this.userName = userName;
		this.serviceName = serviceName;
		this.carType = carType;
		this.price = price;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	public Date getTimeStart() {
		return timeStart;
	}

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	public Date getTimeEnd() {
		return timeEnd;
	}

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

}
