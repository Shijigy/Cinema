package com.cinema.system.service;

import com.cinema.system.domin.SysMovieAge;
import com.cinema.system.domin.SysMovieArea;

import java.util.List;


public interface SysMovieAreaService {
    List<SysMovieArea> findAll();

    SysMovieArea findById(Long id);

    int add(SysMovieArea sysMovieArea);

    int update(SysMovieArea sysMovieArea);

    int delete(Long[] ids);
}
