/**
 * 初始化影评回复管理详情对话框
 */
var TbCommentReplyInfoDlg = {
    tbCommentReplyInfoData : {}
};

/**
 * 清除数据
 */
TbCommentReplyInfoDlg.clearData = function() {
    this.tbCommentReplyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbCommentReplyInfoDlg.set = function(key, val) {
    this.tbCommentReplyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbCommentReplyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbCommentReplyInfoDlg.close = function() {
    parent.layer.close(window.parent.TbCommentReply.layerIndex);
}

/**
 * 收集数据
 */
TbCommentReplyInfoDlg.collectData = function() {
    this
    .set('replyId')
    .set('commentId')
    .set('rcontent')
    .set('createTime')
    .set('state')
    .set('parentId')
    .set('userId');
}

/**
 * 提交添加
 */
TbCommentReplyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbCommentReply/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbCommentReply.table.refresh();
        TbCommentReplyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbCommentReplyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbCommentReplyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbCommentReply/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbCommentReply.table.refresh();
        TbCommentReplyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbCommentReplyInfoData);
    ajax.start();
}

$(function() {

});
