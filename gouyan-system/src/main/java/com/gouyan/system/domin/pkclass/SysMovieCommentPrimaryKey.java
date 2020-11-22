package com.gouyan.system.domin.pkclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 定义包含影评类的三个主键的类
 * @Author: 华雨欣
 * @Create: 2020-11-22 23:11
 */
public class SysMovieCommentPrimaryKey implements Serializable {

    private Long movieId;
    private Long userId;
    private Date commentTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public SysMovieCommentPrimaryKey() {
    }

    public SysMovieCommentPrimaryKey(Long movieId, Long userId, Date commentTime) {
        this.movieId = movieId;
        this.userId = userId;
        this.commentTime = commentTime;
    }
}
