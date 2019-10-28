package com.stylefeng.guns.modular.MovieTypeManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbMovieType;
import com.stylefeng.guns.modular.MovieTypeManager.service.ITbMovieTypeService;

/**
 * 电影类型管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:18:00
 */
@Controller
@RequestMapping("/tbMovieType")
public class TbMovieTypeController extends BaseController {

    private String PREFIX = "/MovieTypeManager/tbMovieType/";

    @Autowired
    private ITbMovieTypeService tbMovieTypeService;

    /**
     * 跳转到电影类型管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbMovieType.html";
    }

    /**
     * 跳转到添加电影类型管理
     */
    @RequestMapping("/tbMovieType_add")
    public String tbMovieTypeAdd() {
        return PREFIX + "tbMovieType_add.html";
    }

    /**
     * 跳转到修改电影类型管理
     */
    @RequestMapping("/tbMovieType_update/{tbMovieTypeId}")
    public String tbMovieTypeUpdate(@PathVariable Integer tbMovieTypeId, Model model) {
        TbMovieType tbMovieType = tbMovieTypeService.selectById(tbMovieTypeId);
        model.addAttribute("item",tbMovieType);
        LogObjectHolder.me().set(tbMovieType);
        return PREFIX + "tbMovieType_edit.html";
    }

    /**
     * 获取电影类型管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbMovieTypeService.selectList(null);
    }

    /**
     * 新增电影类型管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbMovieType tbMovieType) {
        tbMovieTypeService.insert(tbMovieType);
        return SUCCESS_TIP;
    }

    /**
     * 删除电影类型管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbMovieTypeId) {
        tbMovieTypeService.deleteById(tbMovieTypeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改电影类型管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbMovieType tbMovieType) {
        tbMovieTypeService.updateById(tbMovieType);
        return SUCCESS_TIP;
    }

    /**
     * 电影类型管理详情
     */
    @RequestMapping(value = "/detail/{tbMovieTypeId}")
    @ResponseBody
    public Object detail(@PathVariable("tbMovieTypeId") Integer tbMovieTypeId) {
        return tbMovieTypeService.selectById(tbMovieTypeId);
    }
}
