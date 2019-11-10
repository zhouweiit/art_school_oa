<script>
$.validator.setDefaults({
    debug: true,
    errorPlacement: function(error, element) {
        message_id = element.attr("name") + "_message";
        form_group_id = element.attr("name") + "_form_group";
        error.appendTo($("#" + message_id));
        $("#" + form_group_id).addClass("has-error");
    },
});
</script>