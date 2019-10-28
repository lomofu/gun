/**
 * 电影类型管理管理初始化
 */
var TbMovieType = {
    id: "TbMovieTypeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbMovieType.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '类型ID', field: 'typeId', visible: true, align: 'center', valign: 'middle'},
            {title: '类型名字', field: 'typeName', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbMovieType.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbMovieType.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加电影类型管理
 */
TbMovieType.openAddTbMovieType = function () {
    var index = layer.open({
        type: 2,
        title: '添加电影类型管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbMovieType/tbMovieType_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看电影类型管理详情
 */
TbMovieType.openTbMovieTypeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '电影类型管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbMovieType/tbMovieType_update/' + TbMovieType.seItem.typeId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除电影类型管理
 */
TbMovieType.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbMovieType/delete", function (data) {
            Feng.success("删除成功!");
            TbMovieType.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbMovieTypeId",this.seItem.typeId);
        ajax.start();
    }
};

/**
 * 查询电影类型管理列表
 */
TbMovieType.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbMovieType.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbMovieType.initColumn();
    var table = new BSTable(TbMovieType.id, "/tbMovieType/list", defaultColunms);
    table.setPaginationType("client");
    TbMovieType.table = table.init();
});
