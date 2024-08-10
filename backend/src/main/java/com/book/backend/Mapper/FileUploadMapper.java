package com.book.backend.Mapper;

import com.book.backend.Models.FileUpload;
import com.book.backend.Serializer_DTO.FileUpload_DTO;

public class FileUploadMapper {
    public static FileUpload convertToFileUpload(FileUpload_DTO fileUpload_dto){
        return new FileUpload(
                fileUpload_dto.getFilename(),
                fileUpload_dto.getFileType(),
                fileUpload_dto.getFilesize(),
                fileUpload_dto.getFile_src()
        );
    }
    public static FileUpload_DTO convertToFileUpload_DTO(FileUpload file){
        return new FileUpload_DTO(
                file.getFilename(),
                file.getFileType(),
                file.getFilesize(),
                file.getFile_src()
        );
    }
}
