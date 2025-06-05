package com.cinema.web.controller;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    // 上传文件
    String uploadFile(MultipartFile file) throws IOException;

    // 删除文件
    Boolean deleteFile(String filePath) throws IOException;
}