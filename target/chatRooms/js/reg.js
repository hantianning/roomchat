layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,laydate = layui.laydate;

    //日期
    laydate.render({
        elem: '#birth'
    });

    //自定义验证规则
    form.verify({
       username: [
            /^[a-zA-Z0-9_]{4,12}$/,
               '用户名必须4-8位的字母、数字或下划线哦'
        ]
        ,password: [
            /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,12}$/
            ,'密码必须6到12位，字母加数字'
        ]
        ,passagain: function (value) {
            var val = $('#password').val();
            if(value != val){
                return '两次密码输入不相符！'
            }
        }
        ,phone:[
            /^1[3456789]\d{9}$/
            ,'手机号码格式错误！'
        ]
    });


    //监听提交
    form.on('submit(register)', function(data) {
        var user = data.field;
        var url = 'user/regInfo.do';
        console.log('>>>  ', user);
        $.ajax({
            url: url,
            data: user,
            type: "POST",
            dataType: "JSON",
            success: function (result) {
                console.log('注册返回值', result)
                console.log('注册返回值', result.state == 3001)
                if (result.state == 200) {
                    layer.msg('注册成功', {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 6,
                        time : 1500
                    });
                    setTimeout(function () {
                        window.location.href = 'main.do';
                    }, 1500);
                    return false;
                } else if (result.state == 3001 || result.state == 3000) {
                    layer.msg(result.message, {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 7,
                        shift : 6, //抖动效果
                        time : 1500
                    });
                    return false;
                } else if (result.state == 3003) {
                    layer.msg(result.message, {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 5,
                        shift : 6, //抖动效果
                        time : 1500
                    });
                    return false;
                }
            }
        })
        return false;
    });
});
