package Game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Game.interfaces.GameInterface;
import Game.interfaces.LandingInterface;
import Game.interfaces.UserInterface;
import java.awt.Rectangle;


public class Game extends JFrame {

    private ImageIcon icon = new ImageIcon("images/icon.png");  
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final Rectangle FRAMESIZE = new Rectangle(0, 0, 1600, 1000);

          
    // Interfaces :
    private JLabel landingInterface = new LandingInterface(this);
    private JLabel userInterface = new UserInterface(this);
    private JLabel gameInterface = new GameInterface(this);




    Game(){

        this.gameFrame();

        landingInterface.setVisible(true);
        userInterface.setVisible(false);
        gameInterface.setVisible(false);
        this.add(landingInterface);
        this.add(userInterface);
        this.add(gameInterface);


        this.setVisible(true);
        


    }


    public void gameFrame() {

        // Frame (game's window):

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess - By EFA");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0x8f99a3));
        this.setLayout(null);
        this.setSize(800,800);
        this.setLocation(500, 25);
        this.setBounds(0, 0,  1600, 1000);
        this.setResizable(false);   
                    
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y-30);

    }

    public JLabel getUserInterface() {
        return this.userInterface;
    }

    public JLabel getLandingInterface() {
        return this.landingInterface;
    }

    public JLabel getGameInterface() {
        return this.gameInterface;
    }

    public Rectangle getFrameSize() {
        return this.FRAMESIZE;
    }
}


