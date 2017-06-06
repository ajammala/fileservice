package com.adi.fileservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Entity class for the Metadata file. The columns are Id, FileContent and
 * createdate.
 * 
 * @author aditya
 *
 */
@Entity
public class MetaFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Lob
	private String metadataXML;

	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMetadataXML() {
		return metadataXML;
	}

	public void setMetadataXML(String metadataXML) {
		this.metadataXML = metadataXML;
	}

	public Date getCreated() {
		return created;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(id);
		stringBuilder.append("\t");
		stringBuilder.append(metadataXML);

		return stringBuilder.toString();
	}
}
