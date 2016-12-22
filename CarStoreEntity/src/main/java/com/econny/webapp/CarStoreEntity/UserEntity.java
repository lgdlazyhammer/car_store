package com.econny.webapp.CarStoreEntity;
/*
 * author: peter.li
 * date: 2016-12-22
 * purpose: entity of user for db persistence*/
public class UserEntity {

	private String id;
	private String name;
	private String password;
	private String roleId;
	private Boolean delFlag;

	public UserEntity() {
		super();
		this.delFlag = false;
	}

	public UserEntity(String id, String name, String password, String roleId, Boolean delFlag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.roleId = roleId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
