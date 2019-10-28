/**
 * 日志管理管理初始化
 */
var TbLog = {
    id: "TbLogTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbLog.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'logId', visible: true, align: 'center', valign: 'middle'},
            {title: '用户名', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'createdate', visible: true, align: 'center', valign: 'middle'},
            {title: '日志内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '用户所做的操作', field: 'operation', visible: true, align: 'center', valign: 'middle'},
            {title: '日志类型', field: 'type', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbLog.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbLog.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加日志管理
 */
TbLog.openAddTbLog = function () {
    var index = layer.open({
        type: 2,
        title: '添加日志管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbLog/tbLog_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看日志管理详情
 */
TbLog.openTbLogDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '日志管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbLog/tbLog_update/' + TbLog.seItem.logId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除日志管理
 */
TbLog.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbLog/delete", function (data) {
            Feng.success("删除成功!");
            TbLog.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbLogId",this.seItem.logId);
        ajax.start();
    }
};

/**
 * 查询日志管理列表
 */
TbLog.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbLog.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbLog.initColumn();
    var table = new BSTable(TbLog.id, "/tbLog/list", defaultColunms);
    table.setPaginationType("client");
    TbLog.table = table.init();
});
