package com.adi.fileservice.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.adi.fileservice.FileServiceError;
import com.adi.fileservice.model.MetaFile;
import com.adi.fileservice.service.MetaFileService;

/**
 * Controller class - all http requests are handled by this class.
 * 
 * @author aditya
 *
 */
@RestController
@RequestMapping("/api")
public class MetaServiceController {
	@Autowired
	MetaFileService metaFileService;

	/**
	 * Method to return all the records in the database.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/metadatafiles/", method = RequestMethod.GET)
	public ResponseEntity<List<MetaFile>> listAllMetaFiles() {
		List<MetaFile> files = metaFileService.findAllMetaFiles();
		if (files.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MetaFile>>(files, HttpStatus.OK);
	}

	/**
	 * Method to return one specific record from the database.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/metadatafiles/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMetaFile(@PathVariable("id") long id) {
		MetaFile file = metaFileService.findById(id);
		if (file == null) {
			return new ResponseEntity(new FileServiceError("File with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MetaFile>(file, HttpStatus.OK);
	}

	/**
	 * Upload a file to the database.
	 * 
	 * @param file
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/metadatafiles/", method = RequestMethod.POST)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ResponseEntity<?> uploadMetaFile(@RequestPart("file") MultipartFile file, UriComponentsBuilder ucBuilder) {
		try {
			MetaFile mf = new MetaFile();
			mf.setMetadataXML(new String(file.getBytes()));
			metaFileService.saveMetaFile(mf);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/metadatafiles/{id}").buildAndExpand(mf.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new FileServiceError("Unable to upload file: " + file.getOriginalFilename()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
