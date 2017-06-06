package com.adi.fileservice.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adi.fileservice.model.MetaFile;

/**
 * DAO Implementation to perform the database related operations.
 * 
 * @author aditya
 *
 */
@Service("metaFileDao")
@Transactional
public class MetaFileDaoImpl implements MetaFileDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Find record matching Id
	 */
	public MetaFile findById(long id) {
		return entityManager.find(MetaFile.class, id);
	}

	/**
	 * Create a new record in the data table.
	 */
	public void save(MetaFile file) {
		entityManager.persist(file);
	}

	/**
	 * Get all the records in the table
	 */
	public List<MetaFile> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM MetaFile e");
		return (List<MetaFile>) query.getResultList();
	}

	/**
	 * Get all the record ids that were updated in the last hour.
	 */
	public List<Long> getAllNewIdsForNotification() {
		Query query = entityManager.createQuery("SELECT e.id FROM MetaFile e where e.created >= :date ");
		query.setParameter("date", new Date(System.currentTimeMillis() - 60 * 60 * 1000));
		return (List<Long>) query.getResultList();
	}

}
