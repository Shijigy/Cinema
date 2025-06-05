package com.cinema.system.service.impl;

import com.cinema.common.response.ResponseResult;
import com.cinema.system.domin.SysMovieRuntime;
import com.cinema.system.domin.SysSession;
import com.cinema.system.domin.vo.SysSessionVo;
import com.cinema.system.mapper.SysMovieRuntimeMapper;
import com.cinema.system.mapper.SysSessionMapper;
import com.cinema.system.service.SysSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-24 23:24
 */
@Service
public class SysSessionServiceImpl implements SysSessionService {

    @Autowired
    private SysSessionMapper sysSessionMapper;

    @Override
    public List<SysSession> findByVo(SysSessionVo sysSessionVo) {
        return sysSessionMapper.findByVo(sysSessionVo);
    }

    @Override
    public SysSession findById(Long id) {
        return sysSessionMapper.findById(id);
    }

    @Override
    public SysSession findOne(Long id){
        return sysSessionMapper.findOne(id);
    }

    @Override
    public int add(SysSession sysSession) {
        return sysSessionMapper.add(sysSession);
    }

    @Override
    public int update(SysSession sysSession) {
        return sysSessionMapper.update(sysSession);
    }

    @Override
    public int delete(Long[] ids) {
        int rows = 0;
        for(Long id : ids){
            rows += sysSessionMapper.delete(id);
        }
        return rows;
    }

    @Override
    public List<SysSession> findByCinemaAndMovie(Long cinemaId, Long movieId) {
        return sysSessionMapper.findByCinemaAndMovie(cinemaId, movieId);
    }

    @Autowired
    private SysMovieRuntimeMapper sysMovieRuntimeMapper;
    //场次冲突4
    @Override
    public ResponseResult addWithCheck(SysSession sysSession) {
        // 1. 查询播放时段详情，获取开始和结束时间
        SysMovieRuntime runtime = sysMovieRuntimeMapper.findById(sysSession.getMovieRuntimeId());
        if (runtime == null) {
            return ResponseResult.error("无效的播放时段");
        }

        // 2. 设置开始和结束时间到场次对象
        sysSession.setBeginTime(runtime.getBeginTime());
        sysSession.setEndTime(runtime.getEndTime());

        // 3. 校验时间冲突
        int count = sysSessionMapper.countOverlapSessions(sysSession);
        if (count > 0) {
            return ResponseResult.error("该影厅该时段已有安排，无法添加新场次");
        }


        // 4. 执行添加操作
//        int rows = sysSessionMapper.add(sysSession);
//        return rows > 0
//                ? ResponseResult.success("场次添加成功")
//                : ResponseResult.error("场次添加失败");

//        try {
//            int rows = sysSessionMapper.add(sysSession);
//            return rows > 0
//                    ? ResponseResult.success("场次添加成功")
//                    : ResponseResult.error("添加失败：数据库未插入记录");
//        } catch (Exception e) {
//            return ResponseResult.error("添加失败：" + e.getMessage());
//        }


        try {
            int rows = sysSessionMapper.add(sysSession);
            return rows > 0
                    ? ResponseResult.success("场次添加成功")
                    : ResponseResult.error("添加失败：数据库未插入记录");
        } catch (org.mybatis.spring.MyBatisSystemException e) {
            // MyBatis 执行 SQL 时的系统异常，比如连接问题等
            System.out.println("MyBatis 执行插入异常：" + e.getMessage());
            return ResponseResult.error("添加失败：数据库操作异常，请检查配置");
        } catch (Exception e) {
            System.out.println("其他异常：" + e.getMessage());
            return ResponseResult.error("添加失败：" + e.getMessage());
        }
    }
}
