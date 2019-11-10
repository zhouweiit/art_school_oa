<#include "global_param.ftl"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <#--
    支持缩放
    <meta name="viewport" content="width=device-width, initial-scale=1">
    不支持缩放
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    -->
    <title>博美助教</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <script src="/static/widget/admin/bower_components/jquery/dist/jquery.min.js"></script>
    <link rel="stylesheet" href="/static/widget/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/static/widget/admin/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/widget/admin/dist/css/skins/_all-skins.min.css">
    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.min.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
    <@layout_headercss/>
    <style type="text/css">
        <#-- 调整form 表单中的float右边的按钮间距 -->
        div.box-footer > button.pull-right {
            margin-right: 10px;
        }
        <#-- 调整form 表单中的checkbox的间距-->
        div.checkbox > label {
            margin-left: 20px;
        }
        <#-- 调整form 表单中的radio的间距-->
        div.radio > label {
            margin-left: 20px;
        }
    </style>
    <@layout_headerjs/>
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
<div class="wrapper">
    <#--头信息-->
    <header class="main-header">
        <a href="/static/widget/admin/index2.html" class="logo">
            <span class="logo-mini"><b>博美</b></span>
            <span class="logo-lg"><b>博美助教</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="/static/widget/admin/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Support Team
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 10 notifications</li>
                            <li>
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul>
                    </li>
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 9 tasks</li>
                            <li>
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <h3>
                                                Design some buttons
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">View all tasks</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/static/widget/admin/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">Alexander Pierce</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <img src="/static/widget/admin/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                <p>Alexander Pierce - Web Developer<small>Member since Nov. 2012</small></p>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <span class="btn btn-default btn-flat" id="password_modify">密码修改</span>
                                </div>
                                <div class="pull-right">
                                    <span id="logout_submit" class="btn btn-default btn-flat">登出</span>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <#--菜单信息-->
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
            <#list _menu_dto_key_ as item>
                <#if item.menuTreeDtos?size == 0>
                <li <#if item.url == _servlet_path_>class="active"</#if>>
                    <a href="${item.url}"><i class="fa ${item.icon}"></i><span>${item.name}</span></a>
                </li>
                <#else>
                <li class="treeview <#list item.menuTreeDtos as childItem> <#if childItem.url == _servlet_path_>active menu-open</#if> </#list>">
                    <a href="#">
                        <i class="fa ${item.icon}"></i><span>${item.name}</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">
                        <#list item.menuTreeDtos as childItem>
                            <li <#if childItem.url == _servlet_path_>class="active"</#if>><a href="${childItem.url}"><i class="fa fa-circle-o text-aqua"></i>${childItem.name}</a></li>
                        </#list>
                    </ul>
                </li>
                </#if>
            </#list>
        </section>
    </aside>

    <#--内容主体信息-->
    <div class="content-wrapper">
        <@layout_content/>
    </div>

    <#--底部信息-->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2018-2019 <a href="javscript:void(0)">博美集团</a></strong>
    </footer>

</div>
<script src="/static/widget/validate/dist/jquery.validate.js"></script>
<script src="/static/widget/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/static/widget/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/widget/admin/dist/js/adminlte.min.js"></script>
<script src="/static/widget/admin/bower_components/fastclick/lib/fastclick.js"></script>
<script src="/static/widget/admin/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/widget/admin/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/static/widget/treeview/js/bootstrap-treeview.js"></script>
<script>
    $.ajaxSetup({
        complete: function (XMLHttpRequest, textStatus) {
            var res = XMLHttpRequest.responseText;
            try {
                var jsonData = JSON.parse(res);
                <#-- 用户未登录或者登录超时-->
                if (jsonData.resultCode == 88) {
                    window.location.href = "/admin/login/view";
                }
            } catch(e) {
            }
        }
    });

    <#-- 登出js -->
    $(function () {

        $("#logout_submit").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin/user/logout",
                dataType: "json",
                success: function (msg) {
                    if (msg.resultCode >= 200) {
                        if (msg.resultCode == 200) {
                            alert("您还未登录，或者登录已经超时，请重新登录");
                            window.location.href = '/admin/login/view';
                        } else {
                            alert(msg.resultMessage);
                        }
                    }
                },
                error: function (msg) {
                }
            });
        });
    });

</script>
<@layout_footerjs/>
</body>
</html>
<#--通用-->
<#include "common.ftl"/>