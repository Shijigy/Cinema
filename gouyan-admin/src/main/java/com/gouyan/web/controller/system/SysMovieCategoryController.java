package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysMovieArea;
import com.gouyan.system.domin.SysMovieCategory;
import com.gouyan.system.service.impl.SysMovieCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-19 18:45
 */
@RestController
public class SysMovieCategoryController {

    @Autowired
    private SysMovieCategoryServiceImpl sysMovieCategoryService;

    @GetMapping("/sysMovieCategory")
    public ResponseResult findAll(){
        List<SysMovieCategory> data = sysMovieCategoryService.findAll();
        return ResponseResult.success(data);
    }

    @GetMapping("/sysMovieCategory/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return ResponseResult.success(sysMovieCategoryService.findById(id));
    }

    @PostMapping("/sysMovieCategory")
    public ResponseResult add(@Validated @RequestBody SysMovieCategory sysMovieCategory){
        sysMovieCategoryService.add(sysMovieCategory);
        return ResponseResult.success();
    }


    @PutMapping("/sysMovieCategory")
    public ResponseResult update(@Validated @RequestBody SysMovieCategory sysMovieCategory){
        sysMovieCategoryService.update(sysMovieCategory);
        return ResponseResult.success();
    }

    @DeleteMapping("/sysMovieCategory/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        sysMovieCategoryService.delete(ids);
        return ResponseResult.success();
    }
}
