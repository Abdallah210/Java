package Game.interfaces;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.Game;
import Game.Player;

public class UserInterface extends JLabel {

    private Game game;

    private JLabel logoLabel = new JLabel();
    private JLabel mainLabel = new JLabel();
    private JLabel timeLabel = new JLabel();
    private JLabel player1Label = new JLabel();
    private JLabel player2Label = new JLabel();

    private int time;
    private Player player1;
    private Player player2;
    private ImageIcon logo = new ImageIcon("./images/miniLogo.png");

    public UserInterface(Game game) {
        
        this.game = game;
        this.setBounds(this.game.getFrameSize());
        this.setVerticalAlignment(JLabel.CENTER);  
        this.setHorizontalAlignment(JLabel.CENTER);

        // Logo :
        this.logoLabel.setIcon(logo);
        this.logoLabel.setVerticalAlignment(JLabel.CENTER);    
        this.logoLabel.setHorizontalAlignment(JLabel.CENTER);
        this.logoLabel.setBounds((this.getWidth()-175)/2,150,175,95);
        this.logoLabel.setOpaque(false);

        // Main label :
        this.mainLabel.setBounds((this.getWidth()-1475)/2,(this.getHeight()-900)/2,1475,875);
        this.mainLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.mainLabel.setBackground(new Color(0x455565));
        this.mainLabel.setOpaque(true);

        // Time label :
        this.timeLabel.setBounds(562,350,475,500);
        this.timeLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.timeLabel.setBackground(new Color(0x455565));
        this.timeLabel.setOpaque(true);

        // Player labels :
        this.player1Label.setBounds(112,350,425,500);
        this.player1Label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.player1Label.setBackground(new Color(0x455565));
        this.player1Label.setOpaque(true);

        this.player2Label.setBounds(1062,350,425,500);
        this.player2Label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.player2Label.setBackground(new Color(0x455565));
        this.player2Label.setOpaque(true);


        this.add(logoLabel);
        this.add(timeLabel);
        this.add(player1Label);
        this.add(player2Label);
        this.add(mainLabel);
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public int getTime() {
        return this.time;
    }









    
}
