
package bookborrowing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class logoutpage extends JFrame{
    JLabel l1,l2,l3;
    
    public logoutpage(){
        super("Log out");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
        Color lyellow = new Color(232,157,170);
        
        l1=new JLabel("GoodBye", SwingConstants.CENTER);
        l1.setFont(new Font("Jenna Sue",Font.BOLD,55));
        l1.setForeground(lyellow);
        ImageIcon pic=new ImageIcon("/Users/sulimanreem/NetBeansProjects/BookBorrowing/giphy2.gif");
        l2=new JLabel(pic);
        l3=new JLabel("Go To Log in Page..", SwingConstants.CENTER);
        l3.setFont(new Font("Jenna Sue",Font.BOLD,24));
        l3.setForeground(lyellow);
        add(l1,BorderLayout.NORTH);
        add(l2,BorderLayout.CENTER);
        add(l3,BorderLayout.SOUTH);
        
        
        l3.addMouseListener( new MouseAdapter()
    {
        public void mouseClicked( MouseEvent e )
        {
           setVisible(false);
            Login l=new Login();
            l.setVisible(true);
        }
    });
        
        
    }
}
