package com.cinema.system.service.impl;

import com.cinema.system.domin.SysCinema;
import com.cinema.system.domin.vo.SysCinemaVo;
import com.cinema.system.mapper.SysCinemaMapper;
import com.cinema.system.service.SysCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysCinemaServiceImpl implements SysCinemaService {

    @Autowired
    private SysCinemaMapper sysCinemaMapper;


    @Override
    public List<SysCinema> findAll(SysCinemaVo sysCinemaVo) {
        return sysCinemaMapper.findAll(sysCinemaVo);
    }

    @Override
    public SysCinema findById(Long id) {
        return sysCinemaMapper.findById(id);
    }

    @Override
    public int add(SysCinema sysCinema) {
        return sysCinemaMapper.add(sysCinema);
    }

    @Override
    public int update(SysCinema sysCinema) {
        return sysCinemaMapper.update(sysCinema);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysCinemaMapper.delete(id);
        }
        return rows;
    }

    @Override
    public SysCinema findCinemaById(Long id) {
        return sysCinemaMapper.findCinemaById(id);
    }
}
