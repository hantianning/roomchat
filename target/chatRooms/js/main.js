layui.use(['form'], function(){
    var form = layui.form
        ,layer = layui.layer;


    //自定义验证规则
    form.verify({
        phone: [
            /^[a-zA-Z0-9_]{4,12}$/,
            '用户名必须4-8位的字母、数字和下划线哦'
        ]
        ,password: [
            /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,12}$/
            ,'密码必须6到12位，字母加数字'
        ]
    });


    //监听读者登录
    form.on('submit(login)', function(data){
        console.log(data.field);
        var user = data.field;
        var url = 'user/login.do';
        console.log('>>>  ',user);
        $.ajax({
            url : url,
            data: user,
            type: "POST",
            dataType: "JSON",
            success: function (result) {
                console.log('注册返回值',result)
                if (result.state == 200){
                    layer.msg('登录成功',{
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 6,
                        time : 1000
                    })
                    setTimeout(function () {
                        window.location.href = 'index.do';
                    },1000)
                    return false;
                }else if (result.state == 3002 || result.state == 3004) {
                    layer.msg(result.message, {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 7,
                        shift : 6, //抖动效果
                        time : 1500
                    });
                    return false;
                }else{
                    layer.msg("网络异常，请联系管理员！", {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 7,
                        shift : 6, //抖动效果
                        time : 1500
                    });
                    return false;
                }
            }
        })
        return false;
    });

    //监听管理员登录
    form.on('submit(logManager)', function(data){
        console.log(data.field);
        var user = data.field;
        var url = 'user/logManager.do';
        console.log('>>>  ',user);
        $.ajax({
            url : url,
            data: user,
            type: "POST",
            dataType: "JSON",
            success: function (result) {
                console.log('注册返回值',result)
                if (result.state == 200){
                    layer.msg('登录成功',{
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 6,
                        time : 1000
                    })
                    setTimeout(function () {
                        window.location.href = 'index.do';
                    },1000)
                    return false;
                }else if (result.state == 3002 || result.state == 3004) {
                    layer.msg(result.message, {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 7,
                        shift : 6, //抖动效果
                        time : 1500
                    });
                    return false;
                }else{
                    layer.msg("网络异常，请联系管理员！", {
                        //1:正确；2:错误；3:询问；4:锁定；5:失败；6：成功；7:警告；16：加载
                        icon : 7,
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