package com.econny.webapp.CarStoreEnum;
/*
 * author:peter.li
 * date:2017-01-02
 * purpose:enum to mark file secure level*/
public enum FileSecureLevel {
	LevelOne (0,"保密性文件"),
	LevelTwo (1,"非保密文件"),
	LevelThree (2,"静态文件");
	
	private final int code;//标记号
	private final String description;//描述
	
	FileSecureLevel(int code, String description){
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
