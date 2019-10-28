package com.stylefeng.guns.modular.ReplyManager.controller;

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
import com.stylefeng.guns.modular.system.model.TbCommentReply;
import com.stylefeng.guns.modular.ReplyManager.service.ITbCommentReplyService;

/**
 * 影评回复管理控制器
 *
 * @author fengshuonan
 * @Date 2019-06-16 20:42:59
 */
@Controller
@RequestMapping("/tbCommentReply")
public class TbCommentReplyController extends BaseController {

    private String PREFIX = "/ReplyManager/tbCommentReply/";

    @Autowired
    private ITbCommentReplyService tbCommentReplyService;

    /**
     * 跳转到影评回复管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tbCommentReply.html";
    }

    /**
     * 跳转到添加影评回复管理
     */
    @RequestMapping("/tbCommentReply_add")
    public String tbCommentReplyAdd() {
        return PREFIX + "tbCommentReply_add.html";
    }

    /**
     * 跳转到修改影评回复管理
     */
    @RequestMapping("/tbCommentReply_update/{tbCommentReplyId}")
    public String tbCommentReplyUpdate(@PathVariable Integer tbCommentReplyId, Model model) {
        TbCommentReply tbCommentReply = tbCommentReplyService.selectById(tbCommentReplyId);
        model.addAttribute("item",tbCommentReply);
        LogObjectHolder.me().set(tbCommentReply);
        return PREFIX + "tbCommentReply_edit.html";
    }

    /**
     * 获取影评回复管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tbCommentReplyService.selectList(null);
    }

    /**
     * 新增影评回复管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TbCommentReply tbCommentReply, BindingResult bindingResult) {
        tbCommentReplyService.insert(tbCommentReply);
        return SUCCESS_TIP;
    }

    /**
     * 删除影评回复管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tbCommentReplyId) {
        tbCommentReplyService.deleteById(tbCommentReplyId);
        return SUCCESS_TIP;
    }

    /**
     * 修改影评回复管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TbCommentReply tbCommentReply) {
        tbCommentReplyService.updateById(tbCommentReply);
        return SUCCESS_TIP;
    }

    /**
     * 影评回复管理详情
     */
    @RequestMapping(value = "/detail/{tbCommentReplyId}")
    @ResponseBody
    public Object detail(@PathVariable("tbCommentReplyId") Integer tbCommentReplyId) {
        return tbCommentReplyService.selectById(tbCommentReplyId);
    }
}
