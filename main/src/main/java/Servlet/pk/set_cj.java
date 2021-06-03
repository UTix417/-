package Servlet.pk;

import Servlet.jdbc;
import domain.xinxi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name="set_cj",value = "/set_cj")
public class set_cj extends HttpServlet {
    public void init(){
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        jdbc temp=new jdbc();
        temp.DBconnect();
        String gh= (String) request.getSession().getAttribute("username");
        String xq= xinxi.xq;

        String[] kh= request.getParameterValues("kh");
        String[] xh=request.getParameterValues("xh");
        String[] pscj=request.getParameterValues("pscj");
        String[] kscj=request.getParameterValues("kscj");
        String[] bl=request.getParameterValues("bl");
        if(kh!=null){
            for(int i=0;i<kh.length;i++){
                String sql="update E set pscj='"+pscj[i]+"',kscj='"+kscj[i]+"',pscjbl='"+bl[i]+"' where(xh='"+xh[i]+"' and kh='"+kh[i]+"' and gh='"+gh+"' and xq='"+xq+"');";
                temp.DBupdate(sql);
            }
        }
        String sql="select * from E where(gh='"+gh+"' and xq='"+xq+"');";
        ResultSet res=temp.DBquery(sql);
        request.setAttribute("r1",res);
        request.getRequestDispatcher("/pk.jsp").forward(request,response);
        temp.disconnect();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void destroy(){

    }
}
