package com.cinema.system.mapper;

import com.cinema.system.domin.SysActorMovie;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-27 10:13
 */
public interface SysActorMovieMapper {
    List<SysActorMovie> findAll(SysActorMovie sysActorMovie);

    int add(SysActorMovie sysActorMovie);

    int delete(SysActorMovie sysActorMovie);
}
