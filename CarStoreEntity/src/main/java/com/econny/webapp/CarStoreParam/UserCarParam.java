package com.econny.webapp.CarStoreParam;

/*
 * author: peter.li
 * date: 2016-12-25
 * purpose: class for display*/
public class UserCarParam {

	private String id;
	private String userName;
	private String carType;
	private String description;

	public UserCarParam() {
		super();
	}

	public UserCarParam(String id, String userName, String carType, String description) {
		super();
		this.id = id;
		this.userName = userName;
		this.carType = carType;
		this.description = description;
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

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
