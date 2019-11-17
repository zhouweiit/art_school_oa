<#-- 密码修改，模态窗口，开始-->
<div class="modal fade" id="password_modify_modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">密码修改</h4>
            </div>
            <div class="modal-body">
                <form class="form" id="modify_password_form">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="modify_password_submit">提交</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        var form = $("#modify_password_form").validate({
            rules: {
                old_password: {
                    required: true
                },
                first_password: {
                    required: true,
                    minlength: 5,
                    maxlength: 20
                },
                second_password: {
                    required: true,
                    equalTo: "#first_password"
                }
            },
            messages: {
                old_password: {
                    required: "请输入旧密码"
                },
                first_password: {
                    required: "请输入新密码",
                    minlength: "密码最短长度为5位",
                    maxlength: "密码最长长度为20位"
                },
                second_password: {
                    required: "请输入重复新密码",
                    equalTo: "两次输入的密码不一致"
                }
            }
        });

        var modal_body = '<div class="row" style="margin-left: 0px; margin-right: 0px;">\n' +
                '                        <div class="form-group has-feedback" id="old_password_form_group">\n' +
                '                            <label for="recipient-name" class="control-label">旧密码:</label>\n' +
                '                            <input type="password" id="old_password" name="old_password" class="form-control" placeholder="密码">\n' +
                '                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>\n' +
                '                            <span class="help-block" id="old_password_message"></span>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                    <div class="row" style="margin-left: 0px; margin-right: 0px;">\n' +
                '                        <div class="form-group has-feedback" id="first_password_form_group">\n' +
                '                            <label for="recipient-name" class="control-label">新密码:</label>\n' +
                '                            <input type="password" id="first_password" name="first_password" class="form-control" placeholder="密码">\n' +
                '                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>\n' +
                '                            <span class="help-block" id="first_password_message"></span>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                    <div class="row" style="margin-left: 0px; margin-right: 0px;">\n' +
                '                        <div class="form-group has-feedback" id="second_password_form_group">\n' +
                '                            <label for="recipient-name" class="control-label">重复新密码:</label>\n' +
                '                            <input type="password" id="second_password" name="second_password" class="form-control" placeholder="密码">\n' +
                '                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>\n' +
                '                            <span class="help-block" id="second_password_message"></span>\n' +
                '                        </div>\n' +
                '                    </div>';

        $("#password_modify").click(function () {
            $('#password_modify_modal').modal({
                keyboard: true
            });
            $("#modify_password_form").html(modal_body);
        });

        $("#modify_password_submit").click(function () {
            result = form.form();
            if (result) {
                data = {
                    oldPassword: $("#old_password").val(),
                    firstPassword: $("#first_password").val(),
                    secondPassword: $("#second_password").val()
                };
                $.ajax({
                    type: "POST",
                    url: "/admin/org/user/modify_password",
                    data: data,
                    dataType: "json",
                    success: function (msg) {
                        if (msg.resultCode >= 200) {
                            if (msg.resultCode == 200) {
                                alert("密码修改成功");
                                $('#password_modify_modal').modal('hide');
                                $("#old_password").val("");
                                $("#first_password").val("");
                                $("#second_password").val("");
                            } else {
                                alert(msg.resultMessage);
                            }
                        }
                    },
                    error: function (msg) {
                    }
                });
            }
        });
    });
</script>
<#-- 密码修改，模态窗口，结束-->