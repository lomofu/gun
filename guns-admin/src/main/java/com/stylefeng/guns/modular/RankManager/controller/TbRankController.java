package com.stylefeng.guns.modular.RankManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbRank;
import com.stylefeng.guns.modular.RankManager.service.ITbRankService;

/**
 * 排行管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:40:34
 */
@Controller
@RequestMapping("/tbRank")
public class TbRankController extends BaseController {

    private String PREFIX = "/RankManager/tbRank/";

    @Autowired
    private ITbRankService tbRankService;

    /**
     * 跳转到排行管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbRank.html";
    }

    /**
     * 跳转到添加排行管理
     */
    @RequestMapping("/tbRank_add")
    public String tbRankAdd() {
        return PREFIX + "tbRank_add.html";
    }

    /**
     * 跳转到修改排行管理
     */
    @RequestMapping("/tbRank_update/{tbRankId}")
    public String tbRankUpdate(@PathVariable Integer tbRankId, Model model) {
        TbRank tbRank = tbRankService.selectById(tbRankId);
        model.addAttribute("item",tbRank);
        LogObjectHolder.me().set(tbRank);
        return PREFIX + "tbRank_edit.html";
    }

    /**
     * 获取排行管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbRankService.selectList(null);
    }

    /**
     * 新增排行管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbRank tbRank) {
        tbRankService.insert(tbRank);
        return SUCCESS_TIP;
    }

    /**
     * 删除排行管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbRankId) {
        tbRankService.deleteById(tbRankId);
        return SUCCESS_TIP;
    }

    /**
     * 修改排行管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbRank tbRank) {
        tbRankService.updateById(tbRank);
        return SUCCESS_TIP;
    }

    /**
     * 排行管理详情
     */
    @RequestMapping(value = "/detail/{tbRankId}")
    @ResponseBody
    public Object detail(@PathVariable("tbRankId") Integer tbRankId) {
        return tbRankService.selectById(tbRankId);
    }
}
