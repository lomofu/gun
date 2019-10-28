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
 * 电影表
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_movie")
public class TbMovie extends Model<TbMovie> {

    private static final long serialVersionUID = 1L;

    /**
     * 电影ID
     */
    @TableId(value = "movie_id", type = IdType.AUTO)
    private Integer movieId;
    /**
     * 电影名
     */
    @TableField("movie_name")
    private String movieName;
    /**
     * 类型id
     */
    @TableField("type_id")
    private Integer typeId;
    /**
     * 上映时间
     */
    @TableField("on_time")
    private Date onTime;
    /**
     * 语言类型
     */
    private String language;
    /**
     * 国家/地区
     */
    private String country;
    /**
     * 电影时长
     */
    @TableField("movie_time")
    private String movieTime;
    /**
     * 导演名
     */
    private String director;
    /**
     * 演员
     */
    private String actor;
    /**
     * 图片路径
     */
    @TableField("movie_img")
    private String movieImg;
    /**
     * 视频路径
     */
    @TableField("movie_video")
    private String movieVideo;
    /**
     * 简介
     */
    private String profile;


    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getMovieVideo() {
        return movieVideo;
    }

    public void setMovieVideo(String movieVideo) {
        this.movieVideo = movieVideo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    protected Serializable pkVal() {
        return this.movieId;
    }

    @Override
    public String toString() {
        return "TbMovie{" +
        "movieId=" + movieId +
        ", movieName=" + movieName +
        ", typeId=" + typeId +
        ", onTime=" + onTime +
        ", language=" + language +
        ", country=" + country +
        ", movieTime=" + movieTime +
        ", director=" + director +
        ", actor=" + actor +
        ", movieImg=" + movieImg +
        ", movieVideo=" + movieVideo +
        ", profile=" + profile +
        "}";
    }
}
