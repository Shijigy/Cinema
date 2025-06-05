package com.cinema.system.mapper;

import com.cinema.system.domin.SysHall;

import java.util.List;


public interface SysHallMapper {
    List<SysHall> findAll(SysHall sysHall);

    SysHall findByCinemaIdAndHallId(SysHall sysHall);

    int add(SysHall sysHall);

    int update(SysHall sysHall);

    int delete(SysHall sysHall);
}
