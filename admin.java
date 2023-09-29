import java.awt.Color;
import javax.swing.*;
public class admin extends JFrame {
    admin(){
        JFrame admindashboard =new JFrame("Admin Dashboard");
        JPanel heading_panel=new JPanel();
        heading_panel.setBackground(Color.WHITE);
        heading_panel.setBounds(0,0,1500, 800);
        JButton logout=new JButton("LOGOUT");
        logout.setBounds(150,150,100,40);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        admindashboard.add(heading_panel);
        heading_panel.add(logout);
        admindashboard.setVisible(true);
        admindashboard.setSize(1500, 800);
        admindashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        admin object=new admin();
    }
}