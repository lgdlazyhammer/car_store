package com.econny.webapp.CarStoreDao.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UploadFileEntity;

@Repository
public interface UploadFileMapper {

	public void insert(UploadFileEntity UploadFileEntity);
	
	public UploadFileEntity getById(UploadFileEntity UploadFileEntity);
	
	public void delete(UploadFileEntity UploadFileEntity);
}
