package com.cinema.web.controller;

import com.cinema.common.file.FileUploadUtils;
import com.cinema.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private UploadService  uploadService;

    @PostMapping("/user")
    public ResponseResult uploadUser(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.userPath);
        String url = uploadService.uploadFile(file);
        return ResponseResult.success((Object)url);
    }

    @PostMapping("/movie")
    public ResponseResult uploadMovie(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.moviePath);
        String url = uploadService.uploadFile(file);
        return ResponseResult.success((Object)url);
    }

    @PostMapping("/cinema")
    public ResponseResult uploadCinema(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.cinemaPath);
        String url = uploadService.uploadFile(file);
        return ResponseResult.success((Object)url);
    }

    @PostMapping("/actor")
    public ResponseResult uploadActor(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadUtils.setDefaultBaseDir(FileUploadUtils.actorPath);

        String url = uploadService.uploadFile(file);
        return ResponseResult.success((Object)url);
    }

    @RequestMapping("/delete")
    public ResponseResult deletePicture(String filePath){
        try {
            log.debug("删除文件路径为：" + filePath);
            Boolean flag = uploadService.deleteFile(filePath);
            log.debug(flag ? "删除成功" : "删除失败");
        } finally {
            return ResponseResult.success();
        }
    }

}
