package com.cinema.system.service.impl;

import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.mapper.SysMovieRuntimeMapper;
import com.cinema.system.service.SysMovieRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysMovieRuntimeServiceImpl implements SysMovieRuntimeService {

    @Autowired
    private SysMovieRuntimeMapper sysMovieRuntimeMapper;

    @Override
    public List<SysMovieRuntime> findAll() {
        return sysMovieRuntimeMapper.findAll();
    }

    @Override
    public SysMovieRuntime findById(Long id) {
        return sysMovieRuntimeMapper.findById(id);
    }

    @Override
    public int add(SysMovieRuntime sysMovieRuntime) {
        return sysMovieRuntimeMapper.add(sysMovieRuntime);
    }

    @Override
    public int update(SysMovieRuntime sysMovieRuntime) {
        return sysMovieRuntimeMapper.update(sysMovieRuntime);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysMovieRuntimeMapper.delete(id);
        }
        return rows;
    }
}
