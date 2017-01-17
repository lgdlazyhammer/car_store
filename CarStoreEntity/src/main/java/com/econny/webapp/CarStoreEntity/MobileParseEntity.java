package com.econny.webapp.CarStoreEntity;

/*
 * author: peter.li
 * date: 2017-01-12
 * purpose: mobile parse entity*/
public class MobileParseEntity {

	private String ajaxData;
	private String token;

	public MobileParseEntity() {
		super();
	}

	public MobileParseEntity(String ajaxData) {
		super();
		this.ajaxData = ajaxData;
	}

	public String getAjaxData() {
		return ajaxData;
	}

	public void setAjaxData(String ajaxData) {
		this.ajaxData = ajaxData;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
