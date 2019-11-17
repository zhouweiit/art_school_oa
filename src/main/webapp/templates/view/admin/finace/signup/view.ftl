<#include "${layout_admin_path}/layout_macro.ftl">
<#macro layout_content>
<#--内容的头信息-->
<section class="content-header">
    <h4>
        报名续费
        <small></small>
    </h4>
</section>
<#--内容的主题信息-->
<section class="content">
    <div class="box box-warning">
        <form class="form-horizontal">
            <div class="box-header with-border">
                学员信息
            </div>
            <div class="box-body">
                <div class="form-group">
                    <label class="col-md-1 control-label">姓名：</label>
                    <div class="col-md-1">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="">
                    </div>
                    <div class="col-md-3">
                        <span class="help-block" id=""></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">联系人：</label>
                    <div class="col-md-1">
                        <select class="form-control" name="select">
                            <option value="">请选择</option>
                            <option value="1">爸爸</option>
                            <option value="2">妈妈</option>
                            <option value="3">爷爷</option>
                            <option value="4">奶奶</option>
                            <option value="5">外公</option>
                            <option value="5">外婆</option>
                            <option value="5">其他</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <span class="help-block" id=""></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">手机号码：</label>
                    <div class="col-md-2">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="">
                    </div>
                    <div class="col-md-3">
                        <span class="help-block" id=""></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">性别：</label>
                    <div class="col-md-1">
                        <div style="margin-top: 5px;">
                            <label>
                                <input type="radio" name="optionsRadios" value="option2" checked>男
                            </label>
                            &nbsp;&nbsp;
                            <label>
                                <input type="radio" name="optionsRadios" value="option2">女
                            </label>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <span class="help-block" id=""></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">住址：</label>
                    <div class="col-md-3">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="">
                    </div>
                    <div class="col-md-3">
                        <span class="help-block" id=""></span>
                    </div>
                </div>
            </div>
            <div class="box-header with-border">
                购买项目
            </div>
            <div class="box-body">
                <div class="form-group">
                    <div class="col-md-1">
                        <button type="button" class="btn btn-default btn-warning">选择课程</button>
                    </div>
                </div>
            </div>
            <div class="box-header with-border">
                费用结算
            </div>
            <div class="box-body">
                <div class="form-group">
                    <label class="col-md-1 control-label"></label>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
            <div class="box-footer">
                <div class="col-md-1"></div>
                <div class="col-md-2">
                    <button type="button" class="btn btn-info pull-right" style="margin-left: 10px;">提交</button>
                    <button type="button" class="btn btn-default pull-right">取消</button>
                </div>
            </div>
        </form>
    </div>
</section>
</#macro>
<#include "${layout_admin_path}/layout.ftl">