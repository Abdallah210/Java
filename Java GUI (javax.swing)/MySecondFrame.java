import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

public class MySecondFrame extends JFrame {
    
    // We can use a class for a frame 

    MySecondFrame(){
    
        this.setTitle("my second frame !");   

        this.setSize(420, 420);  
        this.setResizable(false);  
    
    
        this.setVisible(true); 
    
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
        ImageIcon icon = new ImageIcon("images/animeIcon.png"); 
        this.setIconImage(icon.getImage());  
    
        Color myColor = new Color(60,8,50); 
        this.getContentPane().setBackground(myColor);  

        // method from Window class
        this.setLocation(420, 0);
    
    }
}
