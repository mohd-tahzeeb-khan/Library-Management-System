import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;
 
public class admin extends JFrame{
    JFrame Admin;
    JLabel name, logo_images;
    JButton logout, help;
    JPanel heading_Panel, plain_Panel, dynamicpanel;
    CardLayout cardlayoutinstance;
    ImageIcon icon;

    admin(){
        Admin=new JFrame();
        Admin.setTitle("Admin Dashboard");
        heading_Panel=new JPanel();
        heading_Panel.setBounds(20,15,1450, 100);
        heading_Panel.setBackground(Color.LIGHT_GRAY);
        plain_Panel=new JPanel();
        plain_Panel.setBounds(20,15,1450, 100);
        plain_Panel.setBackground(Color.WHITE);
        Admin.setSize(1500, 800);
        icon=new ImageIcon("images/logo.png");
        logo_images=new JLabel(icon);
        logo_images.setBounds(30,35,80,65);
        name=new JLabel("Tahzeeb");
        name.setBounds(150,20,150,60);
        help=new JButton("HELP");
        help.setBounds(1350, 30, 100, 35);
        help.setBackground(Color.LIGHT_GRAY);
        help.setForeground(Color.BLACK);
        logout=new JButton("LOGOUT");
        logout.setBounds(1350, 70, 100, 35);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        cardlayoutinstance=new CardLayout();
        dynamicpanel=new JPanel(cardlayoutinstance);
        JPanel dashboard=new JPanel();
        JPanel book= new JPanel();
        JPanel student=new JPanel();
        JPanel staff=new JPanel();
        JPanel publication=new JPanel();
        JPanel admin=new JPanel();
        JPanel account=new JPanel();
        JPanel setting=new JPanel();
        dynamicpanel.add(dashboard, "Dashboard");
        dynamicpanel.add(book, "Books");
        dynamicpanel.add(student, "Students");
        dynamicpanel.add(staff, "Staff");
        dynamicpanel.add(publication, "Publications");
        dynamicpanel.add(admin, "Admin");
        dynamicpanel.add(account, "Accounts");
        dynamicpanel.add(setting, "Setting");
        getContentPane().add(dynamicpanel, BorderLayout.CENTER);
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu dashboardmenu=new JMenu("DASHBOARD");
        JMenu bookmenu=new JMenu("BOOKS");
        JMenu studentmenu=new JMenu("STUDENTS");
        JMenu staffmenu=new JMenu("STAFF");
        JMenu publicationmenu=new JMenu("PUBLICATIONS");
        JMenu adminmenu=new JMenu("ADMIN");
        JMenu accountmenu=new JMenu("ACCOUNTS");
        JMenu settingmenu=new JMenu("SETTING");
        menubar.add(dashboardmenu);
        menubar.add(accountmenu);
        menubar.add(staffmenu);
        menubar.add(settingmenu);
        menubar.add(bookmenu);
        menubar.add(adminmenu);
        menubar.add(publicationmenu);
        menubar.add(studentmenu);
        menubar.setBounds(600,65,600, 50);
        menubar.setBackground(Color.WHITE);


        Admin.setVisible(true);
        Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Admin.add(name);
        Admin.add(logo_images);
        Admin.add(help);
        Admin.add(logout);
        Admin.add(menubar);
        Admin.add(plain_Panel);
        Admin.add(heading_Panel);

    }
    public static void main(String args[]){
        admin adminobj=new admin();
    }
}