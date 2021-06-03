<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/3
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="referrer" content="no-referrer" />
<head>
    <title>登陆界面</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <form class="form-signin" action="logincheck" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <label for="username" class="sr-only">用户名</label>
        <input type="username" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
  </body>
</html>
<script>
    var errori='<%=request.getParameter("error")%>';
    if(errori=='yes'){
        alert("睡醒了没!");
    }
</script>