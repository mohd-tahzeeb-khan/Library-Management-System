import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.sql.*;
public class admin extends JFrame implements ActionListener{
    database dbobj=new database();
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
    TotalStafflabelicon,TotalStudentlabeltexticon, TotalIssuedBookslabelicon, TotalPublicerlabeltexticon, Reffered,
    //---------------------------------------------------------------------------------------------------------------
    RegistrationNo, usno, Name, Fathername, DOB, year, semester, Department, contactno, altercontactno, age, gender, emailid, Classrollno, Program,
    //--------------------------------------------------------------------------------------------------------------------
    publicationname, publicationtel, publicationfax, publicationemail, publicationinqueryemail, publicationadd, publicationnoofbooks, publicationscin, publicationinqueryno,
    //--------------------------------------------------------------------------------------------------------------------
    bookISBNno, booktitle, bookauthor, bookpublisher, bookpublicationyear, bookgenre, bookprice, bookquantity, booklanguage,bookdateadded, bookEdition, bookpages, bookformat, bookdepartment,
    //--------------------------------------------------------------------------------------------------------------------
    deptcode, deptname, depthead, deptcreatedate,deptslogan, deptheademail, deptemail,
    //--------------------------------------------------------------------------------------------------------------------
    firstname, lastname, dob, genderstaff,address, phone, email, jobtitle,alterphone, joiningdate, Education; 
    //--------------------------------------------------------------------------------------------------------------------
    JTextField RegistrationNofield, usnofield, Namefield, Fathernamefield, DOBfield, contactnofield, altercontactnofield, agefield, emailidfield, Classrollnofield,
               publicationnamefiled, publicationcinfield, publicationemailfield, publicationinqueryemailfield, publicationinquerynoField, publicationfaxfield,publicationnofield, publicationnoofbookdfield,
               bookISBNnofield, booktitlefield, bookauthorfield, bookpublisherfield, bookpublicationyearfield, bookgenrefield, bookpricefield, bookquantityfield, booklanguagefield,bookdateaddedfield, bookEditionfield, bookpagesfield, bookformatfield, bookdepartmentfield,
               deptcodeJTextField, deptnameJTextField, deptheadJTextField, deptcreatedateJTextField,deptsloganJTextField, deptheademailJTextField, deptemailJTextField, Refferedfield,
               firstnamJTextField, lastnamJTextField, addressJTextField, phonenoJTextField, collegJTextField, alternatenoJTextField, jobtitleJTextField, joiningdaJTextField, educationJTextField, qualificationJTextField;
    //--------------------------------------------------------------------------------------------------------------------
    JRadioButton malegender, femalegender, transgender;
    //--------------------------------------------------------------------------------------------------------------------
    JComboBox<String> departmentComboBox, ProgramComboBox, SemesterComboBox, YearComboBox, JobComboBox, EducationComboBox;
    //--------------------------------------------------------------------------------------------------------------------
    JCheckBox notesCheckBox;
    //--------------------------------------------------------------------------------------------------------------------
    JButton logout, help, RegisterStudent, Cancel, Clear, addpublicationJButton, addbookJButton, adddepartmentJButton, addstaffJButton;
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
        removebook.setEnabled(true);
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
        database dbobj=new database();
        if(e.getSource()==logout){
            Admin.dispose();
        }
        if(e.getSource()==RegisterStudent){
            String gender, program, dept, sem,studyear;
            gender="";
            if(malegender.isSelected()){
                gender="Male";
            }
            if(femalegender.isSelected()){
                gender="Female";
            }
            if(transgender.isSelected()){
                gender="Transgender";
            }
            program=String.valueOf(ProgramComboBox.getSelectedItem());
            dept=String.valueOf(departmentComboBox.getSelectedItem());
            sem=String.valueOf(SemesterComboBox.getSelectedItem());
            studyear=String.valueOf(YearComboBox.getSelectedItem());
            dbobj.studentINTOdb(RegistrationNofield.getText(), usnofield.getText(),Namefield.getText() ,Fathernamefield.getText() ,DOBfield.getText() ,gender, contactnofield.getText(),altercontactnofield.getText() ,Classrollnofield.getText() ,program, studyear,
            sem ,dept ,emailidfield.getText() );
        }
        if(e.getSource()==addbookJButton){
            dbobj.bookINTOdb(bookISBNnofield.getText(),booktitlefield.getText(),bookauthorfield.getText(),bookpublisherfield.getText() ,bookgenrefield.getText(), bookpricefield.getText(),bookpublicationyearfield.getText(), bookquantityfield.getText(), booklanguagefield.getText(), bookdateaddedfield.getText(), bookformatfield.getText(), bookEditionfield.getText(), bookpagesfield.getText(), bookdepartmentfield.getText());
        }
        if(e.getSource()==adddepartmentJButton){
            dbobj.departmentINTOdb(deptcodeJTextField.getText(),deptnameJTextField.getText(),deptheadJTextField.getText(),deptcreatedateJTextField.getText(),deptsloganJTextField.getText(),deptheademailJTextField.getText(), deptemailJTextField.getText());
            // String recipt=dbobj.insert_bookINTOdb();
        }
        if(e.getSource()==addpublicationJButton){
            String program=String.valueOf(ProgramComboBox.getSelectedItem());
            dbobj.publicationINTOdb(publicationnamefiled.getText(),publicationcinfield.getText(), publicationnofield.getText(), publicationinquerynoField.getText(),publicationemailfield.getText(), publicationinqueryemailfield.getText(), publicationfaxfield.getText(), publicationnoofbookdfield.getText(),program);
            // String recipt=dbobj.insert_bookINTOdb();
        }
        if(e.getSource()==addstaffJButton){
            String gender, job, education;
             gender="";
            if(malegender.isSelected()){
                gender="Male";
            }
            if(femalegender.isSelected()){
                gender="Female";
            }
            if(transgender.isSelected()){
                gender="Transgender";
            }
            job=String.valueOf(JobComboBox.getSelectedItem());
            education=String.valueOf(EducationComboBox.getSelectedItem());
            dbobj.staffINTOdb(firstnamJTextField.getText(), lastnamJTextField.getText(), DOBfield.getText(), gender, addressJTextField.getText(), phonenoJTextField.getText(), emailidfield.getText(), job, alternatenoJTextField.getText(), joiningdaJTextField.getText(), education);
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
//-----------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource()==viewbook){
            System.out.println("viewbook");
            this.viewbook_ui();
                    }
        if(e.getSource()==addbook){
            System.out.println("addbook");
            this.add_book_ui();
        }
        if(e.getSource()==removebook){
            System.out.println("removebook");
            this.removebook_functions();
        }
        if(e.getSource()==updatebook){
            System.out.println("updatebook");
        }
//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource()==viewdepartment){
            System.out.println("viewdepartment");
            this.veiwDepartment_ui();
        }
        if(e.getSource()==adddepartment){
            System.out.println("adddepartment");
            this.add_department_ui();
        }
        if(e.getSource()==removedepartment){
            System.out.println("removedepartment");
            this.removedepartment_functions();
        }
        if(e.getSource()==updatedepartment){
            System.out.println("updatedepartment");
        }
//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource()==viewpublication){
            System.out.println("viewPublication");
            this.viewPublication_ui();
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
            //----------------------------------------------
            addpublicationJButton.addActionListener(this);
            // dynamicpanel.add();
            dynamicpanel.revalidate();
            dynamicpanel.repaint();

        }
        if(e.getSource()==updatepublication){
            System.out.println("updatepublication");
        }
        if(e.getSource()==removepublication){
            System.out.println("removepublication");
            this.removepublication_functions();
        }
//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
if(e.getSource()==addstaff){
            System.out.println("addstaff");
            this.add_staff_ui();
        }
//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource()==viewstaff){
            System.out.println("viewstaff");
            this.viewstaff_ui();
        }
        if(e.getSource()==addstaff){
            System.out.println("addstaff");
            this.add_staff_ui();
        }
        if(e.getSource()==removestaff){
            System.out.println("removestaff");
            this.removestaff_functions();
        } 
        if(e.getSource()==updatestaff){
            System.out.println("updatestaff");
        }
//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource()==viewstudent){
            System.out.println("viewstudent");
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              All STUDENTS              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            ResultSet rs;
            database dbdobj=new database();
            rs=dbdobj.StudentRetrieve();  
            String column[]={"REGISTRATION","ENROLLMENT" ,"NAME","DEPARTMENT", "PROGRAM", "YEAR", "CONTACT", "ALTERCONTACT", "EMAIL", "STATUS"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);
            final JTable jt=new JTable(dtm);    
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
            jt.getColumnModel().getColumn(5).setPreferredWidth(20);
            jt.getColumnModel().getColumn(6).setPreferredWidth(20);
            jt.getColumnModel().getColumn(7).setPreferredWidth(60);
            jt.getColumnModel().getColumn(8).setPreferredWidth(10);
            jt.getColumnModel().getColumn(9).setPreferredWidth(20);
            jt.getColumnModel().getColumn(0).setPreferredWidth(10);
            //jt.getColumnModel().getColumn(1).setPreferredWidth(20);
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 580));
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();  
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(13),rs.getString(10), 
                        rs.getString(11),rs.getString(7), rs.getString(8),rs.getString(14)};
                    dtm.addRow(item);
            }}catch(Exception f){
                System.out.println(f);
            }
    }
        if(e.getSource()==removestudent){
            System.out.println("removestudent");
            this.removestudent_functions();
        }//remove student
        if(e.getSource()==updatestudent){
            System.out.println("updatestudent");
            dynamicpanel.setBackground(white);
            dynamicpanel.setSize(200, 500);
        }//updatestudent
        if(e.getSource()==addstudent){
            System.out.println("addstudent");
            this.add_student_ui();
        }//add student
    }
    public void add_book_ui(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setSize(1250,630);
        dynamicpanel.setLocation(120,115);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "    NEW BOOK    ", TitledBorder.CENTER, TitledBorder.TOP));
        //---------------------------------------------------------
        bookISBNno=new JLabel("ISBN NO:");
        bookISBNno.setFont(font_20_bold);
        bookISBNno.setBounds(100, 60, 200, 30);
        bookISBNnofield=new JTextField();
        bookISBNnofield.setFont(font_20_bold);
        bookISBNnofield.setBounds(350, 60, 200, 30);
        //-----------------------------------------------------------
        booktitle=new JLabel("TITLE");
        booktitle.setFont(font_20_bold);
        booktitle.setBounds(100, 120, 200, 30);
        booktitlefield=new JTextField();
        booktitlefield.setFont(font_20_bold);
        booktitlefield.setBounds(350, 120, 200, 30);
        //-----------------------------------------------------------
        bookauthor=new JLabel("AUTHOR:");
        bookauthor.setFont(font_20_bold);
        bookauthor.setBounds(100, 180, 200, 30);
        bookauthorfield=new JTextField();
        bookauthorfield.setFont(font_20_bold);
        bookauthorfield.setBounds(350, 180, 200, 30);
        //------------------------------------------------------------
        bookpublisher=new JLabel("PUBLISHER: ");
        bookpublisher.setFont(font_20_bold);
        bookpublisher.setBounds(100, 240, 200, 30);
        bookpublisherfield=new JTextField();
        bookpublisherfield.setFont(font_20_bold);
        bookpublisherfield.setBounds(350, 240, 200, 30);
        //-----------------------------------------------------------
        bookpublicationyear=new JLabel("PUBLISHER YEAR: ");
        bookpublicationyear.setFont(font_20_bold);
        bookpublicationyear.setBounds(100, 300, 200, 30);
        bookpublicationyearfield=new JTextField();
        bookpublicationyearfield.setFont(font_20_bold);
        bookpublicationyearfield.setBounds(350, 300, 200, 30);
        //------------------------------------------------------------
        bookgenre=new JLabel("GENRE: ");
        bookgenre.setFont(font_20_bold);
        bookgenre.setBounds(100, 360, 200, 30);
        bookgenrefield=new JTextField();
        bookgenrefield.setFont(font_20_bold);
        bookgenrefield.setBounds(350, 360, 200, 30);
        //-----------------------------------------------------------
        bookprice=new JLabel("PRICE: ");
        bookprice.setFont(font_20_bold);
        bookprice.setBounds(100, 420, 200, 30);
        bookpricefield=new JTextField();
        bookpricefield.setFont(font_20_bold);
        bookpricefield.setBounds(350, 420, 200, 30);
        //-----------------------------------------------------------
        bookquantity=new JLabel("QUANTITY: ");
        bookquantity.setFont(font_20_bold);
        bookquantity.setBounds(100, 480, 200, 30);
        bookquantityfield=new JTextField();
        bookquantityfield.setFont(font_20_bold);
        bookquantityfield.setBounds(350, 480, 200, 30);
        //-----------------------------------------------------------
        booklanguage=new JLabel("LANGUAGE USED: ");
        booklanguage.setFont(font_20_bold);
        booklanguage.setBounds(700, 60, 200, 30);
        booklanguagefield=new JTextField();
        booklanguagefield.setFont(font_20_bold);
        booklanguagefield.setBounds(920, 60, 200, 30);
        //-----------------------------------------------------------
        bookdateadded=new JLabel("BOOK ADDED ON: ");
        bookdateadded.setFont(font_20_bold);
        bookdateadded.setBounds(700, 120, 200, 30);
        bookdateaddedfield=new JTextField();
        bookdateaddedfield.setFont(font_20_bold);
        bookdateaddedfield.setBounds(920, 120, 200, 30);
        //-----------------------------------------------------------
        bookEdition=new JLabel("EDITION");
        bookEdition.setFont(font_20_bold);
        bookEdition.setBounds(700, 180, 200, 30);
        bookEditionfield=new JTextField();
        bookEditionfield.setFont(font_20_bold);
        bookEditionfield.setBounds(920, 180, 200, 30);
        //-----------------------------------------------------------
        bookpages=new JLabel("PAGES");
        bookpages.setFont(font_20_bold);
        bookpages.setBounds(700, 240, 200, 30);
        bookpagesfield=new JTextField();
        bookpagesfield.setFont(font_20_bold);
        bookpagesfield.setBounds(920, 240, 200, 30);
        //-----------------------------------------------------------
        bookformat=new JLabel("FORMAT");
        bookformat.setFont(font_20_bold);
        bookformat.setBounds(700, 300, 200, 30);
        bookformatfield=new JTextField();
        bookformatfield.setFont(font_20_bold);
        bookformatfield.setBounds(920, 300, 200, 30);
        //-----------------------------------------------------------
        bookdepartment=new JLabel("DEPARTMENT: ");
        bookdepartment.setFont(font_20_bold);
        bookdepartment.setBounds(700, 360, 200, 30);
        bookdepartmentfield=new JTextField(); 
        bookdepartmentfield.setFont(font_20_bold);
        bookdepartmentfield.setBounds(920, 360, 200, 30);
        //-----------------------------------------------------------
        addbookJButton=new JButton("SAVE");
        addbookJButton.setFont(font_20_bold);
        addbookJButton.setBounds(150, 560, 150, 30);
        Clear=new JButton("CLEAR");
        Clear.setFont(font_20_bold);
        Clear.setBounds(450, 560, 150, 30);
        Cancel=new JButton("CANCEL");
        Cancel.setFont(font_20_bold);
        Cancel.setBounds(750, 560, 150, 30);
        //-----------------------------------------------------------
        dynamicpanel.add(bookISBNno);
        dynamicpanel.add(bookISBNnofield);
        dynamicpanel.add(booktitle);
        dynamicpanel.add(booktitlefield);
        dynamicpanel.add(bookauthor);
        dynamicpanel.add(bookauthorfield);
        dynamicpanel.add(bookpublisher);
        dynamicpanel.add(bookpublisherfield);
        dynamicpanel.add(bookpublicationyear);
        dynamicpanel.add(bookpublicationyearfield);
        dynamicpanel.add(bookgenre);
        dynamicpanel.add(bookgenrefield);
        dynamicpanel.add(bookquantity);
        dynamicpanel.add(bookquantityfield);
        dynamicpanel.add(bookprice);
        dynamicpanel.add(bookpricefield);
        dynamicpanel.add(booklanguagefield);
        dynamicpanel.add(booklanguage);
        dynamicpanel.add(bookdateadded);
        dynamicpanel.add(bookdateaddedfield);
        dynamicpanel.add(bookEdition);
        dynamicpanel.add(bookEditionfield);
        dynamicpanel.add(bookdepartment);
        dynamicpanel.add(bookdepartmentfield);
        dynamicpanel.add(bookpages);
        dynamicpanel.add(bookpagesfield);
        dynamicpanel.add(bookformat);
        dynamicpanel.add(bookformatfield);
        //------------------------------------------------------
        dynamicpanel.add(addbookJButton);
        addbookJButton.addActionListener(this);
        dynamicpanel.add(Clear);
        dynamicpanel.add(Cancel);
        //------------------------------------------------------
        dynamicpanel.revalidate();
        dynamicpanel.repaint();
    }//add_book_ui()
    //...................................................................................................................................
    public void add_department_ui(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setBorder(null);
        dynamicpanel.setBackground(white);
        dynamicpanel.setSize(900,630);
        dynamicpanel.setLocation(300,120);
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "    NEW DEPARTMENT    ", TitledBorder.CENTER, TitledBorder.TOP));
        //---------------------------------------------------
        deptcode=new JLabel("DEPARTMENT CODE: ");
        deptcode.setFont(font_20_bold);
        deptcode.setBounds(160,60,300, 30);
        deptcodeJTextField=new JTextField();   
        deptcodeJTextField.setFont(font_15_bold);
        deptcodeJTextField.setBounds(550, 60, 120, 30);
        //----------------------------------------------------
        deptname=new JLabel("DEPARTMENT NAME: ");
        deptname.setFont(font_20_bold);
        deptname.setBounds(160,120,300, 30);
        deptnameJTextField=new JTextField();   
        deptnameJTextField.setFont(font_15_bold);
        deptnameJTextField.setBounds(550, 120, 200, 30);
        //----------------------------------------------------
        depthead=new JLabel("DEPARTMENT HEAD:");
        depthead.setFont(font_20_bold);
        depthead.setBounds(160,180,300, 30);
        deptheadJTextField=new JTextField();   
        deptheadJTextField.setFont(font_15_bold);
        deptheadJTextField.setBounds(550, 180, 200, 30);
        //----------------------------------------------------
        deptcreatedate=new JLabel("DEPARTMENT DATE(CREATION):");
        deptcreatedate.setFont(font_20_bold);
        deptcreatedate.setBounds(160,240,350, 30);
        deptcreatedateJTextField=new JTextField();   
        deptcreatedateJTextField.setFont(font_15_bold);
        deptcreatedateJTextField.setBounds(550, 240, 150, 30);
        //----------------------------------------------------
        deptslogan=new JLabel("SLOGAN:");
        deptslogan.setFont(font_20_bold);
        deptslogan.setBounds(160,300,300, 30);
        deptsloganJTextField=new JTextField();   
        deptsloganJTextField.setFont(font_15_bold);
        deptsloganJTextField.setBounds(550, 300, 220, 30);
        //----------------------------------------------------
        deptheademail=new JLabel("EMAIL(HOD):");
        deptheademail.setFont(font_20_bold);
        deptheademail.setBounds(160,360,300, 30);
        deptheademailJTextField=new JTextField();   
        deptheademailJTextField.setFont(font_15_bold);
        deptheademailJTextField.setBounds(550, 360, 220, 30);
        //----------------------------------------------------
        deptemail=new JLabel("DEPARTMENT EMAIL:");
        deptemail.setFont(font_20_bold);
        deptemail.setBounds(160,420,300, 30);
        deptemailJTextField=new JTextField();   
        deptemailJTextField.setFont(font_15_bold);
        deptemailJTextField.setBounds(550, 420, 220, 30);
        //----------------------------------------------------
        adddepartmentJButton=new JButton("SAVE");
        adddepartmentJButton.setBounds(60,550, 200, 40);
        adddepartmentJButton.setFont(font_20_bold);
        Clear=new JButton("CLEAR");
        Clear.setBounds(350,550, 200, 40);
        Clear.setFont(font_20_bold);
        Cancel=new JButton("CANCEL");
        Cancel.setBounds(640,550, 200, 40);
        Cancel.setFont(font_20_bold);
        //----------------------------------------------------
        dynamicpanel.add(deptcode);
        dynamicpanel.add(deptcodeJTextField);
        dynamicpanel.add(depthead);
        dynamicpanel.add(deptheadJTextField);
        dynamicpanel.add(deptname);
        dynamicpanel.add(deptnameJTextField);
        dynamicpanel.add(deptslogan);
        dynamicpanel.add(deptsloganJTextField);
        dynamicpanel.add(deptemail);
        dynamicpanel.add(deptemailJTextField);
        dynamicpanel.add(deptheademail);
        dynamicpanel.add(deptheademailJTextField);
        dynamicpanel.add(deptcreatedate);
        dynamicpanel.add(deptcreatedateJTextField);
        dynamicpanel.add(adddepartmentJButton);
        dynamicpanel.add(Clear);
        dynamicpanel.add(Cancel);
        //----------------------------------------------------
        adddepartmentJButton.addActionListener(this);
        //----------------------------------------------------
        
        dynamicpanel.revalidate();
        dynamicpanel.repaint();
    }//add_department_ui
    public void dashboard_ui(){
        database dbobj=new database();
        int[] data=new int[5];
        data=dbobj.retrive();
        String Book=Integer.toString(data[0]);
        String Department=Integer.toString(data[1]);
        String Publication=Integer.toString(data[2]);
        String Students =Integer.toString(data[3]);
        String Staff =Integer.toString(data[4]);
        //String =Integer.toString();


            dynamicpanel.removeAll();
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
            dynamicpanel.setBorder(null);
            dynamicpanel.setSize(1450, 630);
            dynamicpanel.setLocation(20, 120);

            TotalBooksPanel.removeAll();
            TotalIssuedBooksPanel.removeAll();
            TotalDepartmentPanel.removeAll();
            TotalPublicerPanel.removeAll();
            //Total no of books Panel...........................................
            icon=new ImageIcon("images/totalbooks.png");
            TotalBookslabelicon=new JLabel(icon);
            TotalBookslabel=new JLabel(Book);
            TotalBookslabel.setFont(font_100_bold);
            TotalBookslabel.setForeground(black);
            TotalBookslabeltext=new JLabel("Total Books");
            TotalBookslabeltext.setFont(font_30_bold);
            TotalBookslabeltext.setForeground(black);
            //...................................................................
            //Total no of students panel.........................................\
            icon=new ImageIcon("images/student.png");
            TotalStudentlabeltexticon=new JLabel(icon);
            TotalStudentlabel=new JLabel(Students);
            TotalStudentlabel.setFont(font_100_bold);
            TotalStudentlabel.setForeground(black);
            TotalStudentlabeltext=new JLabel("Total Students");
            TotalStudentlabeltext.setFont(font_30_bold);
            TotalStudentlabeltext.setForeground(black);
            //....................................................................
           
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
            TotalDepartmentlabel=new JLabel(Department);
            TotalDepartmentlabel.setForeground(black);
            TotalDepartmentlabel.setFont(font_100_bold);
            TotalDepartmentlabeltext=new JLabel("Departments");
            TotalDepartmentlabeltext.setForeground(black);
            TotalDepartmentlabeltext.setFont(font_30_bold);
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
            //----------------------------------------------------------------------
            //Total Publications---------------------------------------------------
            icon=new ImageIcon("images/publication.png");
            TotalPublicerlabeltexticon=new JLabel(icon);
            TotalPublicerlabel=new JLabel(Publication);
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
            TotalStafflabel=new JLabel(Staff);
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
            //-------------------------------------------------------
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
    }//dashboard_ui
    //-------------------------------------------------------................................................................................
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
            RegisterStudent.addActionListener(this);
            malegender.addActionListener(this);
            femalegender.addActionListener(this);
            transgender.addActionListener(this);
            dynamicpanel.add(Clear);
            dynamicpanel.add(Cancel);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
    }//add_student_ui---------------------------------------------------------------------------------
    void viewbook_ui(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
        ResultSet rs;
        database dbobj=new database();
        rs=dbobj.BooksRetrieve();
        dynamicpanel.removeAll();
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "              ALL BOOKS              ", TitledBorder.LEFT, TitledBorder.TOP));
        dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
        String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition", "Price", "Publication Contact"};         
        DefaultTableModel dtm=new DefaultTableModel(column,0);
        // final JTable jt=new JTable(dtm);  
        final JTable jt=new JTable(dtm);    
        jt.setCellSelectionEnabled(false); 
        jt.setEnabled(false);
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
                    try{
                        while(rs.next()){
                            String[] item={rs.getString(1), rs.getString(8)," ", rs.getString(2),rs.getString(3), 
                                "",rs.getString(14), rs.getString(4),rs.getString(12),  rs.getString(6)," "};
                            dtm.addRow(item);
                    }}catch(Exception f){
                        System.out.println(f);
                    }
                }
    //------------------------------------------------------------------------------------------------
    void viewPublication_ui(){
            ResultSet rs;
            rs=dbobj.PublicationRetrieve();
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              ALL STAFF              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);  
            final JTable jt=new JTable(dtm);      
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
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
                        sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(8),rs.getString(2),rs.getString(3), 
                        "",rs.getString(4), rs.getString(4),rs.getString(8),  rs.getString(6)};
                        dtm.addRow(item);
                    }
                }catch(Exception f){
                        System.out.println(f);
                    }
    }
    //------------------------------------------------------------------------------------------------
    void viewstaff_ui(){
            ResultSet rs;
            rs=dbobj.StaffRetrieve();
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              ALL STAFF              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);  
            final JTable jt=new JTable(dtm);      
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
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
                        sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(8),rs.getString(2),rs.getString(3), 
                        "",rs.getString(4), rs.getString(4),rs.getString(8),  rs.getString(6)};
                        dtm.addRow(item);
                    }
                }catch(Exception f){
                        System.out.println(f);
                    }
    }
    //------------------------------------------------------------------------------------------------
    void veiwDepartment_ui(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
        ResultSet rs;
        database dbobj=new database();
        rs=dbobj.DepartmentRetrieve();
        dynamicpanel.removeAll();
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "           ALL Departments          ", TitledBorder.LEFT, TitledBorder.TOP));
        dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
        String column[]={"Code","Department" ,"Head of Department","Date Added"," Slogan", "Head-Email", "Dept-Email"};         
        DefaultTableModel dtm=new DefaultTableModel(column,0);
        // final JTable jt=new JTable(dtm);  
        final JTable jt=new JTable(dtm);    
        jt.setCellSelectionEnabled(false); 
        jt.setEnabled(false);
        jt.setRowHeight(20);
        jt.getTableHeader().setFont(font_15_bold);
        jt.getColumnModel().getColumn(0).setPreferredWidth(10);
        jt.getColumnModel().getColumn(1).setPreferredWidth(20);
        jt.getColumnModel().getColumn(2).setPreferredWidth(20);
        jt.getColumnModel().getColumn(3).setPreferredWidth(20);
        jt.getColumnModel().getColumn(4).setPreferredWidth(120);
        jt.getColumnModel().getColumn(5).setPreferredWidth(120);
        jt.getColumnModel().getColumn(6).setPreferredWidth(20);
        
        jt.setGridColor(grey);
        jt.setFont(font_15_bold);
        JScrollPane sp=new JScrollPane(jt);
                    sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    //Admin.setBackground(black);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
                    try{
                        while(rs.next()){
                            String[] item={rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), 
                                rs.getString(6),rs.getString(7)};
                            dtm.addRow(item);
                    }}catch(Exception f){
                        System.out.println(f);
                    }
            }

    //-----------------------------------------------------------------------------------------------=
    void add_staff_ui(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
        //---------------------------------------------
        firstname=new JLabel("FIRST NAME:");
        firstname.setFont(font_20_bold);
        firstname.setBounds(60, 60, 200, 30);
        firstnamJTextField=new JTextField();
        firstnamJTextField.setFont(font_15_bold);
        firstnamJTextField.setBounds(350, 60, 250, 30);
        //---------------------------------------------
        lastname=new JLabel("LAST NAME:");
        lastname.setFont(font_20_bold);
        lastname.setBounds(60, 120, 200, 30);
        lastnamJTextField=new JTextField();
        lastnamJTextField.setFont(font_15_bold);
        lastnamJTextField.setBounds(350, 120, 250, 30);
        //---------------------------------------------
        dob=new JLabel("DATE OF BIRTH:");
        dob.setFont(font_20_bold);
        dob.setBounds(60, 180, 300, 30);
        
        //---------------------------------------------
        genderstaff=new JLabel("GENDER:");
        genderstaff.setFont(font_20_bold);
        genderstaff.setBounds(60, 240, 150, 30);
        malegender=new JRadioButton("MALE");
        malegender.setBounds(350, 240, 100, 30);
        malegender.setBackground(grey);
        femalegender=new JRadioButton("FEMALE");
        femalegender.setBackground(grey);
        femalegender.setBounds(450, 240, 100, 30);
        transgender=new JRadioButton("TRANS");
        transgender.setBackground(grey);
        transgender.setBounds(550, 240, 150, 30);
        //---------------------------------------------
        address=new JLabel("ADDRESS:");
        address.setFont(font_20_bold);
        address.setBounds(60, 300, 200, 30);
        addressJTextField=new JTextField();
        addressJTextField.setFont(font_15_bold);
        addressJTextField.setBounds(350, 300, 250, 30);
        //---------------------------------------------
        phone=new JLabel("PHONE NO: ");
        phone.setFont(font_20_bold);
        phone.setBounds(60, 360, 200, 30);
        phonenoJTextField=new JTextField();
        phonenoJTextField.setFont(font_15_bold);
        phonenoJTextField.setBounds(350, 360, 250, 30);
        //---------------------------------------------
        email=new JLabel("COLLEGE EMAIL ID: ");
        email.setFont(font_20_bold);
        email.setBounds(60, 420, 300, 30);
        emailidfield=new JTextField();
        emailidfield.setFont(font_15_bold);
        emailidfield.setBounds(350, 420, 250, 30);
        //---------------------------------------------
        jobtitle=new JLabel("JOB TITLE: ");
        jobtitle.setFont(font_20_bold);
        jobtitle.setBounds(700, 240, 300, 30);
        JobComboBox=new JComboBox<>();
        JobComboBox.addItem("LIBRARIAN");
        JobComboBox.addItem("ASSISTANT");
        JobComboBox.addItem("ADMIN");
        JobComboBox.setBounds(1100, 240, 250, 30);
        //---------------------------------------------
        alterphone=new JLabel("ALTERNATE PHONE NO:");
        alterphone.setFont(font_20_bold);
        alterphone.setBounds(700, 60, 300, 30);
        alternatenoJTextField=new JTextField();
        alternatenoJTextField.setFont(font_15_bold);
        alternatenoJTextField.setBounds(1100, 60, 250, 30);
        //---------------------------------------------
        joiningdate=new JLabel("JOINING DATE: ");
        joiningdate.setFont(font_20_bold);
        joiningdate.setBounds(700, 120, 300, 30);
        joiningdaJTextField=new JTextField();
        joiningdaJTextField.setFont(font_15_bold);
        joiningdaJTextField.setBounds(1100, 120, 250, 30);
        //---------------------------------------------
        Education=new JLabel("EDUCATION QULIFICATION: ");
        Education.setFont(font_20_bold);
        Education.setBounds(700, 180, 300, 30);
        EducationComboBox=new JComboBox<>();
        EducationComboBox.addItem("DIPLOMA");
        EducationComboBox.addItem("GRADUATED");
        EducationComboBox.addItem("POST-GRADUATED");
        EducationComboBox.addItem("DOCTORATE");
        EducationComboBox.setBounds(1100, 180, 250, 30);
        //---------------------------------------------
        addstaffJButton=new JButton("SAVE");
        addstaffJButton.setFont(font_20_bold);
        addstaffJButton.setBounds(150, 560, 200, 40);
        Clear=new JButton("CLEAR");
        Clear.setFont(font_20_bold);
        Clear.setBounds(540, 560, 200, 40);
        Cancel=new JButton("CANCEL");
        Cancel.setFont(font_20_bold);
        Cancel.setBounds(930, 560, 200, 40);
        //---------------------------------------------
        dynamicpanel.add(firstname);
        dynamicpanel.add(firstnamJTextField);
        dynamicpanel.add(lastname);
        dynamicpanel.add(lastnamJTextField);
        dynamicpanel.add(dob);
        dynamicpanel.add(genderstaff);
        grp.add(malegender);
        grp.add(femalegender);
        grp.add(transgender);
        dynamicpanel.add(malegender);
        dynamicpanel.add(femalegender);
        dynamicpanel.add(transgender);
        dynamicpanel.add(address);
        dynamicpanel.add(addressJTextField);
        dynamicpanel.add(phone);
        dynamicpanel.add(phonenoJTextField);
        dynamicpanel.add(jobtitle);
        dynamicpanel.add(JobComboBox);
        dynamicpanel.add(joiningdate);
        dynamicpanel.add(joiningdaJTextField);
        dynamicpanel.add(alterphone);
        dynamicpanel.add(alternatenoJTextField);
        dynamicpanel.add(Education);
        dynamicpanel.add(EducationComboBox);
        dynamicpanel.add(email);
        dynamicpanel.add(emailidfield);
        dynamicpanel.add(addstaffJButton);
        dynamicpanel.add(Clear);
        dynamicpanel.add(Cancel);
        //---------------------------------------------
        addstaffJButton.addActionListener(this);
        femalegender.addActionListener(this);
        malegender.addActionListener(this);
        transgender.addActionListener(this);
        //---------------------------------------------
        dynamicpanel.revalidate();
        dynamicpanel.repaint();
    }//add_staff_UI();
//-------------------------------------------------------------------------------------------------------------------
    void removebook_functions(){
        dynamicpanel.removeAll();
        Reffered=new JLabel("Reffered ID");
        Reffered.setBounds(300,414,200,40);
        Reffered.setFont(font_20_bold);
        Refferedfield=new JTextField();
        Refferedfield.setFont(font_20_bold);
        Refferedfield.setBounds(350,220,200,50);
        dynamicpanel.setLayout(null);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
        ResultSet rs;
        database dbobj=new database();
        rs=dbobj.BooksRetrieve();
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "              REMOVE BOOKS              ", TitledBorder.LEFT, TitledBorder.TOP));
        dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 10));
        String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition", "Price", "Publication Contact"};         
        DefaultTableModel dtm=new DefaultTableModel(column,0);
        final JTable jt=new JTable(dtm);    
        jt.setEnabled(false);
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
                    sp.setPreferredSize(new Dimension(1420, 100));
                    dynamicpanel.add(Reffered);
                    dynamicpanel.add(Refferedfield);
                    dynamicpanel.add(sp);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
                    try{
                        while(rs.next()){
                            String[] item={rs.getString(1), rs.getString(8)," ", rs.getString(2),rs.getString(3), 
                                "",rs.getString(14), rs.getString(4),rs.getString(12),  rs.getString(6)," "};
                            dtm.addRow(item);
                    }}catch(Exception f){
                        System.out.println(f);
                    }
                
    }

//-----------------------------------------------------------------------------------------------------------------------------------
    void removestudent_functions(){
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              All STUDENTS              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            ResultSet rs;
            database dbdobj=new database();
            rs=dbdobj.StudentRetrieve();  
            String column[]={"REGISTRATION","ENROLLMENT" ,"NAME","DEPARTMENT", "PROGRAM", "YEAR", "CONTACT", "ALTERCONTACT", "EMAIL", "STATUS"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);
            final JTable jt=new JTable(dtm);    
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
            jt.getColumnModel().getColumn(5).setPreferredWidth(20);
            jt.getColumnModel().getColumn(6).setPreferredWidth(20);
            jt.getColumnModel().getColumn(7).setPreferredWidth(60);
            jt.getColumnModel().getColumn(8).setPreferredWidth(10);
            jt.getColumnModel().getColumn(9).setPreferredWidth(20);
            jt.getColumnModel().getColumn(0).setPreferredWidth(10);
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
            sp.setPreferredSize(new Dimension(1420, 280));
            dynamicpanel.add(sp);
            //Admin.setBackground(black);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();  
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(13),rs.getString(10), 
                        rs.getString(11),rs.getString(7), rs.getString(8),rs.getString(14)};
                    dtm.addRow(item);
            }}catch(Exception f){
                System.out.println(f);
            }
    }
//-----------------------------------------------------------------------------------------------------------------------------------
    void removedepartment_functions(){
        dynamicpanel.removeAll();
        dynamicpanel.setLayout(null);
        dynamicpanel.setBackground(grey);
        dynamicpanel.setSize(1450, 630);
        dynamicpanel.setLocation(20, 115);
        ResultSet rs;
        database dbobj=new database();
        rs=dbobj.DepartmentRetrieve();
        dynamicpanel.removeAll();
        dynamicpanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "           ALL Departments          ", TitledBorder.LEFT, TitledBorder.TOP));
        dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 40));
        String column[]={"Code","Department" ,"Head of Department","Date Added"," Slogan", "Head-Email", "Dept-Email"};         
        DefaultTableModel dtm=new DefaultTableModel(column,0);
        // final JTable jt=new JTable(dtm);  
        final JTable jt=new JTable(dtm);    
        jt.setCellSelectionEnabled(false); 
        jt.setEnabled(false);
        jt.setRowHeight(20);
        jt.getTableHeader().setFont(font_15_bold);
        jt.getColumnModel().getColumn(0).setPreferredWidth(10);
        jt.getColumnModel().getColumn(1).setPreferredWidth(20);
        jt.getColumnModel().getColumn(2).setPreferredWidth(20);
        jt.getColumnModel().getColumn(3).setPreferredWidth(20);
        jt.getColumnModel().getColumn(4).setPreferredWidth(120);
        jt.getColumnModel().getColumn(5).setPreferredWidth(120);
        jt.getColumnModel().getColumn(6).setPreferredWidth(20);
        
        jt.setGridColor(grey);
        jt.setFont(font_15_bold);
        JScrollPane sp=new JScrollPane(jt);
                    sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    //Admin.setBackground(black);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
                    try{
                        while(rs.next()){
                            String[] item={rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), 
                                rs.getString(6),rs.getString(7)};
                            dtm.addRow(item);
                    }}catch(Exception f){
                        System.out.println(f);
                    }
    }
    void removepublication_functions(){
        ResultSet rs;
            rs=dbobj.PublicationRetrieve();
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              ALL STAFF              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);  
            final JTable jt=new JTable(dtm);      
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
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
                        sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(8),rs.getString(2),rs.getString(3), 
                        "",rs.getString(4), rs.getString(4),rs.getString(8),  rs.getString(6)};
                        dtm.addRow(item);
                    }
                }catch(Exception f){
                        System.out.println(f);
                    }
    }
//---------------------------------------------------------------------------------------------------------------------
    void removestaff_functions(){
        ResultSet rs;
            rs=dbobj.StaffRetrieve();
            dynamicpanel.removeAll();
            dynamicpanel.setBackground(grey);
            dynamicpanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "              ALL STAFF              ", TitledBorder.LEFT, TitledBorder.TOP));
            dynamicpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 14)); 
            String column[]={"Reffered ID","Quantity" ,"Available","NAME"," Author", "Subject", "Department", "Publication", "Edition"};         
            DefaultTableModel dtm=new DefaultTableModel(column,0);  
            final JTable jt=new JTable(dtm);      
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
            jt.setGridColor(grey);
            jt.setFont(font_15_bold);
            JScrollPane sp=new JScrollPane(jt);
                        sp.setPreferredSize(new Dimension(1420, 580));
                    dynamicpanel.add(sp);
                    dynamicpanel.revalidate();
                    dynamicpanel.repaint();
            try{
                while(rs.next()){
                    String[] item={rs.getString(1), rs.getString(8),rs.getString(2),rs.getString(3), 
                        "",rs.getString(4), rs.getString(4),rs.getString(8),  rs.getString(6)};
                        dtm.addRow(item);
                    }
                }catch(Exception f){
                        System.out.println(f);
                    }
    }
    public static void main(String args[]){
        admin adminobj=new admin();
    }//main
}//class