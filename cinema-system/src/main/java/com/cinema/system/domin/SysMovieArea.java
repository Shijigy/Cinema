package com.cinema.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysMovieArea implements Serializable {

    //序列号
    private static final long serialVersionUID = 1L;

    //电影区域id
    private Long movieAreaId;

    //电影区域名称
    @NotBlank(message = "电影区域名称不能为空")
    private String movieAreaName;
}
