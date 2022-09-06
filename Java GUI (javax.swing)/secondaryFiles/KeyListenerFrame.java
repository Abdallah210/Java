package secondaryFiles;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerFrame extends JFrame implements KeyListener {


    JLabel player = new JLabel();
    ImageIcon playerIcon = new ImageIcon("./images/directionsIcon.png");
 

    public KeyListenerFrame(){
            

            //Frame :
            this.setSize(500, 500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Key listener");
            this.setLayout(null);
            this.addKeyListener(this);


            //Label :
            this.player.setBounds(0, 0, 50, 50);
            this.player.setIcon(playerIcon);
            this.player.setBackground(Color.black);





            this.add(player);
            this.setVisible(true);



    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                if (player.getX()>0) {
                    player.setLocation(player.getX()-10, player.getY());
                }
                break;
            case 'w':
                if (player.getY()>0) {
                    player.setLocation(player.getX(), player.getY()-10);
                }
                break;
            case 'd':
            if (player.getX()+player.getWidth()<this.getWidth()) {
                player.setLocation(player.getX()+10, player.getY());
            }
                break;
            case 's':
            if (player.getY()+player.getHeight()<this.getHeight()) {
                player.setLocation(player.getX(), player.getY()+10);
            }
                break;
        
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                this.player.setLocation(this.player.getX()-10, this.player.getY());
                break;
            case 38:
                this.player.setLocation(this.player.getX(), this.player.getY()-10);
                break;
            case 39:
                this.player.setLocation(this.player.getX()+10, this.player.getY());
                break;
            case 40:
                this.player.setLocation(this.player.getX(), this.player.getY()+10);
                break;
        
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("you realesed key character : "+ e.getKeyCode());
        System.out.println("his key code is : "+ e.getKeyCode());
        
    }


    
}
