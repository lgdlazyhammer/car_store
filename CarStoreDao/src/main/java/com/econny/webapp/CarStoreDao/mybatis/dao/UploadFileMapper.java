package com.econny.webapp.CarStoreDao.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UploadFileEntity;

@Repository
public interface UploadFileMapper {

	/*insert one row in upload file table*/
	public void insert(UploadFileEntity UploadFileEntity);
	
	/* get item information by id */
	public UploadFileEntity getById(UploadFileEntity UploadFileEntity);
	
	public void delete(UploadFileEntity UploadFileEntity);
}
