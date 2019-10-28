package com.stylefeng.guns.modular.PushManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbPush;
import com.stylefeng.guns.modular.PushManager.service.ITbPushService;

/**
 * 关注管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:49:10
 */
@Controller
@RequestMapping("/tbPush")
public class TbPushController extends BaseController {

    private String PREFIX = "/PushManager/tbPush/";

    @Autowired
    private ITbPushService tbPushService;

    /**
     * 跳转到关注管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbPush.html";
    }

    /**
     * 跳转到添加关注管理
     */
    @RequestMapping("/tbPush_add")
    public String tbPushAdd() {
        return PREFIX + "tbPush_add.html";
    }

    /**
     * 跳转到修改关注管理
     */
    @RequestMapping("/tbPush_update/{tbPushId}")
    public String tbPushUpdate(@PathVariable Integer tbPushId, Model model) {
        TbPush tbPush = tbPushService.selectById(tbPushId);
        model.addAttribute("item",tbPush);
        LogObjectHolder.me().set(tbPush);
        return PREFIX + "tbPush_edit.html";
    }

    /**
     * 获取关注管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbPushService.selectList(null);
    }

    /**
     * 新增关注管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbPush tbPush) {
        tbPushService.insert(tbPush);
        return SUCCESS_TIP;
    }

    /**
     * 删除关注管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbPushId) {
        tbPushService.deleteById(tbPushId);
        return SUCCESS_TIP;
    }

    /**
     * 修改关注管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbPush tbPush) {
        tbPushService.updateById(tbPush);
        return SUCCESS_TIP;
    }

    /**
     * 关注管理详情
     */
    @RequestMapping(value = "/detail/{tbPushId}")
    @ResponseBody
    public Object detail(@PathVariable("tbPushId") Integer tbPushId) {
        return tbPushService.selectById(tbPushId);
    }
}
