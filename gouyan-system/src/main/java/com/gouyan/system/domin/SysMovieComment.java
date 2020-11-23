package com.gouyan.system.domin;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 演员角色实体类
 * @Author: 华雨欣
 * @Create: 2020-11-19 22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieComment implements Serializable {

    private static final long serialVersionUID = 1L;

    //电影id
    private Long movieId;

    //用户id
    private Long userId;

    //评论时间
    private Date commentTime;

    //评论内容
    private String content;

    //评分
    private Double score;


    //评论用户
    SysUser sysUser;

}
