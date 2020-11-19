package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.domin.SysMovieArea;
import com.gouyan.system.service.SysMovieAreaService;
import com.gouyan.system.service.impl.SysMovieAgeServiceImpl;
import com.gouyan.system.service.impl.SysMovieAreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-18 22:27
 */
@RestController
public class SysMovieAreaController {
    @Autowired
    SysMovieAreaServiceImpl sysMovieAreaService;

    @GetMapping("/sysMovieArea")
    public ResponseResult findAll(){
        List<SysMovieArea> data = sysMovieAreaService.findAll();
        return ResponseResult.success(data);
    }

    @GetMapping("/sysMovieArea/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return ResponseResult.success(sysMovieAreaService.findById(id));
    }

    @PostMapping("/sysMovieArea")
    public ResponseResult add(@Validated @RequestBody SysMovieArea sysMovieArea){
        sysMovieAreaService.add(sysMovieArea);
        return ResponseResult.success();
    }


    @PutMapping("/sysMovieArea")
    public ResponseResult update(@Validated @RequestBody SysMovieArea sysMovieArea){
        sysMovieAreaService.update(sysMovieArea);
        return ResponseResult.success();
    }

    @DeleteMapping("/sysMovieArea/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        sysMovieAreaService.delete(ids);
        return ResponseResult.success();
    }
}
