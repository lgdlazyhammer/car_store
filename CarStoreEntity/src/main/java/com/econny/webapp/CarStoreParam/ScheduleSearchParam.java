package com.econny.webapp.CarStoreParam;

import java.util.Date;

import com.econny.webapp.common.CustomJsonDateDeserializer;
import com.econny.webapp.common.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*
 * author: peter.li
 * date: 2016-12-30
 * purpose: class for schedule search*/
public class ScheduleSearchParam {

	private String id;
	private String userName;
	private String carTypeId;
	private String serviceId;
	private Date timeStart;
	private Date timeEnd;

	public ScheduleSearchParam() {

	}

	public ScheduleSearchParam(String id, String userName, String carTypeId, String serviceId, Date timeStart,
			Date timeEnd) {
		super();
		this.id = id;
		this.userName = userName;
		this.carTypeId = carTypeId;
		this.serviceId = serviceId;
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

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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
