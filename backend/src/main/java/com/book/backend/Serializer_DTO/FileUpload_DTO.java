package com.book.backend.Serializer_DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload_DTO {
    private String filename;
    private String fileType;
    private String filesize;
    private byte[] file_src;
}
