package com.stylefeng.guns.modular.CommentManager.controller;

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
import com.stylefeng.guns.modular.system.model.TbMovieComment;
import com.stylefeng.guns.modular.CommentManager.service.ITbMovieCommentService;

/**
 * 电影评论管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:35:47
 */
@Controller
@RequestMapping("/tbMovieComment")
public class TbMovieCommentController extends BaseController {

    private String PREFIX = "/CommentManager/tbMovieComment/";

    @Autowired
    private ITbMovieCommentService tbMovieCommentService;

    /**
     * 跳转到电影评论管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbMovieComment.html";
    }

    /**
     * 跳转到添加电影评论管理
     */
    @RequestMapping("/tbMovieComment_add")
    public String tbMovieCommentAdd() {
        return PREFIX + "tbMovieComment_add.html";
    }

    /**
     * 跳转到修改电影评论管理
     */
    @RequestMapping("/tbMovieComment_update/{tbMovieCommentId}")
    public String tbMovieCommentUpdate(@PathVariable Integer tbMovieCommentId, Model model) {
        TbMovieComment tbMovieComment = tbMovieCommentService.selectById(tbMovieCommentId);
        model.addAttribute("item",tbMovieComment);
        LogObjectHolder.me().set(tbMovieComment);
        return PREFIX + "tbMovieComment_edit.html";
    }

    /**
     * 获取电影评论管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbMovieCommentService.selectList(null);
    }

    /**
     * 新增电影评论管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbMovieComment tbMovieComment, BindingResult bindingResult) {
        tbMovieCommentService.insert(tbMovieComment);
        return SUCCESS_TIP;
    }

    /**
     * 删除电影评论管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbMovieCommentId) {
        tbMovieCommentService.deleteById(tbMovieCommentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改电影评论管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbMovieComment tbMovieComment) {
        tbMovieCommentService.updateById(tbMovieComment);
        return SUCCESS_TIP;
    }

    /**
     * 电影评论管理详情
     */
    @RequestMapping(value = "/detail/{tbMovieCommentId}")
    @ResponseBody
    public Object detail(@PathVariable("tbMovieCommentId") Integer tbMovieCommentId) {
        return tbMovieCommentService.selectById(tbMovieCommentId);
    }
}
