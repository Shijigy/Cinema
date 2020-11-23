package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysMovieComment;
import com.gouyan.system.service.impl.SysMovieCommentServiceImpl;
import com.gouyan.system.service.impl.SysMovieServiceImpl;
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

    @Autowired
    private SysMovieServiceImpl sysMovieService;

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
        int rows = sysMovieCommentService.add(sysMovieComment);
        if(rows > 0){
            //添加成功 修改电影评分和评论人数
            SysMovie movie = sysMovieService.findById(sysMovieComment.getMovieId());
            Integer movieRateNum = movie.getMovieRateNum();
            Double movieScore = movie.getMovieScore();
            movieScore = (movieScore * movieRateNum + sysMovieComment.getScore()) / (++movieRateNum);

            movie.setMovieScore(movieScore);
            movie.setMovieRateNum(movieRateNum);
            sysMovieService.update(movie);
        }
        return getResult(rows);
    }

    /**
     * 修改评论内容信息，不允许修改评分
     * @param sysMovieComment
     * @return
     */
    @PutMapping("/sysMovieComment")
    public ResponseResult update(@Validated @RequestBody SysMovieComment sysMovieComment){
        return getResult(sysMovieCommentService.update(sysMovieComment));
    }

    @PostMapping("/sysMovieComment/delete")
    public ResponseResult delete(@RequestBody SysMovieComment[] pks){
        int rows = sysMovieCommentService.delete(pks);
        if(rows > 0){
            for(SysMovieComment comment : pks){
                SysMovie movie = sysMovieService.findById(comment.getMovieId());
                Integer movieRateNum = movie.getMovieRateNum();
                Double movieScore = movie.getMovieScore();
                if(movieRateNum == 1){
                    movieRateNum = 0;
                    movieScore = 0.0;
                }else{
                    movieScore = (movieScore * movieRateNum - comment.getScore()) / (--movieRateNum);
                }

                movie.setMovieRateNum(movieRateNum);
                movie.setMovieScore(movieScore);
                sysMovieService.update(movie);
            }
        }
        return getResult(rows);
    }

}
