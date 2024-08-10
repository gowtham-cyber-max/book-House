package com.book.spring.Controllers;

import com.book.spring.Models.FileUpload;
import com.book.spring.Services.FileUploadServ;
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
public class FileUploadController {
    @Autowired
    private FileUploadServ s;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") List<MultipartFile> file) throws IOException {
        return new ResponseEntity<>(s.addFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id)throws IOException{
        FileUpload filee=s.downloadFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(filee.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +filee.getFilename())
                .body(new ByteArrayResource(filee.getFile_src()));

    }

}
