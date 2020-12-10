package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysResource;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-19 22:52
 */
public interface SysResourceMapper {

    /**
     * 查询所有并包含其父菜单
     * @return
     */
    List<SysResource> findAll();

    /**
     * 查出所有菜单并包含其children
     * @return
     */
    List<SysResource> findWithChildren();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysResource findById(Long id);

    /**
     * 添加演员角色
     * @param sysResource
     * @return 影响行数
     */
    int add(SysResource sysResource);

    /**
     * 修改演员角色
     * @param sysResource
     */
    int update(SysResource sysResource);

    /**
     * 删除指定id的演员角色
     * @param id
     */
    int delete(Long id);

}
