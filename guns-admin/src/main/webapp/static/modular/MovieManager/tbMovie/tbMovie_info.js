/**
 * 初始化电影管理详情对话框
 */
var TbMovieInfoDlg = {
    tbMovieInfoData : {}
};

/**
 * 清除数据
 */
TbMovieInfoDlg.clearData = function() {
    this.tbMovieInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieInfoDlg.set = function(key, val) {
    this.tbMovieInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbMovieInfoDlg.close = function() {
    parent.layer.close(window.parent.TbMovie.layerIndex);
}

/**
 * 收集数据
 */
TbMovieInfoDlg.collectData = function() {
    this
    .set('movieId')
    .set('movieName')
    .set('typeId')
    .set('onTime')
    .set('language')
    .set('country')
    .set('movieTime')
    .set('director')
    .set('actor')
    .set('movieImg')
    .set('movieVideo')
    .set('profile');
}

/**
 * 提交添加
 */
TbMovieInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovie/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbMovie.table.refresh();
        TbMovieInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbMovieInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovie/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbMovie.table.refresh();
        TbMovieInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieInfoData);
    ajax.start();
}

$(function() {

});
