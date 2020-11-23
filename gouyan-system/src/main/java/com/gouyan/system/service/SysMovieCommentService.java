package com.gouyan.system.service;

import com.gouyan.system.domin.SysMovieComment;
import com.gouyan.system.domin.pkclass.SysMovieCommentPrimaryKey;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 21:48
 */
public interface SysMovieCommentService {

    List<SysMovieComment> findAll();

    List<SysMovieComment> findByMovieId(Long movieId);

    List<SysMovieComment> findByUserId(Long userId);

    int add(SysMovieComment sysMovieComment);

    int update(SysMovieComment sysMovieComment);

    int delete(SysMovieCommentPrimaryKey[] pks);

}
