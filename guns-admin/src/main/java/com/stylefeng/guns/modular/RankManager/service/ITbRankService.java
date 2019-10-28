package com.stylefeng.guns.modular.RankManager.service;

import com.stylefeng.guns.modular.system.model.TbRank;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 排名表,MID是确保评分是同一个电影的评分且评分不是同一个用户反复多次打分 服务类
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
public interface ITbRankService extends IService<TbRank> {

}
