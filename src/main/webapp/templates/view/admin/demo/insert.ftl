<#include "../../../layout/admin/layout_macro.ftl">
<#macro layout_content>
<div class="row">
    <div class="col-md-12">
        <!-- general form elements disabled -->
        <div class="box box-warning">
            <div class="box-header with-border">
                <h3 class="box-title">General Elements</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <form role="form">
                    <!-- text input -->
                    <div class="form-group has-success">
                        <label>成功示例</label>
                        <input type="text" class="form-control" placeholder="Enter ...">
                        <span class="help-block">Help block with success</span>
                    </div>

                    <div class="row"><#-- 表示一个容器独占一行，class = row -->
                        <div class="col-md-6"> <#-- 表示一个容器的宽度，class = col-md-x -->
                            <div class="form-group has-warning">
                                <label>警告示例</label>
                                <input type="text" class="form-control" placeholder="Enter ..." disabled>
                                <span class="help-block">Help block with warning</span>
                            </div>
                        </div>
                    </div>

                    <div class="row"><#-- 表示一个容器独占一行，class = row -->
                        <div class="col-md-3"> <#-- 表示一个容器的宽度，class = col-md-x -->
                            <div class="form-group has-warning">
                                <label>警告示例</label>
                                <input type="text" class="form-control" placeholder="Enter ...">
                                <span class="help-block">Help block with warning</span>
                            </div>
                        </div>
                    </div>

                    <!-- textarea -->
                    <div class="form-group has-error">
                        <label>简介</label>
                        <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                        <span class="help-block">Help block with error</span>
                    </div>

                    <!-- checkbox -->
                    <div class="form-group has-warning">
                        <label>上课时间</label>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">
                                周六
                            </label>
                            <label>
                                <input type="checkbox">
                                周日
                            </label>
                        </div>
                        <span class="help-block">请尽量选择周六</span>
                    </div>

                    <!-- radio -->
                    <div class="form-group has-success">
                        <label>学校</label>
                        <div class="radio">
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                分校一
                            </label>
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option1" checked>
                                分校二
                            </label>
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios3" value="option1" checked>
                                分校三
                            </label>
                        </div>
                        <span class="help-block">请选择学校</span>
                    </div>

                    <!-- select -->
                    <div class="row">
                        <div class="col-md-2">
                            <div class="form-group has-error">
                                <label>性别</label>
                                <select class="form-control">
                                    <option>男</option>
                                    <option>女</option>
                                    <option>未知</option>
                                </select>
                                <span class="help-block">请选择性别</span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1">
                            <div class="form-group">
                                <label>学龄</label>
                                <select class="form-control">
                                    <option>小学</option>
                                    <option>初中</option>
                                    <option>高中</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label>Select Disabled</label>
                                <select class="form-control" disabled>
                                    <option>option 1</option>
                                    <option>option 2</option>
                                    <option>option 3</option>
                                    <option>option 4</option>
                                    <option>option 5</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>
</#macro>
<#include "../../../layout/admin/layout.ftl">