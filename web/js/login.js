
function checkUsername() {
    var username = $("#username").val();
    if (username == null || username == "") {
        $("#usernameError").html("用户名为必填项");
        $("#usernameError").css("color", "red");
        return false;
    } else {
        $.get("getUserInfo", "username="+username,
            function (res) {
                res = eval("(" + res + ")");
                if (res != null) {
                    console.log(res);
                    $("#usernameError").html("该用户名已注册，可直接登陆");
                    $("#usernameError").css("color", "darkgreen");
                } else {
                    $("#usernameError").html("该用户名未注册");
                    $("#usernameError").css("color", "darkgreen");
                }
            }
        )
    }
    $("#usernameError").html("");
    return true;
}

function checkPassword() {
    var password = $("#password").val();
    if (password == null || password == "") {
        $("#passwordError").html("密码为必填项");
        return false;
    }
    $("#passwordError").html("");
    return true;
}

$(function () {

    $("#username").blur(function () {
        checkUsername();
    })

    $("#password").blur(function () {
        checkPassword();
    })

    $("#loginForm").submit(function () {
        return checkUsername() && checkPassword();
    })
});