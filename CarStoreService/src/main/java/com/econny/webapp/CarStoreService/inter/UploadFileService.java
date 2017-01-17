package com.econny.webapp.CarStoreService.inter;

import com.econny.webapp.CarStoreEntity.UploadFileEntity;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UploadFileService {

	/* insert one row in upload file table */
	public void insert(UploadFileEntity UploadFileEntity);

	/* get item information by id */
	public UploadFileEntity getById(UploadFileEntity UploadFileEntity);

	public void delete(UploadFileEntity UploadFileEntity, String filePath, String filePathStatic);
}
