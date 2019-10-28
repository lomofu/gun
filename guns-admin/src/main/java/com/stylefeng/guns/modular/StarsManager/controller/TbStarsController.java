package com.stylefeng.guns.modular.StarsManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbStars;
import com.stylefeng.guns.modular.StarsManager.service.ITbStarsService;

/**
 * 收藏管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:45:24
 */
@Controller
@RequestMapping("/tbStars")
public class TbStarsController extends BaseController {

    private String PREFIX = "/StarsManager/tbStars/";

    @Autowired
    private ITbStarsService tbStarsService;

    /**
     * 跳转到收藏管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbStars.html";
    }

    /**
     * 跳转到添加收藏管理
     */
    @RequestMapping("/tbStars_add")
    public String tbStarsAdd() {
        return PREFIX + "tbStars_add.html";
    }

    /**
     * 跳转到修改收藏管理
     */
    @RequestMapping("/tbStars_update/{tbStarsId}")
    public String tbStarsUpdate(@PathVariable Integer tbStarsId, Model model) {
        TbStars tbStars = tbStarsService.selectById(tbStarsId);
        model.addAttribute("item",tbStars);
        LogObjectHolder.me().set(tbStars);
        return PREFIX + "tbStars_edit.html";
    }

    /**
     * 获取收藏管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbStarsService.selectList(null);
    }

    /**
     * 新增收藏管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbStars tbStars) {
        tbStarsService.insert(tbStars);
        return SUCCESS_TIP;
    }

    /**
     * 删除收藏管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbStarsId) {
        tbStarsService.deleteById(tbStarsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改收藏管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbStars tbStars) {
        tbStarsService.updateById(tbStars);
        return SUCCESS_TIP;
    }

    /**
     * 收藏管理详情
     */
    @RequestMapping(value = "/detail/{tbStarsId}")
    @ResponseBody
    public Object detail(@PathVariable("tbStarsId") Integer tbStarsId) {
        return tbStarsService.selectById(tbStarsId);
    }
}
