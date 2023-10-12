import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
 
public class admin extends JFrame implements ActionListener{
    JFrame Admin;
    Font font_100_bold = new Font("Serif", Font.BOLD, 60);
    Font font_30_bold = new Font("Serif", Font.BOLD, 30);
    Color blue=new Color(0, 0, 204);
    Color black=new Color(0,0,0);
    Color white =new Color(255,255,255);


    JLabel name, logo_images, TotalBookslabel, TotalStudentlabel, TotalIssuedBookslabel, TotalDepartmentlabel,
    TotalPublicerlabel, Requirementlabel, TotalStafflabel, TotalBookAvailablelabel,TotalBookslabeltext, TotalStudentlabeltext, TotalIssuedBookslabeltext, TotalDepartmentlabeltext,
    TotalPublicerlabeltext, Requirementlabeltext, TotalStafflabeltext, TotalBookAvailablelabeltext, TotalBookAvailableicon, TotalBookslabelicon, TotalDepartmentlabelicon, Requirementlabelicon, TotalStafflabelicon,TotalStudentlabeltexticon, TotalIssuedBookslabelicon, TotalPublicerlabeltexticon;
    JButton logout, help;
    JScrollPane scrollableTable;
    JPanel heading_Panel, plain_Panel, dynamicpanel,sidepanel, TotalBooksPanel, TotalStudentPanel, TotalIssuedBooksPanel, TotalDepartmentPanel,
    TotalPublicerPanel, RequirementPanel, TotalStaffPanel, TotalBookAvailable;
    CardLayout cardlayoutinstance;
    JMenu menubar;
    JMenuItem addbook, viewbook, removebook, updatebook, viewpublication, addpublication, removepublication, updatepublication,
    viewstudent, addstudent, removestudent, updatestudent, viewstaff, addstaff, removestaff, updatestaff, helpItem, dashboaderItem, requirItem, adminItem, adddepartment, viewdepartment, updatedepartment, removedepartment;
    JMenu requirementmenu, helpmenu, adminmenu, dashboardmenu;
    ImageIcon icon;

    admin(){
        Admin=new JFrame();
        Admin.setTitle("Admin Dashboard");
        
        heading_Panel=new JPanel();
        heading_Panel.setBounds(20,15,1450, 100);
        heading_Panel.setBackground(Color.LIGHT_GRAY);
        plain_Panel=new JPanel();
        plain_Panel.setBounds(20,0,1450, 100);
        plain_Panel.setBackground(Color.WHITE);   
        Admin.setSize(1500, 800);
        icon=new ImageIcon("images/logo.png");
        logo_images=new JLabel(icon);
        logo_images.setBounds(30,20,80,65);
        name=new JLabel("Tahzeeb");
        name.setBounds(150,20,150,60);
        //...........................................................
        icon=new ImageIcon("images/exit-logo-for-panel.png");
        logout=new JButton("LOGOUT", icon);
        logout.setBounds(1310, 20, 150, 35);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
       //.............................................................
        JMenuBar menubar=new JMenuBar();
        menubar.setBounds(320,61,1100,40);
        menubar.setBackground(Color.WHITE);
        dashboardmenu=new JMenu("     DASHBOARD    ");
        JMenu settingmenu=new JMenu("   SETTING    ");
        adminmenu=new JMenu("     ADMIN   ");
        JMenu bookmenu=new JMenu("     BOOKS    ");
        JMenu staffmenu=new JMenu("   STAFF    ");
        JMenu publicationmenu=new JMenu("     PUBLICATIONS   ");
        JMenu departmentmenu=new JMenu("        DEPARTMENT      ");
        requirementmenu=new JMenu("     REQUIREMENT    ");
        JMenu studentmenu=new JMenu("   STUDENTS    ");
        JMenu overduemenu=new JMenu("     OVERDUE   ");
        helpmenu=new JMenu("     HELP   ");
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        addbook=new JMenuItem("ADD");
        viewbook=new JMenuItem("VIEW ALL");
        removebook=new JMenuItem("REMOVE ");
        updatebook=new JMenuItem("UPDATE");
        icon=new ImageIcon("images/viewbook.png");
        viewbook.setIcon(icon);
        icon=new ImageIcon("images/addbook.png");
        addbook.setIcon(icon);
        icon=new ImageIcon("images/updatebook.png");
        updatebook.setIcon(icon);
        icon=new ImageIcon("images/deletebook.png");        
        removebook.setIcon(icon);
        bookmenu.add(viewbook);
        bookmenu.add(addbook);
        bookmenu.add(removebook);
        bookmenu.add(updatebook);
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        viewpublication=new JMenuItem("VIEW ALL");
        addpublication=new JMenuItem("ADD");
        removepublication=new JMenuItem("REMOVE ");
        updatepublication=new JMenuItem("UPDATE");
        icon=new ImageIcon("images/viewnormal.png");
        viewpublication.setIcon(icon);
        icon=new ImageIcon("images/addnormal.png");
        addpublication.setIcon(icon);
        icon=new ImageIcon("images/deletenormal.png");
        removepublication.setIcon(icon);
        icon=new ImageIcon("images/updatenormal.png");   
        updatepublication.setIcon(icon);
        publicationmenu.add(viewpublication);
        publicationmenu.add(addpublication);
        publicationmenu.add(removepublication);
        publicationmenu.add(updatepublication);
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        viewstudent=new JMenuItem("VIEW ALL");
        addstudent=new JMenuItem("ADD");
        removestudent=new JMenuItem("REMOVE ");
        updatestudent=new JMenuItem("UPDATE");
        icon=new ImageIcon("images/view.png");
        viewstudent.setIcon(icon);
        icon=new ImageIcon("images/update.png");
        updatestudent.setIcon(icon);
        icon=new ImageIcon("images/delete.png");
        removestudent.setIcon(icon);
        icon=new ImageIcon("images/add.png");
        addstudent.setIcon(icon);
        studentmenu.add(viewstudent);
        studentmenu.add(addstudent);
        studentmenu.add(removestudent);
        studentmenu.add(updatestudent);
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------

        viewstaff=new JMenuItem("VIEW ALL");
        addstaff=new JMenuItem("ADD");
        removestaff=new JMenuItem("REMOVE ");
        updatestaff=new JMenuItem("UPDATE");
        icon=new ImageIcon("images/view.png");
        viewstaff.setIcon(icon);
        icon=new ImageIcon("images/update.png");
        updatestaff.setIcon(icon);
        icon=new ImageIcon("images/delete.png");
        removestaff.setIcon(icon);
        icon=new ImageIcon("images/add.png");
        addstaff.setIcon(icon);
        staffmenu.add(viewstaff);
        staffmenu.add(addstaff);
        staffmenu.add(removestaff);
        staffmenu.add(updatestaff);
        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
        adminItem=new JMenuItem("ADMIN PANEL");
        adminmenu.add(adminItem);
        dashboaderItem=new JMenuItem("DASHBOARD PANEL");
        dashboardmenu.add(dashboaderItem);
        requirItem=new JMenuItem("REQUIREMENT PANEL");
        requirementmenu.add(requirItem);
        helpItem=new JMenuItem("HELP PANEL");
        helpmenu.add(helpItem);
        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        adddepartment=new JMenuItem("ADD");
        viewdepartment=new JMenuItem("VIEW ALL");
        removedepartment=new JMenuItem("REMOVE ");
        updatedepartment=new JMenuItem("UPDATE");
icon=new ImageIcon("images/addnormal.png");
adddepartment.setIcon(icon);
icon=new ImageIcon("images/viewnormal.png");
viewdepartment.setIcon(icon);
icon=new ImageIcon("images/deletenormal.png");
removedepartment.setIcon(icon);
        icon=new ImageIcon("images/updatenormal.png");
        updatedepartment.setIcon(icon);
        departmentmenu.add(viewdepartment);
        departmentmenu.add(adddepartment);
        departmentmenu.add(removedepartment);
        departmentmenu.add(updatedepartment);
        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        dynamicpanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 40));
        dynamicpanel.setBackground(Color.GRAY);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
    
        //------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------
        // sidepanel=new JPanel();
        // sidepanel.setBackground(Color.GRAY);
        // sidepanel.setSize(420, 630);
        // sidepanel.setLocation(15, 115);
        //----------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------
        TotalBooksPanel=new JPanel();
        TotalBooksPanel.setBackground(white);
        TotalBooksPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalBooksPanel.setPreferredSize(new Dimension(350, 250));
        
        //----------------------------------------------------------------------------------
        TotalBookAvailable=new JPanel();
        TotalBookAvailable.setBackground(white);
        TotalBookAvailable.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalBookAvailable.setPreferredSize(new Dimension(350, 250));
        
        //----------------------------------------------------------------------------------
        TotalDepartmentPanel=new JPanel();
        TotalDepartmentPanel.setBackground(white);
        TotalDepartmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalDepartmentPanel.setPreferredSize(new Dimension(350, 250));
        //--------------------------------------------------------------------------------------
        TotalIssuedBooksPanel=new JPanel();
        TotalIssuedBooksPanel.setBackground(white);
        TotalIssuedBooksPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalIssuedBooksPanel.setPreferredSize(new Dimension(350, 250));
        
        //-----------------------------------------------------------------------------------------
        TotalStaffPanel=new JPanel();
        TotalStaffPanel.setBackground(white);
        TotalStaffPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalStaffPanel.setPreferredSize(new Dimension(350, 250));
        //--------------------------------------------------------------------------------------
        TotalStudentPanel=new JPanel();
        TotalStudentPanel.setBackground(white);
        TotalStudentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40)) ;
        TotalStudentPanel.setPreferredSize(new Dimension(350, 250));
        //--------------------------------------------------------------------------------------
        TotalPublicerPanel=new JPanel();
        TotalPublicerPanel.setBackground(white);
        TotalPublicerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        TotalPublicerPanel.setPreferredSize(new Dimension(350, 250));
        //--------------------------------------------------------------------------------------
        RequirementPanel=new JPanel();
        RequirementPanel.setBackground(white);
        RequirementPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40,40));
        RequirementPanel.setPreferredSize(new Dimension(350, 250));
        //--------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------

        help=new JButton("Help");
        help.setBounds(50,50,100,40);
        //-----------------------------------------------------------------------------------
        cardlayoutinstance=new CardLayout();


        Admin.setVisible(true);
        Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar.add(dashboardmenu);
        menubar.add(adminmenu);
        menubar.add(bookmenu);
        menubar.add(departmentmenu);
        menubar.add(publicationmenu);
        menubar.add(studentmenu);
        menubar.add(staffmenu);
        menubar.add(overduemenu);
        menubar.add(requirementmenu);
        menubar.add(settingmenu);
        menubar.add(helpmenu);
        
        
        Admin.add(menubar);
        Admin.add(dynamicpanel);
       // Admin.add(sidepanel);
        Admin.add(logo_images);
        //Admin.add(name);
       
        Admin.add(logout);
        Admin.add(plain_Panel);
        Admin.add(heading_Panel);

        logout.addActionListener(this);
        helpItem.addActionListener(this);
        requirItem.addActionListener(this);
        dashboaderItem.addActionListener(this);
        adminItem.addActionListener(this);
        viewbook.addActionListener(this);
        addbook.addActionListener(this);
        removebook.addActionListener(this);
        updatebook.addActionListener(this);
        viewstaff.addActionListener(this);
        addstaff.addActionListener(this);
        removestaff.addActionListener(this);
        updatestaff.addActionListener(this);
        viewstudent.addActionListener(this);
        addstudent.addActionListener(this);
        removestudent.addActionListener(this);
        updatestudent.addActionListener(this);
        viewpublication.addActionListener(this);
        addpublication.addActionListener(this);
        updatepublication.addActionListener(this);
        removepublication.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            Admin.dispose();
        }
        if(e.getSource()==dashboaderItem){
            System.out.println("dashboard");
            dynamicpanel.removeAll();
            //Total no of books Panel...........................................
            icon=new ImageIcon("images/totalbooks.png");
            TotalBookslabelicon=new JLabel(icon);
            TotalBookslabel=new JLabel("1125");
            TotalBookslabel.setFont(font_100_bold);
            TotalBookslabel.setForeground(black);
            TotalBookslabeltext=new JLabel("Total Books");
            TotalBookslabeltext.setFont(font_30_bold);
            TotalBookslabeltext.setForeground(black);
            //...................................................................
            //Total no of students panel.........................................\
            icon=new ImageIcon("images/student.png");
            TotalStudentlabeltexticon=new JLabel(icon);
            TotalStudentlabel=new JLabel("10526");
            TotalStudentlabel.setFont(font_100_bold);
            TotalStudentlabel.setForeground(black);
            TotalStudentlabeltext=new JLabel("Total Students");
            TotalStudentlabeltext.setFont(font_30_bold);
            TotalStudentlabeltext.setForeground(black);
            //....................................................................
            //Total no of books available.........................................
            icon=new ImageIcon("images/availablebook.png");
            TotalBookAvailableicon=new JLabel(icon);
            TotalBookAvailablelabel=new JLabel("456");
            TotalBookAvailablelabel.setFont(font_100_bold);
            TotalBookAvailablelabel.setForeground(black);
            TotalBookAvailablelabeltext=new JLabel("Available Books");
            TotalBookAvailablelabeltext.setFont(font_30_bold);
            TotalBookAvailablelabeltext.setForeground(black);
            //....................................................................
            //Total Issued Books..................................................
            icon=new ImageIcon("images/Bookissued.png");
            TotalIssuedBookslabelicon=new JLabel(icon);
            TotalIssuedBookslabel=new JLabel("5k");
            TotalIssuedBookslabel.setFont(font_100_bold);
            TotalIssuedBookslabel.setForeground(black);
            TotalIssuedBookslabeltext=new JLabel("Issued Books");
            TotalIssuedBookslabeltext.setFont(font_30_bold);
            TotalIssuedBookslabeltext.setForeground(black);
            //...................................................................
            //Total Departments..................................................
            icon=new ImageIcon("images/departments.png");
            TotalDepartmentlabelicon=new JLabel(icon);
            TotalDepartmentlabel=new JLabel("6");
            TotalDepartmentlabel.setForeground(black);
            TotalDepartmentlabel.setFont(font_100_bold);
            TotalDepartmentlabeltext=new JLabel("Departments");
            TotalDepartmentlabeltext.setForeground(black);
            TotalDepartmentlabeltext.setFont(font_30_bold);
            //....................................................................
            icon=new ImageIcon("images/publication.png");
            TotalPublicerlabeltexticon=new JLabel(icon);
            TotalPublicerlabel=new JLabel("20");
            TotalPublicerlabel.setForeground(black);
            TotalPublicerlabel.setFont(font_100_bold);
            TotalPublicerlabeltext=new JLabel("Publications");
            TotalPublicerlabeltext.setForeground(black);
            TotalPublicerlabeltext.setFont(font_30_bold);
            //....................................................................
            icon=new ImageIcon("images/requirement.png");
            Requirementlabelicon=new JLabel(icon);
            Requirementlabel=new JLabel("67");
            Requirementlabel.setForeground(black);
            Requirementlabel.setFont(font_100_bold);
            Requirementlabeltext=new JLabel("Requirements");
            Requirementlabeltext.setForeground(black);
            Requirementlabeltext.setFont(font_30_bold);
            //.....................................................................
            icon=new ImageIcon("images/staff.png");
            TotalStafflabelicon=new JLabel(icon);
            TotalStafflabel=new JLabel("56");
            TotalStafflabel.setForeground(black);
            TotalStafflabel.setFont(font_100_bold);
            TotalStafflabeltext=new JLabel("Library Staff");
            TotalStafflabeltext.setForeground(black);
            TotalStafflabeltext.setFont(font_30_bold);
            //......................................................................
            TotalBookAvailable.setBorder(BorderFactory.createLineBorder(black));
            TotalBookAvailable.add(TotalBookAvailableicon);
            TotalBookAvailable.add(TotalBookAvailablelabel);
            TotalBookAvailable.add(TotalBookAvailablelabeltext);
            //.......................................................................
            TotalStudentPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalStudentPanel.add(TotalStudentlabeltexticon);
            TotalStudentPanel.add(TotalStudentlabel);
            TotalStudentPanel.add(TotalStudentlabeltext);
            //........................................................................
            TotalBooksPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalBooksPanel.add(TotalBookslabelicon);
            TotalBooksPanel.add(TotalBookslabel);
            TotalBooksPanel.add(TotalBookslabeltext);
            //.........................................................................
            TotalIssuedBooksPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalIssuedBooksPanel.add(TotalIssuedBookslabelicon);
            TotalIssuedBooksPanel.add(TotalIssuedBookslabel);
            TotalIssuedBooksPanel.add(TotalIssuedBookslabeltext);
            //.........................................................................
            TotalDepartmentPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalDepartmentPanel.add(TotalDepartmentlabelicon);
            TotalDepartmentPanel.add(TotalDepartmentlabel);
            TotalDepartmentPanel.add(TotalDepartmentlabeltext);
            //.........................................................................
            RequirementPanel.setBorder(BorderFactory.createLineBorder(black));
            RequirementPanel.add(Requirementlabelicon);
            RequirementPanel.add(Requirementlabel);
            RequirementPanel.add(Requirementlabeltext);
            //.........................................................................
            TotalStaffPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalStaffPanel.add(TotalStafflabelicon);
            TotalStaffPanel.add(TotalStafflabel);
            TotalStaffPanel.add(TotalStafflabeltext);
            //.........................................................................
            TotalPublicerPanel.setBorder(BorderFactory.createLineBorder(black));
            TotalPublicerPanel.add(TotalPublicerlabeltexticon);
            TotalPublicerPanel.add(TotalPublicerlabel);
            TotalPublicerPanel.add(TotalPublicerlabeltext);
            //.........................................................................
            dynamicpanel.add(TotalBooksPanel);
            dynamicpanel.add(TotalDepartmentPanel);
            dynamicpanel.add(TotalStaffPanel);
            dynamicpanel.add(TotalStudentPanel);
            dynamicpanel.add(TotalBookAvailable);
            dynamicpanel.add(TotalIssuedBooksPanel);
            dynamicpanel.add(TotalPublicerPanel);
            dynamicpanel.add(RequirementPanel);
            //..........................................................................
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==helpItem){
            System.out.println("help");
        }
        if(e.getSource()==adminItem){
            System.out.println("admin");
            String data[][]={ {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"}

          };    
          String column[]={"ID","NAME","SALARY"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(true); 
JScrollPane sp=new JScrollPane(jt);  
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==requirItem){
            System.out.println("require");
            Admin.remove(this.dynamicpanel);
            Admin.setBackground(black);
            Admin.revalidate();
            Admin.repaint();
        }
        if(e.getSource()==viewbook){
            System.out.println("viewbook");
            String data[][]={ {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"}

          };    
          String column[]={"ID","NAME","SALARY"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(true); 
JScrollPane sp=new JScrollPane(jt);  
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
            
        }
        if(e.getSource()==addbook){
            System.out.println("addbook");
            
            Admin.validate();
        }
        if(e.getSource()==removebook){
            System.out.println("removebook");
        }
        if(e.getSource()==updatebook){
            System.out.println("updatebook");
        }
        if(e.getSource()==viewpublication){
            System.out.println("viewPublication");
            String data[][]={ {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"},
            {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"}

          };    
          String column[]={"ID","NAME","SALARY"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(true); 
JScrollPane sp=new JScrollPane(jt);  
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==addpublication){
            System.out.println("addpublication");
        }
        if(e.getSource()==updatepublication){
            System.out.println("updatepublication");
        }
        if(e.getSource()==removepublication){
            System.out.println("removepublication");
            dynamicpanel.removeAll();
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==viewstaff){
            System.out.println("viewstaff");
        }
        if(e.getSource()==removestaff){
            System.out.println("removestaff");
        } 
        if(e.getSource()==updatestaff){
            System.out.println("updatestaff");
        }
        if(e.getSource()==addstaff){
            System.out.println("addstaff");
        }
        if(e.getSource()==viewstudent){
            System.out.println("viewstudent");
        }
        if(e.getSource()==removestudent){
            System.out.println("removestudent");
        }
        if(e.getSource()==updatestudent){
            System.out.println("updatestudent");
        }
        if(e.getSource()==addstudent){
            System.out.println("addstudent");
        }
    }
    public static void main(String args[]){
        admin adminobj=new admin();
    }
}