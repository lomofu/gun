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
@TableName("tb_info")
public class TbInfo extends Model<TbInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;
    @TableField("create_time")
    private Date createTime;
    private String title;
    @TableField("info_content")
    private String infoContent;
    @TableField("admin_id")
    private Integer adminId;
    @TableField("info_img")
    private String infoImg;
    @TableField("info_from")
    private String infoFrom;


    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }

    public String getInfoFrom() {
        return infoFrom;
    }

    public void setInfoFrom(String infoFrom) {
        this.infoFrom = infoFrom;
    }

    @Override
    protected Serializable pkVal() {
        return this.infoId;
    }

    @Override
    public String toString() {
        return "TbInfo{" +
        "infoId=" + infoId +
        ", createTime=" + createTime +
        ", title=" + title +
        ", infoContent=" + infoContent +
        ", adminId=" + adminId +
        ", infoImg=" + infoImg +
        ", infoFrom=" + infoFrom +
        "}";
    }
}
