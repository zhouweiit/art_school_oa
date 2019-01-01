<#include "../../../layout/admin/layout_macro.ftl">
<#macro layout_content>
<div class="row">
    <div class="col-md-12">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">水平FORM</h3>
            </div>
            <form class="form-horizontal"> <#-- 设置label与input是垂直还是水平 -->
                <div class="box-body">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" placeholder="Password">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail4" placeholder="Email">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-info pull-right">Cancel</button>
                    <button type="submit" class="btn btn-info pull-right seacher_teacher">搜索</button>
                </div>
            </form>
        </div>
    </div>

    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header">
                <i class="fa fa-table"></i>
                <h3 class="box-title">学校信息</h3>
            </div>
            <div class="box-body">
                <table id="example2" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
</#macro>
<#macro layout_footerjs>
<script>
    $(function () {
        <#-- 创建一个表 -->
        var datable = {
            "serverSide"  : true,
            "language": {
                "paginate": {
                    "previous": "上一页",
                    "next": "下一页",
                    "first": "首页",
                    "last": "尾页"
                },
                "info": "当前为第_PAGE_页(共_PAGES_页，共_MAX_条数据)",
                "lengthMenu": "显示 _MENU_ 条记录"
            },
            "paging"      : true,
            "pagingType"  : "full_numbers",
            "autoWidth"   : false,
            "lengthChange": true,
            "lengthMenu": [ 10, 20, 50, 100 ],
            "searching"   : false,
            "ordering"    : true,
            "info"        : true,
            "pageLength"  : 10,                         <#-- 默认每页面显示的条数 -->
            "order"       : [],                         <#--默认不排序，以数据来排序-->
            "columnDefs"  : [
                { "orderable": false, "targets": 0 }    <#-- 禁止第一列排序 -->
            ]
        };

        datable.ajax = {
            "url": "/admin/demo/tableinfo",
            "type": "POST",
            "data": function (param) {
                var newParam = {
                    "tableParam": JSON.stringify(param)
                };
                console.log(newParam);
                return newParam;
            },
            "dataSrc": function (result) {
                console.log(result);
                <#-- 比如要给每条数据加一个button或者checkbox之类的，后端返回的数据，需要占位符
                for ( var i=0, ien=json.data.length ; i<ien ; i++ ) {
                    json.data[i][0] = '<a href="/message/'+json.data[i][0]+'">View message</a>';
                }
                -->
                return result.data;
            }
        };

        var table = $("#example2").DataTable(datable);

        <#-- 搜索时间触发后，重新加载信息-->
        $("div.seacher_teacher").onclick(function () {
           table.ajax.reload();
        });

        <#--&lt;#&ndash; 翻页事件 &ndash;&gt;-->
        <#--table.on( 'page.dt', function () {-->
            <#--var info = table.page.info();-->
            <#--&lt;#&ndash; 通过ajax获取数据后，写入表中&ndash;&gt;-->
            <#--var data = [-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],-->
                <#--[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5]-->
            <#--];-->
            <#--alert( 'Showing page: '+info.page+' of '+info.pages );-->
            <#--table.clear();&lt;#&ndash; 清除表中的数据 &ndash;&gt;-->
            <#--table.rows.add(data);&lt;#&ndash; 将数据写入表中 &ndash;&gt;-->
            <#--table.draw();&lt;#&ndash; 重新渲染表中的数据 &ndash;&gt;-->
        <#--});-->

        <#--&lt;#&ndash; 排序事件 order[][]，第一维表示哪一列，取值:数字，表示第几列，从0开始 ；第二维表示升序还是降序，取值:asc、desc&ndash;&gt;-->
        <#--table.on( 'order.dt', function () {-->
            <#--var order = table.order();-->
            <#--alert( 'Ordering on column '+order[0][0]+' ('+order[0][1]+')' );-->
        <#--});-->

        <#--&lt;#&ndash; 每页显示的数据长度发生变化 &ndash;&gt;-->
        <#--table.on( 'length.dt', function (e, settings, len ) {-->
            <#--&lt;#&ndash; 表里面的排序信息 &ndash;&gt;-->
            <#--alert(table.order());-->
            <#--&lt;#&ndash; page - 当前页的索引（0代表第一页）-->
            <#--pages - 总页数-->
            <#--start - 起始索引-->
            <#--end - 结束索引-->
            <#--length - 每页长度。一般情况下 start+length=end，但是也不是所有情况都是这样，例如你总共数据条数是2，而 length是10-->
            <#--recordsTotal - 总条数-->
            <#--recordsDisplay - 显示的数据条数，如果你加上了过滤条件这个则是过滤后的记录数-->
            <#--&ndash;&gt;-->
            <#--alert(table.page.info());-->
            <#--console.log(table.page.info());-->
            <#--console.log(table.page());-->
            <#--console.log(table.page.len());-->
            <#--alert( 'New page length: '+len );-->
        <#--});-->

    })
</script>
</#macro>
<#include "../../../layout/admin/layout.ftl">
