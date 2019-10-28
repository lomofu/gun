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
 * 影评回复表
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_comment_reply")
public class TbCommentReply extends Model<TbCommentReply> {

    private static final long serialVersionUID = 1L;

    /**
     * 影评回复id
     */
    @TableId(value = "reply_id", type = IdType.AUTO)
    private Integer replyId;
    /**
     * 评论ID
     */
    @TableField("comment_id")
    private Integer commentId;
    /**
     * 内容
     */
    private String rcontent;
    /**
     * 时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 删除与否(0-没删除,1-删除)
     */
    private Integer state;
    @TableField("parent_id")
    private Integer parentId;
    /**
     * 回复用户id
     */
    @TableField("user_id")
    private Integer userId;


    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.replyId;
    }

    @Override
    public String toString() {
        return "TbCommentReply{" +
        "replyId=" + replyId +
        ", commentId=" + commentId +
        ", rcontent=" + rcontent +
        ", createTime=" + createTime +
        ", state=" + state +
        ", parentId=" + parentId +
        ", userId=" + userId +
        "}";
    }
}
