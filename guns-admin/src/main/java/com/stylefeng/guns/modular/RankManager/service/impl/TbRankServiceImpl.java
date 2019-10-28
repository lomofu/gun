package com.stylefeng.guns.modular.RankManager.service.impl;

import com.stylefeng.guns.modular.system.model.TbRank;
import com.stylefeng.guns.modular.system.dao.TbRankMapper;
import com.stylefeng.guns.modular.RankManager.service.ITbRankService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 排名表,MID是确保评分是同一个电影的评分且评分不是同一个用户反复多次打分 服务实现类
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@Service
public class TbRankServiceImpl extends ServiceImpl<TbRankMapper, TbRank> implements ITbRankService {

}
