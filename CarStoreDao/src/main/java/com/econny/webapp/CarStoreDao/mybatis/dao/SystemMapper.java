package com.econny.webapp.CarStoreDao.mybatis.dao;

import org.springframework.stereotype.Repository;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user*/
@Repository
public interface SystemMapper {

	public void truncTables();
}
