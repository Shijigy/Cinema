package com.cinema.system.service;

import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.domin.SysUserHobby;

import java.util.List;


public interface SysMovieRuntimeService {

    List<SysMovieRuntime> findAll();

    SysMovieRuntime findById(Long id);

    int add(SysMovieRuntime sysMovieRuntime);

    int update(SysMovieRuntime sysMovieRuntime);

    int delete(Long[] ids);

}
