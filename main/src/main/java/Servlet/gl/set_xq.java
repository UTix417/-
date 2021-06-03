package Servlet.gl;

import Servlet.jdbc;
import domain.xinxi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
@WebServlet(name="set_xq",value="/set_xq")
public class set_xq {
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        xinxi.xq=request.getParameter("xq");
        jdbc temp=new jdbc();
        temp.DBconnect();
        String sql="select * from C;";
        ResultSet res=temp.DBquery(sql);
        request.setAttribute("r2",res);
        sql="select * from M;";
        res=temp.DBquery(sql);
        request.setAttribute("r1",res);
        temp.disconnect();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void destroy(){

    }
}
