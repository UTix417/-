<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/4
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="domain.xinxi" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎你管理员</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<Body>
    <div class="container">
        <form action="set_xq" method="post" class="form-signin">
            <label for="xq">学期</label>
            <input type="text" id="xq" name="xq" class="form-control">
            <button class="btn btn-lg btn-primary btn-block" type="submit">设置</button>
        </form>

        <form action="set_zxf" method="post" class="form-signin">
            <table border="1" class="table table-bordered">
                <tr>
                    <td>学号</td>
                    <td>学期</td>
                    <td>学分</td>
                </tr>
                <%
                    String xq= xinxi.xq;
                    ResultSet rs= (ResultSet) request.getAttribute("r1");
                    while(true){
                        try{
                            if (!rs.next()) break;
                %>
                <tr>
                    <td><input type="text" name="xh" value=<%=rs.getString("xh")%> readonly></td>
                    <td><input type="text" name="xh" value=<%=xq%> readonly></td>
                    <td><input type="text" name="zxf" value=<%=rs.getString("xfsx")%>></td>
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
        <form action="set_kk" method="post" class="form-signin">
            <table border="1" class="table table-bordered">
                <tr>
                    <td>课号</td>
                    <td>课名</td>
                    <td>学分</td>
                    <td>学时</td>
                    <td>院系号</td>
                    <td>开课</td>
                    <td>工号</td>
                    <td>上课时间</td>
                </tr>
                <%
                    ResultSet res= (ResultSet) request.getAttribute("r2");
                    int i=0;
                    while(true){
                        try{
                            if (!res.next()) break;
                            //if(rs.getString("xq").equals(request.getSession().getAttribute("xq"))){
                            String tt=res.getString("kh");
                %>
                <tr>
                    <td><input type="text" name="kh" readonly value=<%=res.getString("kh")%>></td>
                    <td><%=res.getString("km")%></td>
                    <td><%=res.getString("xf")%></td>
                    <td><%=res.getString("xs")%></td>
                    <td><%=res.getString("yxh")%></td>
                    <td><input type="checkbox" name="kk" value=<%=i%>></td>
                    <td><input type="text" name="gh"></td>
                    <td><input type="text" name="sksj"></td>
                </tr>
                <%
                            i++;
                        }catch (SQLException throwables){
                            throwables.printStackTrace();
                        }
                    }
                %>
            </table>
            <input type="submit" value="开课">
        </form>
    </div>
  </Body>
</html>
