package com.econny.webapp.CarStoreEnum;

public enum UserRoleEnum {
	CUSTOMER ("111","顾客"),
	MANAGER ("222","管理员"),
	SUPERMANAGER ("333","超级管理员");

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
