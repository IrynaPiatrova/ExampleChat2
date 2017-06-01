$(document).ready(function () {
    ajaxRequest();
    $("#btn-chat ").click(function (event) {
        var mess = $('#btn-input').val();
        if (mess.length != 0) {
            /*alert(mess);*/
            $('#btn-input').val('');
            $.ajax({
                    type: 'POST',
                    url: '/chat',
                    data: {message: mess},
                    success: function (data) {
                        /*alert('successful');*/
                        ajaxRequest();
                    }
                }
            );
        }
    });
});
function ajaxRequest() {
    $.ajax({
        type: "POST",
        url: "/chat",
        async: true,
        dataType: "html",
        success: function (response) {
            console.log("response: " + response);
            $("#panelMessage").html(response);
        },
        error: function (XHR, status) {
            console.error("Err: " + status);
        }
    });
}
