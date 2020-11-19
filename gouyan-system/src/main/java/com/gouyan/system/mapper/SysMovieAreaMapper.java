package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.domin.SysMovieArea;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-18 22:07
 */
public interface SysMovieAreaMapper {
    /**
     * 查询所有
     * @return
     */
    List<SysMovieArea> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysMovieArea findById(Long id);


    int add(SysMovieArea sysMovieArea);


    int update(SysMovieArea sysMovieArea);

    /**
     * 删除指定id的电影区域
     * @param id
     */
    int delete(Long id);
}
