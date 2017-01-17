package com.econny.webapp.CarStoreParam;

/*
 * author: peter.li
 * date: 2016-12-25
 * purpose: class for display*/
public class UserParam {

	private String id;
	private String name;
	private String role;
	private String picId;

	public UserParam() {
		super();
	}

	public UserParam(String id, String name, String role, String picId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.picId = picId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

}
