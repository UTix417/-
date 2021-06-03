package Servlet.xk;
import java.io.*;
import java.sql.*;

import Servlet.jdbc;
import domain.xinxi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(name="chaxunkecheng",value="/cxkc")
public class chaxunkecheng extends HttpServlet{
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        jdbc temp=new jdbc();
        temp.DBconnect();
        String xh= (String) request.getSession().getAttribute("username");
        String sql1="select * from U where LX=4;";
        ResultSet rs1=temp.DBquery(sql1);
        request.setAttribute("r1",rs1);
        request.setAttribute("r2",rs1);
        int r3=0,r4=0;
        float r5=0;
        request.setAttribute("r3",r3);
        request.setAttribute("r4",r4);
        request.setAttribute("r5",r5);
        String kh=request.getParameter("kh");
        String gh=request.getParameter("gh");
        String sksj=request.getParameter("sksj");
        String xq= xinxi.xq;
        String sql="select xq,kh,gh,sksj from O where(xq='"+xq+"'";
        if(!kh.equals("")){
            sql+=" and ";
            sql+="kh='"+kh+"'";
        }
        if(!gh.equals("")){
            sql+=" and ";
            sql+="gh='"+gh+"'";
        }
        if(!sksj.equals("")){
            sql+=" and ";
            sql+="sksj='"+sksj+"'";
        }
        sql+=");";
        ResultSet rs=temp.DBquery(sql);
        request.setAttribute("r1",rs);
        sql1="select xf,jd from E where(xh='"+xh+"');";
        rs=temp.DBquery(sql1);
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            float jd=0;
            int xf= 0;
            try {
                xf = rs.getInt("xf");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                jd=rs.getFloat("jd");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            r4+=xf;
            if(jd!=0){
                r3+=xf;
                r5+=xf*jd;
            }
        }
        r5/=r4;
        request.setAttribute("r3",r3);
        request.setAttribute("r4",r4);
        request.setAttribute("r5",r5);
        sql1="select * from E where xh='"+xh+"';";
        rs=temp.DBquery(sql1);
        request.setAttribute("r2",rs);
        request.getRequestDispatcher("/xk.jsp").forward(request,response);
        temp.disconnect();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void destroy(){

    }
}
