
package bookborrowing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {
    
    draw d;
    int userid;
    String username;
    
    JMenuBar bar;
    JMenu Menu1,Menu2;
    JMenuItem  i2, i3;
    
    JButton b1;
public Main(){
    super("Main");
    
}
        
    
        public Main(final String username, final int userid){
        super("Main");
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d=new draw();
        d.setString(""+username);
        Menu1=new JMenu("Books");
        Menu2=new JMenu("Borrow");
        Color c=new Color(232,157,170);
        i2=new JMenuItem("Edit Books");
        i3=new JMenuItem("Borrow Books");
        i2.setForeground(c);
        i3.setForeground(c);
        bar=new JMenuBar();
        
        bar.setForeground(c);
        bar.setOpaque(true);
        Menu1.add(i2);
        Menu2.add(i3);
        
        setJMenuBar(bar);
        bar.add(Menu1);
        bar.add(Menu2);
        add(d,BorderLayout.CENTER);
        
        b1=new JButton("logout");
        b1.setForeground(c);
        add(b1,BorderLayout.SOUTH);
        
         
         i2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //EditPage
               booksEditing be=new booksEditing(userid,username);
               setVisible(false);
               be.setVisible(true);
            }
        } );
          i3.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             borrowpage b=new borrowpage(userid,username);
               setVisible(false);
               b.setVisible(true);
            }
        } );
          b1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //logout
               setVisible(false);
               logoutpage l=new logoutpage();
                l.setVisible(true);
            }
        } );
           
        
    }

    
    
}
