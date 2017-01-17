package com.econny.webapp.CarStoreService.inter;

import java.util.HashMap;
import java.util.List;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer interface*/
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEntity.UserRoleEntity;
import com.econny.webapp.CarStoreEntity.UserRoleServiceEntity;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UserRoleServiceService {

	public void save(UserRoleServiceEntity userRoleServiceEntity);

	public void saveBatch(HashMap<String, Object> map);

	public void delete(UserRoleServiceEntity userRoleServiceEntity);

	public void update(UserRoleServiceEntity userRoleServiceEntity);

	public List<UserRoleServiceEntity> findList(UserRoleServiceEntity userRoleServiceEntity);

	/* find user role service permission list */
	public List<UserRoleServiceEntity> findUserPermission(UserEntity userEntity);
}
