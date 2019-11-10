<#include "${layout_admin_path}/layout_macro.ftl">
<#macro layout_content>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Horizontal Form</h3>
                </div>
                <form class="form" id="test_form_validate"> <#-- 设置label与input是垂直还是水平 -->
                    <div class="box-body">
                        <#-- <div class="form-group has-success"> -->
                        <div class="form-group" id="name_form_group">
                            <label class="control-label" for="inputSuccess"><i class="fa fa-check"></i> Input with success</label>
                            <input type="text" class="form-control" placeholder="Enter ..." name="name">
                            <span class="help-block" id="name_message"></span>
                        </div>
                        <#-- <div class="form-group has-warning"> -->
                        <div class="form-group" id="age_form_group">
                            <label class="control-label" for="inputWarning"><i class="fa fa-bell-o"></i> Input with warning</label>
                            <input type="text" class="form-control" placeholder="Enter ..." name="age">
                            <span class="help-block" id="age_message"></span>
                        </div>
                        <#-- <div class="form-group has-error"> -->
                        <div class="form-group" id="test_form_group">
                            <label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i> Input with error</label>
                            <input type="text" class="form-control" placeholder="Enter ..." name="test">
                            <span class="help-block" id="test_message"></span>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-3" id="select_form_group">
                                <label>Select</label>
                                <select class="form-control" name="select">
                                    <option value="">请选择</option>
                                    <option value="1">option 1</option>
                                    <option value="2">option 2</option>
                                    <option value="3">option 3</option>
                                    <option value="4">option 4</option>
                                    <option value="5">option 5</option>
                                </select>
                                <span class="help-block" id="select_message"></span>
                            </div>
                        </div>
                        <div class="form-group" id="optionsRadios_form_group">
                            <label>茶叶</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" value="option1">
                                    普洱
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" value="option2">
                                    铁观音
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" value="option3">
                                    碧螺春
                                </label>
                            </div>
                            <span class="help-block" id="optionsRadios_message"></span>
                        </div>
                        <div class="form-group" id="fruit_form_group">
                            <label>水果</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="fruit">
                                    香蕉
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="fruit">
                                    苹果
                                </label>
                            </div>
                            <span class="help-block" id="fruit_message"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i> Input with error</label>
                            <input type="text" class="form-control" placeholder="Enter ..." name="buyanzheng">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" class="btn btn-info pull-right" id="submit_button">Cancel</button>
                        <button type="button" class="btn btn-info pull-right" id="reset_button">Sign in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</#macro>
<#macro layout_footerjs>
<script>
    $(function () {
        var form = $("#test_form_validate").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 10,
                    maxlength: 20
                },
                age: {
                    required: true,
                    min: 1,
                    max: 99
                },
                test: {
                    required: true
                },
                select: {
                    required: true
                },
                fruit: {
                    required: true
                },
                optionsRadios: {
                    required: true
                }
            },
            messages: {
                name: {
                    required: "请输入姓名",
                    minlength: "姓名的最小长度是10个字符",
                    maxlength: "姓名的最小长度是20个字符"
                },
                age: {
                    required: "请输入年龄",
                    min: "年龄最小为1岁",
                    max: "年龄最大为99岁"
                },
                test: {
                    required: "请输入test"
                },
                select: {
                    required: "请选择select"
                },
                fruit: {
                    required: "请选择至少一种水果"
                },
                optionsRadios: {
                    required: "请选择茶叶类型"
                }
            },
            debug: true,
            errorPlacement: function(error, element) {
                message_id = element.attr("name") + "_message";
                form_group_id = element.attr("name") + "_form_group";
                error.appendTo($("#" + message_id));
                $("#" + form_group_id).addClass("has-error");
            }
        });

        $("#submit_button").click(function () {
            result = form.form();
            if (!result) {
            }
        });

        $("#reset_button").click(function () {
            form.resetForm();
        });
    });
</script>
</#macro>
<#include "${layout_admin_path}/layout.ftl">