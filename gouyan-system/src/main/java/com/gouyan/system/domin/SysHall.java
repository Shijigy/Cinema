package com.gouyan.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lxd
 * @create 2020-11-25 9:59
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysHall implements Serializable {
    private final static Long serialVersionUID = 1L;

    private Long cinemaId;

    private Long hallId;

    @NotBlank(message = "影厅名称不能为空")
    private String hallName;

    @NotNull(message = "影厅分类id不能为空")
    private Long hallCategoryId;

    @Min(value = 3, message = "排数不能小于3")
    @Max(value = 50, message = "排数不能大于50")
    private Integer rowNums;

    @Min(value = 9, message = "座位数不能小于9")
    @Max(value = 1000, message = "座位数不能大于1000")
    private Integer seatNums;

    @NotNull(message = "影厅状态不能为空")
    private Boolean hallState;
}
