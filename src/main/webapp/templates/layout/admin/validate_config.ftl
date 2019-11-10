<script>
$.validator.setDefaults({
    debug: true,
    errorPlacement: function(error, element) {
        message_id = element.attr("name") + "_message";
        form_group_id = element.attr("name") + "_form_group";
        error.appendTo($("#" + message_id));
        $("#" + form_group_id).addClass("has-error");
    },
    success: function(label) {
        id = label.attr("for"); <#-- 根据规律发现它的label有一个这个属性，所以拿来当ID用了 -->
        form_group_id = id + "_form_group";
        $("#" + form_group_id).removeClass("has-error");
    },
});
</script>