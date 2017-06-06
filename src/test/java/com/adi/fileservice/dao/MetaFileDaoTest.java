package com.adi.fileservice.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.adi.fileservice.model.MetaFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaFileDaoTest {

	@Autowired
	private MetaFileDao metaFileDao;

	@Test
	@Transactional
	@Rollback(true)
	public void testFindById() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileDao.save(mf);
		MetaFile mf1 = metaFileDao.findById(mf.getId());
		assertEquals(mf.getMetadataXML(), mf1.getMetadataXML());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileDao.save(mf);
		List<MetaFile> mfList = metaFileDao.findAll();
		assertEquals(mf.getId(), mfList.get(0).getId());
		assertEquals(mf.getMetadataXML(), mfList.get(0).getMetadataXML());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindAll() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileDao.save(mf);
		MetaFile mf2 = new MetaFile();
		mf2.setMetadataXML("<Test>This is a test2</Test>");
		metaFileDao.save(mf2);
		List<MetaFile> mfList = metaFileDao.findAll();
		assertEquals(mfList.size(), 2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllNewIdsForNotification() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileDao.save(mf);
		MetaFile mf1 = metaFileDao.findById(mf.getId());
		assertEquals(mf.getMetadataXML(), mf1.getMetadataXML());
	}

}
