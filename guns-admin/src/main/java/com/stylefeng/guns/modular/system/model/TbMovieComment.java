package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_movie_comment")
public class TbMovieComment extends Model<TbMovieComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;
    /**
     * 电影ID参看Movie表
     */
    @TableField("movie_id")
    private Integer movieId;
    /**
     * 用户ID参考User表
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 评分(从低到高 1-5)
     */
    private Float start;
    /**
     * 删除与否(0-没删除,1-删除)
     */
    private Integer state;
    private Integer flag;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getStart() {
        return start;
    }

    public void setStart(Float start) {
        this.start = start;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

    @Override
    public String toString() {
        return "TbMovieComment{" +
        "commentId=" + commentId +
        ", movieId=" + movieId +
        ", userId=" + userId +
        ", content=" + content +
        ", createTime=" + createTime +
        ", start=" + start +
        ", state=" + state +
        ", flag=" + flag +
        "}";
    }
}
