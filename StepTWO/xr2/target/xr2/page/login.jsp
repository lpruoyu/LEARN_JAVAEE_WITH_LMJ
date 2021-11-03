<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>小码哥简历管理-登录</title>
    <%@ include file="../WEB-INF/page/admin/common/head.jsp" %>
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="javascript:void(0);"><b>小码哥简历管理</b></a>
            <small>您身边最好用的简历助手</small>
        </div>
        <div class="card">
            <div class="body">
                <form class="form-validation" method="post" action="${ctx}/user/login">
                    <div class="msg">赶紧登录吧</div>
                    <div class="input-group form-group form-float">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="email" class="form-control" name="email" maxlength="50"
                                   placeholder="邮箱" required autofocus
                                   value="mj@qq.com">
                        </div>
                    </div>
                    <div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input id="fakePassword" type="password" class="form-control"
                                   placeholder="密码" required
                                   value="Mj123456">
                            <input id="realPassword" type="hidden" name="password">
                        </div>
                    </div>
                    <div class="input-group form-group captcha">
                        <span class="input-group-addon">
                            <i class="material-icons">security</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="captcha"
                                   placeholder="验证码" required
                                   value="1234">
                        </div>
                        <img src="${asset}/img/captcha.png" alt="验证码">
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">记住密码</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">登录</button>
                        </div>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6">
                            <a href="${ctx}/page/register.jsp">现在注册</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <%@ include file="../WEB-INF/page/admin/common/foot.jsp" %>
    <script src="${plugin}/JavaScript-MD5/md5.min.js"></script>
    <script>
        addValidatorRules('.form-validation', () => {
            $('#realPassword').val(md5($('#fakePassword').val()))
            return true
        })
    </script>
</body>

</html>