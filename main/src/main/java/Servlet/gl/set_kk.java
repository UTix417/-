package Servlet.gl;

import Servlet.jdbc;
import domain.xinxi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name="set_kk",value="/set_kk")
public class set_kk extends HttpServlet {
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        jdbc temp=new jdbc();
        temp.DBconnect();
        String xq= xinxi.xq;
        String[] kk=request.getParameterValues("kk");
        String[] gh=request.getParameterValues("gh");
        String[] sksj=request.getParameterValues("sksj");
        String[] kh=request.getParameterValues("kh");
        System.out.println(kk.length);
        if(kk!=null){
            for(int i=0;i<kk.length;i++){
                String sql="insert into O values('"+xq+"','"+kh[Integer.parseInt(kk[i])]+"','"+gh[Integer.parseInt(kk[i])]+"','"+sksj[Integer.parseInt(kk[i])]+"');";
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
