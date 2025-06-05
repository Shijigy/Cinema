package com.cinema.system.service;

import com.cinema.common.response.ResponseResult;
import com.cinema.system.domin.SysSession;
import com.cinema.system.domin.vo.SysSessionVo;

import java.util.List;


public interface SysSessionService {

    List<SysSession> findByVo(SysSessionVo sysSessionVo);

    SysSession findById(Long id);

    SysSession findOne(Long id);

    int add(SysSession sysSession);

    int update(SysSession sysSession);

    int delete(Long[] id);

    List<SysSession> findByCinemaAndMovie(Long cinemaId, Long movieId);

    /**
     * 添加场次（含冲突校验）
     * @param sysSession 场次信息
     * @return ResponseResult 成功/失败提示
     */
    ResponseResult addWithCheck(SysSession sysSession);

}
