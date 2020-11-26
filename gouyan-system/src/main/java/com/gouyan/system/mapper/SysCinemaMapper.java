package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysCinema;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-25 22:23
 */
public interface SysCinemaMapper {

    List<SysCinema> findAll(SysCinema sysCinema);

    SysCinema findById(Long id);

    int add(SysCinema sysCinema);

    int update(SysCinema sysCinema);

    int delete(Long id);

}
