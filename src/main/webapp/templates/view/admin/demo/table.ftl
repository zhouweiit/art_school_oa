<#include "${layout_admin_path}/layout_macro.ftl">
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
        <#-- 创建一个表 所有的设置：https://datatables.net/reference/option/ -->
        var datable = {
            "serverSide"  : true,
            "paging"      : true,
            "pagingType"  : "numbers",
            "autoWidth"   : false,
            "lengthChange": true,
            "lengthMenu": [ 10, 20, 50, 100 ],
            "searching"   : false,
            "ordering"    : true,
            "info"        : true,
            "pageLength"  : 10,                         <#-- 默认每页面显示的条数 -->
            "order"       : [],                         <#--默认不排序，以数据来排序-->
            "columns"     : [
                {"data" : 'name1' },
                {"data" : 'name2' },
                {"data" : 'name3' },
                {"data" : 'name4' },
                {"data" : 'name5' }
            ],
            "columnDefs"  : [                           <#-- 禁止第一列排序 -->
                {
                    "orderable": false,
                    "targets": 0
                }
            ],
            "scrollX": 100,
            "ajax" : {
                "url": "/admin/demo/tableinfo",
                "type": "POST",
                "data": function (param) {
                    var newParam = {
                        "tableParam": JSON.stringify(param),
                        "name": "小华",
                        "age": 20,
                    };
                    return newParam;
                },
                "dataSrc": function (result) {
                <#-- 比如要给每条数据加一个button或者checkbox之类的，后端返回的数据，需要占位符-->
                    for ( var i=0, ien=result.data.length ; i<ien ; i++ ) {
                        result.data[i][0] = '<a href="/message/'+result.data[i][0]+'">View message</a>';
                    }
                    return result.data;
                }
            }
        };

        var table = $("#example2").DataTable(datable);

        <#-- 搜索时间触发后，重新加载信息-->
        $("button.seacher_teacher").click(function () {
            table.ajax.reload();
        });

    })
</script>
</#macro>
<#include "${layout_admin_path}/layout.ftl">
