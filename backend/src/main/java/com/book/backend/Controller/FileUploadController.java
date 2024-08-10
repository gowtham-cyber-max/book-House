package com.book.backend.Controller;

import com.book.backend.Models.FileUpload;
import com.book.backend.Serializer_DTO.FileUpload_DTO;
import com.book.backend.Service.Service_Class.FileUploadServ;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/file")
public class FileUploadController {
    @Autowired
    private FileUploadServ s;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestBody List<MultipartFile> file) throws IOException {
        return new ResponseEntity<>(s.addFile(file), HttpStatus.CREATED);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id)throws IOException{
        FileUpload_DTO file=s.downloadFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +file.getFilename())
                .body(new ByteArrayResource(file.getFile_src()));

    }

}

