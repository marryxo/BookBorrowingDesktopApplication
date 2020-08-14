package bookborrowing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class borrowpage extends JFrame{
  
    JLabel title,l0,l1,l2,l3;
    JTextField text1,text2,text3;
    JButton b1;
    JPanel p;
    JComboBox box;
    private static String sql0;
    PreparedStatement ps;
    ResultSet rs;
    int userid;
    String usrename;
    Main m;
    public borrowpage(final int userid, final String username) {
        
        super("Borrow Books");
        this.userid=userid;
        this.usrename=username;
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        GridBagConstraints gbc=new GridBagConstraints();
        Color lyellow = new Color(232,157,170);
        Color aqua = new Color(11,211,208);
        
        title=new JLabel("Borrow  Books", SwingConstants.CENTER);
        title.setForeground(lyellow);
        title.setFont(new Font("Jenna Sue", Font.PLAIN,50));
        
        gbc.gridx=200;
        gbc.gridy=0;
        add(title,gbc);
        
        l1=new JLabel("Book Title: ");
        l2=new JLabel("Start Date Borrow: ");
        l3=new JLabel("Return Date Borrow: ");
        b1=new JButton("Borrow");
        p=new JPanel();
        
        l1.setFont(new Font("AppleGothic", Font.PLAIN,12));
        l2.setFont(new Font("AppleGothic", Font.PLAIN,12));
        l3.setFont(new Font("AppleGothic", Font.PLAIN,12));
        l1.setForeground(lyellow);
        l2.setForeground(lyellow);
        l3.setForeground(lyellow);
        
        b1.setForeground(lyellow);
        b1.setFont(new Font("AppleGothic", Font.PLAIN,12));
        
       
        
        box=new JComboBox();
        text2=new JTextField(10);
        text3=new JTextField(10);
        
        
        p.setLayout(new GridLayout(3,2,10,10));
        p.add(l1);
        p.add(box);
        p.add(l2);
        p.add(text2);
        p.add(l3);
        p.add(text3);
        
         gbc.gridx=200;
        gbc.gridy=50;
        add(p,gbc);
        gbc.gridx=200;
        gbc.gridy=200;
        add(b1,gbc);
        gbc.gridx=200;
        gbc.gridy=550;
        
       
        
        l0=new JLabel("Go back to main", SwingConstants.CENTER);
        l0.setForeground(aqua);
        l0.setFont(new Font("AppleGothic", Font.PLAIN,15));
        add(l0,gbc);
        
        
       try{
        String sql1="select b_title from books WHERE status=? AND uid != ? ";
        ps = DBConnection.getConnection().prepareStatement(sql1);
        ps.setString(1, "Available");
        ps.setInt(2, userid);
        rs=ps.executeQuery();
        while (rs.next()) {  
            box.addItem(rs.getString("b_title")); 
        }
       }catch(Exception e) { 
           JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
           
       }
      
       
           
        l0.addMouseListener( new MouseAdapter()
    {
        public void mouseClicked( MouseEvent e )
        {
            int userid = 0;
            setVisible(false);
            m=new Main(username, userid);
            m.setVisible(true);
        }
    });
           
        b1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                try {
                String btitle=box.getSelectedItem().toString();
                int selectedI=box.getSelectedIndex();
                String sdate=text2.getText();
                String rdate=text3.getText();
                
                    String sql01="INSERT INTO `bookBorrowing`( `u_id`, `b_title`, `date_b`, `date_r`) VALUES (?,?,?,?)";
                    ps=DBConnection.getConnection().prepareStatement(sql01);
                    
                    ps.setInt(1, userid);
                    ps.setString(2, btitle);
                    ps.setString(3, sdate);
                    ps.setString(4, rdate);
                    
                    if(ps.executeUpdate()>0){
                    String sql012="UPDATE books SET status=?  WHERE  b_title=?";
                    ps=DBConnection.getConnection().prepareStatement(sql012);
                    ps.setString(1, "Unavailable");
                    ps.setString(2, btitle);
                    if(ps.executeUpdate()>0){
                     JOptionPane.showMessageDialog(null,"Borrow Sucessfully");
                     box.removeItemAt(selectedI);
                     box.setSelectedItem( box.getItemAt(0));
                     text2.setText("");
                     text3.setText(""); 
                    }
                    }
                     } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
               
                
            
        }} );
        
    }
   
}


