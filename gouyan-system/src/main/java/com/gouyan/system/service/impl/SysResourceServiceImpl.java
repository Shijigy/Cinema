package com.gouyan.system.service.impl;

import com.gouyan.system.domin.SysResource;
import com.gouyan.system.mapper.SysResourceMapper;
import com.gouyan.system.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-12-10 15:20
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> findAll() {
        return sysResourceMapper.findAll();
    }

    @Override
    public List<SysResource> findWithChildren() {
        return sysResourceMapper.findWithChildren();
    }

    @Override
    public SysResource findById(Long id) {
        return sysResourceMapper.findById(id);
    }

    @Override
    public int add(SysResource sysResource) {
        return sysResourceMapper.add(sysResource);
    }

    @Override
    public int update(SysResource sysResource) {
        return sysResourceMapper.update(sysResource);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysResourceMapper.delete(id);
        }
        return rows;
    }
}
