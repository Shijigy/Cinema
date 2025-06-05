package com.cinema.system.mapper;

import com.cinema.system.domin.SysSession;
import com.cinema.system.domin.vo.SysSessionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysSessionMapper {

    /**
     * 根据条件查询
     * @param sysSessionVo
     * @return
     */
    List<SysSession> findByVo(SysSessionVo sysSessionVo);

    /**
     * 查询一个
     * @param id
     * @return
     */
    SysSession findById(Long id);

    /**
     * 查询一个，不查询相关的信息
     * @param id
     * @return
     */
    SysSession findOne(Long id);

    /**
     * 添加
     * @param sysSession
     * @return
     */
    int add(SysSession sysSession);

    /**
     * 修改
     * @param sysSession
     * @return
     */
    int update(SysSession sysSession);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据影院id和电影id查询近5天上映的场次信息
     * @param cinemaId
     * @param movieId
     * @return
     */
    // List<SysSession> findByCinemaAndMovie(Long cinemaId, Long movieId);
    List<SysSession> findByCinemaAndMovie(
            @Param("cinemaId") Long cinemaId,
            @Param("movieId") Long movieId
    );

    //场次冲突2
    /**
     * 检查是否存在时间冲突的场次
     * @param sysSession 场次信息
     * @return 冲突的场次数量
     */
    int countSameSession(SysSession sysSession);

    /**
     * 校验场次时间是否重叠
     * @param sysSession 包含 hallId、sessionDate、beginTime、endTime
     * @return 重叠场次数量
     */
    int countOverlapSessions(SysSession sysSession);


}
