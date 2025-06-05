package com.cinema.system.service;

import com.cinema.system.domin.SysMovie;
import com.cinema.system.domin.SysMovieToCategory;

import java.util.List;


public interface SysMovieToCategoryService {

    List<SysMovieToCategory> findAll(SysMovieToCategory sysMovieToCategory);

    int add(SysMovieToCategory sysMovieToCategory);

    int delete(SysMovieToCategory sysMovieToCategory);

}
