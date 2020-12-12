package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysRole;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-19 22:52
 */
public interface SysRoleMapper {

    List<SysRole> findAll();

    SysRole findById(Long id);

    int add(SysRole sysRole);

    int update(SysRole sysRole);

    int delete(Long id);

}
