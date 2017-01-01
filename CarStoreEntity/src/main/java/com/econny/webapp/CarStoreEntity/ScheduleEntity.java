package com.econny.webapp.CarStoreEntity;

import java.util.Date;

import com.econny.webapp.common.CustomJsonDateDeserializer;
import com.econny.webapp.common.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of schedule for db persistence*/
public class ScheduleEntity {

	private String id;
	private String userId;
	private String serviceId;
	private String carId;
	private Double price;
	private Date timeStart;
	private Date timeEnd;
	private String description;
	private Boolean delFlag;

	public ScheduleEntity() {
		super();
		price = 0.0;
		timeStart = new Date();
		timeEnd = new Date();
		delFlag = false;
	}

	public ScheduleEntity(String id, String userId, String serviceId, String carId, Double price, Date timeStart,
			Date timeEnd, String description, Boolean delFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.serviceId = serviceId;
		this.carId = carId;
		this.price = price;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.description = description;
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
