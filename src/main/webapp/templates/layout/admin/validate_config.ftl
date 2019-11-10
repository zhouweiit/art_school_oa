<script>
$.validator.setDefaults({
    debug: true,
    errorPlacement: function(error, element) { <#-- error并不是字符串，而是validate框架的一个label的标签，里面包含了错误信息，element是 -->
        message_id = element.attr("name") + "_message";
        form_group_id = element.attr("name") + "_form_group";
        error.appendTo($("#" + message_id));
        $("#" + form_group_id).addClass("has-error");
    },
    success: function(label) {  <#-- label是validate框架生成错误信息的label -->
        id = label.attr("for"); <#-- 根据规律发现它的label有一个这个属性，所以拿来当ID用了 -->
        form_group_id = id + "_form_group";
        $("#" + form_group_id).removeClass("has-error");
        label.remove(); <#-- 成功后，删除label，恢复样式 -->
    }
});
</script>