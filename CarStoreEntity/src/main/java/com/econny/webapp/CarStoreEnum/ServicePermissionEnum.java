package com.econny.webapp.CarStoreEnum;

/*
 * author:peter.li
 * date:2017-01-02
 * purpose:enum to identify user permission*/
public enum ServicePermissionEnum {
	InitSystem("100", "系统配置"), 
	ScheduleReserve("101", "预约管理");

	private final String permission;
	private final String description;

	private ServicePermissionEnum(String permission, String description) {
		this.permission = permission;
		this.description = description;
	}

	public String getPermission() {
		return permission;
	}

	public String getDescription() {
		return description;
	}
}
