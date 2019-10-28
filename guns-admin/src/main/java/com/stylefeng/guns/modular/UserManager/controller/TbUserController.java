package com.stylefeng.guns.modular.UserManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbUser;
import com.stylefeng.guns.modular.UserManager.service.ITbUserService;

/**
 * 用户管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 19:41:21
 */
@Controller
@RequestMapping("/tbUser")
public class TbUserController extends BaseController {

    private String PREFIX = "/UserManager/tbUser/";

    @Autowired
    private ITbUserService tbUserService;

    /**
     * 跳转到用户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbUser.html";
    }

    /**
     * 跳转到添加用户管理
     */
    @RequestMapping("/tbUser_add")
    public String tbUserAdd() {
        return PREFIX + "tbUser_add.html";
    }

    /**
     * 跳转到修改用户管理
     */
    @RequestMapping("/tbUser_update/{tbUserId}")
    public String tbUserUpdate(@PathVariable Integer tbUserId, Model model) {
        TbUser tbUser = tbUserService.selectById(tbUserId);
        model.addAttribute("item",tbUser);
        LogObjectHolder.me().set(tbUser);
        return PREFIX + "tbUser_edit.html";
    }

    /**
     * 获取用户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbUserService.selectList(null);
    }

    /**
     * 新增用户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbUser tbUser, BindingResult bindingResult) {
        tbUserService.insert(tbUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbUserId) {
        tbUserService.deleteById(tbUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbUser tbUser) {
        tbUserService.updateById(tbUser);
        return SUCCESS_TIP;
    }

    /**
     * 用户管理详情
     */
    @RequestMapping(value = "/detail/{tbUserId}")
    @ResponseBody
    public Object detail(@PathVariable("tbUserId") Integer tbUserId) {
        return tbUserService.selectById(tbUserId);
    }
}
