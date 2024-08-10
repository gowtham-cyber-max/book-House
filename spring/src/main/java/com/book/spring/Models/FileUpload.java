package com.book.spring.Models;

public class FileUpload {
    private String filename;
    private  String fileType;
    private String filesize;
    private byte[] file_src;

    public FileUpload(){

    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilesize(String fileSize) {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public byte[] getFile_src() {
        return file_src;
    }

    public void setFile_src(byte[] file_src) {
        this.file_src = file_src;
    }
}
