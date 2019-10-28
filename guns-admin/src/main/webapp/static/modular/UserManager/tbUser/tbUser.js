/**
 * 用户管理管理初始化
 */
var TbUser = {
    id: "TbUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TbUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '用户名', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: '性别0男 1女 未添加是-1', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'age', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'userImg', visible: true, align: 'center', valign: 'middle'},
            {title: '邮箱', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '用户创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '登陆状态（‘0’未登陆 ，‘1’登陆状态）', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '用户类型（‘0’普通用户 ‘1’超级管理员）', field: 'userType', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TbUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TbUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户管理
 */
TbUser.openAddTbUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tbUser/tbUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户管理详情
 */
TbUser.openTbUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tbUser/tbUser_update/' + TbUser.seItem.userId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户管理
 */
TbUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tbUser/delete", function (data) {
            Feng.success("删除成功!");
            TbUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tbUserId",this.seItem.userId);
        ajax.start();
    }
};

/**
 * 查询用户管理列表
 */
TbUser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TbUser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TbUser.initColumn();
    var table = new BSTable(TbUser.id, "/tbUser/list", defaultColunms);
    table.setPaginationType("client");
    TbUser.table = table.init();
});
