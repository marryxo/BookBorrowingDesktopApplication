
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
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class booksEditing extends JFrame {
    private JLabel bookTitle, author, description, genre;
    private JTextField bookTitleF, autherF, descriptionF;
    private JComboBox genreB;
    private JButton insert, update, delete, clear;
    private JLabel main, title;
    JList<String> list;
    DefaultListModel<String> DLM; 
    private static String sqlQ;
    PreparedStatement ps;
    ResultSet rs;
    Border raisedbevel,loweredbevel;
    int userid;
    String usrename;
    Main m;
    Login log;
    
    public booksEditing(final int userid, final String username){
        super("Books Editing");
        this.userid=userid;
        this.usrename=username;
        
        setLayout(new GridBagLayout());
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBackground(Color.white);
        JPanel booksEditingPanel=new JPanel();
        booksEditingPanel.setLayout(new GridLayout(4,2));
        GridBagConstraints gbc = new GridBagConstraints();
        Color lyellow = new Color(232,157,170);
        Color aqua = new Color(11,211,208);
        
        list = new JList<>();
        Border compound;
       
        raisedbevel = BorderFactory.createBevelBorder(1, lyellow, lyellow);
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        list.setBorder(compound);
        DLM = new DefaultListModel<>(); 
        
        list.setPreferredSize(new Dimension(300, 100));
        fillList();
        title=new JLabel("Book Editing");
        bookTitle=new JLabel("Book Title: ");
        author=new JLabel("Author: ");
        genre=new JLabel("Genre: ");
        description=new JLabel("Description: ");
        title.setForeground(lyellow);
        title.setFont(new Font("Jenna Sue", Font.PLAIN,50));
        bookTitleF=new JTextField();
        autherF=new JTextField();
        descriptionF=new JTextField();
       
        genreB=new JComboBox();
        genreB.addItem("Drama");
        genreB.addItem("Action");
        genreB.addItem("adventure");
        genreB.addItem("Fantasy");
        genreB.addItem("Mystery");
        genreB.addItem("Horror");
        genreB.addItem("Coming-of-age");
        genreB.addItem("Comic book");
        genreB.addItem("Romance");
        genreB.addItem("Poetry");
        genreB.addItem("Science fiction");
        genreB.addItem("Crime");
        
        bookTitle.setForeground(lyellow);
        author.setForeground(lyellow);
        genre.setForeground(lyellow);
        description.setForeground(lyellow);
        
        
        bookTitle.setFont(new Font("AppleGothic", Font.BOLD,12));
        author.setFont(new Font("AppleGothic", Font.BOLD,12));
        genre.setFont(new Font("AppleGothic", Font.BOLD,12));
        description.setFont(new Font("AppleGothic", Font.BOLD,12));
        
        booksEditingPanel.add(bookTitle);
        booksEditingPanel.add(bookTitleF);
        booksEditingPanel.add(author);
        booksEditingPanel.add(autherF);
        booksEditingPanel.add(genre);
        booksEditingPanel.add(genreB);
        booksEditingPanel.add(description);
        booksEditingPanel.add(descriptionF);
        
        insert=new JButton("Add");
        update=new JButton("Update");
        delete=new JButton("Delete");
        clear=new JButton("Clear");
        
        insert.setForeground(lyellow);
        update.setForeground(lyellow);
        delete.setForeground(lyellow);
        clear.setForeground(lyellow);
        
        insert.setFont(new Font("AppleGothic", Font.PLAIN,12));
        update.setFont(new Font("AppleGothic", Font.PLAIN,12));
        delete.setFont(new Font("AppleGothic", Font.PLAIN,12));
        clear.setFont(new Font("AppleGothic", Font.PLAIN,12));
        
        
        JPanel buttonsPanel=new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(insert);
        buttonsPanel.add(update);
        buttonsPanel.add(delete);
        buttonsPanel.add(clear);
        
        main=new JLabel("Go back to main");
        main.setForeground(aqua);
        main.setFont(new Font("AppleGothic", Font.PLAIN,15));
        
        gbc.gridx = 200;
        gbc.gridy = 50;
        add(title,gbc);
        gbc.gridx = 200;
        gbc.gridy = 100;
        add(list , gbc);
        gbc.gridx = 200;
        gbc.gridy = 200;
        add(booksEditingPanel,gbc);
        gbc.gridx = 200;
        gbc.gridy = 250;
        add(buttonsPanel,gbc);
        gbc.gridx = 200;
        gbc.gridy = 300;
        add(main,gbc);
        
        
         main.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                m=new Main(username, userid);
                setVisible(false);
                m.setVisible(true);
            }
        });
         
         list.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                 try{
        String tmp=(String) list.getSelectedValue();
        String sqlQ1="SELECT `auther`,`description`,`genre` FROM `books` WHERE uid=? AND status=? AND `b_title`=? ";
        ps= DBConnection.getConnection().prepareStatement(sqlQ1);

        ps.setInt(1, userid);
        ps.setString(2, "Available");
        ps.setString(3, tmp);
        rs=ps.executeQuery();
        if(rs.next()){
            String auther=rs.getString("auther");
            String description=rs.getString("description");
            String genre=rs.getString("genre");
          bookTitleF.setText(tmp);
          autherF.setText(auther);
          genreB.setSelectedItem(genre);
          descriptionF.setText(description);
        } 
        }catch(Exception ex){
    JOptionPane.showMessageDialog(rootPane, ex.getMessage());

    } 
            }
        });
        insert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
           
           if(bookTitleF.getText().equals("") || autherF.getText().equals("") || descriptionF.getText().equals("")){
             JOptionPane.showMessageDialog(rootPane, "All fields are required", "error message", JOptionPane.ERROR_MESSAGE);

           }
           else {
               try{
               String bookTitle=bookTitleF.getText();
               String auther=autherF.getText();
               String description=descriptionF.getText();
               String genre=genreB.getSelectedItem().toString();
               
               
               sqlQ="INSERT INTO books(b_title, auther, description, genre, status, uid) VALUES (?,?,?,?,?,?)";
               ps= DBConnection.getConnection().prepareStatement(sqlQ);
               
               ps.setString(1, bookTitle);
               ps.setString(2, auther);
               ps.setString(3, description);
               ps.setString(4, genre);
               ps.setString(5, "Available");
               ps.setInt(6, userid);
                     
                     if(ps.executeUpdate()>0){
                         DLM.addElement(bookTitle);
                         JOptionPane.showMessageDialog(rootPane, "Book added sucessfully!");
                     }
               } catch(SQLException ex){
                   if (ex instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(rootPane,ex , "error message", JOptionPane.ERROR_MESSAGE);  //"The book entered has already been added"
    } else{
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
           }
               }finally{
        try {
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(booksEditing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
                     
       }
        }});

      clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
          bookTitleF.setText("");
          autherF.setText("");
          genreB.setSelectedItem( genreB.getItemAt(0));
          descriptionF.setText("");
          list.clearSelection();
      }
            });
      
       delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    int i=list.getSelectedIndex();
                    list.clearSelection();
                    String sqlQ1="DELETE FROM books WHERE b_title=? ";
                    ps= DBConnection.getConnection().prepareStatement(sqlQ1);
                    ps.setString(1, bookTitleF.getText());
                    if(ps.executeUpdate()>0){
                    DLM.removeElementAt(i);
                    bookTitleF.setText("");
                    autherF.setText("");
                    genreB.setSelectedItem( genreB.getItemAt(0));
                    descriptionF.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Record deleted sucessfully");
                    }

                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
      }
            });
       update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try {
                String i=list.getSelectedValue(); //book choosen
                int ii=list.getSelectedIndex();
                String sqlQ1="SELECT b_id FROM books WHERE b_title=? ";
                ps= DBConnection.getConnection().prepareStatement(sqlQ1);
                ps.setString(1, i);
                rs=ps.executeQuery();
                if(rs.next()){
                int b_id=rs.getInt("b_id");
                String bookTitle=bookTitleF.getText();
                String author=autherF.getText();
                String genre= genreB.getSelectedItem().toString();
                String description=descriptionF.getText();
                String sqlQ12="UPDATE books SET b_title=? ,auther=?,description=?,genre=?  WHERE b_id=? ";
                    ps= DBConnection.getConnection().prepareStatement(sqlQ12);
                    ps.setString(1, bookTitle);
                    ps.setString(2, author);
                    ps.setString(3, description);
                    ps.setString(4, genre);
                    ps.setInt(5, b_id);
                    if(ps.executeUpdate()>0){
                    if(!DLM.getElementAt(ii).equals(bookTitle)){
                        DLM.removeElementAt(ii);
                        DLM.addElement(bookTitle);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Record updated sucessfully");
                    }

                }
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }

                
       }
        });
       
    }
    
    private void fillList(){
    try{
        String sqlQ1="SELECT b_title, auther,description,genre FROM books WHERE uid=? AND status=? ";
        ps= DBConnection.getConnection().prepareStatement(sqlQ1);

        ps.setInt(1, userid);
        ps.setString(2, "Available");
        rs=ps.executeQuery();
        while(rs.next()){
            String bookTitle=rs.getString("b_title");
          DLM.addElement(bookTitle);
        } list.setModel(DLM);
    }catch(Exception e){
    JOptionPane.showMessageDialog(rootPane, e.getMessage());
    } 
    }
}
