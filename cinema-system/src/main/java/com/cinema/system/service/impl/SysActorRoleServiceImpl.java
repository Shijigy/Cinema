package com.cinema.system.service.impl;

import com.cinema.system.domin.SysActorRole;
import com.cinema.system.mapper.SysActorRoleMapper;
import com.cinema.system.service.SysActorRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysActorRoleServiceImpl implements SysActorRoleService {

    @Autowired
    SysActorRoleMapper sysActorRoleMapper;

    @Override
    public List<SysActorRole> findAll() {
        return sysActorRoleMapper.findAll();
    }

    @Override
    public SysActorRole findById(Long id) {
        return sysActorRoleMapper.findById(id);
    }

    @Override
    public int add(SysActorRole sysActorRole) {
        return sysActorRoleMapper.add(sysActorRole);
    }

    @Override
    public int update(SysActorRole sysActorRole) {
        return sysActorRoleMapper.update(sysActorRole);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysActorRoleMapper.delete(id);
        }
        return rows;
    }
}
