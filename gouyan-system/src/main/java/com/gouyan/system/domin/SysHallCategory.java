package com.gouyan.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author lxd
 * @create 2020-11-19 21:05
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysHallCategory {
    //序列号
    private static final long serialVersionUID = 1L;

    //影厅分类id
    private long hallCategoryId;

    //影厅分类名称
    @NotBlank(message = "影厅分类名称不能为空")
    private String hallCategoryName;
}
