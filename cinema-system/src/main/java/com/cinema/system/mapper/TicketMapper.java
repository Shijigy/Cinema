package com.cinema.system.mapper;

import com.cinema.system.domin.Ticket;

import java.util.List;

public interface TicketMapper {

    List<Ticket> findAll(Ticket ticket);

    Ticket findById(Long id);

    int add(Ticket ticket);

    int update(Ticket ticket);

    int delete(Long id);

    /**
     * 根据订单ID查询电影票列表
     */
    List<Ticket> findByBillId(Long billId);

    /**
     * 根据用户ID查询电影票列表
     */
    List<Ticket> findByUserId(Long userId);
}