package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 排名表,MID是确保评分是同一个电影的评分且评分不是同一个用户反复多次打分
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@TableName("tb_rank")
public class TbRank extends Model<TbRank> {

    private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private Integer count;
    /**
     * 排名标识符
     */
    @TableId(value = "rank_id", type = IdType.AUTO)
    private Integer rankId;
    /**
     * 电影ID参考Comment表
     */
    @TableField("movie_id")
    private Integer movieId;
    /**
     * 平均分
     */
    @TableField("avg_star")
    private Integer avgStar;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getAvgStar() {
        return avgStar;
    }

    public void setAvgStar(Integer avgStar) {
        this.avgStar = avgStar;
    }

    @Override
    protected Serializable pkVal() {
        return this.rankId;
    }

    @Override
    public String toString() {
        return "TbRank{" +
        "count=" + count +
        ", rankId=" + rankId +
        ", movieId=" + movieId +
        ", avgStar=" + avgStar +
        "}";
    }
}
