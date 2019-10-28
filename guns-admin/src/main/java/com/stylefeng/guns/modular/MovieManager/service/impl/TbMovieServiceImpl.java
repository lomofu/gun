package com.stylefeng.guns.modular.MovieManager.service.impl;

import com.stylefeng.guns.modular.system.model.TbMovie;
import com.stylefeng.guns.modular.system.dao.TbMovieMapper;
import com.stylefeng.guns.modular.MovieManager.service.ITbMovieService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电影表 服务实现类
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@Service
public class TbMovieServiceImpl extends ServiceImpl<TbMovieMapper, TbMovie> implements ITbMovieService {

}
