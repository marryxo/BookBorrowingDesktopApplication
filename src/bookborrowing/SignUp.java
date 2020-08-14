
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
import javax.swing.*;

public class SignUp extends JFrame {
    private JLabel firstName, lastName, email, password, conPassword, msg;
    private JPasswordField passwordF, conPasswordF;
    private JTextField firstNameF, lastNameF, emailF;
    private JButton SignUp;
    
    
    private static String sqlQ;

       PreparedStatement ps;
       
    public SignUp(){
        super("Sign up");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation(kit.getScreenSize().width/4, kit.getScreenSize().height/4); 
        setSize(kit.getScreenSize().width/2, kit.getScreenSize().height/2); //1440, 900
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        JPanel signUpPanel=new JPanel();
        signUpPanel.setLayout(new GridLayout(5,2));
        GridBagConstraints gbc = new GridBagConstraints();
        
        Color lyellow = new Color(232,157,170);
        Color aqua = new Color(11,211,208);
        
        firstName=new JLabel("First Name:");
        lastName=new JLabel("Last Name:");
        email=new JLabel("Email:");
        password=new JLabel("Password:");
        conPassword=new JLabel("Confirm Password:");
        
        firstName.setForeground(lyellow);
        lastName.setForeground(lyellow);
        email.setForeground(lyellow);
        password.setForeground(lyellow);
        conPassword.setForeground(lyellow);
        
        firstName.setFont(new Font("AppleGothic", Font.BOLD,12));
        lastName.setFont(new Font("AppleGothic", Font.BOLD,12));
        email.setFont(new Font("AppleGothic", Font.BOLD,12));
        password.setFont(new Font("AppleGothic", Font.BOLD,12));
        conPassword.setFont(new Font("AppleGothic", Font.BOLD,12));
        
        passwordF=new JPasswordField();
        conPasswordF=new JPasswordField();
        
        firstNameF=new JTextField();
        lastNameF=new JTextField();
        emailF=new JTextField();
        
        signUpPanel.add(firstName);
        signUpPanel.add(firstNameF);
        signUpPanel.add(lastName);
        signUpPanel.add(lastNameF);
        signUpPanel.add(email);
        signUpPanel.add(emailF);
        signUpPanel.add(password);
        signUpPanel.add(passwordF);
        signUpPanel.add(conPassword);
        signUpPanel.add(conPasswordF);
        gbc.gridx = 200;
        gbc.gridy = 50;
        add(signUpPanel, gbc);
        
        SignUp=new JButton("Sign up");
        SignUp.setForeground(lyellow);
        msg=new JLabel("Already have an account? Log in");
        msg.setForeground(aqua);
        msg.setFont(new Font("AppleGothic", Font.BOLD,12));
        SignUp.setFont(new Font("AppleGothic", Font.BOLD,12));
        
        gbc.gridx = 200;
        gbc.gridy = 170;
        add(SignUp, gbc);
        gbc.gridx = 200;
        gbc.gridy = 200;
        add(msg, gbc);
        
        
        
        SignUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            if(firstNameF.getText().equals("") || lastNameF.getText().equals("") || emailF.getText().equals("") || String.valueOf(passwordF.getPassword()).equals("") || String.valueOf(conPasswordF.getPassword()).equals("") ){
               JOptionPane.showMessageDialog(rootPane, "All fields are required", "error message", JOptionPane.ERROR_MESSAGE);

            }
            else {
           if(!String.valueOf(passwordF.getPassword()).equals(String.valueOf(conPasswordF.getPassword()))){
            JOptionPane.showMessageDialog(rootPane, "The passwords entered do not match up, please enter password again", "error message", JOptionPane.ERROR_MESSAGE);
        } else{
                 try{
                    
                     String email=emailF.getText();
                     String password= String.valueOf(passwordF.getPassword());
                     String fName=firstNameF.getText();
                     String lName=lastNameF.getText();
                     
                    sqlQ="INSERT INTO `users`(`f_name`, `l_name`, `password`, `email`) VALUES (?,?,?,?)";
                    ps= DBConnection.getConnection().prepareStatement(sqlQ);
                     
                     ps.setString(1, fName);
                     ps.setString(2, lName);
                     ps.setString(3, password);
                     ps.setString(4, email);
                     if(ps.executeUpdate()>0){
                         JOptionPane.showMessageDialog(rootPane, "Sign up sucessfully!");
                     }
                     
       } catch (SQLException ex) {
           if (ex instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(rootPane, "The email entered has already registerd", "error message", JOptionPane.ERROR_MESSAGE);
    } else{
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
           }
    }
            
            
        }

       }
            }
        });
        
        
        msg.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Login li=new Login();
                setVisible(false);
                li.setVisible(true);
            }
        });
        
        
    }
    
}
