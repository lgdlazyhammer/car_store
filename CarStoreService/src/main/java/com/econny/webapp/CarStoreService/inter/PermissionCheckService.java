package com.econny.webapp.CarStoreService.inter;

import com.econny.webapp.CarStoreEntity.UserEntity;

/*
 * author: peter.li
 * date: 2017-01-02
 * purpose: service layer*/
public interface PermissionCheckService {
	
	/* check user permission */
	public Boolean checkPermission(String permissionId, UserEntity userEntity);
}
