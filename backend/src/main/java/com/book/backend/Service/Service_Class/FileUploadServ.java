package com.book.backend.Service.Service_Class;

import com.book.backend.Mapper.FileUploadMapper;
import com.book.backend.Models.FileUpload;
import com.book.backend.Repo.FileUploadRepo;
import com.book.backend.Serializer_DTO.FileUpload_DTO;
import com.book.backend.Service.Service_Interface.FileUpload_Interface;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServ implements FileUpload_Interface {
    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;
    public List<String> addFile(List<MultipartFile> uploadFile) throws IOException {
        List<String>fileIdList=new ArrayList<>();
        for(MultipartFile i:uploadFile){
            DBObject metadata=new BasicDBObject();
            metadata.put("filesize", i.getSize()); // i add file size as extra column
            Object fileId=template.store(i.getInputStream(),i.getOriginalFilename(),i.getContentType(),metadata);
            fileIdList.add(fileId.toString());
        }
        return fileIdList;




    }

    public FileUpload_DTO downloadFile(String id) throws IOException {

        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );

        FileUpload fileUpload = new FileUpload();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            fileUpload.setFilename(gridFSFile.getFilename());

            Object contentType = gridFSFile.getMetadata().get("_contentType");
            fileUpload.setFileType(contentType != null ? contentType.toString() : "unknown");

            Object fileSize = gridFSFile.getMetadata().get("fileSize");
            fileUpload.setFilesize(fileSize != null ? fileSize.toString() : "0");

            fileUpload.setFile_src(IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));
        }
        else {
            System.out.println("errrrr");
        }
        FileUpload_DTO fd= FileUploadMapper.convertToFileUpload_DTO(fileUpload);
        return fd;
    }
}
