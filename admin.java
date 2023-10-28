import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;
 
public class admin extends JFrame implements ActionListener{
    //--------------------------------------------------------------------------------------------------------------------
    JFrame Admin;
    Font font_100_bold = new Font("Serif", Font.BOLD, 60);
    Font font_30_bold = new Font("Serif", Font.BOLD, 30);
    Font font_20_bold = new Font("Serif", Font.BOLD, 20);
    Font font_15_bold = new Font("Serif", Font.BOLD, 15);
    Font font_10_bold = new Font("Serif", Font.BOLD, 10);
    Color grey=new Color(200, 200, 200);
    Color black=new Color(0,0,0);
    Color white =new Color(255,255,255);
//--------------------------------------------------------------------------------------------------------------------

    JLabel name, logo_images, TotalBookslabel, TotalStudentlabel, TotalIssuedBookslabel, TotalDepartmentlabel,
    TotalPublicerlabel, Requirementlabel, TotalStafflabel, TotalBookAvailablelabel,TotalBookslabeltext, TotalStudentlabeltext, TotalIssuedBookslabeltext, TotalDepartmentlabeltext,
    TotalPublicerlabeltext, Requirementlabeltext, TotalStafflabeltext, TotalBookAvailablelabeltext, TotalBookAvailableicon, TotalBookslabelicon, TotalDepartmentlabelicon, Requirementlabelicon, 
    TotalStafflabelicon,TotalStudentlabeltexticon, TotalIssuedBookslabelicon, TotalPublicerlabeltexticon, 
    //---------------------------------------------------------------------------------------------------------------
    RegistrationNo, usno, Name, Fathername, DOB, year, semester, Department, contactno, altercontactno, age, gender, emailid, Classrollno, Program,
    //--------------------------------------------------------------------------------------------------------------------
    publicationname, publicationtel, publicationfax, publicationemail, publicationinqueryemail, publicationadd, publicationnoofbooks, publicationscin, publicationinqueryno;
    //--------------------------------------------------------------------------------------------------------------------
    JTextField RegistrationNofield, usnofield, Namefield, Fathernamefield, DOBfield, contactnofield, altercontactnofield, agefield, emailidfield, Classrollnofield,
               publicationnamefiled, publicationcinfield, publicationemailfield, publicationinqueryemailfield, publicationinquerynoField, publicationfaxfield,publicationnofield, publicationnoofbookdfield;
    //--------------------------------------------------------------------------------------------------------------------
    JRadioButton malegender, femalegender, transgender;
    //--------------------------------------------------------------------------------------------------------------------
    JComboBox<String> departmentComboBox, ProgramComboBox, SemesterComboBox, YearComboBox;
    //--------------------------------------------------------------------------------------------------------------------
    JCheckBox notesCheckBox;
    //--------------------------------------------------------------------------------------------------------------------
    JButton logout, help, RegisterStudent, Cancel, Clear, addpublicationJButton;
    //---------------------------------------------------------------------------------------------------------------------
    ButtonGroup grp=new ButtonGroup();
    //---------------------------------------------------------------------------------------------------------------------
    JScrollPane scrollableTable;
    //--------------------------------------------------------------------------------------------------------------------
    JPanel heading_Panel, plain_Panel, dynamicpanel,sidepanel, TotalBooksPanel, TotalStudentPanel, TotalIssuedBooksPanel, TotalDepartmentPanel,
    TotalPublicerPanel, RequirementPanel, TotalStaffPanel, TotalBookAvailable;
    //--------------------------------------------------------------------------------------------------------------------
    CardLayout cardlayoutinstance;
    //--------------------------------------------------------------------------------------------------------------------
    JToolTip tip;
    //--------------------------------------------------------------------------------------------------------------------
    JMenu menubar;
    JMenuItem addbook, viewbook, removebook, updatebook, viewpublication, addpublication, removepublication, updatepublication,
    viewstudent, addstudent, removestudent, updatestudent, viewstaff, addstaff, removestaff, updatestaff, helpItem, dashboaderItem, requirItem, adminItem, adddepartment, viewdepartment, updatedepartment, removedepartment;
    JMenu requirementmenu, helpmenu, adminmenu, dashboardmenu;
    //--------------------------------------------------------------------------------------------------------------------
    ImageIcon icon;
    //--------------------------------------------------------------------------------------------------------------------

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
        helpmenu.setEnabled(false);
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
        removebook.setEnabled(false);
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
        viewdepartment.addActionListener(this);
        removedepartment.addActionListener(this);
        updatedepartment.addActionListener(this);
        adddepartment.addActionListener(this);
        

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            Admin.dispose();
        }
        if(e.getSource()==dashboaderItem){
            System.out.println("dashboard");
            this.dashboard_ui();
        }
        if(e.getSource()==helpItem){
            System.out.println("help");
            this.dashboard_ui();
        }
        if(e.getSource()==adminItem){
            System.out.println("admin");
            dynamicpanel.removeAll();
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
//jt.setCellSelectionEnabled(true); 
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
            dynamicpanel.removeAll();
             dynamicpanel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "              ALL BOOKS              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
            String data[][]={ {"120","90", "35","Pointer in C","Mahesh Tiwari","Programming", "CSE", "NAVNEET", "1st", "450", "85848584"},
            {"E450","12", "8","Let us Python","Pankaj Trivedi","Programming", "CSE", "MVC", "8th", "$25", "6481516"}    
            

          };    
          String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition", "Price", "Publication Contact"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(false); 
jt.setEnabled(false);
//jt.setBounds(200, 200, 1300, 800);
jt.setRowHeight(20);
jt.getTableHeader().setFont(font_15_bold);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);
jt.getColumnModel().getColumn(2).setPreferredWidth(20);
jt.getColumnModel().getColumn(3).setPreferredWidth(120);
jt.getColumnModel().getColumn(4).setPreferredWidth(120);
jt.getColumnModel().getColumn(5).setPreferredWidth(120);
jt.getColumnModel().getColumn(6).setPreferredWidth(20);
jt.getColumnModel().getColumn(7).setPreferredWidth(120);
jt.getColumnModel().getColumn(8).setPreferredWidth(10);
jt.getColumnModel().getColumn(9).setPreferredWidth(20);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);

jt.setGridColor(grey);
jt.setFont(font_15_bold);
JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 580));
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
            
        }
        if(e.getSource()==addbook){
            System.out.println("addbook");
            dynamicpanel.removeAll();
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
            
        }
        if(e.getSource()==removebook){
            System.out.println("removebook");
        }
        if(e.getSource()==updatebook){
            System.out.println("updatebook");
        }
        if(e.getSource()==viewdepartment){
            System.out.println("viewdepartment");
        }
        if(e.getSource()==adddepartment){
            System.out.println("adddepartment");
        }
        if(e.getSource()==removedepartment){
            System.out.println("removedepartment");
        }
        if(e.getSource()==updatedepartment){
            System.out.println("updatedepartment");
        }
        if(e.getSource()==viewpublication){
            System.out.println("viewPublication");
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "              ALL PUBLICATIONS              ", TitledBorder.LEFT, TitledBorder.TOP));
         dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
         String data[][]={ {"CS21D008","140025601577", "163","Mohd Tahzeeb Khan","CSE","BTech", "4th", "7498518671", "9822130819", "mohdtahzeebk.csead20@sbjit.edu.in", "Active"},
            {"E450","12", "8","Let us Python","Pankaj Trivedi","Programming", "CSE", "MVC", "8th", "$25", "6481516"}    
            

          };    
          String column[]={"REGISTRATION","ENROLLMENT" ,"C-ROLLNO","NAME","DEPARTMENT", "PROGRAM", "YEAR", "CONTACT", "ALTERCONTACT", "EMAIL", "STATUS"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(false); 
jt.setEnabled(false);
//jt.setBounds(200, 200, 1300, 800);
jt.setRowHeight(20);
jt.getTableHeader().setFont(font_15_bold);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);
jt.getColumnModel().getColumn(2).setPreferredWidth(20);
jt.getColumnModel().getColumn(3).setPreferredWidth(120);
jt.getColumnModel().getColumn(4).setPreferredWidth(120);
jt.getColumnModel().getColumn(5).setPreferredWidth(120);
jt.getColumnModel().getColumn(6).setPreferredWidth(20);
jt.getColumnModel().getColumn(7).setPreferredWidth(120);
jt.getColumnModel().getColumn(8).setPreferredWidth(10);
jt.getColumnModel().getColumn(9).setPreferredWidth(20);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);

jt.setGridColor(grey);
jt.setFont(font_15_bold);
JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 580));
            dynamicpanel.add(sp);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==addpublication){
            System.out.println("addpublication");
            dynamicpanel.setLayout(null);
            dynamicpanel.setBackground(white);
            dynamicpanel.setSize(830, 630);
            dynamicpanel.setLocation(350, 120);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "           REGISTRATION FORM            ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.removeAll();
            //------------------------------------------------------------
            publicationname=new JLabel("Name: ");
            publicationname.setFont(font_20_bold);
            publicationname.setBounds(50,60,100,30);
            publicationnamefiled=new JTextField();
            publicationnamefiled.setFont(font_20_bold);
            publicationnamefiled.setBounds(300, 60, 250, 30);
            //-------------------------------------------------------------
            publicationscin=new JLabel("CIN: ");
            publicationscin.setFont(font_20_bold);
            publicationscin.setBounds(50, 120, 100, 30);
            publicationcinfield=new JTextField();
            publicationcinfield.setFont(font_20_bold);
            publicationcinfield.setBounds(300, 120, 250, 30);
            //--------------------------------------------------------------
            publicationtel=new JLabel("TELEPHONE NO:");
            publicationtel.setFont(font_20_bold);
            publicationtel.setBounds(50, 180, 200, 30);
            publicationnofield=new JTextField();
            publicationnofield.setFont(font_20_bold);
            publicationnofield.setBounds(300, 180, 250, 30);
            //--------------------------------------------------------------
            publicationinqueryno=new JLabel("INQUERY TELEPHONE:");
            publicationinqueryno.setFont(font_20_bold);
            publicationinqueryno.setBounds(50,240, 300, 30);
            publicationinquerynoField=new JTextField();
            publicationinquerynoField.setFont(font_20_bold);
            publicationinquerynoField.setBounds(300, 240, 250, 30);
            //--------------------------------------------------------------
            publicationemail=new JLabel("EMAIL ADDRESS:");
            publicationemail.setFont(font_20_bold);
            publicationemail.setBounds(50,300, 200, 30);
            publicationemailfield=new JTextField();
            publicationemailfield.setFont(font_20_bold);
            publicationemailfield.setBounds(300, 300, 250,30);
            //--------------------------------------------------------------
            publicationinqueryemail=new JLabel("INQUERY EMAIL: ");
            publicationinqueryemail.setFont(font_20_bold);
            publicationinqueryemail.setBounds(50,360,200,30);
            publicationinqueryemailfield=new JTextField();
            publicationinqueryemailfield.setFont(font_20_bold);
            publicationinqueryemailfield.setBounds(300, 360, 250, 30);
            //--------------------------------------------------------------
            publicationfax=new JLabel("FAX NO:");
            publicationfax.setFont(font_20_bold);
            publicationfax.setBounds(50, 420, 100, 30);
            publicationfaxfield=new JTextField();
            publicationfaxfield.setFont(font_20_bold);
            publicationfaxfield.setBounds(300, 420, 250, 30);
            //--------------------------------------------------------------
            publicationnoofbooks=new JLabel("BOOKS AVAILABLE:");
            publicationnoofbooks.setFont(font_20_bold);
            publicationnoofbooks.setBounds(50, 480, 300, 30);
            publicationnoofbookdfield=new JTextField();
            publicationnoofbookdfield.setFont(font_20_bold);
            publicationnoofbookdfield.setBounds(300, 480, 250, 30);
            //--------------------------------------------------------------
            Program=new JLabel("PROGRAM");
            Program.setFont(font_20_bold);
            Program.setBounds(50,540, 300, 30);
            ProgramComboBox=new JComboBox<>();
            ProgramComboBox.addItem("BECHALOR'S IN TECHNOLOGY");
            ProgramComboBox.addItem("MASTER'S IN TECHNOLOGY");
            ProgramComboBox.addItem("MASTER'S IN MANAGEMENT");
            ProgramComboBox.addItem("PH.D");
            ProgramComboBox.setBounds(300, 540, 250, 30);
            //--------------------------------------------------------------
            addpublicationJButton=new JButton("ADD");
            addpublicationJButton.setFont(font_20_bold);
            addpublicationJButton.setBounds(630, 150, 150, 30);
            addpublicationJButton.setBackground(grey);
            //............................................
            Clear=new JButton("CLEAR");
            Clear.setFont(font_20_bold);
            Clear.setBounds(630, 300, 150, 30);
            Clear.setBackground(grey);
            //............................................
            Cancel=new JButton("CANCEL");
            Cancel.setFont(font_20_bold);
            Cancel.setBounds(630, 450, 150, 30);
            Cancel.setBackground(grey);
            //--------------------------------------------------------------
            //--------------------------------------------------------------
            dynamicpanel.add(publicationname);
            dynamicpanel.add(publicationnamefiled);
            dynamicpanel.add(publicationscin);
            dynamicpanel.add(publicationcinfield);
            dynamicpanel.add(publicationtel);
            dynamicpanel.add(publicationnofield);
            dynamicpanel.add(publicationfax);
            dynamicpanel.add(publicationfaxfield);
            dynamicpanel.add(publicationemail);
            dynamicpanel.add(publicationemailfield);
            dynamicpanel.add(publicationinqueryno);
            dynamicpanel.add(publicationinquerynoField);
            dynamicpanel.add(publicationinqueryemail);
            dynamicpanel.add(publicationinqueryemailfield);
            dynamicpanel.add(publicationnoofbooks);
            dynamicpanel.add(publicationnoofbookdfield);
            dynamicpanel.add(Program);
            dynamicpanel.add(ProgramComboBox);
            dynamicpanel.add(addpublicationJButton);
            dynamicpanel.add(Clear);
            dynamicpanel.add(Cancel);
            
            // dynamicpanel.add();
            dynamicpanel.revalidate();
            dynamicpanel.repaint();

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
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "              ALL STAFF              ", TitledBorder.LEFT, TitledBorder.TOP));
         dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
         String data[][]={ {"CS21D008","140025601577", "163","Mohd Tahzeeb Khan","CSE","BTech", "4th", "7498518671", "9822130819", "mohdtahzeebk.csead20@sbjit.edu.in", "Active"},
            {"E450","12", "8","Let us Python","Pankaj Trivedi","Programming", "CSE", "MVC", "8th", "$25", "6481516"}    
            

          };    
          String column[]={"REGISTRATION","ENROLLMENT" ,"C-ROLLNO","NAME","DEPARTMENT", "PROGRAM", "YEAR", "CONTACT", "ALTERCONTACT", "EMAIL", "STATUS"};         
          final JTable jt=new JTable(data,column);    
jt.setCellSelectionEnabled(false); 
jt.setEnabled(false);
//jt.setBounds(200, 200, 1300, 800);
jt.setRowHeight(20);
jt.getTableHeader().setFont(font_15_bold);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);
jt.getColumnModel().getColumn(2).setPreferredWidth(20);
jt.getColumnModel().getColumn(3).setPreferredWidth(120);
jt.getColumnModel().getColumn(4).setPreferredWidth(120);
jt.getColumnModel().getColumn(5).setPreferredWidth(120);
jt.getColumnModel().getColumn(6).setPreferredWidth(20);
jt.getColumnModel().getColumn(7).setPreferredWidth(120);
jt.getColumnModel().getColumn(8).setPreferredWidth(10);
jt.getColumnModel().getColumn(9).setPreferredWidth(20);
jt.getColumnModel().getColumn(0).setPreferredWidth(10);
jt.getColumnModel().getColumn(1).setPreferredWidth(20);

jt.setGridColor(grey);
jt.setFont(font_15_bold);
JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 580));
            dynamicpanel.add(sp);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
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
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "              All STUDENTS              ", TitledBorder.LEFT, TitledBorder.TOP));
         dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
         String data[][]={ {"CS21D008","140025601577", "163","Mohd Tahzeeb Khan","CSE","BTech", "4th", "7498518671", "9822130819", "mohdtahzeebk.csead20@sbjit.edu.in", "Active"},
            {"E450","12", "8","Let us Python","Pankaj Trivedi","Programming", "CSE", "MVC", "8th", "$25", "6481516"}    
            

        };    
        String column[]={"REGISTRATION","ENROLLMENT" ,"C-ROLLNO","NAME","DEPARTMENT", "PROGRAM", "YEAR", "CONTACT", "ALTERCONTACT", "EMAIL", "STATUS"};         
                      final JTable jt=new JTable(data,column);    
            jt.setCellSelectionEnabled(false); 
            jt.setEnabled(false);
            //jt.setBounds(200, 200, 1300, 800);
            jt.setRowHeight(20);
            jt.getTableHeader().setFont(font_15_bold);
            jt.getColumnModel().getColumn(0).setPreferredWidth(10);
            jt.getColumnModel().getColumn(1).setPreferredWidth(20);
            jt.getColumnModel().getColumn(2).setPreferredWidth(20);
            jt.getColumnModel().getColumn(3).setPreferredWidth(120);
            jt.getColumnModel().getColumn(4).setPreferredWidth(120);
            jt.getColumnModel().getColumn(5).setPreferredWidth(120);
            jt.getColumnModel().getColumn(6).setPreferredWidth(20);
            jt.getColumnModel().getColumn(7).setPreferredWidth(120);
            jt.getColumnModel().getColumn(8).setPreferredWidth(10);
            jt.getColumnModel().getColumn(9).setPreferredWidth(20);
            jt.getColumnModel().getColumn(0).setPreferredWidth(10);
            jt.getColumnModel().getColumn(1).setPreferredWidth(20);

            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 580));
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();

        }
        if(e.getSource()==removestudent){
            System.out.println("removestudent");
        }
        if(e.getSource()==updatestudent){
            System.out.println("updatestudent");
            dynamicpanel.setBackground(white);
            dynamicpanel.setSize(200, 500);
        }
        if(e.getSource()==addstudent){
            System.out.println("addstudent");
            this.add_student_ui();
        }
    }
    public void dashboard_ui(){
            dynamicpanel.removeAll();
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
            dynamicpanel.setBorder(null);
            TotalBooksPanel.removeAll();
            TotalIssuedBooksPanel.removeAll();
            TotalDepartmentPanel.removeAll();
            TotalPublicerPanel.removeAll();
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
    }//dashboard_ui
    public void add_student_ui(){
        dynamicpanel.setLayout(null);
            dynamicpanel.setBackground(grey);
            dynamicpanel.setSize(1450,630 );
            dynamicpanel.setLocation(20,115 );
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "..........REGISTRATION FORM..........", TitledBorder.CENTER, TitledBorder.TOP));
            dynamicpanel.removeAll();
            RegistrationNo=new JLabel("REGISTRATION NO:");
            RegistrationNo.setFont(font_20_bold);
            RegistrationNo.setBounds(30,32,200,40);
            RegistrationNofield=new JTextField();
            RegistrationNofield.setFont(font_20_bold);
            RegistrationNofield.setBounds(250,38,200,30);
            //-------------------------------------------------------------
            usno=new JLabel("ENROLLMENT NO:");
            usno.setBounds(30,89,200,40);
            usno.setFont(font_20_bold);
            usnofield=new JTextField();
            usnofield.setFont(font_20_bold);
            usnofield.setBounds(250,95,200,30);
            usnofield.setToolTipText("Enter students University Registration NO.");
            //-------------------------------------------------------------
            Name=new JLabel("NAME:");
            Name.setBounds(30,146,200,40);
            Name.setFont(font_20_bold);
            Namefield=new JTextField();
            Namefield.setFont(font_20_bold);
            Namefield.setBounds(250,152,200,30);
            //-------------------------------------------------------------
            Fathername=new JLabel("FATHER'S NAME:");
            Fathername.setBounds(30,213,200,40);
            Fathername.setFont(font_20_bold);
            Fathernamefield=new JTextField();
            Fathernamefield.setFont(font_20_bold);
            Fathernamefield.setBounds(250,219,200,30);
            //-------------------------------------------------------------
            DOB=new JLabel("DATE OF BIRTH: ");
            DOBfield=new JTextField();
            DOBfield.setFont(font_20_bold);
            DOB.setFont(font_20_bold);
            DOB.setBounds(30,280,200,40);
            DOBfield.setBounds(250,286,100,30);            
            //-------------------------------------------------------------
            gender=new JLabel("GENDER:");
            gender.setFont(font_20_bold);
            gender.setBounds(30,347, 100,30);
            malegender=new JRadioButton("MALE");
            malegender.setBackground(grey);
            malegender.setFont(font_15_bold);
            femalegender=new JRadioButton("FEMALE");
            femalegender.setBackground(grey);
            femalegender.setFont(font_15_bold);
            transgender=new JRadioButton("TRANS");
            transgender.setBackground(grey);
            transgender.setFont(font_15_bold);
            malegender.setBounds(250, 353, 70,20);
            femalegender.setBounds(330, 353, 90,20);
            transgender.setBounds(420, 353,90,20);
            //-------------------------------------------------------------
            contactno=new JLabel("CONTACT NO:");
            contactno.setBounds(30,414,200,40);
            contactno.setFont(font_20_bold);
            contactnofield=new JTextField();
            contactnofield.setFont(font_20_bold);
            contactnofield.setBounds(250,420,200,30);
            //-------------------------------------------------------------
            altercontactno=new JLabel("ALTERNATE NO:");
            altercontactno.setBounds(30,481,200,40);
            altercontactno.setFont(font_20_bold);
            altercontactnofield=new JTextField();
            altercontactnofield.setFont(font_20_bold);
            altercontactnofield.setBounds(250,487,200,30);
            //-------------------------------------------------------------
            Classrollno=new JLabel("ROLL-NO: ");
            Classrollno.setFont(font_20_bold);
            Classrollno.setBounds(600, 30, 200, 30);
            Classrollnofield=new JTextField();
            Classrollnofield.setFont(font_20_bold);
            Classrollnofield.setBounds(800, 30, 200, 30);
            //-------------------------------------------------------------
            Program=new JLabel("PROGRAM:");
            Program.setFont(font_20_bold);
            Program.setBounds(600, 97, 200, 30);
            ProgramComboBox=new JComboBox<>();
            ProgramComboBox.addItem("BECHALOR'S IN TECHNOLOGY");
            ProgramComboBox.addItem("MASTER'S IN TECHNOLOGY");
            ProgramComboBox.addItem("MANAGEMENT");
            ProgramComboBox.addItem("PH.D");
            ProgramComboBox.setBounds(800, 103, 300, 30);
            //-------------------------------------------------------------
            year=new JLabel("YEAR: ");
            year.setFont(font_20_bold);
            year.setBounds(600,146, 200, 30);
            YearComboBox=new JComboBox<>();
            YearComboBox.addItem("FIRST");
            YearComboBox.addItem("SECOND");
            YearComboBox.addItem("THIRD");
            YearComboBox.addItem("FOURTH");
        
            YearComboBox.setFont(font_15_bold);
            YearComboBox.setBounds(800,152, 100, 30);
            //-------------------------------------------------------------
            SemesterComboBox=new JComboBox<>();
            SemesterComboBox.addItem("FIRST");
            SemesterComboBox.addItem("SECOND");
            SemesterComboBox.addItem("THIRD");
            SemesterComboBox.addItem("FOURTH");
            SemesterComboBox.addItem("FIFTH");
            SemesterComboBox.addItem("SIXTH");
            SemesterComboBox.addItem("SEVENTH");
            SemesterComboBox.addItem("EIGHTH");
            semester=new JLabel("SEMESTER: ");
            semester.setFont(font_20_bold);
            semester.setBounds(600, 213, 200, 30);
            SemesterComboBox.setFont(font_15_bold);
            SemesterComboBox.setBounds(800, 219, 100, 30);
            //-------------------------------------------------------------
            Department=new JLabel("DEPARTMENT: ");
            Department.setFont(font_20_bold);
            Department.setBounds(600, 280, 200, 30);
            departmentComboBox=new JComboBox<>();
            departmentComboBox.setFont(font_15_bold);
            departmentComboBox.addItem("COMPUTER SCIENCE & TECHNOLOGY ENGINEERING");
            departmentComboBox.addItem("ELECTRICAL ENGINEERING");
            departmentComboBox.addItem("MECANICAL ENGINEERING");
            departmentComboBox.addItem("ELETRONICS AND TELECOMMUNICATIONS ENGINEERING");
            departmentComboBox.addItem("ARTIFICAIL INTELLIGENCE AND DATA SCIENCE ENGINEERING");
            departmentComboBox.addItem("ARTIFICAIL INTELLIGENCE AND MACHINE LEARNING ENGINEERING");
            departmentComboBox.addItem("CIVIL ENGINEERING");
            departmentComboBox.addItem("MBA");
            departmentComboBox.setBounds(800, 286, 300, 30);
            //-------------------------------------------------------------
            emailid=new JLabel("EMAIL ID: ");
            emailid.setFont(font_20_bold);
            emailid.setBounds(600, 347, 200, 30);
            emailidfield=new JTextField();
            emailidfield.setFont(font_20_bold);
            emailidfield.setBounds(800, 353, 200, 30);
            //------------------------------------------------------------
            notesCheckBox=new JCheckBox();
            notesCheckBox.setText("<html>The Student has already submitted the hardcopy of the form and is eligible to create new Library card and is accessed to use the books present in the library,  under the rules and regulations of Library.</html>");
            notesCheckBox.setVerticalTextPosition(SwingConstants.TOP);
            notesCheckBox.setFont(font_15_bold);
            notesCheckBox.setBounds(600, 414, 500, 100);
            //------------------------------------------------------------
            RegisterStudent=new JButton();
            RegisterStudent.setFont(font_15_bold);
            RegisterStudent.setBounds(1250,100 , 100, 40);
            RegisterStudent.setBackground(white);
            RegisterStudent.setForeground(black);
            Clear=new JButton();
            Clear.setFont(font_15_bold);
            Clear.setBounds(1250, 300, 100, 40);
            Clear.setBackground(white);
            Clear.setForeground(black);
            Cancel=new JButton();
            Cancel.setFont(font_15_bold);
            Cancel.setBounds(1250,500 , 100, 40);
            Cancel.setForeground(black);
            Cancel.setBackground(white);
            //------------------------------------------------------------


            dynamicpanel.add(RegistrationNo);
            dynamicpanel.add(RegistrationNofield);
            dynamicpanel.add(usno);
            dynamicpanel.add(usnofield);
            dynamicpanel.add(Name);
            dynamicpanel.add(Namefield);
            dynamicpanel.add(Fathername);
            dynamicpanel.add(Fathernamefield);
            dynamicpanel.add(contactno);
            dynamicpanel.add(contactnofield);
            dynamicpanel.add(altercontactno);
            dynamicpanel.add(altercontactnofield);
            dynamicpanel.add(gender);
            grp.add(malegender);
            grp.add(femalegender);
            grp.add(transgender);
            dynamicpanel.add(malegender);
            dynamicpanel.add(femalegender);
            dynamicpanel.add(transgender);
            dynamicpanel.add(Name);
            dynamicpanel.add(DOB);
            dynamicpanel.add(DOBfield);
            dynamicpanel.add(Classrollno);
            dynamicpanel.add(Classrollnofield);
            dynamicpanel.add(Program);
            dynamicpanel.add(ProgramComboBox);
            dynamicpanel.add(year);
            dynamicpanel.add(YearComboBox);
            dynamicpanel.add(semester);
            dynamicpanel.add(SemesterComboBox);  
            dynamicpanel.add(Department); 
            dynamicpanel.add(departmentComboBox); 
            dynamicpanel.add(emailid);
            dynamicpanel.add(emailidfield);
            dynamicpanel.add(notesCheckBox);

            dynamicpanel.add(RegisterStudent);
            dynamicpanel.add(Clear);
            dynamicpanel.add(Cancel);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
    }//add_student_ui
    public static void main(String args[]){
        admin adminobj=new admin();
    }//main
}//class