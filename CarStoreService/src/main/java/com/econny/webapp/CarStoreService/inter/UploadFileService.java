package com.econny.webapp.CarStoreService.inter;

import com.econny.webapp.CarStoreEntity.UploadFileEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UploadFileService {
	
	public void insert(UploadFileEntity UploadFileEntity);
	
	public UploadFileEntity getById(UploadFileEntity UploadFileEntity);
	
	public void delete(UploadFileEntity UploadFileEntity, String filePath, String filePathStatic);
}
