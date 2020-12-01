package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysMovieToCategory;
import com.gouyan.system.service.impl.SysMovieToCategoryServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-30 22:56
 */
@RestController
public class SysMovieToCategoryController extends BaseController {

    @Autowired
    private SysMovieToCategoryServiceImpl sysMovieToCategoryService;

    @GetMapping("/sysMovieToCategory")
    public ResponseResult findAll(SysMovieToCategory sysMovieToCategory){
        startPage();
        return getResult(sysMovieToCategoryService.findAll(sysMovieToCategory));
    }

    @PostMapping("/sysMovieToCategory")
    public ResponseResult add(@Validated @RequestBody SysMovieToCategory sysMovieToCategory){
        return getResult(sysMovieToCategoryService.add(sysMovieToCategory));
    }

    @PostMapping("/sysMovieToCategory/delete")
    public ResponseResult delete(@RequestBody SysMovieToCategory[] sysMovieToCategory){
        return getResult(sysMovieToCategoryService.delete(sysMovieToCategory));
    }

}
