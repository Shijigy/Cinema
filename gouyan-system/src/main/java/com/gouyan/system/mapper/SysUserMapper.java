package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysActor;
import com.gouyan.system.domin.SysUser;
import com.gouyan.system.domin.SysUserHobby;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-22 21:48
 */
public interface SysUserMapper {
    List<SysUser> findAll(SysUser sysUser);

    SysUser findById(Long id);

    int add(SysUser sysUser);

    int update(SysUser sysUser);

    int delete(Long id);
}
