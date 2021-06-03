package Servlet;
import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import domain.xinxi;
import domain.yixuan;
@WebServlet(name="login_check",value="/logincheck")
public class logincheck extends HttpServlet{
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        jdbc temp=new jdbc();
        String xq=xinxi.xq;
        temp.DBconnect();
        String sql1="select * from U where LX=4;";
        ResultSet rs1=temp.DBquery(sql1);
        request.setAttribute("r1",rs1);
        request.setAttribute("r2",rs1);
        int r3=0,r4=0;
        float r5=0;
        request.setAttribute("r3",r3);
        request.setAttribute("r4",r4);
        request.setAttribute("r5",r5);
        String sql="select lx from U where(username='"+username+"' and password='"+password+"');";
        ResultSet rs=temp.DBquery(sql);
        HttpSession session=request.getSession();
        boolean flag=false;
        while(true){
            try {
                if (!rs.next()) break;
                int LX=rs.getInt("LX");
                //System.out.println(LX);
                session.setAttribute("username",username);
                session.setAttribute("LX",LX);
                session.setAttribute("xq",xq);
                if(LX==2){
                    sql="select * from C;";
                    ResultSet res=temp.DBquery(sql);
                    request.setAttribute("r2",res);
                    sql="select * from M;";
                    res=temp.DBquery(sql);
                    request.setAttribute("r1",res);
                    System.out.println("Root");
                    flag=true;
                    request.getRequestDispatcher("gl.jsp").forward(request,response);
                }else if(LX==1){
                    sql="select * from E where(gh='"+username+"' and xq='"+xq+"');";
                    ResultSet res=temp.DBquery(sql);
                    request.setAttribute("r1",res);
                    System.out.println("Teacher");
                    flag=true;
                    request.getRequestDispatcher("pk.jsp").forward(request,response);
                }else if(LX==0){
                    System.out.println("Student");
                    flag=true;
                    sql="select xf,jd from E where(xh='"+username+"');";
                    ResultSet res=temp.DBquery(sql);
                    while(res.next()){
                        float jd=0;
                        int xf=res.getInt("xf");
                        jd=res.getFloat("jd");
                        System.out.println(xf);
                        System.out.println(jd);
                        r4+=xf;
                        if(jd!=0){
                            r3+=xf;
                            r5+=xf*jd;
                        }
                    }
                    r5/=r3;
                    request.setAttribute("r3",r3);
                    request.setAttribute("r4",r4);
                    request.setAttribute("r5",r5);
                    sql="select * from O where xq='"+xq+"';";
                    res=temp.DBquery(sql);
                    request.setAttribute("r1",res);
                    sql="select * from E where xh='"+username+"';";
                    res=temp.DBquery(sql);
                    request.setAttribute("r2",res);
                    request.getRequestDispatcher("xk.jsp").forward(request,response);
                }
            } catch (SQLException | ServletException throwables) {
                throwables.printStackTrace();
            }
        }
        if(!flag){
            response.sendRedirect("login.jsp?error=yes");
        }
        temp.disconnect();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
    public void destroy(){
        System.out.println("login_check destoy!!!!!");
    }
}
