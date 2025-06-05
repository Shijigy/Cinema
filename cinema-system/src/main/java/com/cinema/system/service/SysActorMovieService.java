package com.cinema.system.service;

import com.cinema.system.domin.SysActor;
import com.cinema.system.domin.SysActorMovie;

import java.util.List;


public interface SysActorMovieService {
    List<SysActorMovie> findAll(SysActorMovie sysActorMovie);

    int add(SysActorMovie sysActorMovie);

    int delete(SysActorMovie sysActorMovie);
}
