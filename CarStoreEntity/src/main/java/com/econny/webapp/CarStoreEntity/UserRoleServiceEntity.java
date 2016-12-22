package com.econny.webapp.CarStoreEntity;

/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of user role service relation for db persistence*/
public class UserRoleServiceEntity {

	private String id;
	private String userRoleId;
	private String serviceId;
	private String description;
	private Boolean delFlag;

	public UserRoleServiceEntity() {
		super();
		this.delFlag = false;
	}

	public UserRoleServiceEntity(String id, String userRoleId, String serviceId, String description, Boolean delFlag) {
		super();
		this.id = id;
		this.userRoleId = userRoleId;
		this.serviceId = serviceId;
		this.description = description;
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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
