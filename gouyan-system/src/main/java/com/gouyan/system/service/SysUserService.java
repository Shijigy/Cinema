package com.gouyan.system.service;

import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysUser;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-22 21:42
 */
public interface SysUserService {
    List<SysUser> findAll(SysUser sysUser);

    SysUser findById(Long id);

    int add(SysUser sysUser);

    int update(SysUser sysUser);

    int delete(Long[] ids);
}
