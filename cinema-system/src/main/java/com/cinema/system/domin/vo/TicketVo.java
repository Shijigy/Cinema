package com.cinema.system.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 电影票视图对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long ticketId;      // 电影票ID
    private Long billId;        // 订单ID
    private Long user_id;       // 用户ID
    private String username;    // 用户名称
    private String movieNameCn; // 电影中文名
    private String movieNameEn; // 电影英文名
    private String languageVersion; // 语言版本
    private LocalDate sessionDate;   // 场次日期
    private String hallTips;    // 影厅提示
    private String hallCategoryName; // 影厅类别名称
    private String seatInfo;    // 座位信息
    private BigDecimal ticketPrice; // 票价
    private Date order_time;    // 下单时间
    private Integer ticketState;    // 票状态
    private String stateDesc;       // 状态描述
    private Date createTime;        // 创建时间
    private Date useTime;           // 使用时间

}
