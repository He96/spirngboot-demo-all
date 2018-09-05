$(function () {
    //回车事件
    $('body').keyup(function (e) {
        var event = e || window.event;
        var code = event.keyCode || event.which || event.charCode;
        if (code == 13) {
            login();
        }
    });

    //登录
    $('#button').click(function () {
        login();
    });

    //提交登录信息
    function login() {
        checkForm();
        if ($('#loginForm').valid()) {
            console.log("验证通过");
            var data = $('#loginForm').formJson();
            console.log('data' + JSON.stringify(data));
            $.ajax({
                type: 'POST',
                url: 'loginInfo',
                data: JSON.stringify(data),
                success: function (result) {
                    if (result.code == 1) {
                        window.location.href = 'index';
                    }
                    if (result.code == -1) {
                        showModel("提示", result.msg);
                    }
                }
            });
        }
    }

    //表单验证
    function checkForm() {
        $('#loginForm').validate({
            rules: {
                //account:'required',
                //password:'required',
                account: {
                    required: true,
                    rangelength: [4, 16]
                },
                password: {
                    required: true,
                    minlength: 4
                }
            },
            messages: {
                account: {
                    required: '请输入用户名',
                    rangelength: '用户名长度有误(4-16字符以内)'
                },
                password: {
                    required: '请输入密码',
                    minlength: '密码长度不能少于4个字符'
                }
            }
        });
    }

});