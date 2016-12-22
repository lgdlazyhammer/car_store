package com.econny.webapp.CarStoreEntity;
/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of user car for db persistence*/
public class UserCarEntity {

	private String id;
	private String userId;
	private String carTypeId;
	private String description;
	private Boolean delFlag;

	public UserCarEntity() {
		super();
		this.delFlag = false;
	}

	public UserCarEntity(String id, String userId, String carTypeId, String description, Boolean delFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.carTypeId = carTypeId;
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

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
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
