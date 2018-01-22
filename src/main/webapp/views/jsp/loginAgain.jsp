<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link href="/views/css/login.css" rel="stylesheet">
</head>
<body>
<div id="box">
    <img src="/views/images/login.jpg" >
    <div class="position">
        <form action="http:localhost:8080/user/check" method="post" name="systemLogin">
            <p class="photo">
                <img src="/views/images/logo.png"> &nbsp;&nbsp; <span class="span">系统登录</span>
            </p><hr>
            <br>
            <p>
                用户名：<input type="text" name="name" placeholder="请输入您的用户名!" class="userNameId" required="required"/>
            </p>
            <p>
                密&nbsp;码：<input type="password" name="password" placeholder="请输入您的密码!" class="userNamePassword" required="required"/>
            </p>
            <p>
                <input type="checkbox" name="key">记住密码
            </p>
            <p>
                <button type="submit" id="butn">登陆</button>
                <button type="reset">重置</button>
                <button type="submit">注册</button>
            </p>
        </form>
    </div>
</div>
</body>
</html>
