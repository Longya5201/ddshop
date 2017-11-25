<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox">
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
        <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="dg"></table>
<script>

    //模糊查询
    function searchForm(){
        $('#dg').datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
    }

    // 添加工具栏
    function add(){
        ddshop.addTabs('新增商品','item-add');
    }

    function edit(){
        console.log('edit')
    }
    function remove() {
        var selections =  $('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请至少选择一项');
            return;
        }
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                var ids=[];
                //遍历选中的记录，把选中的id存放在js数组ids中
                for(var i=0;i<selections.length;i++ ){
                    ids.push(selections[i].id);
                }
                $.post(
                    'items/batch',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    'json'
                );
            }
        });
    }

    function down(){
        var selections=$('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请至少选择一项');
            return;
        }
        $.messager.confirm('提示','你确定要把这些商品下架吗？',function(r){
            if(r){
                //存放选中行商品的I
                var ids=[];
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }
                $.post(
                    'items/down',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    'json'
                )
            }
        });
    }

    function up(){
        var selections=$('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请至少选择一项');
            return;
        }
        $.messager.confirm('提示','你确定要把这些商品上架吗？',function(r){
            if(r){
                //存放选中行商品的I
                var ids=[];
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }
                $.post(
                    'items/up',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    'json'
                )
            }
        });
    }
    //初始化数据表格
    $('#dg').datagrid({
        //允许多列进行排序
        multiSort:true,
        url:'items',
        pagination:true,
        rownumbers:true,
        striped:true,
        fit:true,
        pageSize:20,
        pageNumber:1,
        pageList:[20,30,50,100],
        //将工具栏添加到数据表格中
        toolbar:"#toolbar",
        columns:[[
            {field:'ck',checkbox:'true'},
            {field:'id',title:'商品编号',width:100,sortable:true},
            {field:'title',title:'商品名称',width:100,sortable:true},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'statusName',title:'状态',width:100},
            {field:'catName',title:'商品分类',width:100},
            {field:'price',title:'价格',width:100},
            {field:'created',title:'创建时间',width:100,formatter:function(value,row,index){
                    return moment(value).format('LL');
            }},
            {field:'updated',title:'修改时间',width:100,formatter:function(value,row,index){
                    return moment(value).format('LL');
            }}
        ]]
    });
</script>