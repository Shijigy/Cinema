package com.cinema.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 电影票实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long ticketId;      // 电影票ID
    private Long billId;        // 订单ID
    private Long user_id;       // 用户ID
    private Long movieId;       // 电影ID
    private Long sessionId;     // 场次ID
    private Long hall_category_id; // 影厅类别ID

    @NotNull(message = "座位信息不能为空")
    private String seatInfo;    // 座位信息

    @NotNull(message = "票价不能为空")
    private Double ticketPrice; // 票价

    @NotNull(message = "下单时间不能为空")
    private Date order_time;    // 下单时间

    private Integer ticketState;    // 票状态
    private Date createTime;        // 创建时间
    private Date useTime;           // 使用时间

    // 关联对象
    private SysBill bill;           // 订单信息
    private SysMovie movie;         // 电影信息
    private SysSession session;     // 场次信息
    private SysUser user;           // 用户信息
    private SysHallCategory hallCategory; // 影厅类别信息
}