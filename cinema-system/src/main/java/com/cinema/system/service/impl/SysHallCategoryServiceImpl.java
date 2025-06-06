package com.cinema.system.service.impl;

import com.cinema.system.domin.SysHallCategory;
import com.cinema.system.mapper.SysHallCategoryMapper;
import com.cinema.system.service.SysHallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysHallCategoryServiceImpl implements SysHallCategoryService {

    @Autowired
    private SysHallCategoryMapper sysHallCategoryMapper;

    @Override
    public List<SysHallCategory> findAll() {
        return sysHallCategoryMapper.findAll();
    }

    @Override
    public SysHallCategory findById(Long id) {
        return sysHallCategoryMapper.findById(id);
    }

    @Override
    public int add(SysHallCategory sysHallCategory) {
        return sysHallCategoryMapper.add(sysHallCategory);
    }

    @Override
    public int update(SysHallCategory sysHallCategory) {
        return sysHallCategoryMapper.update(sysHallCategory);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysHallCategoryMapper.delete(id);
        }
        return rows;
    }
}
