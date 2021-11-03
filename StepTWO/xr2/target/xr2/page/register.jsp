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
                <form class="form-validation" method="post" action="${ctx}/user/register">
                    <div class="msg">注册一个新的帐号</div>
                    <div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="email" class="form-control" name="email" maxlength="50" placeholder="邮箱" required>
                        </div>
                    </div>
                    <div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" maxlength="20"placeholder="密码" required>
                        </div>
                    </div>
                    <div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" id="confirm" placeholder="确认" required>
                        </div>
                    </div>
                    <div class="input-group form-group captcha">
                        <span class="input-group-addon">
                            <i class="material-icons">security</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="captcha" placeholder="验证码" required>
                        </div>
                        <img src="${asset}/img/captcha.png" alt="验证码">
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="terms" id="terms" class="filled-in chk-col-pink" required>
                        <label for="terms">已阅读和同意<a href="javascript:void(0);">用户使用协议</a></label>
                    </div>

                    <button class="btn btn-block btn-lg bg-pink waves-effect" type="submit">注册</button>

                    <div class="m-t-25 m-b--5 align-center">
                        <a href="${ctx}/page/login.jsp">已经注册过？</a>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <%@ include file="../WEB-INF/page/admin/common/foot.jsp" %>
    <script>
        addValidatorRules('.form-validation')
        $('#confirm').rules("add", {
            equalTo: '[name=password]'
        })
    </script>
</body>

</html>