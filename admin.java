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
    Font myFont = new Font("Serif", Font.BOLD, 100);
    JLabel name, logo_images, TotalBookslabel, TotalStudentlabel, TotalIssuedBookslabel, TotalDepartmentlabel,
    TotalPublicerlabel, Requirementlabel, TotalStafflabel, TotalBookAvailablelabel;
    JButton logout, help;
    JPanel heading_Panel, plain_Panel, dynamicpanel,sidepanel, TotalBooksPanel, TotalStudentPanel, TotalIssuedBooksPanel, TotalDepartmentPanel,
    TotalPublicerPanel, RequirementPanel, TotalStaffPanel, TotalBookAvailable;
    CardLayout cardlayoutinstance;
    JMenu menubar;
    JMenuItem addbook, viewbook, removebook, updatebook, viewpublication, addpublication, removepublication, updatepublication,
    viewstudent, addstudent, removestudent, updatestudent, viewstaff, addstaff, removestaff, updatestaff, helpItem, dashboaderItem, requirItem, adminItem;
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
       
        logout=new JButton("LOGOUT");
        logout.setBounds(1350, 20, 100, 35);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
       
        JMenuBar menubar=new JMenuBar();
        menubar.setBounds(450,61,1000,40);
        menubar.setBackground(Color.WHITE);
        dashboardmenu=new JMenu("     DASHBOARD    ");
        JMenu settingmenu=new JMenu("   SETTING    ");
        adminmenu=new JMenu("     ADMIN   ");
        JMenu bookmenu=new JMenu("     BOOKS    ");
        JMenu staffmenu=new JMenu("   STAFF    ");
        JMenu publicationmenu=new JMenu("     PUBLICATIONS   ");
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
        dynamicpanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 20));
        dynamicpanel.setBackground(Color.GRAY);
        dynamicpanel.setSize(1020, 630);
        dynamicpanel.setLocation(450, 115);
    
        //------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------
        sidepanel=new JPanel();
        sidepanel.setBackground(Color.GRAY);
        sidepanel.setSize(420, 630);
        sidepanel.setLocation(15, 115);
        //----------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------
        TotalBooksPanel=new JPanel();
        TotalBooksPanel.setBackground(Color.WHITE);
       
        TotalBooksPanel.setPreferredSize(new Dimension(240, 290));
        
        //----------------------------------------------------------------------------------
        TotalBookAvailable=new JPanel();
        TotalBookAvailable.setBackground(Color.RED);
        
        TotalBookAvailable.setPreferredSize(new Dimension(240, 290));
        
        //----------------------------------------------------------------------------------
        TotalDepartmentPanel=new JPanel();
        TotalDepartmentPanel.setBackground(Color.LIGHT_GRAY);
        TotalDepartmentPanel.setPreferredSize(new Dimension(240, 290));
        //--------------------------------------------------------------------------------------
        TotalIssuedBooksPanel=new JPanel();
        TotalIssuedBooksPanel.setBackground(Color.LIGHT_GRAY);
        TotalIssuedBooksPanel.setPreferredSize(new Dimension(240, 290));
        
        //-----------------------------------------------------------------------------------------
        TotalStaffPanel=new JPanel();
        TotalStaffPanel.setBackground(Color.YELLOW);
        TotalStaffPanel.setPreferredSize(new Dimension(240, 290));
        //--------------------------------------------------------------------------------------
        TotalStudentPanel=new JPanel();
        TotalStudentPanel.setBackground(Color.LIGHT_GRAY);
        TotalStudentPanel.setPreferredSize(new Dimension(240, 290));
        //--------------------------------------------------------------------------------------
        TotalPublicerPanel=new JPanel();
        TotalPublicerPanel.setBackground(Color.GREEN);
        TotalPublicerPanel.setPreferredSize(new Dimension(240, 290));
        //--------------------------------------------------------------------------------------
        RequirementPanel=new JPanel();
        RequirementPanel.setBackground(Color.LIGHT_GRAY);
        RequirementPanel.setPreferredSize(new Dimension(240, 290));
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
        menubar.add(publicationmenu);
        menubar.add(studentmenu);
        menubar.add(staffmenu);
        menubar.add(overduemenu);
        menubar.add(requirementmenu);
        menubar.add(settingmenu);
        menubar.add(helpmenu);
        
        
        Admin.add(menubar);
        Admin.add(dynamicpanel);
        Admin.add(sidepanel);
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
            TotalBookslabel=new JLabel("25");
            TotalBookslabel.setBounds(15,15,50,50);
            TotalBookslabel.setFont(myFont);
            TotalStudentlabel=new JLabel();
            TotalIssuedBookslabel=new JLabel();
            TotalDepartmentlabel=new JLabel();
            TotalPublicerlabel=new JLabel();
            Requirementlabel=new JLabel();
            TotalStafflabel=new JLabel();
            TotalBookAvailablelabel=new JLabel();
            TotalBookAvailable.add(TotalBookslabel);
            dynamicpanel.add(TotalBookAvailable);
            dynamicpanel.add(TotalDepartmentPanel);
            dynamicpanel.add(TotalIssuedBooksPanel);
            dynamicpanel.add(TotalStaffPanel);
            dynamicpanel.add(TotalPublicerPanel);
            dynamicpanel.add(RequirementPanel);
            dynamicpanel.add(TotalStudentPanel);
            dynamicpanel.add(TotalBooksPanel);
            
        //TotalBooksPanel.add(help);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==helpItem){
            System.out.println("help");
        }
        if(e.getSource()==adminItem){
            System.out.println("admin");
            dynamicpanel.removeAll();

            dynamicpanel.add(TotalBookAvailable);
            dynamicpanel.add(TotalPublicerPanel);
            dynamicpanel.revalidate();
            dynamicpanel.repaint();
        }
        if(e.getSource()==requirItem){
            System.out.println("require");
        }
        if(e.getSource()==viewbook){
            System.out.println("viewbook");
            
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