package com.cinema.system.service.impl;

import com.cinema.system.domin.SysUserHobby;
import com.cinema.system.mapper.SysUserHobbyMapper;
import com.cinema.system.service.SysUserHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserHobbyServiceImpl implements SysUserHobbyService {

    @Autowired
    private SysUserHobbyMapper sysUserHobbyMapper;

    @Override
    public List<SysUserHobby> findAll() {
        return sysUserHobbyMapper.findAll();
    }

    @Override
    public SysUserHobby findById(Long id) {
        return sysUserHobbyMapper.findById(id);
    }

    @Override
    public int add(SysUserHobby sysUserHobby) {
        return sysUserHobbyMapper.add(sysUserHobby);
    }

    @Override
    public int update(SysUserHobby sysUserHobby) {
        return sysUserHobbyMapper.update(sysUserHobby);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysUserHobbyMapper.delete(id);
        }
        return rows;
    }
}
