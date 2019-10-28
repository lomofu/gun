package com.stylefeng.guns.modular.InfoManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbInfo;
import com.stylefeng.guns.modular.InfoManager.service.ITbInfoService;

/**
 * 电影资讯管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:31:24
 */
@Controller
@RequestMapping("/tbInfo")
public class TbInfoController extends BaseController {

    private String PREFIX = "/InfoManager/tbInfo/";

    @Autowired
    private ITbInfoService tbInfoService;

    /**
     * 跳转到电影资讯管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbInfo.html";
    }

    /**
     * 跳转到添加电影资讯管理
     */
    @RequestMapping("/tbInfo_add")
    public String tbInfoAdd() {
        return PREFIX + "tbInfo_add.html";
    }

    /**
     * 跳转到修改电影资讯管理
     */
    @RequestMapping("/tbInfo_update/{tbInfoId}")
    public String tbInfoUpdate(@PathVariable Integer tbInfoId, Model model) {
        TbInfo tbInfo = tbInfoService.selectById(tbInfoId);
        model.addAttribute("item",tbInfo);
        LogObjectHolder.me().set(tbInfo);
        return PREFIX + "tbInfo_edit.html";
    }

    /**
     * 获取电影资讯管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbInfoService.selectList(null);
    }

    /**
     * 新增电影资讯管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbInfo tbInfo) {
        tbInfoService.insert(tbInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除电影资讯管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbInfoId) {
        tbInfoService.deleteById(tbInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改电影资讯管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbInfo tbInfo) {
        tbInfoService.updateById(tbInfo);
        return SUCCESS_TIP;
    }

    /**
     * 电影资讯管理详情
     */
    @RequestMapping(value = "/detail/{tbInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("tbInfoId") Integer tbInfoId) {
        return tbInfoService.selectById(tbInfoId);
    }
}
