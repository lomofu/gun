/**
 * 初始化收藏管理详情对话框
 */
var TbStarsInfoDlg = {
    tbStarsInfoData : {}
};

/**
 * 清除数据
 */
TbStarsInfoDlg.clearData = function() {
    this.tbStarsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbStarsInfoDlg.set = function(key, val) {
    this.tbStarsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbStarsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbStarsInfoDlg.close = function() {
    parent.layer.close(window.parent.TbStars.layerIndex);
}

/**
 * 收集数据
 */
TbStarsInfoDlg.collectData = function() {
    this
    .set('userId')
    .set('movieId')
    .set('state')
    .set('createTime');
}

/**
 * 提交添加
 */
TbStarsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbStars/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbStars.table.refresh();
        TbStarsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbStarsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbStarsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbStars/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbStars.table.refresh();
        TbStarsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbStarsInfoData);
    ajax.start();
}

$(function() {

});
