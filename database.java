import java.sql.*;
import java.util.*;
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
public void departmentINTOdb(String code, String name, String head,String date,String slogan, String email, String deptemail){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst1;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            try{
                pst1=c.prepareStatement("INSERT INTO department VALUES(?,?,?,?,?,?,?);");
                pst1.setString(1, code);
                pst1.setString(2, name);
                pst1.setString(3, head);
                pst1.setString(4, date);
                pst1.setString(5, slogan);
                pst1.setString(6, email);
                pst1.setString(7, deptemail);
                int i=pst1.executeUpdate();
                if(i<1){
                    JOptionPane.showMessageDialog(null, "Error, something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "New Department Added", "Acknowlegde!!", JOptionPane.INFORMATION_MESSAGE);
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
    public void publicationINTOdb(String name, String cin, String telephone,String inquerytele,String email, String inqueryemail, String fax, String noofbook, String program){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst1;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            try{
                pst1=c.prepareStatement("INSERT INTO publication VALUES(?,?,?,?,?,?,?,?,?);");
                pst1.setString(1, name);
                pst1.setString(2, cin);
                pst1.setString(3, telephone);
                pst1.setString(4, email);
                pst1.setString(5, fax);
                pst1.setString(6, noofbook);
                pst1.setString(7, fax);
                pst1.setString(8, inqueryemail);
                pst1.setString(9, inquerytele);
                int i=pst1.executeUpdate();
                if(i==0){
                    JOptionPane.showMessageDialog(null, "Error, something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "New Publication Added", "Acknowlegde!!", JOptionPane.INFORMATION_MESSAGE);
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
    public void staffINTOdb(String fname, String lname, String dob,String gender,String address, String phoneno, String college, String alterno, String joiningdate, String education, String jobtitle){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst1;
        ResultSet rs;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");      
            try{
                pst1=c.prepareStatement("INSERT INTO staff VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                pst1.setString(1, fname);
                pst1.setString(2, lname);
                pst1.setString(3, dob);
                pst1.setString(4, gender);
                pst1.setString(5, address);
                pst1.setString(6, phoneno);
                pst1.setString(7, college);
                pst1.setString(8, alterno);
                pst1.setString(9, joiningdate);
                pst1.setString(10, education);
                pst1.setString(11, jobtitle);
                int i=pst1.executeUpdate();
                if(i==0){
                    JOptionPane.showMessageDialog(null, "Error, something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "New Member Added", "Acknowlegde!!", JOptionPane.INFORMATION_MESSAGE);
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
//-----------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------
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
//--------------------------------Retrive Data Section----------------------------------
    public int[] retrive(){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement pst0, pst1, pst2, pst3, pst4, pst5, pst6;
        ResultSet rs0,rs1,rs2,rs3,rs4, rs5;
        int[] data=new int[5];
        try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db"); 
        pst0=c.prepareStatement("SELECT SUM(quantity) FROM books");
        pst1=c.prepareStatement("SELECT COUNT(*) FROM department");
        pst2=c.prepareStatement("SELECT COUNT(*) FROM publication");
        pst3=c.prepareStatement("SELECT COUNT(*) FROM students");
        pst4=c.prepareStatement("SELECT COUNT(*) FROM staff");
         
            rs0=pst0.executeQuery();
            rs1=pst1.executeQuery(); 
            rs2=pst2.executeQuery(); 
            rs3=pst3.executeQuery(); 
            rs4=pst4.executeQuery(); 
            //rs5=pst5.executeQuery(); 
            data[0]=rs0.getInt(1);
            data[1]=rs1.getInt(1);
            data[2]=rs2.getInt(1);
            data[3]=rs3.getInt(1);
            data[4]=rs4.getInt(1);
        // for(int i=0; i<5; i++){
        //     System.out.print(data[i]);
        // }
        
        return data;
        }
        catch(Exception e){
            System.out.println(e);
        }
         return data;
    }
//-------------------------------------------------------------------------------------------------------
    public ResultSet BooksRetrieve(){
        Connection c=null;
        Statement stmt=null;
        PreparedStatement ps1;
        ResultSet rs;
        rs=null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");
            ps1=c.prepareStatement("SELECT * FROM books");
            rs=ps1.executeQuery();
            return rs; 
        }catch(Exception e){
            System.out.println(e);return rs;
        }
        
    }
//----------------------------------------------------------------------------------------------------------------
public ResultSet StudentRetrieve(){
    Connection c=null;
    Statement stmt=null;
    PreparedStatement ps;
    ResultSet rs;
    rs=null;
    try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");
        ps=c.prepareStatement("SELECT * FROM students");
        rs=ps.executeQuery();
        return rs;
    }catch(Exception e){
        System.out.println(e);
        return rs;
    }
}
public ResultSet StaffRetrieve(){
    Connection c=null;
    Statement stmt=null;
    PreparedStatement ps;
    ResultSet rs;
    rs=null;
    try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");
        ps=c.prepareStatement("SELECT * FROM staff");
        rs=ps.executeQuery();
        return rs;
    }catch(Exception e){
        System.out.println(e);
        return rs;
    }
}
public ResultSet DepartmentRetrieve(){
    Connection c=null;
    Statement stmt=null;
    PreparedStatement ps;
    ResultSet rs;
    rs=null;
    try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");
        ps=c.prepareStatement("SELECT * FROM department");
        rs=ps.executeQuery();
        return rs;
    }catch(Exception e){
        System.out.println(e);
        return rs;
    }
}
public ResultSet PublicationRetrieve(){
    Connection c=null;
    Statement stmt=null;
    PreparedStatement ps;
    ResultSet rs;
    rs=null;
    try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:G:/Java Project/Library-Management-System/Library.db");
        ps=c.prepareStatement("SELECT * FROM publication");
        rs=ps.executeQuery();
        return rs;
    }catch(Exception e){
        System.out.println(e);
        return rs;
    }
}
    public static void main(String args[]){
        database insert=new database();
        //insert.bookINTOdb("dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,","dfgd,");
        //insert.insert_bookINTOdb("Lets Learn Python", "15785");
        //insert.retrive();
        // insert.BooksRetrieve();
    }
}