package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户电影收藏表
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_stars")
public class TbStars extends Model<TbStars> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 电影Id
     */
    @TableField("movie_id")
    private Integer movieId;
    /**
     * 收藏状态 0为收藏 1为取消收藏
     */
    private Integer state;
    /**
     * 收藏时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TbStars{" +
        "userId=" + userId +
        ", movieId=" + movieId +
        ", state=" + state +
        ", createTime=" + createTime +
        "}";
    }
}
