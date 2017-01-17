package com.econny.webapp.CarStoreEnum;
/*
 * author:peter.li
 * date:2017-01-02
 * purpose:enum to identify user role*/
public enum UserRoleEnum {
	CUSTOMER ("111","普通会员"),
	MANAGER ("222","管理员"),
	SUPERMANAGER ("333","超级管理员"),
	SILVERCUSTOMER ("444","银牌会员"),
	GOLDCUSTOMER ("555","金牌会员");

	private final String roleId;
	private final String description;
	
	private UserRoleEnum(String roleId, String description) {
		this.roleId = roleId;
		this.description = description;
	}

	public String getRoleId() {
		return roleId;
	}

	public String getDescription() {
		return description;
	}
	
}
