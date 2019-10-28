package com.stylefeng.guns.modular.LogManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbLog;
import com.stylefeng.guns.modular.LogManager.service.ITbLogService;

/**
 * 日志管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:22:07
 */
@Controller
@RequestMapping("/tbLog")
public class TbLogController extends BaseController {

    private String PREFIX = "/LogManager/tbLog/";

    @Autowired
    private ITbLogService tbLogService;

    /**
     * 跳转到日志管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbLog.html";
    }

    /**
     * 跳转到添加日志管理
     */
    @RequestMapping("/tbLog_add")
    public String tbLogAdd() {
        return PREFIX + "tbLog_add.html";
    }

    /**
     * 跳转到修改日志管理
     */
    @RequestMapping("/tbLog_update/{tbLogId}")
    public String tbLogUpdate(@PathVariable Integer tbLogId, Model model) {
        TbLog tbLog = tbLogService.selectById(tbLogId);
        model.addAttribute("item",tbLog);
        LogObjectHolder.me().set(tbLog);
        return PREFIX + "tbLog_edit.html";
    }

    /**
     * 获取日志管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbLogService.selectList(null);
    }

    /**
     * 新增日志管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbLog tbLog) {
        tbLogService.insert(tbLog);
        return SUCCESS_TIP;
    }

    /**
     * 删除日志管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbLogId) {
        tbLogService.deleteById(tbLogId);
        return SUCCESS_TIP;
    }

    /**
     * 修改日志管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbLog tbLog) {
        tbLogService.updateById(tbLog);
        return SUCCESS_TIP;
    }

    /**
     * 日志管理详情
     */
    @RequestMapping(value = "/detail/{tbLogId}")
    @ResponseBody
    public Object detail(@PathVariable("tbLogId") Integer tbLogId) {
        return tbLogService.selectById(tbLogId);
    }
}
