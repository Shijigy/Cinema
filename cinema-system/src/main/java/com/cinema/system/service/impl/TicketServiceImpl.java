package com.cinema.system.service.impl;

import com.cinema.common.exception.DataNotFoundException;
import com.cinema.system.domin.*;
import com.cinema.system.domin.vo.TicketVo;
import com.cinema.system.mapper.TicketMapper;
import com.cinema.system.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private SysBillService sysBillService;

    @Autowired
    private SysMovieService sysMovieService;

    @Autowired
    private SysSessionService sysSessionService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysHallCategoryService sysHallCategoryService;

    @Override
    public List<Ticket> findAll(Ticket ticket) {
        return ticketMapper.findAll(ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketMapper.findById(id);
    }

    @Override
    @Transactional
    public Object add(Ticket ticket) {
        // 插入票记录
        int rows = ticketMapper.add(ticket);
        if (rows > 0) {
            // 返回新生成的票视图信息
            return getTicketVoById(ticket.getTicketId());
        }
        return rows;
    }

    @Override
    public int update(Ticket ticket) {
        return ticketMapper.update(ticket);
    }

    @Override
    public int delete(Long[] ids) {
        int count = 0;
        for (Long id : ids) {
            count += ticketMapper.delete(id);
        }
        return count;
    }

    @Override
    public List<Ticket> findByBillId(Long billId) {
        return ticketMapper.findByBillId(billId);
    }

    @Override
    public List<Ticket> findByUserId(Long userId) {
        return ticketMapper.findByUserId(userId);
    }

    @Override
    public List<TicketVo> findTicketVos(Ticket ticket) {
        List<Ticket> tickets = ticketMapper.findAll(ticket);
        return convertToTicketVos(tickets);
    }

    @Override
    public TicketVo getTicketVoById(Long id) {
        Ticket ticket = ticketMapper.findById(id);
        if (ticket == null) {
            throw new DataNotFoundException("电影票不存在");
        }
        List<TicketVo> ticketVos = convertToTicketVos(Collections.singletonList(ticket));
        return ticketVos.isEmpty() ? null : ticketVos.get(0);
    }

    @Override
    public int updateTicketState(Long ticketId, Integer newState) {
        Ticket ticket = ticketMapper.findById(ticketId);
        if (ticket == null) {
            throw new DataNotFoundException("电影票不存在");
        }
        ticket.setTicketState(newState);
        if (newState == 1) { // 已使用
            ticket.setUseTime(new Date());
        }
        return ticketMapper.update(ticket);
    }

    @Override
    @Transactional
    public List<TicketVo> generateTicketsByBillId(Long billId) {
        // 查询订单信息
        SysBill bill = sysBillService.findById(billId);
        if (bill == null) {
            throw new DataNotFoundException("订单不存在");
        }

        // 查询场次信息
        SysSession session = sysSessionService.findOne(bill.getSessionId());
        if (session == null) {
            throw new DataNotFoundException("订单对应的场次不存在");
        }

        // 查询影厅类别信息
        SysHallCategory hallCategory = sysHallCategoryService.findById(session.getHallId());
        if (hallCategory == null) {
            throw new DataNotFoundException("影厅类别不存在");
        }

        // 生成电影票
        List<TicketVo> tickets = new ArrayList<>();
        String[] seats = bill.getSeats().split(",");
        for (String seat : seats) {
            Ticket ticket = new Ticket();
            ticket.setBillId(billId);
            ticket.setUser_id(bill.getUserId());
            ticket.setMovieId(session.getMovieId());
            ticket.setSessionId(session.getSessionId());
            ticket.setHall_category_id(hallCategory.getHallCategoryId());
            ticket.setSeatInfo(seat);
            ticket.setTicketPrice(session.getSessionPrice());
            ticket.setOrder_time(bill.getBillDate());
            ticket.setTicketState(0);
            ticket.setCreateTime(new Date());

            ticketMapper.add(ticket);
            // 获取新生成的票视图信息
            tickets.add(getTicketVoById(ticket.getTicketId()));
        }

        return tickets;
    }



    /**
     * 将Ticket列表转换为TicketVo列表
     */
    private List<TicketVo> convertToTicketVos(List<Ticket> tickets) {
        List<TicketVo> ticketVos = new ArrayList<>();
        Map<Long, SysMovie> movieMap = new HashMap<>();
        Map<Long, SysSession> sessionMap = new HashMap<>();
        Map<Long, SysUser> userMap = new HashMap<>();
        Map<Long, SysHallCategory> hallCategoryMap = new HashMap<>();

        for (Ticket ticket : tickets) {
            // 获取电影信息
            SysMovie movie = movieMap.computeIfAbsent(ticket.getMovieId(),
                    k -> sysMovieService.findOne(k));

            // 获取场次信息
            SysSession session = sessionMap.computeIfAbsent(ticket.getSessionId(),
                    k -> sysSessionService.findOne(k));

            // 获取用户信息
            SysUser user = userMap.computeIfAbsent(ticket.getUser_id(),
                    k -> sysUserService.findById(k));

            // 获取影厅类别信息
            SysHallCategory hallCategory = hallCategoryMap.computeIfAbsent(ticket.getHall_category_id(),
                    k -> sysHallCategoryService.findById(k));

            // 转换为TicketVo
            TicketVo ticketVo = new TicketVo();
            BeanUtils.copyProperties(ticket, ticketVo);

            // 填充电影信息
            ticketVo.setMovieNameCn(movie != null ? movie.getMovieNameCn() : "未知电影");
            ticketVo.setMovieNameEn(movie != null ? movie.getMovieNameEn() : "");

            // 填充场次信息（确保非空）
            if (session != null) {
                ticketVo.setLanguageVersion(session.getLanguageVersion() != null ?
                        session.getLanguageVersion() : "未知语言");
                ticketVo.setSessionDate(session.getSessionDate());
                ticketVo.setHallTips(session.getSessionTips() != null ?
                        session.getSessionTips() : "无特殊提示");
                ticketVo.setTicketPrice(session.getSessionPrice() != null ?
                        new BigDecimal(session.getSessionPrice().toString()) : BigDecimal.ZERO);
            } else {
                ticketVo.setTicketPrice(BigDecimal.ZERO);
            }

            // 填充用户信息
            ticketVo.setUsername(user != null ? user.getUserName() : "未知用户");

            // 填充影厅类别信息
            ticketVo.setHallCategoryName(hallCategory != null ?
                    hallCategory.getHallCategoryName() : "普通影厅");

            // 填充时间信息（确保非空）
            ticketVo.setOrder_time(ticket.getOrder_time() != null ?
                    ticket.getOrder_time() : new Date(0));
            ticketVo.setUseTime(ticket.getUseTime());

            // 设置状态描述
            ticketVo.setStateDesc(getStateDescription(ticket.getTicketState()));

            ticketVos.add(ticketVo);
        }

        return ticketVos;
    }

    /**
     * 获取票状态描述
     */
    private String getStateDescription(Integer state) {
        Map<Integer, String> stateMap = new HashMap<>();
        stateMap.put(0, "有效");
        stateMap.put(1, "已使用");
        stateMap.put(2, "已退票");
        stateMap.put(3, "已作废");
        return stateMap.getOrDefault(state, "未知状态");
    }
}