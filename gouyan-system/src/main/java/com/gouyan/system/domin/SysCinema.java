package com.gouyan.system.domin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author lxd
 * @create 2020-11-25 16:03
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysCinema implements Serializable {
    private final static Long serialVersionUID = 1L;

    private Long cinemaId;

    @NotBlank(message = "影院名称不能为空")
    private String cinemaName;

    @NotBlank(message = "影院品牌不能为空")
    private String cinemaBrand;

    private String cinemaPicture;

    @NotNull(message = "能否改签不能为空")
    private Boolean isTicketChanged;

    @NotNull(message = "能否退款不能为空")
    private Boolean isRefunded;

    @NotNull(message = "所属区域id不能为空")
    private Long cinemaAreaId;

    @NotNull(message = "地址不能为空")
    private String cinemaAddress;

    @NotNull(message = "负责人id不能为空")
    private Long userId;

    @NotNull(message = "入驻日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    private SysUser user;
}
