package com.cinema.web.controller.system;

import com.cinema.common.response.ResponseResult;
import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.service.impl.SysMovieRuntimeServiceImpl;
import com.cinema.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SysMovieRuntimeController extends BaseController {

    @Autowired
    SysMovieRuntimeServiceImpl sysMovieRuntimeService;

    @GetMapping("/sysMovieRuntime")
    public ResponseResult findAll(){
        startPage();
        List<SysMovieRuntime> data = sysMovieRuntimeService.findAll();
        return getResult(data);
    }

    @GetMapping("/sysMovieRuntime/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysMovieRuntimeService.findById(id));
    }

    @PostMapping("/sysMovieRuntime")
    public ResponseResult add(@Validated @RequestBody SysMovieRuntime sysMovieRuntime){
        return getResult(sysMovieRuntimeService.add(sysMovieRuntime));
    }

    @PutMapping("/sysMovieRuntime")
    public ResponseResult update(@Validated @RequestBody SysMovieRuntime sysMovieRuntime){
        return getResult(sysMovieRuntimeService.update(sysMovieRuntime));
    }

    @DeleteMapping("/sysMovieRuntime/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysMovieRuntimeService.delete(ids));
    }

}
