package com.adi.fileservice.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.adi.fileservice.dao.MetaFileDao;
import com.adi.fileservice.model.MetaFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaFileServiceTest {

	@Autowired
	private MetaFileDao metaFileService;

	@Test
	@Transactional
	@Rollback(true)
	public void testFindById() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileService.save(mf);
		MetaFile mf1 = metaFileService.findById(mf.getId());
		assertEquals(mf.getMetadataXML(), mf1.getMetadataXML());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindAllMetaFiles() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileService.save(mf);
		MetaFile mf2 = new MetaFile();
		mf2.setMetadataXML("<Test>This is a test2</Test>");
		metaFileService.save(mf2);
		List<MetaFile> mfList = metaFileService.findAll();
		assertEquals(mfList.size(), 2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSaveMetaFile() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileService.save(mf);
		List<MetaFile> mfList = metaFileService.findAll();
		assertEquals(mf.getId(), mfList.get(0).getId());
		assertEquals(mf.getMetadataXML(), mfList.get(0).getMetadataXML());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllNewIdsForNotification() {
		MetaFile mf = new MetaFile();
		mf.setMetadataXML("<Test>This is a test</Test>");
		metaFileService.save(mf);
		MetaFile mf1 = metaFileService.findById(mf.getId());
		assertEquals(mf.getMetadataXML(), mf1.getMetadataXML());
	}

}
