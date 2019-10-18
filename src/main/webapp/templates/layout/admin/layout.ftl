<#include "global_param.ftl"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>博美教育管理系统</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
    <!-- Google Font -->
    <link rel="stylesheet" href="/static/css/font.css">
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
            <span class="logo-lg"><b>博美教育管理系统</b></span>
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
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <#--菜单信息-->
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-dashboard"></i> <span>博美教育</span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/static/widget/admin/index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
                        <li><a href="/static/widget/admin/index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
                    </ul>
                </li>
                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-files-o"></i>
                        <span>页面分层</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/static/widget/admin/pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
                        <li><a href="/static/widget/admin/pages/layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed</a></li>
                        <li class="active"><a href="/static/widget/admin/pages/layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed</a></li>
                        <li><a href="collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Collapsed Sidebar</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>

    <#--内容主体信息-->
    <div class="content-wrapper">
        <#--内容的头信息-->
        <section class="content-header">
            <section class="content-header">
                <h1>
                    学校管理
                    <small><小标题></小标题></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li><a href="#">学校管理</a></li>
                    <li class="active">新增学校</li>
                </ol>
            </section>
        </section>
        <#--内容的主题信息-->
        <section class="content">
        <@layout_content/>
        </section>
    </div>

    <#--底部信息-->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2018-2019 <a href="javscript:void(0)">博美集团</a></strong>
    </footer>

</div>
<script src="/static/widget/admin/bower_components/jquery/dist/jquery.min.js"></script>
<script src="/static/widget/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/static/widget/admin/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/widget/admin/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/static/widget/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/widget/admin/bower_components/fastclick/lib/fastclick.js"></script>
<script src="/static/widget/admin/dist/js/adminlte.min.js"></script>
<@layout_footerjs/>
</body>
</html>