package com.gouyan.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lxd
 * @create 2020-11-18 22:01
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysMovieArea {

    //序列号
    private static final long serialVersionUID = 1L;

    //电影区域id
    private Long movieAreaId;

    //电影区域名称
    private String movieAreaName;
}
