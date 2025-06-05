package com.cinema.system.mapper;

import com.cinema.system.domin.SysCinema;
import com.cinema.system.domin.vo.SysCinemaVo;

import java.util.List;


public interface SysCinemaMapper {

    List<SysCinema> findAll(SysCinemaVo sysCinemaVo);

    SysCinema findById(Long id);

    int add(SysCinema sysCinema);

    int update(SysCinema sysCinema);

    int delete(Long id);

    //前台展示单个影院信息，返回包含影院、上映中的所有电影信息
    SysCinema findCinemaById(Long id);

}
