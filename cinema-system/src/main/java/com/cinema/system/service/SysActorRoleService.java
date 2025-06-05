package com.cinema.system.service;

import com.cinema.system.domin.SysActorRole;
import com.cinema.system.domin.SysMovieAge;

import java.util.List;


public interface SysActorRoleService {
    List<SysActorRole> findAll();

    SysActorRole findById(Long id);

    int add(SysActorRole sysActorRole);

    int update(SysActorRole sysActorRole);

    int delete(Long[] ids);
}
