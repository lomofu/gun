/**
 * 关注管理管理初始化
 */
var TbPush = {
    id: "TbPushTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbPush.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户Id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '关注的用户Id', field: 'followId', visible: true, align: 'center', valign: 'middle'},
            {title: '关注状态 0为关注 1为取消关注', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '关注时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbPush.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbPush.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加关注管理
 */
TbPush.openAddTbPush = function () {
    var index = layer.open({
        type: 2,
        title: '添加关注管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbPush/tbPush_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看关注管理详情
 */
TbPush.openTbPushDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '关注管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbPush/tbPush_update/' + TbPush.seItem.userId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除关注管理
 */
TbPush.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbPush/delete", function (data) {
            Feng.success("删除成功!");
            TbPush.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbPushId",this.seItem.userId);
        ajax.start();
    }
};

/**
 * 查询关注管理列表
 */
TbPush.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbPush.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbPush.initColumn();
    var table = new BSTable(TbPush.id, "/tbPush/list", defaultColunms);
    table.setPaginationType("client");
    TbPush.table = table.init();
});
