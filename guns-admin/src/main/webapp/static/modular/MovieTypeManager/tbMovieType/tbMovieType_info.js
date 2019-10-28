/**
 * 初始化电影类型管理详情对话框
 */
var TbMovieTypeInfoDlg = {
    tbMovieTypeInfoData : {}
};

/**
 * 清除数据
 */
TbMovieTypeInfoDlg.clearData = function() {
    this.tbMovieTypeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieTypeInfoDlg.set = function(key, val) {
    this.tbMovieTypeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TbMovieTypeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TbMovieTypeInfoDlg.close = function() {
    parent.layer.close(window.parent.TbMovieType.layerIndex);
}

/**
 * 收集数据
 */
TbMovieTypeInfoDlg.collectData = function() {
    this
    .set('typeId')
    .set('typeName');
}

/**
 * 提交添加
 */
TbMovieTypeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovieType/add", function(data){
        Feng.success("添加成功!");
        window.parent.TbMovieType.table.refresh();
        TbMovieTypeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieTypeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TbMovieTypeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tbMovieType/update", function(data){
        Feng.success("修改成功!");
        window.parent.TbMovieType.table.refresh();
        TbMovieTypeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tbMovieTypeInfoData);
    ajax.start();
}

$(function() {

});
