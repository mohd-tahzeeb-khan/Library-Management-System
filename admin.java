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

        Admin.setVisible(true);
        Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Admin.add(name);
        Admin.add(logo_images);
        Admin.add(help);
        Admin.add(logout);
        Admin.add(plain_Panel);
        Admin.add(heading_Panel);

    }
    public static void main(String args[]){
        admin adminobj=new admin();
    }
}