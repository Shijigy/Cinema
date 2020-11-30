package com.gouyan.system.mapper;

import com.gouyan.system.domin.SysMovie;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 10:00
 */
public interface SysMovieMapper {

    /**
     * 按照传入对象的参数进行条件分页查询
     * @param sysMovie
     * @return
     */
    List<SysMovie> findAll(SysMovie sysMovie);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysMovie findById(Long id);

    /**
     * 查询一个电影的信息，不查询相关的演员等信息
     * @param id
     * @return
     */
    SysMovie findOne(Long id);

    /**
     * 添加
     * @param sysMovie
     * @return 影响行数
     */
    int add(SysMovie sysMovie);

    /**
     * 修改
     * @param sysMovie
     */
    int update(SysMovie sysMovie);

    /**
     * 删除
     * @param id
     */
    int delete(Long id);


    /**
     * 前台根据movie_id查询电影信息，含电影演员与演员对应角色
     * @param id
     * @return
     */
    List<SysMovie> findMovieById(Long id);

}
