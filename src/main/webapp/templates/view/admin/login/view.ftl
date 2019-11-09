<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <title>博美助教</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/widget/admin/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/static/widget/admin/dist/css/AdminLTE.min.css">
    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.min.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/static/widget/admin/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>博美助教</b></a>
    </div>
    <div class="login-box-body">
        <p class="login-box-msg">用户登录</p>

        <form action="#" method="post">
            <div class="form-group has-feedback">
                <input type="text" id="username" class="form-control" placeholder="用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" id="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-md-5" style="padding-left: 15px;">
                    <div class="form-group">
                        <input type="text" id="captcha" class="form-control" placeholder="验证码">
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="form-group">
                        <img src="/admin/login/captcha" id="captcha_img" class="img-thumbnail"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-4">
                    <button type="button" id="login_sumit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>

    </div>
</div>

<script src="/static/widget/admin/bower_components/jquery/dist/jquery.min.js"></script>
<script src="/static/widget/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/static/widget/admin/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $("#login_sumit").click(function () {
            data = {
                username: $("#username").val(),
                password: $("#password").val(),
                captcha: $("#captcha").val()
            };
            $.ajax({
                type: "POST",
                url: "/admin/login/login",
                data: data,
                dataType: "json",
                success: function (msg) {
                    if (msg.resultCode == 200) {
                        window.location.href = '/admin/index/view';
                    } else {
                        alert(msg.resultMessage);
                    }
                    $("#captcha_img").click();
                },
                error: function (msg) {
                    $("#captcha_img").click();
                }
            });
        });
        $("#captcha_img").click(function () {
            $(this).attr("src", "/admin/login/captcha?" + Math.random());
        });
    });
</script>
</body>
</html>
