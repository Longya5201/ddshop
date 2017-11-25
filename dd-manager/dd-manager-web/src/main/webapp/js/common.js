
var ddshop = {
    //点击左侧导航树上的节点，添加选项卡
    registerMenuEvent:function(){
        //约定大于配置：jquery对象前面加上$,如果是DOM对象不需要加$
        var $tree = $('#menu .easyui-tree');
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
                //判断选项卡是否已经打开，一但被打开，那么就去选择选项卡，而不是去创建选项卡
                if($('#tab').tabs("exists",text)){
                    $('#tab').tabs("select",text);
                }else {
                    $('#tab').tabs('add',{
                        title: text,
                        href: href,
                        closable:true
                    });
                }
            }
        });
    },

    addTabs:function(title,href){
        //判断选项卡是否已经打开，一但被打开，那么就去选择选项卡，而不是去创建选项卡
        if($('#tab').tabs('exists',title)){
            $('#tab').tabs('select',title);
        }else {
            $('#tab').tabs('add',{
                title: title,
                href: href,
                closable:true
            });
        }
    }
};



