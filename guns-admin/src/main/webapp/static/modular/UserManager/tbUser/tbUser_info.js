/**
 * 初始化用户管理详情对话框
 */
var TbUserInfoDlg = {
    tbUserInfoData : {}
};

/**
 * 清除数据
 */
TbUserInfoDlg.clearData = function() {
    this.tbUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbUserInfoDlg.set = function(key, val) {
    this.tbUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbUserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbUserInfoDlg.close = function() {
    parent.layer.close(window.parent.TbUser.layerIndex);
}

/**
 * 收集数据
 */
TbUserInfoDlg.collectData = function() {
    this
    .set('userId')
    .set('userName')
    .set('password')
    .set('sex')
    .set('age')
    .set('userImg')
    .set('email')
    .set('phone')
    .set('createTime')
    .set('state')
    .set('userType');
}

/**
 * 提交添加
 */
TbUserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbUser/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbUser.table.refresh();
        TbUserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbUserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbUser/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbUser.table.refresh();
        TbUserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbUserInfoData);
    ajax.start();
}

$(function() {

});
