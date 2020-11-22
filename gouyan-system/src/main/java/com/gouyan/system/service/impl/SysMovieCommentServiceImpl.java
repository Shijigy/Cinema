package com.gouyan.system.service.impl;

import com.gouyan.system.domin.SysMovieComment;
import com.gouyan.system.domin.pkclass.SysMovieCommentPrimaryKey;
import com.gouyan.system.mapper.SysMovieCommentMapper;
import com.gouyan.system.service.SysMovieCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 21:51
 */
@Service
public class SysMovieCommentServiceImpl implements SysMovieCommentService {

    @Autowired
    private SysMovieCommentMapper sysMovieCommentMapper;

    @Override
    public List<SysMovieComment> findAll() {
        return sysMovieCommentMapper.findAll();
    }

    @Override
    public List<SysMovieComment> findByMovieId(Long movieId) {
        return sysMovieCommentMapper.findByMovieId(movieId);
    }

    @Override
    public List<SysMovieComment> findByUserId(Long userId) {
        return sysMovieCommentMapper.findByUserId(userId);
    }

    @Override
    public int add(SysMovieComment sysMovieComment) {
        return sysMovieCommentMapper.add(sysMovieComment);
    }

    @Override
    public int update(SysMovieComment sysMovieComment) {
        return sysMovieCommentMapper.update(sysMovieComment);
    }

    @Override
    public int delete(SysMovieCommentPrimaryKey[] pks) {
        int rows = 0;
        for(SysMovieCommentPrimaryKey pk : pks){
            rows += sysMovieCommentMapper.delete(pk.getMovieId(), pk.getUserId(), pk.getCommentTime());
        }
        return rows;
    }
}
