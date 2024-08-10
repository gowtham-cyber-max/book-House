package com.book.spring.Repos;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileUploadRepo extends MongoRepository<FileUpload,String> {
}
