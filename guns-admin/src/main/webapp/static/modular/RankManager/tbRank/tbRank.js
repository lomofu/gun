/**
 * 排行管理管理初始化
 */
var TbRank = {
    id: "TbRankTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbRank.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '总数', field: 'count', visible: true, align: 'center', valign: 'middle'},
            {title: '排名标识符', field: 'rankId', visible: true, align: 'center', valign: 'middle'},
            {title: '电影ID参考Comment表', field: 'movieId', visible: true, align: 'center', valign: 'middle'},
            {title: '平均分', field: 'avgStar', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbRank.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbRank.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加排行管理
 */
TbRank.openAddTbRank = function () {
    var index = layer.open({
        type: 2,
        title: '添加排行管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbRank/tbRank_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看排行管理详情
 */
TbRank.openTbRankDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '排行管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbRank/tbRank_update/' + TbRank.seItem.rankId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除排行管理
 */
TbRank.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbRank/delete", function (data) {
            Feng.success("删除成功!");
            TbRank.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbRankId",this.seItem.rankId);
        ajax.start();
    }
};

/**
 * 查询排行管理列表
 */
TbRank.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbRank.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbRank.initColumn();
    var table = new BSTable(TbRank.id, "/tbRank/list", defaultColunms);
    table.setPaginationType("client");
    TbRank.table = table.init();
});
