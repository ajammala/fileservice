package com.adi.fileservice.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MetaFileTest {
	@Test
	public void setUp() {
		MetaFile mf = new MetaFile();
		mf.setId(1l);
		mf.setMetadataXML("<Test>This is a test</Test>");
		assertNotNull(mf);
		assertEquals(1l, mf.getId());
		assertEquals("<Test>This is a test</Test>", mf.getMetadataXML());
	}
	
	@Test
	public void testToString() {
		MetaFile mf = new MetaFile();
		mf.setId(1l);
		mf.setMetadataXML("<Test>This is a test</Test>");
		assertNotNull(mf.toString());
	}
}
