package Game.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Game.Game;


public class LandingInterface extends JLabel {

    private JButton button = new JButton(); 
    private ImageIcon logoEFA = new ImageIcon("./images/logoEFA.png");
    private ImageIcon logo = new ImageIcon("./images/logo.png");
    private JLabel logoLabel = new JLabel();
    private JLabel logoEFALabel = new JLabel();
    
    private Game game;

    public LandingInterface(Game game) {

        this.game = game;
        this.setBounds(this.game.getFrameSize());
        this.setVerticalAlignment(JLabel.CENTER);  
        this.setHorizontalAlignment(JLabel.CENTER);

        // Button
        this.button.setText("PLAY"); 
        this.button.setFocusable(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.TOP);
        this.button.setFont(new Font("Comic Sans",Font.BOLD, 20));
        this.button.setBackground(new Color(0x616e7c));
        this.button.setForeground(new Color(0xc7ccd1));
        this.button.setEnabled(true);

        // Logo :
        this.logoLabel.setIcon(logo);
        this.logoLabel.setVerticalAlignment(JLabel.CENTER);    
        this.logoLabel.setHorizontalAlignment(JLabel.CENTER);
        this.logoLabel.setBounds(0, 0, 840,500);
        this.logoLabel.setOpaque(false);

        // EFA logo :
        this.logoEFALabel.setIcon(logoEFA);
        this.logoEFALabel.setVerticalAlignment(JLabel.CENTER);    
        this.logoEFALabel.setHorizontalAlignment(JLabel.CENTER);
        this.logoEFALabel.setBounds(0, 0, 300,175);
        this.logoEFALabel.setOpaque(false);

        this.button.setBounds((this.getWidth()-350)/2, (this.getHeight()+200)/2, 350, 175);
        this.logoLabel.setBounds((this.getWidth()-840)/2, (this.getHeight()-850)/2, 840, 500);
        this.logoEFALabel.setBounds(this.getWidth()-325, -25, 350, 175);

        this.add(logoLabel);
        this.add(button);
        this.add(logoEFALabel);


        // pass to user interface :
        button.addActionListener(     
            e -> {
                this.game.getLandingInterface().setVisible(false);
                this.game.getUserInterface().setVisible(true);
                this.game.getGameInterface().setVisible(false);
                }
            );   
    }
    
}
