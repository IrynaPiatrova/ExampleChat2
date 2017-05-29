$(document).ready(function () {
    $("#btn-chat").click(function (event) {
        if($('#btn-input').text.length != 0) {
            $.post("chat", $("#msgForm").serialize());
            $('#btn-input').val('');
            ajaxRequest();
        }
    });
});
function ajaxRequest() {
    $.ajax({
        type: "post",
        url: "/chat",
        async: true,
        dataType: "html",
        success: function (response) {
            console.log("response: " + response);
            var history = $('#panelMessage').html();
            if(history.length != 0){
                $("#panelMessage").html("");
                $("#panelMessage").html(history + response);
            }else {
                $("#panelMessage").html(response);
            }
        },
        error: function (XHR, status) {
            console.error("Err: " + status);
        }
    });
}
