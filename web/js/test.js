jQuery(document).ready(function () {
    $("#test").click(function (check) {
        check.preventDefault();
        $.ajax({
            url: "../testServlet",
            data: {
                "username": $(".username").val(),
                "password": $(".password").val(),
                "type":"login"
            },
            type: "POST",
            dataType: "text",
            success: function (result) {
                if (result == "WRONG")
                {
                    $(".errorMessage").html("Wrong Password");
                }
                else
                {
                    window.location.href = "http://www.baidu.com";
                }
            }
        });
    });
});
