# File Service Application

## 1. Introduction
The application is a **Spring Boot** Application. It utilizes an **In-memory H2** db to store files and let the users retrieve them. It is designed as a Restful API to provide the following services -  

* Upload a file with a few meta-data fields. Persist meta-data in persistence store. In this case - The file format is XML and the file is directly persisted in DB.  
* Service to get file meta-data. The user has the option to fetch by a particular 'File Id' or fetch all items in the database.  
* Scheduler in the same app to poll for new items in the last hour and send an email.  

## 2. Usage
### 2.1 Uploading a file
*Endpoint* - http://localhost:8080/api/metadatafiles  
*HTTP Method* - POST  
*Body* - Multi-part file
### 2.2 Fetching a particular file
*Endpoint* - http://localhost:8080/api/metadatafiles/{id}  
*HTTP Method* - GET  
### 2.3 Fetching all files
*Endpoint* - http://localhost:8080/api/metadatafiles/  
*HTTP Method* - GET   
### 2.4 Scheduler Service
The scheduler service is designed to run every hour. It checks the database for all the items created within the last hour and sends out an email with the Ids of the records inserted in the last hour. The files with the configuration for the task timer - 

> MetaFileScheduledTask.java  
>> 	@Scheduled(fixedRate = 60 * 60 * 1000)  


> MetaFileDaoImpl.java
>> query.setParameter("date", new Date(System.currentTimeMillis() - 60 * 60 * 1000));


## 3. Testing
The application includes Unit test cases and Integration tests. 
> FileserviceApplicationTest.java  
> MetaServiceControllerTest.java  
> MetaFileDaoTest.java  
> MetaFileTest.java  
> MetaFileServiceTest.java

