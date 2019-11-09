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
                <div class="row" style="margin-left: 0px; margin-right: 0px;">
                    <div class="form-group has-feedback">
                        <label for="recipient-name" class="control-label">旧密码:</label>
                        <input type="password" id="old_password" class="form-control" placeholder="密码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                </div>
                <div class="row" style="margin-left: 0px; margin-right: 0px;">
                    <div class="form-group has-feedback">
                        <label for="recipient-name" class="control-label">新密码:</label>
                        <input type="password" id="first_password" class="form-control" placeholder="密码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                </div>
                <div class="row" style="margin-left: 0px; margin-right: 0px;">
                    <div class="form-group has-feedback">
                        <label for="recipient-name" class="control-label">重复新密码:</label>
                        <input type="password" id="second_password" class="form-control" placeholder="密码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                </div>
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
        $("#password_modify").click(function () {
            $('#password_modify_modal').modal({
                keyboard: true
            });
        });
        $("#modify_password_submit").click(function () {
            data = {
                oldPassword: $("#old_password").val(),
                firstPassword: $("#first_password").val(),
                secondPassword: $("#second_password").val()
            };
            $.ajax({
                type: "POST",
                url: "/admin/user/modify_password",
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
        });
    })

</script>
<#-- 密码修改，模态窗口，结束-->