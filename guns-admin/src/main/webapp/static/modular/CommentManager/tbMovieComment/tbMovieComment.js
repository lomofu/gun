/**
 * 电影评论管理管理初始化
 */
var TbMovieComment = {
    id: "TbMovieCommentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbMovieComment.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '评论ID', field: 'commentId', visible: true, align: 'center', valign: 'middle'},
            {title: '电影ID参看Movie表', field: 'movieId', visible: true, align: 'center', valign: 'middle'},
            {title: '用户ID参考User表', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '评分(从低到高 1-5)', field: 'start', visible: true, align: 'center', valign: 'middle'},
            {title: '删除与否(0-没删除,1-删除)', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'flag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbMovieComment.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbMovieComment.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加电影评论管理
 */
TbMovieComment.openAddTbMovieComment = function () {
    var index = layer.open({
        type: 2,
        title: '添加电影评论管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbMovieComment/tbMovieComment_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看电影评论管理详情
 */
TbMovieComment.openTbMovieCommentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '电影评论管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbMovieComment/tbMovieComment_update/' + TbMovieComment.seItem.commentId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除电影评论管理
 */
TbMovieComment.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbMovieComment/delete", function (data) {
            Feng.success("删除成功!");
            TbMovieComment.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbMovieCommentId",this.commentId);
        ajax.start();
    }
};

/**
 * 查询电影评论管理列表
 */
TbMovieComment.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbMovieComment.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbMovieComment.initColumn();
    var table = new BSTable(TbMovieComment.id, "/tbMovieComment/list", defaultColunms);
    table.setPaginationType("client");
    TbMovieComment.table = table.init();
});
