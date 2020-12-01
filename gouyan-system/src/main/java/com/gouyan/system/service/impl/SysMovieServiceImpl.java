package com.gouyan.system.service.impl;

import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.vo.SysMovieVo;
import com.gouyan.system.mapper.SysMovieMapper;
import com.gouyan.system.service.SysMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 15:58
 */
@Service
public class SysMovieServiceImpl implements SysMovieService {

    @Autowired
    private SysMovieMapper sysMovieMapper;

    @Override
    public List<SysMovie> findAll(SysMovieVo sysMovieVo) {
        return sysMovieMapper.findAll(sysMovieVo);
    }

    @Override
    public SysMovie findById(Long id) {
        return sysMovieMapper.findById(id);
    }

    @Override
    public SysMovie findOne(Long id) {
        return sysMovieMapper.findOne(id);
    }

    @Override
    public int add(SysMovie sysMovie) {
        return sysMovieMapper.add(sysMovie);
    }

    @Override
    public int update(SysMovie sysMovie) {
        return sysMovieMapper.update(sysMovie);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysMovieMapper.delete(id);
        }
        return rows;
    }

    @Override
    public List<SysMovie> findMovieById(Long id) {
        return sysMovieMapper.findMovieById(id);
    }
}
