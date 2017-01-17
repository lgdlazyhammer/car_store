package com.econny.webapp.CarStoreService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEntity.UserRoleServiceEntity;
import com.econny.webapp.CarStoreService.inter.PermissionCheckService;
import com.econny.webapp.CarStoreService.inter.ScheduleService;

/*
 * author: peter.li
 * date: 2017-01-02
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class PermissionCheckServiceImpl implements PermissionCheckService{
	
	@Autowired
	UserRoleServiceServiceImpl userRoleServiceServiceImpl;
	
	/*check user permission*/
	public Boolean checkPermission(String permissionId, UserEntity userEntity){
		
		List<UserRoleServiceEntity> userRoleServiceList = userRoleServiceServiceImpl.findUserPermission(userEntity);
		
		for(UserRoleServiceEntity temp: userRoleServiceList){
			if(temp.getServiceId().equals(permissionId)){
				return true;
			}
		}
		return false;
	}

}
