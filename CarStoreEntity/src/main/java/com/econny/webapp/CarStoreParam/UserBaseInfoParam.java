package com.econny.webapp.CarStoreParam;

import java.util.List;

/*
 * author: peter.li
 * date: 2016-12-25
 * purpose: class for display*/
public class UserBaseInfoParam {

	private UserParam user;
	private List<UserCarParam> carList;

	public UserBaseInfoParam() {
		super();
	}

	public UserBaseInfoParam(UserParam user, List<UserCarParam> carList) {
		super();
		this.user = user;
		this.carList = carList;
	}

	public UserParam getUser() {
		return user;
	}

	public void setUser(UserParam user) {
		this.user = user;
	}

	public List<UserCarParam> getCarList() {
		return carList;
	}

	public void setCarList(List<UserCarParam> carList) {
		this.carList = carList;
	}

}
