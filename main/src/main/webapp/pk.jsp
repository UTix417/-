<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/4
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教学管理</title>
    <meta charset="UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<Body>
    <div class="container">
        <form action="set_cj" method="post" class="form-signin">
            <table border="1" class="table table-bordered">
                <tr>
                    <td>课号</td>
                    <td>学号</td>
                    <td>平时成绩</td>
                    <td>考试成绩</td>
                    <td>平时成绩比例</td>
                </tr>
                <%
                    ResultSet rs= (ResultSet) request.getAttribute("r1");
                    while(true){
                        try{
                            if (!rs.next()) break;
                %>
                <tr>
                    <td><input type="text" name="kh" value=<%=rs.getString("kh")%> readonly></td>
                    <td><input type="text" name="xh" value=<%=rs.getString("xh")%> readonly></td>
                    <td><input type="text" name="pscj" value=<%=rs.getString("pscj")%>></td>
                    <td><input type="text" name="kscj" value=<%=rs.getString("kscj")%>></td>
                    <td><input type="text" name="bl" value=<%=rs.getFloat("pscjbl")%>></td>
                </tr>
                <%
                        }catch (SQLException throwables){
                            throwables.printStackTrace();
                        }
                    }
                %>
            </table>
            <input type="submit" value="提交">
        </form>
    </div>
  </Body>
</html>
