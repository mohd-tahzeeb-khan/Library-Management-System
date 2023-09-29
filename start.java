import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class start extends JFrame implements ActionListener{
    JButton login_button, clear_Button, exit;
    JFrame login;
    JTextField username;
    JPasswordField password;
    JLabel heading, passwordlabel, usernamelabel,subheading;
    start(){
        login=new JFrame("Login");
        heading=new JLabel("Library Management System");
        heading.setBounds(400, 10, 1465, 70);
        heading.setForeground(Color.WHITE);
        Font originalfont=heading.getFont();//Getting the size of existing font in JTextField
        Font newFont = originalfont.deriveFont(originalfont.getSize() + 40.0f);//Increasing the font size by 10pixels.
        heading.setFont(newFont);
        JPanel jpanel=new JPanel();
        jpanel.setBounds(10, 0, 1465, 90);
        jpanel.setBackground(Color.BLACK);
        JPanel jpanelimage =new JPanel();
        jpanelimage.setBounds(750, 100, 725, 650);
        jpanelimage.setBackground(Color.WHITE);
        JPanel jpanellogin =new JPanel();
        jpanellogin.setBounds(10, 100, 745, 650);
        jpanellogin.setBackground(Color.WHITE);
        usernamelabel=new JLabel("Username:");
        usernamelabel.setBounds(100, 290, 200, 100);
        Font originalfont_label=usernamelabel.getFont();//Getting the size of existing font in JTextField
        Font newFont_label = originalfont_label.deriveFont(originalfont_label.getSize() + 10.0f);//Increasing the font size by 10pixels.
        usernamelabel.setFont(newFont_label);
        username=new JTextField();
        username.setBounds(240,325,300,40);
        username.setFont(new Font("Serif",Font.BOLD,20));
        passwordlabel=new JLabel("Password:");
        passwordlabel.setBounds(100, 300, 200, 200);
        password=new JPasswordField();
        password.setBounds(240,380,300,40);
        password.setFont(new Font("Serif",Font.BOLD,20));
        Font originalfont_password=passwordlabel.getFont();//Getting the size of existing font in JTextField
        Font newFont_password = originalfont.deriveFont(originalfont_password.getSize() + 10.0f);//Increasing the font size by 10pixels.
        passwordlabel.setFont(newFont_password);
        login_button=new JButton("  LOGIN",new ImageIcon("images/login_circle.png"));
        login_button.setBounds(100, 450, 200, 50);
        clear_Button=new JButton("  CLEAR", new ImageIcon("images/clear.png"));
        clear_Button.setBounds(340, 450, 200, 50);
        exit=new JButton("  EXIT", new ImageIcon("images/exit.png"));
        exit.setBounds(100,520, 440, 50);
        login.add(passwordlabel);
        login.setLayout(null);
        login.add(usernamelabel);
        login.add(heading);
        login.add(username);
        login.add(password);
        login.add(exit);
        login.add(login_button);
        login.add(clear_Button);
        login.add(jpanel);
        login.add(jpanelimage);
        login.add(jpanellogin);
        exit.addActionListener(this);
        login_button.addActionListener(this);
        clear_Button.addActionListener(this);

        login.setVisible(true);
        login.setSize(1500, 800);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login_button){
            String Username=username.getText();
            String Pass=new String(password.getPassword());
            
        }
        if (e.getSource()==clear_Button) {
            username.setText("");
            password.setText("");
        }
        if(e.getSource()==exit){
            login.dispose();
        }
    }
    public static void main(String args[]){
        start login=new start();
    }
}