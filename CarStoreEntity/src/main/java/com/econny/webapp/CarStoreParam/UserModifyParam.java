package com.econny.webapp.CarStoreParam;

import java.util.List;

import com.econny.webapp.CarStoreEntity.UserRoleEntity;

/*
 * author: peter.li
 * date: 2017-01-03
 * purpose: class for display*/
public class UserModifyParam {

	private UserParam user;
	private List<UserRoleEntity> userRoleList;

	public UserModifyParam() {

	}

	public UserModifyParam(UserParam user, List<UserRoleEntity> userRoleList) {
		super();
		this.user = user;
		this.userRoleList = userRoleList;
	}

	public UserParam getUser() {
		return user;
	}

	public void setUser(UserParam user) {
		this.user = user;
	}

	public List<UserRoleEntity> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoleEntity> userRoleList) {
		this.userRoleList = userRoleList;
	}

}
