package domain;

import Servlet.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class yixuan {
    public static boolean check(String xh,String kh) throws SQLException {
        jdbc temp=new jdbc();
        temp.DBconnect();
        String xq=xinxi.xq;
        String sql1="select * from E where (xh='"+xh+"' and kh='"+kh+"' and xq='"+xq+"');";
        ResultSet rs1=temp.DBquery(sql1);
        if(rs1.next()){
            return true;
        }else{
            return false;

        }
    }
}
