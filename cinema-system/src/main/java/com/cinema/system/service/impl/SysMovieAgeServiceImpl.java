package com.cinema.system.service.impl;

import com.cinema.system.domin.SysMovieAge;
import com.cinema.system.mapper.SysMovieAgeMapper;
import com.cinema.system.service.SysMovieAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysMovieAgeServiceImpl implements SysMovieAgeService {

    @Autowired
    SysMovieAgeMapper sysMovieAgeMapper;

    @Override
    public List<SysMovieAge> findAll() {
        return sysMovieAgeMapper.findAll();
    }

    @Override
    public SysMovieAge findById(Long id) {
        return sysMovieAgeMapper.findById(id);
    }

    @Override
    public int add(SysMovieAge sysMovieAge) {
        return sysMovieAgeMapper.add(sysMovieAge);
    }

    @Override
    public int update(SysMovieAge sysMovieAge) {
        return sysMovieAgeMapper.update(sysMovieAge);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids)
            rows += sysMovieAgeMapper.delete(id);
        return rows;
    }
}
