package com.cinema.system.mapper;

import com.cinema.system.domin.SysActorMovie;

import java.util.List;


public interface SysActorMovieMapper {
    List<SysActorMovie> findAll(SysActorMovie sysActorMovie);

    int add(SysActorMovie sysActorMovie);

    int delete(SysActorMovie sysActorMovie);
}
