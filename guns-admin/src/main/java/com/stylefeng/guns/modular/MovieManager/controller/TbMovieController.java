package com.stylefeng.guns.modular.MovieManager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.CommentManager.service.ITbMovieCommentService;
import com.stylefeng.guns.modular.system.model.TbMovieComment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TbMovie;
import com.stylefeng.guns.modular.MovieManager.service.ITbMovieService;

import java.util.Date;

/**
 * 电影管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:11:13
 */
@Controller
@RequestMapping("/tbMovie")
public class TbMovieController extends BaseController {

    private String PREFIX = "/MovieManager/tbMovie/";

    @Autowired
    private ITbMovieService tbMovieService;
    @Autowired
    private ITbMovieCommentService tbMovieCommentService;
    /**
     * 跳转到电影管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbMovie.html";
    }

    /**
     * 跳转到添加电影管理
     */
    @RequestMapping("/tbMovie_add")
    public String tbMovieAdd() {
        return PREFIX + "tbMovie_add.html";
    }

    /**
     * 跳转到修改电影管理
     */
    @RequestMapping("/tbMovie_update/{tbMovieId}")
    public String tbMovieUpdate(@PathVariable Integer tbMovieId, Model model) {
        TbMovie tbMovie = tbMovieService.selectById(tbMovieId);
        model.addAttribute("item",tbMovie);
        LogObjectHolder.me().set(tbMovie);
        return PREFIX + "tbMovie_edit.html";
    }

    /**
     * 获取电影管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbMovieService.selectList(null);
    }

    /**
     * 新增电影管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbMovie tbMovie, BindingResult bindingResult) {
        tbMovieService.insert(tbMovie);
        TbMovieComment tbMovieComment = new TbMovieComment();
        tbMovieComment.setFlag(1);
        tbMovieComment.setMovieId(tbMovie.getMovieId());
        tbMovieComment.setUserId(1001);
        tbMovieComment.setCreateTime(new Date());
        tbMovieComment.setState(0);
        tbMovieCommentService.insert(tbMovieComment);
        return SUCCESS_TIP;
    }

    /**
     * 删除电影管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbMovieId) {
        tbMovieService.deleteById(tbMovieId);
        return SUCCESS_TIP;
    }

    /**
     * 修改电影管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbMovie tbMovie) {
        tbMovieService.updateById(tbMovie);
        return SUCCESS_TIP;
    }

    /**
     * 电影管理详情
     */
    @RequestMapping(value = "/detail/{tbMovieId}")
    @ResponseBody
    public Object detail(@PathVariable("tbMovieId") Integer tbMovieId) {
        return tbMovieService.selectById(tbMovieId);
    }
}
