/**
 * 电影资讯管理管理初始化
 */
var TbInfo = {
    id: "TbInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'infoId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'infoContent', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'adminId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'infoImg', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'infoFrom', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加电影资讯管理
 */
TbInfo.openAddTbInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加电影资讯管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbInfo/tbInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看电影资讯管理详情
 */
TbInfo.openTbInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '电影资讯管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbInfo/tbInfo_update/' + TbInfo.seItem.infoId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除电影资讯管理
 */
TbInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbInfo/delete", function (data) {
            Feng.success("删除成功!");
            TbInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbInfoId",this.seItem.infoId);
        ajax.start();
    }
};

/**
 * 查询电影资讯管理列表
 */
TbInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbInfo.initColumn();
    var table = new BSTable(TbInfo.id, "/tbInfo/list", defaultColunms);
    table.setPaginationType("client");
    TbInfo.table = table.init();
});
