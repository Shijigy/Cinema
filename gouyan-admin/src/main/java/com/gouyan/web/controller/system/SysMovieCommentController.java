package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.domin.SysMovieComment;
import com.gouyan.system.domin.pkclass.SysMovieCommentPrimaryKey;
import com.gouyan.system.service.impl.SysMovieCommentServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 22:41
 */
@RestController
public class SysMovieCommentController extends BaseController {

    @Autowired
    private SysMovieCommentServiceImpl sysMovieCommentService;

    @GetMapping("/sysMovieComment")
    public ResponseResult findAll(){
        startPage();
        List<SysMovieComment> data = sysMovieCommentService.findAll();
        return getResult(data);
    }

    @GetMapping("/sysMovieComment/{movieId}")
    public ResponseResult findByMovieId(@PathVariable Long movieId){
        return getResult(sysMovieCommentService.findByMovieId(movieId));
    }

    @GetMapping("/sysUserComment/{userId}")
    public ResponseResult findByUserId(@PathVariable Long userId){
        return getResult(sysMovieCommentService.findByUserId(userId));
    }

    @PostMapping("/sysMovieComment")
    public ResponseResult add(@Validated @RequestBody SysMovieComment sysMovieComment){
        return getResult(sysMovieCommentService.add(sysMovieComment));
    }

    @PutMapping("/sysMovieComment")
    public ResponseResult update(@Validated @RequestBody SysMovieComment sysMovieComment){
        return getResult(sysMovieCommentService.update(sysMovieComment));
    }

    @PostMapping("/sysMovieComment/delete")
    public ResponseResult delete(@RequestBody SysMovieCommentPrimaryKey[] pks){
        return getResult(sysMovieCommentService.delete(pks));
    }

}
