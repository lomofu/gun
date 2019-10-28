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
 * 
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_log")
public class TbLog extends Model<TbLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 创建日期
     */
    private Date createdate;
    /**
     * 日志内容
     */
    private String content;
    /**
     * 用户所做的操作
     */
    private String operation;
    /**
     * 日志类型
     */
    private String type;


    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    @Override
    public String toString() {
        return "TbLog{" +
        "logId=" + logId +
        ", userName=" + userName +
        ", createdate=" + createdate +
        ", content=" + content +
        ", operation=" + operation +
        ", type=" + type +
        "}";
    }
}
