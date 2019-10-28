package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TbRank;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 排名表,MID是确保评分是同一个电影的评分且评分不是同一个用户反复多次打分 Mapper 接口
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
public interface TbRankMapper extends BaseMapper<TbRank> {

}
