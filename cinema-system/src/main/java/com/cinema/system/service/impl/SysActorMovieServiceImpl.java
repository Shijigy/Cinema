package com.cinema.system.service.impl;

import com.cinema.system.domin.SysActorMovie;
import com.cinema.system.mapper.SysActorMovieMapper;
import com.cinema.system.service.SysActorMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysActorMovieServiceImpl implements SysActorMovieService {

    @Autowired
    private SysActorMovieMapper sysActorMovieMapper;

    @Override
    public List<SysActorMovie> findAll(SysActorMovie sysActorMovie) {
        return sysActorMovieMapper.findAll(sysActorMovie);
    }

    @Override
    public int add(SysActorMovie sysActorMovie) {
        return sysActorMovieMapper.add(sysActorMovie);
    }

    @Override
    public int delete(SysActorMovie sysActorMovie) {
        return sysActorMovieMapper.delete(sysActorMovie);
    }
}
