package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.service.impl.SysMovieAgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-15 22:58
 */
@RestController
public class SysMovieAgeController {

    @Autowired
    SysMovieAgeServiceImpl sysMovieAgeService;

    @GetMapping("/sysMovieAge")
    public ResponseResult findAll(){
        List<SysMovieAge> data = sysMovieAgeService.findAll();
        return ResponseResult.success(data);
    }

    @GetMapping("/sysMovieAge/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return ResponseResult.success(sysMovieAgeService.findById(id));
    }

    @PostMapping("/sysMovieAge")
    public ResponseResult add(@Validated @RequestBody SysMovieAge sysMovieAge){
        sysMovieAgeService.add(sysMovieAge);
        return ResponseResult.success();
    }

    /**
     * 通过@Validated验证前端传来的数据正确性，使用BindResult接收结果
     * @param sysMovieAge
     */
    @PutMapping("/sysMovieAge")
    public ResponseResult update(@Validated @RequestBody SysMovieAge sysMovieAge){
        sysMovieAgeService.update(sysMovieAge);
        return ResponseResult.success();
    }

    @DeleteMapping("/sysMovieAge/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        sysMovieAgeService.delete(ids);
        return ResponseResult.success();
    }

}
