package com.econny.webapp.CarStoreService.inter;

import java.util.HashMap;
import java.util.List;

import com.econny.webapp.CarStoreEntity.CarTypeEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer interface*/
import com.econny.webapp.CarStoreEntity.UserEntity;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface SystemService {

	/* truncate all table for init */
	public void truncTables();

	/* insert init user information */
	public void initUser();
}
