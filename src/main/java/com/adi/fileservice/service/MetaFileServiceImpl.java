package com.adi.fileservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.fileservice.dao.MetaFileDao;
import com.adi.fileservice.model.MetaFile;

/**
 * Service Implementation for performing the tasks as redirected by the
 * controller.
 * 
 * @author aditya
 *
 */
@Service("metaFileService")
public class MetaFileServiceImpl implements MetaFileService {

	@Autowired
	MetaFileDao metaFileDao;

	/**
	 * Find the data record with matching id.
	 */
	public MetaFile findById(long id) {
		return metaFileDao.findById(id);
	}

	/**
	 * Return all records in the database
	 */
	public List<MetaFile> findAllMetaFiles() {
		return metaFileDao.findAll();
	}

	/**
	 * Upload a file successfully.
	 */
	public void saveMetaFile(MetaFile file) {
		metaFileDao.save(file);
	}

	/**
	 * Find record Ids updated in the last hour.
	 */
	public List<Long> getAllNewIdsForNotification() {
		return metaFileDao.getAllNewIdsForNotification();
	}

}
