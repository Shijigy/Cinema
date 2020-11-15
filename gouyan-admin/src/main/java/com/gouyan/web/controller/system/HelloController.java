package com.gouyan.web.controller.system;

import com.gouyan.system.service.impl.SysMovieAgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-15 00:09
 */
@RestController
public class HelloController {

    @Autowired
    SysMovieAgeServiceImpl sysMovieAgeService;

    @RequestMapping("/hello")
    public String hello(){
        return sysMovieAgeService.findAll().toString();
    }

}
