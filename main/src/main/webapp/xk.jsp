<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/3
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="domain.yixuan" %>
<html>
<head>
    <title>选课系统</title>
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
        <table border="1" class="table table-bordered">
            <tr>
                <td>完成学分</td>
                <td>已选学分</td>
                <td>绩点</td>
            </tr>
            <%
                int r3= (int) request.getAttribute("r3");
                int r4= (int) request.getAttribute("r4");
                float r5=(float) request.getAttribute("r5");
            %>
            <tr>
                <td><%=r3%></td>
                <td><%=r4%></td>
                <td><%=r5%></td>
            </tr>
        </table>
        <form method="post" action="cxkc" class="form-signin">
            <label for="kh">课号</label>
            <input type="text" id="kh" name="kh" class="form-control">
            <label for="gh">工号</label>
            <input type="text" id="gh" name="gh" class="form-control">
            <label for="sksj">上课时间</label>
            <input type="text" id="sksj" name="sksj" class="form-control">
            <button class="btn btn-lg btn-primary btn-block" type="submit">查询</button>
        </form>
        <form method="post" action="deal_xk" class="form-signin">
            <table border="1" class="table table-bordered">
                <tr>
                    <td>学期</td>
                    <td>课号</td>
                    <td>工号</td>
                    <td>上课时间</td>
                    <td>选课</td>
                </tr>
                <%
                    ResultSet rs= (ResultSet) request.getAttribute("r1");
                    while(true){
                        try{
                            if (!rs.next()) break;
                            //if(rs.getString("xq").equals(request.getSession().getAttribute("xq"))){
                                String tt=rs.getString("xq")+"/"+rs.getString("kh")+"/"+rs.getString("gh");
                %>
                            <tr>
                                <td><%=rs.getString("xq")%></td>
                                <td><%=rs.getString("kh")%></td>
                                <td><%=rs.getString("gh")%></td>
                                <td><%=rs.getString("sksj")%></td>
                            <%
                                String xh= (String) request.getSession().getAttribute("username");
                                if(!yixuan.check(xh,rs.getString("kh"))){
                            %>
                                <td><input type="checkbox" name="xk" value=<%=tt%>></td>
                            </tr>
                <%
                            }
                        }catch (SQLException throwables){
                            throwables.printStackTrace();
                        }
                    }
                %>
            </table>
            <input type="submit" value="选课">
        </form>
        <form method="post" action="deal_tk" class="form-signin">
            <table border="1" class="table table-bordered">
                <tr>
                    <td>学期</td>
                    <td>课号</td>
                    <td>工号</td>
                    <td>退课</td>
                </tr>
                <%
                    ResultSet res= (ResultSet) request.getAttribute("r2");
                    while(true){
                        //System.out.println("table_cxyx");
                        try{
                            if (!res.next()) break;
                            String tt=res.getString("xq")+"/"+res.getString("kh")+"/"+res.getString("gh");
                            System.out.println(tt);
                %>
                            <tr>
                                <td><%=res.getString("xq")%></td>
                                <td><%=res.getString("kh")%></td>
                                <td><%=res.getString("gh")%></td>
                            <%
                                if(res.getString("xq").equals(request.getSession().getAttribute("xq"))&&res.getString("jd")==null){
                            %>
                                    <td><input type="checkbox" name="tk" value=<%=tt%>></td>
                                </tr>
                <%
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                    }
                %>
            </table>
            <input type="submit" value="退课">
        </form>
    </div>
  </Body>
</html>
