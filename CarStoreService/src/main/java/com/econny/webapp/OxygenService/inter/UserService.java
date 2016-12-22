package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer interface*/
import com.econny.webapp.CarStoreEntity.UserEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UserService {
	
	public void save(UserEntity userEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserEntity userEntity);
	
	public void update(UserEntity userEntity);
	
	public List<UserEntity> findList(UserEntity userEntity);
}
