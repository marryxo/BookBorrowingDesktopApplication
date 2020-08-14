
package bookborrowing;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Login extends JFrame {
     private JLabel email, password, msg;
     private JPasswordField passwordF;
     private JTextField emailF;
     private JButton login;
     
     PreparedStatement ps;
     ResultSet rs;
     private static String sqlQ;
     String username="";
     int userid=0;
     
    public Login(){
        super("Log in");
        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Toolkit kit = Toolkit.getDefaultToolkit();
       setLocation(kit.getScreenSize().width/4, kit.getScreenSize().height/4); 
       setSize(kit.getScreenSize().width/2, kit.getScreenSize().height/2); 
       
        Color lyellow = new Color(232,157,170);
        Color aqua = new Color(11,211,208);
        
        setLayout(new GridBagLayout());
        JPanel logInPanel=new JPanel();
        logInPanel.setLayout(new GridLayout(2,2));
        GridBagConstraints gbc = new GridBagConstraints();
        
        email=new JLabel("Email:");
        password=new JLabel("Password:");
        
        email.setForeground(lyellow);
        password.setForeground(lyellow);
        email.setFont(new Font("AppleGothic", Font.BOLD,12));
        password.setFont(new Font("AppleGothic", Font.BOLD,12));
        
        emailF=new JTextField();
        passwordF=new JPasswordField();
        passwordF.setPreferredSize(new Dimension(120,20));
        
        logInPanel.add(email);
        logInPanel.add(emailF);
        logInPanel.add(password);
        logInPanel.add(passwordF);
        
        
        login=new JButton("Log in");
        login.setForeground(lyellow);
        msg=new JLabel("Don't have an account? Sign up");
        msg.setForeground(aqua);
        msg.setFont(new Font("AppleGothic", Font.BOLD,12));
        login.setFont(new Font("AppleGothic", Font.BOLD,12));
        gbc.gridx = 200;
        gbc.gridy = 50;
        add(logInPanel, gbc);
        
        gbc.gridx = 200;
        gbc.gridy = 170;
        add(login, gbc);
        
        gbc.gridx = 200;
        gbc.gridy = 200;
        add(msg, gbc);
        
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
         if(emailF.getText().equals("") || String.valueOf(passwordF.getPassword()).equals("") ){
         JOptionPane.showMessageDialog(rootPane, "All fields are required", "error message", JOptionPane.ERROR_MESSAGE);

         } else{
                try {
                    String email=emailF.getText();
                    String password=String.valueOf(passwordF.getPassword());
                    sqlQ="SELECT * FROM `users` WHERE `email`=? AND `password`=? ";
                    ps= DBConnection.getConnection().prepareStatement(sqlQ);
                    ps.setString(1, email);
                    ps.setString(2, password);
                    
                    rs=ps.executeQuery();
                    
                    if(rs.next()){
                     username=rs.getString("f_name");
                     userid=rs.getInt("u_id");
                    setVisible(false);
                    Main m=new Main(username, userid);
                    m.setVisible(true);
                    
                    

                    } else{
                  JOptionPane.showMessageDialog(rootPane, "Error loggin in, please try again", "error message", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (SQLException ex) {
                    if (ex instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(rootPane, "The email entered has already registerd", "error message", JOptionPane.ERROR_MESSAGE);
    } else{
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
           }
                }
       }}
           
        });
        
        msg.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                SignUp sp=new SignUp();
                setVisible(false);
                sp.setVisible(true);
            }
        });
    
    
        }

}
