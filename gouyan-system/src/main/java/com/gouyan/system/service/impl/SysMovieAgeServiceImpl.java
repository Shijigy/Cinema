package com.gouyan.system.service.impl;

import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.mapper.SysMovieAgeMapper;
import com.gouyan.system.service.SysMovieAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-14 22:59
 */
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
    public void add(SysMovieAge sysMovieAge) {
        sysMovieAgeMapper.add(sysMovieAge);
    }

    @Override
    public void update(SysMovieAge sysMovieAge) {
        sysMovieAgeMapper.update(sysMovieAge);
    }

    @Override
    public void delete(Long id) {
        sysMovieAgeMapper.delete(id);
    }
}
