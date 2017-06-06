package com.adi.fileservice.service;

import java.util.List;

import com.adi.fileservice.model.MetaFile;

/**
 * Service Interface for performing the tasks as redirected by the controller.
 * 
 * @author aditya
 *
 */
public interface MetaFileService {

	public MetaFile findById(long id);

	public List<MetaFile> findAllMetaFiles();

	public void saveMetaFile(MetaFile file);

	public List<Long> getAllNewIdsForNotification();
}
