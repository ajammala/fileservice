package com.adi.fileservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adi.fileservice.controller.MetaServiceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileserviceApplicationTest {

	@Autowired
    private MetaServiceController controller;
	
	@Test
    public void contexLoads() throws Exception {
		assertNotNull(controller);
    }

}
