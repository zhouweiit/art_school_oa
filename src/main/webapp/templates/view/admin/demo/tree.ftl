<#include "${layout_admin_path}/layout_macro.ftl">
<#macro layout_content>
<div class="row">
    <div class="col-md-12">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Horizontal Form</h3>
            </div>
            <form class="form-horizontal"> <#-- 设置label与input是垂直还是水平 -->
                <div class="box-body">
                    <div class="col-md-3"> <#-- 设置一对form的宽度 -->
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
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
                    <button type="submit" class="btn btn-info pull-right">Sign in</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-3">
        <div id="treeview1" class=""></div>
    </div>
</div>

<div class="row">
    <div class="col-md-3">
        <div id="treeview2" class=""></div>
    </div>
    <div class="col-md-3">
        <div id="treeview3" class=""></div>
    </div>
    <div class="col-md-3">
        <div id="treeview4" class=""></div>
    </div>
</div>

</#macro>
<#macro layout_footerjs>
<script>
    $(function() {
        var defaultData = [
            {
                text: 'Parent 1',
                href: '#parent1',
                tags: ['4'],
                nodes: [
                    {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    },
                    {
                        text: 'Child 2',
                        href: '#child2',
                        tags: ['0']
                    }
                ]
            },
            {
                text: 'Parent 2',
                href: '#parent2',
                tags: ['0']
            },
            {
                text: 'Parent 3',
                href: '#parent3',
                tags: ['0']
            },
            {
                text: 'Parent 4',
                href: '#parent4',
                tags: ['0']
            },
            {
                text: 'Parent 5',
                href: '#parent5',
                tags: ['0']
            }
        ];

        $('#treeview1').treeview({
            data: defaultData
        });

        $('#treeview2').treeview({
            data: defaultData
        });

        $('#treeview3').treeview({
            data: defaultData
        });

        $('#treeview4').treeview({
            data: defaultData
        });
    });
</script>
</#macro>
<#include "${layout_admin_path}/layout.ftl">