import java.sql.*;

import javax.swing.JOptionPane;
public class database{
    public void bookINTOdb( String isbn, String bookname, String author,String publisher,String genre, String price, String publishedyear, String quantity, String langauage, String dateofentry, String format,String edition, String pages, String department ){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst1;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            try{
                pst1=c.prepareStatement("INSERT INTO Books VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                pst1.setString(1, isbn);
                pst1.setString(2, bookname);
                pst1.setString(3, author);
                pst1.setString(4, publisher);
                pst1.setString(5, genre);
                pst1.setString(6, price);
                pst1.setString(7, publishedyear);
                pst1.setString(8, quantity);
                pst1.setString(9, langauage);
                pst1.setString(10, dateofentry);
                pst1.setString(11, format);
                pst1.setString(12, edition);
                pst1.setString(13, pages);
                pst1.setString(14, department);
                int i=pst1.executeUpdate();
                if(i==0){
                    JOptionPane.showMessageDialog(null, "This is an error message.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "New Book Inserted", "Acknowlegde!!", JOptionPane.INFORMATION_MESSAGE);
                }
                c.commit();
                c.close();
          }
          catch(Exception E){
            System.out.print(E);
          }
            }
            
        catch(Exception e){ 
            System.err.println(e);
            System.exit(0);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------
    public void studentINTOdb(String registration, String enrollment, String name,String fathername,String dob, String gender, String contact, String altercontact, String roll, String program, String year,String semester, String department, String email ){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst1;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            try{
                pst1=c.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                pst1.setString(1, registration);
                pst1.setString(2, enrollment);
                pst1.setString(3, name);
                pst1.setString(4, fathername);
                pst1.setString(5, dob);
                pst1.setString(6, gender);
                pst1.setString(7, contact);
                pst1.setString(8, altercontact);
                pst1.setString(9, roll);
                pst1.setString(10, program);
                pst1.setString(11, year);
                pst1.setString(12, semester);
                pst1.setString(13, department);
                pst1.setString(14, email);
                int i=pst1.executeUpdate();
                if(i==0){
                    JOptionPane.showMessageDialog(null, "Error, something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "New Student Added", "Acknowlegde!!", JOptionPane.INFORMATION_MESSAGE);
                }
                c.commit();
                c.close();
                
          }
          catch(Exception E){
            System.out.print(E); 
          }
            }
            
        catch(Exception e){ 
            System.err.println(e);
            System.exit(0);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------

    // database(){
    //     Connection c=null;
    //     Statement stmt=null;
    //     ResultSet rs;
    //     try{
    //         Class.forName("org.sqlite.JDBC");
    //         c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
    //         stmt=c.createStatement();
    //         String sql="INSERT INTO login VALUES('', '', '', ????????);";
    //         stmt.executeUpdate(sql);
    //         c.close();
    //       }
    //     catch(Exception e){ 
    //         System.err.println(e);
    //         System.exit(0);
    //     }
    // }
    public static void main(String args[]){
        database insert=new database();
        insert.bookINTOdb("dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,");
        //insert.insert_bookINTOdb("Lets Learn Python", "15785");
    }
}