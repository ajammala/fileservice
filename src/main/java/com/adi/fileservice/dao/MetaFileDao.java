package com.adi.fileservice.dao;

import java.util.List;
import java.util.Map;

import com.adi.fileservice.model.MetaFile;

/**
 * Interface for DB operations
 * 
 * @author aditya
 *
 */
public interface MetaFileDao {

	public MetaFile findById(long id);

	public void save(MetaFile file);

	public List<MetaFile> findAll();

	public List<Long> getAllNewIdsForNotification();

}
