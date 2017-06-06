package com.adi.fileservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.adi.fileservice.service.MetaFileService;

/**
 * Scheduler class
 * 
 * @author aditya
 *
 */
@Component
public class MetaFileScheduledTask {
	@Autowired
	MetaFileService metaFileService;

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Job runs every 1 hour to check if there are any new records added during
	 * the last hour.
	 */
	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void sendHourlyEmail() {
		System.out.println("Starting the scheduler!");
		List<Long> listOfIds = metaFileService.getAllNewIdsForNotification();
		if (listOfIds.isEmpty()) {
			System.out.println("Did not find new records!");
		} else {
			// This service will need the configuration in the
			// application.properties file
			// spring.mail.host=...
			// spring.mail.port=...
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("foo@example.com");
			message.setTo("bar@example.com");
			message.setSubject("Updated File Ids");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Hello,\n The following Ids have been uploaded to the DB in the last hour - \n");
			for (Long l : listOfIds) {
				stringBuilder.append(l + "\n");
			}
			mailSender.send(message);
		}
	}
}
