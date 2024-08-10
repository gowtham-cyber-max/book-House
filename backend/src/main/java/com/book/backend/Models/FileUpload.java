package com.book.backend.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document("FileUpload")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileUpload {
    private String filename;
    private String fileType;
    private String filesize;
    private byte[] file_src;


}