import java.sql.*;
public class setup{
    setup(){
        Connection c=null;
        Statement stmt=null;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            stmt=c.createStatement();
            String sql="INSERT INTO login VALUES('dlfjs', 'GANDU', 'CEO');";
            stmt.executeUpdate(sql);
            c.close();
          }
        catch(Exception e){ 
            System.err.println(e);
            System.exit(0);
        }
    }
    public static void main(String args[]){
        setup insert=new setup();
    }
}