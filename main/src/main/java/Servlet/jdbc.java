package Servlet;
import java.sql.*;
public class jdbc {
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet res=null;
    final String url="jdbc:postgresql://124.70.53.230:26000/school";
    final String user="joe";
    final String password="ly@230851";
    //final String driver="org.postgresql.Driver";
    Driver driver = new org.postgresql.Driver();
    public void DBconnect(){
        try{
            //Class.forName(driver);
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void disconnect(){
        if(res!=null){
            try{
                res.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();

            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public int DBupdate(final String strSQL){
        System.out.println("SQL:>"+strSQL);
        try{
            stmt=conn.prepareStatement(strSQL);
            int affectedRows=stmt.executeUpdate();
            return affectedRows;
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public ResultSet DBquery(final String strSQL){
        System.out.println("SQL:>"+strSQL);
        try{
            stmt=conn.prepareStatement(strSQL);
            res=stmt.executeQuery();
            return res;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
