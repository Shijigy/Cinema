package com.cinema.system.service.impl;

import com.cinema.system.domin.SysMovieComment;
import com.cinema.system.mapper.SysMovieCommentMapper;
import com.cinema.system.service.SysMovieCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysMovieCommentServiceImpl implements SysMovieCommentService {

    @Autowired
    private SysMovieCommentMapper sysMovieCommentMapper;

    @Override
    public List<SysMovieComment> findAll() {
        return sysMovieCommentMapper.findAll();
    }

    @Override
    public SysMovieComment findOne(SysMovieComment sysMovieComment) {
        return sysMovieCommentMapper.findOne(sysMovieComment);
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
    public int delete(SysMovieComment[] pks) {
        int rows = 0;
        for(SysMovieComment pk : pks){
            rows += sysMovieCommentMapper.delete(pk);
        }
        return rows;
    }
}
