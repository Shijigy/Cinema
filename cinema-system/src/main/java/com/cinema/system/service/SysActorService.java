package com.cinema.system.service;

import com.cinema.system.domin.SysActor;

import java.util.List;


public interface SysActorService {
    List<SysActor> findAll(SysActor sysActor);

    SysActor findById(Long id);

    int add(SysActor sysActor);

    int update(SysActor sysActor);

    int delete(Long[] ids);

    SysActor findActorById(Long id);
}
