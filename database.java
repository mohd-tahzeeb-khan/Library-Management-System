import java.sql.*;
public class database{
    public void insert_bookINTOdb( String bookname, String isssn){
        Connection c=null;
        Statement stmt=null;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            stmt=c.createStatement();
            PreparedStatement sqlquery =null;
            String sql="INSERT INTO Books VALUES(?,?);";
            sqlquery.setStrng(1,bookname);
            sqlquery.setStrng(2,isssn);
            stmt.executeUpdate(sql);
            c.close();
          }
        catch(Exception e){ 
            System.err.println(e);
            System.exit(0);
        }
    }
    database(){
        Connection c=null;
        Statement stmt=null;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            stmt=c.createStatement();
            String sql="INSERT INTO login VALUES('', '', '', ????????);";
            stmt.executeUpdate(sql);
            c.close();
          }
        catch(Exception e){ 
            System.err.println(e);
            System.exit(0);
        }
    }
    public static void main(String args[]){
        database insert=new database();
    }
}