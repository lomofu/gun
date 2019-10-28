/**
 * 电影管理管理初始化
 */
var TbMovie = {
    id: "TbMovieTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbMovie.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '电影ID', field: 'movieId', visible: true, align: 'center', valign: 'middle'},
            {title: '电影名', field: 'movieName', visible: true, align: 'center', valign: 'middle'},
            {title: '类型id', field: 'typeId', visible: true, align: 'center', valign: 'middle'},
            {title: '上映时间', field: 'onTime', visible: true, align: 'center', valign: 'middle'},
            {title: '语言类型', field: 'language', visible: true, align: 'center', valign: 'middle'},
            {title: '国家/地区', field: 'country', visible: true, align: 'center', valign: 'middle'},
            {title: '电影时长', field: 'movieTime', visible: true, align: 'center', valign: 'middle'},
            {title: '导演名', field: 'director', visible: true, align: 'center', valign: 'middle'},
            {title: '演员', field: 'actor', visible: true, align: 'center', valign: 'middle'},
            {title: '图片路径', field: 'movieImg', visible: true, align: 'center', valign: 'middle'},
            {title: '视频路径', field: 'movieVideo', visible: true, align: 'center', valign: 'middle'},
            {title: '简介', field: 'profile', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbMovie.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbMovie.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加电影管理
 */
TbMovie.openAddTbMovie = function () {
    var index = layer.open({
        type: 2,
        title: '添加电影管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbMovie/tbMovie_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看电影管理详情
 */
TbMovie.openTbMovieDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '电影管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbMovie/tbMovie_update/' + TbMovie.seItem.movieId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除电影管理
 */
TbMovie.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbMovie/delete", function (data) {
            Feng.success("删除成功!");
            TbMovie.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbMovieId",this.seItem.movieId);
        ajax.start();
    }
};

/**
 * 查询电影管理列表
 */
TbMovie.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbMovie.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbMovie.initColumn();
    var table = new BSTable(TbMovie.id, "/tbMovie/list", defaultColunms);
    table.setPaginationType("client");
    TbMovie.table = table.init();
});
