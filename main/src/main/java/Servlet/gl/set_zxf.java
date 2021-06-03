package Servlet.gl;

import Servlet.jdbc;
import domain.xinxi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.omg.CORBA.Request;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name="set_zxf",value = "/set_zxf")
public class set_zxf extends HttpServlet {
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        jdbc temp=new jdbc();
        temp.DBconnect();
        String[] zxf= request.getParameterValues("zxf");
        String[] xh=request.getParameterValues("xh");
        String xq= xinxi.xq;
        if(zxf!=null){
            for(int i=0;i<zxf.length;i++){
                String sql="update M set zxf='"+zxf[i]+"' where (xh='"+xh[i]+"' and xq='"+xq+"');";
                temp.DBupdate(sql);
            }
        }
        String sql="select * from C;";
        ResultSet res=temp.DBquery(sql);
        request.setAttribute("r2",res);
        sql="select * from M;";
        res=temp.DBquery(sql);
        request.setAttribute("r1",res);
        request.getRequestDispatcher("/gl.jsp").forward(request,response);
        temp.disconnect();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void destroy(){

    }
}
