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
import java.util.List;

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
    private String cinemaBrandId;

    private String cinemaPicture;

    private Boolean isTicketChanged;

    private Boolean isRefunded;

    @NotNull(message = "所属区域id不能为空")
    private Long cinemaAreaId;

    private String cinemaAddress;

    @NotNull(message = "负责人id不能为空")
    private Long userId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    private SysUser user;

    //影院存在的影厅类别
    private List<SysHallCategory> sysHallCategoryList;
}
