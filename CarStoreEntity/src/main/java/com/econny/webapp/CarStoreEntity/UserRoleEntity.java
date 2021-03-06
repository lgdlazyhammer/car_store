package com.econny.webapp.CarStoreEntity;

/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of user role for db persistence*/
public class UserRoleEntity {

	private String id;
	private String name;
	private String description;
	private Boolean delFlag;

	public UserRoleEntity() {
		super();
		this.delFlag = false;
	}

	public UserRoleEntity(String id, String name, String description, Boolean delFlag) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
