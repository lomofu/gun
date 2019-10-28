/**
 * 初始化关注管理详情对话框
 */
var TbPushInfoDlg = {
    tbPushInfoData : {}
};

/**
 * 清除数据
 */
TbPushInfoDlg.clearData = function() {
    this.tbPushInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbPushInfoDlg.set = function(key, val) {
    this.tbPushInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbPushInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbPushInfoDlg.close = function() {
    parent.layer.close(window.parent.TbPush.layerIndex);
}

/**
 * 收集数据
 */
TbPushInfoDlg.collectData = function() {
    this
    .set('userId')
    .set('followId')
    .set('state')
    .set('createTime');
}

/**
 * 提交添加
 */
TbPushInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbPush/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbPush.table.refresh();
        TbPushInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbPushInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbPushInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbPush/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbPush.table.refresh();
        TbPushInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbPushInfoData);
    ajax.start();
}

$(function() {

});
