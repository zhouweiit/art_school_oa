<#include "../../../layout/admin/layout_macro.ftl">
<#macro layout_content>
<div class="row">
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
                    <tbody>
                    <tr>
                        <td>Trident</td>
                        <td>Internet
                            Explorer 4.0
                        </td>
                        <td>Win 95+</td>
                        <td> 4</td>
                        <td>X</td>
                    </tr>
                    <tr>
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.0
                        </td>
                        <td>Win 95+</td>
                        <td>5</td>
                        <td>C</td>
                    </tr>
                    <tr>
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.5
                        </td>
                        <td>Win 95+</td>
                        <td>5.5</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Trident</td>
                        <td>Internet
                            Explorer 6
                        </td>
                        <td>Win 98+</td>
                        <td>6</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Trident</td>
                        <td>Internet Explorer 7</td>
                        <td>Win XP SP2+</td>
                        <td>7</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Trident</td>
                        <td>AOL browser (AOL desktop)</td>
                        <td>Win XP</td>
                        <td>6</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Firefox 1.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td>1.7</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Firefox 1.5</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td>1.8</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Firefox 2.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td>1.8</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Firefox 3.0</td>
                        <td>Win 2k+ / OSX.3+</td>
                        <td>1.9</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Camino 1.0</td>
                        <td>OSX.2+</td>
                        <td>1.8</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Camino 1.5</td>
                        <td>OSX.3+</td>
                        <td>1.8</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Netscape 7.2</td>
                        <td>Win 95+ / Mac OS 8.6-9.2</td>
                        <td>1.7</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Netscape Browser 8</td>
                        <td>Win 98SE+</td>
                        <td>1.7</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Netscape Navigator 9</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td>1.8</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Mozilla 1.0</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td>1</td>
                        <td>A</td>
                    </tr>
                    <tr>
                        <td>Gecko</td>
                        <td>Mozilla 1.1</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td>1.1</td>
                        <td>A</td>
                    </tr>
                    </tbody>
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
        var table = $('#example2').DataTable({
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
            'paging'      : true,
            "pagingType"  : "full_numbers",
            "autoWidth"   : false,
            'lengthChange': true,
            "lengthMenu": [ 10, 20, 50, 75, 100 ],
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'pageLength'  : 10,                         <#-- 默认每页面显示的条数 -->
            "order"       : [],                         <#-- 默认不排序，以数据来排序 -->
            "columnDefs"  : [
                { "orderable": false, "targets": 0 }    <#-- 禁止第一列排序 -->
            ]
        })

        <#-- 翻页事件 -->
        table.on( 'page.dt', function () {
            var info = table.page.info();
            <#-- 通过ajax获取数据后，写入表中-->
            var data = [
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],
                [1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5]
            ];
            alert( 'Showing page: '+info.page+' of '+info.pages );
            table.clear();<#-- 清除表中的数据 -->
            table.rows.add(data);<#-- 将数据写入表中 -->
            table.draw();<#-- 重新渲染表中的数据 -->
        });

        <#-- 排序事件 order[][]，第一维表示哪一列，取值:数字，表示第几列，从0开始 ；第二维表示升序还是降序，取值:asc、desc-->
        table.on( 'order.dt', function () {
            var order = table.order();
            alert( 'Ordering on column '+order[0][0]+' ('+order[0][1]+')' );
        });

        <#-- 每页显示的数据长度发生变化 -->
        table.on( 'length.dt', function (e, settings, len ) {
            <#-- 表里面的排序信息 -->
            alert(table.order());
            <#-- page - 当前页的索引（0代表第一页）
            pages - 总页数
            start - 起始索引
            end - 结束索引
            length - 每页长度。一般情况下 start+length=end，但是也不是所有情况都是这样，例如你总共数据条数是2，而 length是10
            recordsTotal - 总条数
            recordsDisplay - 显示的数据条数，如果你加上了过滤条件这个则是过滤后的记录数
            -->
            alert(table.page.info());
            console.log(table.page.info());
            console.log(table.page());
            console.log(table.page.len());
            alert( 'New page length: '+len );
        });

    })
</script>
</#macro>
<#include "../../../layout/admin/layout.ftl">
