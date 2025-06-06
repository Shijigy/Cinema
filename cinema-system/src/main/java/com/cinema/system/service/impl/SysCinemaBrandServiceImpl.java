package com.cinema.system.service.impl;

import com.cinema.system.domin.SysCinemaBrand;
import com.cinema.system.mapper.SysCinemaBrandMapper;
import com.cinema.system.service.SysCinemaBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysCinemaBrandServiceImpl implements SysCinemaBrandService {

    @Autowired
    private SysCinemaBrandMapper sysCinemaBrandMapper;

    @Override
    public List<SysCinemaBrand> findAll() {
        return sysCinemaBrandMapper.findAll();
    }

    @Override
    public SysCinemaBrand findById(Long id) {
        return sysCinemaBrandMapper.findById(id);
    }

    @Override
    public int add(SysCinemaBrand sysCinemaBrand) {
        return sysCinemaBrandMapper.add(sysCinemaBrand);
    }

    @Override
    public int update(SysCinemaBrand sysCinemaBrand) {
        return sysCinemaBrandMapper.update(sysCinemaBrand);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysCinemaBrandMapper.delete(id);
        }
        return rows;
    }
}
