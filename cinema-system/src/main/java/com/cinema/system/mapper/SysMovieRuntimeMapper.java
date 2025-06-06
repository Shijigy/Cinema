package com.cinema.system.mapper;

import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.domin.SysUserHobby;

import java.util.List;


public interface SysMovieRuntimeMapper {

    /**
     * 查询所有
     * @return
     */
    List<SysMovieRuntime> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysMovieRuntime findById(Long id);

    /**
     * 添加电影播放时段
     * @param sysMovieRuntime
     * @return 影响行数
     */
    int add(SysMovieRuntime sysMovieRuntime);

    /**
     * 修改电影播放时段
     * @param sysMovieRuntime
     */
    int update(SysMovieRuntime sysMovieRuntime);

    /**
     * 删除指定id的电影播放时段
     * @param id
     */
    int delete(Long id);


}
