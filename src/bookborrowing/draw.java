
package bookborrowing;

import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{
    String a;
    Login log;
    public draw(){
        log=new Login();
        
    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Color c=new Color(232,157,170);
        g.setColor(c);
        //حجم الكتاب
        g.fillRoundRect(550, 100,300, 350, 50, 50);
        
        g.fillRoundRect(760, 100, 90, 55, 0, 0);
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(553, 398,300, 50, 50, 50);
        g.fillRoundRect(830, 400, 50, 50, 55, 55);
        g.setColor(Color.GRAY);
        //الخطين حق الصفحات
        g.drawLine(583, 435, 850, 435);
        g.drawLine(583, 415, 850, 415);
        //حدود احافة الصفحات 
        g.drawRoundRect(553, 398,300, 50, 50, 50);
        g.drawRoundRect(553, 398,300, 50, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(830, 400, 50, 50, 55, 55);
 
         g.setColor(Color.MAGENTA);
         //g.fillRoundRect(360, 50, 90, 55, 0, 0);
         //بوكس النص
         g.setColor(Color.WHITE);
         g.fill3DRect(655,150, 120, 60, true);
         g.setColor(Color.GRAY);
         Font ff=new Font("Jenna Sue",Font.BOLD,75);
         g.setFont(ff);
         g.drawString("Welcome ",620,70);
         Font f=new Font("Jenna Sue",Font.BOLD,40);
         g.setFont(f);
         g.drawString(a,690,185);
         g.setColor(Color.GRAY);
         //خطوط لتحديد الكتاب
         g.drawLine(850, 100, 850, 398);
         g.drawLine(575, 100, 850, 100);
         g.drawLine(575, 100, 575, 358);
         //رسم مؤشر الكتاب
         g.fillRoundRect(610, 415,20, 50, 0, 0);
         //رسم مثلث لتشكيل مؤشر الكتاب
         g.setColor(Color.WHITE);
         g.fillPolygon(new int[] {620, 610, 630}, new int[] {445, 465, 465}, 3);
         
         
        
        
    }
    public void setString(String a){
        this.a=a;
    }
     
    
}
