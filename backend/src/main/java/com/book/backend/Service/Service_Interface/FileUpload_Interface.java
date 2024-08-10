package com.book.backend.Service.Service_Interface;

import com.book.backend.Models.FileUpload;
import com.book.backend.Serializer_DTO.FileUpload_DTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUpload_Interface {
    FileUpload_DTO downloadFile(String id);

    List<String> addFile(List<MultipartFile> uploadFile);
}
