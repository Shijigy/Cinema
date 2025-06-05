package com.cinema.system.service;

import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.domin.SysUserHobby;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-20 10:43
 */
public interface SysMovieRuntimeService {

    List<SysMovieRuntime> findAll();

    SysMovieRuntime findById(Long id);

    int add(SysMovieRuntime sysMovieRuntime);

    int update(SysMovieRuntime sysMovieRuntime);

    int delete(Long[] ids);

}
