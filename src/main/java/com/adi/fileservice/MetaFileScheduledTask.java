package com.adi.fileservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.adi.fileservice.service.MetaFileService;

/**
 * Scheduler class 
 * @author aditya
 *
 */
@Component
public class MetaFileScheduledTask {
	@Autowired
	MetaFileService metaFileService;

	/**
	 * Job runs every 1 hour to check if there are any new records added during the last hour.
	 */
	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void sendHourlyEmail() {
		System.out.println("Starting the scheduler!");
		List<Long> listOfIds = metaFileService.getAllNewIdsForNotification();
		if (listOfIds.isEmpty())
			System.out.println("Did not find new records!");
	}
}
