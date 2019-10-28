/**
 * 初始化电影评论管理详情对话框
 */
var TbMovieCommentInfoDlg = {
    tbMovieCommentInfoData : {}
};

/**
 * 清除数据
 */
TbMovieCommentInfoDlg.clearData = function() {
    this.tbMovieCommentInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieCommentInfoDlg.set = function(key, val) {
    this.tbMovieCommentInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieCommentInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbMovieCommentInfoDlg.close = function() {
    parent.layer.close(window.parent.TbMovieComment.layerIndex);
}

/**
 * 收集数据
 */
TbMovieCommentInfoDlg.collectData = function() {
    this
    .set('commentId')
    .set('movieId')
    .set('userId')
    .set('content')
    .set('createTime')
    .set('start')
    .set('state')
    .set('flag');
}

/**
 * 提交添加
 */
TbMovieCommentInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovieComment/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbMovieComment.table.refresh();
        TbMovieCommentInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieCommentInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbMovieCommentInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovieComment/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbMovieComment.table.refresh();
        TbMovieCommentInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieCommentInfoData);
    ajax.start();
}

$(function() {

});
