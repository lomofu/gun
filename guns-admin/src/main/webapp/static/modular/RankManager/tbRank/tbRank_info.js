/**
 * 初始化排行管理详情对话框
 */
var TbRankInfoDlg = {
    tbRankInfoData : {}
};

/**
 * 清除数据
 */
TbRankInfoDlg.clearData = function() {
    this.tbRankInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbRankInfoDlg.set = function(key, val) {
    this.tbRankInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbRankInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbRankInfoDlg.close = function() {
    parent.layer.close(window.parent.TbRank.layerIndex);
}

/**
 * 收集数据
 */
TbRankInfoDlg.collectData = function() {
    this
    .set('count')
    .set('rankId')
    .set('movieId')
    .set('avgStar');
}

/**
 * 提交添加
 */
TbRankInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbRank/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbRank.table.refresh();
        TbRankInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbRankInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbRankInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbRank/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbRank.table.refresh();
        TbRankInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbRankInfoData);
    ajax.start();
}

$(function() {

});
