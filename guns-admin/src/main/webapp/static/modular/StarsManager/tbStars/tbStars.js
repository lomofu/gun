/**
 * 收藏管理管理初始化
 */
var TbStars = {
    id: "TbStarsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbStars.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户Id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '电影Id', field: 'movieId', visible: true, align: 'center', valign: 'middle'},
            {title: '收藏状态 0为收藏 1为取消收藏', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '收藏时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbStars.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbStars.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加收藏管理
 */
TbStars.openAddTbStars = function () {
    var index = layer.open({
        type: 2,
        title: '添加收藏管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbStars/tbStars_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看收藏管理详情
 */
TbStars.openTbStarsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '收藏管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbStars/tbStars_update/' + TbStars.seItem.userId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除收藏管理
 */
TbStars.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbStars/delete", function (data) {
            Feng.success("删除成功!");
            TbStars.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbStarsId",this.seItem.userId);
        ajax.start();
    }
};

/**
 * 查询收藏管理列表
 */
TbStars.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbStars.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbStars.initColumn();
    var table = new BSTable(TbStars.id, "/tbStars/list", defaultColunms);
    table.setPaginationType("client");
    TbStars.table = table.init();
});
