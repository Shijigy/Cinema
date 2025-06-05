package com.cinema.system.service;

import com.cinema.system.domin.Ticket;
import com.cinema.system.domin.vo.TicketVo;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll(Ticket ticket);

    Ticket findById(Long id);

    Object add(Ticket ticket);

    int update(Ticket ticket);

    int delete(Long[] ids);

    /**
     * 根据订单ID查询电影票列表
     */
    List<Ticket> findByBillId(Long billId);

    /**
     * 根据用户ID查询电影票列表
     */
    List<Ticket> findByUserId(Long userId);

    /**
     * 根据条件查询电影票视图列表
     */
    List<TicketVo> findTicketVos(Ticket ticket);

    /**
     * 根据ID获取电影票视图信息
     */
    TicketVo getTicketVoById(Long id);

    /**
     * 更新电影票状态
     */
    int updateTicketState(Long ticketId, Integer newState);

    /**
     * 根据订单ID生成电影票
     */
    List<TicketVo> generateTicketsByBillId(Long billId);

    /**
     * 根据用户手机号查询电影票列表
     */
    List<TicketVo> findByPhoneNumber(String phoneNumber);
}