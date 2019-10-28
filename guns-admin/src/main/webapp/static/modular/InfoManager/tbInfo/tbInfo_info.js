/**
 * 初始化电影资讯管理详情对话框
 */
var TbInfoInfoDlg = {
    tbInfoInfoData : {}
};

/**
 * 清除数据
 */
TbInfoInfoDlg.clearData = function() {
    this.tbInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbInfoInfoDlg.set = function(key, val) {
    this.tbInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.TbInfo.layerIndex);
}

/**
 * 收集数据
 */
TbInfoInfoDlg.collectData = function() {
    this
    .set('infoId')
    .set('createTime')
    .set('title')
    .set('infoContent')
    .set('adminId')
    .set('infoImg')
    .set('infoFrom');
}

/**
 * 提交添加
 */
TbInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbInfo.table.refresh();
        TbInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbInfo.table.refresh();
        TbInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbInfoInfoData);
    ajax.start();
}

$(function() {

});
