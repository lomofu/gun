/**
 * 初始化日志管理详情对话框
 */
var TbLogInfoDlg = {
    tbLogInfoData : {}
};

/**
 * 清除数据
 */
TbLogInfoDlg.clearData = function() {
    this.tbLogInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbLogInfoDlg.set = function(key, val) {
    this.tbLogInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbLogInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbLogInfoDlg.close = function() {
    parent.layer.close(window.parent.TbLog.layerIndex);
}

/**
 * 收集数据
 */
TbLogInfoDlg.collectData = function() {
    this
    .set('logId')
    .set('userName')
    .set('createdate')
    .set('content')
    .set('operation')
    .set('type');
}

/**
 * 提交添加
 */
TbLogInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbLog/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbLog.table.refresh();
        TbLogInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbLogInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbLogInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbLog/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbLog.table.refresh();
        TbLogInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbLogInfoData);
    ajax.start();
}

$(function() {

});
