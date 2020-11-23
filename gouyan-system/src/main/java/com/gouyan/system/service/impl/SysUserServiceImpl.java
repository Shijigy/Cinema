package com.gouyan.system.service.impl;

import com.gouyan.system.domin.SysUser;
import com.gouyan.system.mapper.SysUserMapper;
import com.gouyan.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-22 21:45
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll(SysUser sysUser) {
        return sysUserMapper.findAll(sysUser);
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.findById(id);
    }

    @Override
    public int add(SysUser sysUser) {
        return sysUserMapper.add(sysUser);
    }

    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysUserMapper.delete(id);
        }
        return rows;
    }
}
