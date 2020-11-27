package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysActorMovie;
import com.gouyan.system.service.impl.SysActorMovieServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxd
 * @create 2020-11-27 10:36
 */
@RestController
public class SysActorMovieController extends BaseController {

    @Autowired
    private SysActorMovieServiceImpl sysActorMovieService;

    @GetMapping("/sysActorMovie")
    public ResponseResult findAll(SysActorMovie sysActorMovie){
        startPage();
        return getResult(sysActorMovieService.findAll(sysActorMovie));
    }

    @PostMapping("/sysActorMovie")
    public ResponseResult add(@Validated @RequestBody SysActorMovie sysActorMovie){
        return getResult(sysActorMovieService.add(sysActorMovie));
    }

    @PostMapping("/sysActorMovie/delete")
    public ResponseResult delete(@RequestBody SysActorMovie[] sysActorMovies){
        return getResult(sysActorMovieService.delete(sysActorMovies));
    }

}
