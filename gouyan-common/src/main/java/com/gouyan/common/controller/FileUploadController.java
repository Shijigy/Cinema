package com.gouyan.common.controller;

import com.gouyan.common.file.FileUploadUtils;
import com.gouyan.common.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 封装图片上传请求
 * @Author: 华雨欣
 * @Create: 2020-12-05 12:25
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping("/user")
    public ResponseResult uploadUser(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.userPath);
        String filename = FileUploadUtils.upload(file);
        logger.debug("上传文件名 : " + filename);
        return ResponseResult.success((Object)filename);
    }

    @PostMapping("/movie")
    public ResponseResult uploadMovie(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.moviePath);
        String filename = FileUploadUtils.upload(file);
        logger.debug("上传文件名 : " + filename);
        return ResponseResult.success((Object)filename);
    }

    @PostMapping("/cinema")
    public ResponseResult uploadCinema(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.cinemaPath);
        String filename = FileUploadUtils.upload(file);
        logger.debug("上传文件名 : " + filename);
        return ResponseResult.success((Object)filename);
    }

    @PostMapping("/actor")
    public ResponseResult uploadActor(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.actorPath);
        String filename = FileUploadUtils.upload(file);
        logger.debug("上传文件名 : " + filename);
        return ResponseResult.success((Object)filename);
    }

}
