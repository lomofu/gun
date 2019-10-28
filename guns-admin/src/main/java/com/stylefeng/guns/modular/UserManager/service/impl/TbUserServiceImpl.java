package com.stylefeng.guns.modular.UserManager.service.impl;

import com.stylefeng.guns.modular.system.model.TbUser;
import com.stylefeng.guns.modular.system.dao.TbUserMapper;
import com.stylefeng.guns.modular.UserManager.service.ITbUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lomofu
 * @since 2019-06-16
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
