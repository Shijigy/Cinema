package com.cinema.system.service;

import com.cinema.system.domin.SysResource;

import java.util.List;


public interface SysResourceService {
    List<SysResource> findAll();

    List<SysResource> findWithChildren();

    List<SysResource> findAllWithAllChildren();

    SysResource findById(Long id);

    int add(SysResource sysResource);

    int update(SysResource sysResource);

    int delete(Long[] ids);
}
