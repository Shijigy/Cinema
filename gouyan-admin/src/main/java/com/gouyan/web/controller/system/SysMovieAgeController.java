package com.gouyan.web.controller.system;

import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.service.impl.SysMovieAgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-15 22:58
 */
@RestController
public class SysMovieAgeController {

    @Autowired
    SysMovieAgeServiceImpl sysMovieAgeService;

    @GetMapping("/sysMovieAge")
    public String findAll(){
        return sysMovieAgeService.findAll().toString();
    }

    @GetMapping("/sysMovieAge/{id}")
    public String findById(@PathVariable Long id){
        return sysMovieAgeService.findById(id).toString();
    }

    @PostMapping("/sysMovieAge")
    public void add(@Validated @RequestBody SysMovieAge sysMovieAge){
        sysMovieAgeService.add(sysMovieAge);
    }

    @PutMapping("/sysMovieAge")
    public void update(@Validated @RequestBody SysMovieAge sysMovieAge){
        sysMovieAgeService.update(sysMovieAge);
    }

    @DeleteMapping("/sysMovieAge/{ids}")
    public void delete(@PathVariable Long[] ids){
        sysMovieAgeService.delete(ids);
    }

}
