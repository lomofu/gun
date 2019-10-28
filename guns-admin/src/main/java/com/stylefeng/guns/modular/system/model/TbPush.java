package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 关注用户表
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_push")
public class TbPush extends Model<TbPush> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 关注的用户Id
     */
    @TableField("follow_id")
    private Integer followId;
    /**
     * 关注状态 0为关注 1为取消关注
     */
    private Integer state;
    /**
     * 关注时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
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
        return "TbPush{" +
        "userId=" + userId +
        ", followId=" + followId +
        ", state=" + state +
        ", createTime=" + createTime +
        "}";
    }
}
