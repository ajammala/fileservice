package com.adi.fileservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MetaServiceControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testListAllMetaFiles() throws Exception {
		this.mockMvc.perform(get("/api/metadatafiles/")).andDo(print()).andExpect(status().isNoContent());
	}

	@Test
	public void testGetMetaFile() throws Exception {
		this.mockMvc.perform(get("/api/metadatafiles/1")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUploadMetaFile() throws Exception {
		MockMultipartFile firstFile = new MockMultipartFile("file", "<Test>This is a test</Test>".getBytes());
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/metadatafiles/").file(firstFile)).andExpect(status().is(201));
	}

}
