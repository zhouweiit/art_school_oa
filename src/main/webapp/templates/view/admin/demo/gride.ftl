<#include "${layout_admin_path}/layout_macro.ftl">
<#macro layout_content>
<#-- https://v3.bootcss.com/css/#grid-example-basic -->
<div class="row">
    <div class="col-xs-12 col-sm-6 col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
    <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
</div>
<div class="row">
    <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
    <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
    <!-- Optional: clear the XS cols if their content doesn't match in height -->
    <div class="clearfix visible-xs-block"></div>
    <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
</div>
<div class="row">
    ===========
</div>
<div class="row">
    <div class="col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
    <div class="col-md-4">.col-xs-6 .col-md-4</div>
</div>
<div class="row">
    <div class="col-sm-4">.col-xs-6 .col-sm-4</div>
    <div class="col-sm-4">.col-xs-6 .col-sm-4</div>
    <!-- Optional: clear the XS cols if their content doesn't match in height -->
    <div class="clearfix visible-xs-block"></div>
    <div class="col-sm-4">.col-xs-6 .col-sm-4</div>
</div>
</#macro>
<#macro layout_footerjs>
<script>
    $(function() {

    });
</script>
</#macro>
<#include "${layout_admin_path}/layout.ftl">