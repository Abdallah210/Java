package Game.interfaces;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Game.board.util.MySlider;


import Game.Game;
import Game.Player;

public class UserInterface extends JLabel implements ChangeListener{

    static final int TIME_MIN = 5;
    static final int TIME_MAX = 30;
    static final int TIME_INIT = 10;    //initial time

    private Game game;

    private JLabel logoLabel = new JLabel();
    private JLabel mainLabel = new JLabel();
    private JLabel timeLabel = new JLabel();
    private JLabel player1Label = new JLabel();
    private JLabel player2Label = new JLabel();

    private JButton startButton = new JButton();

    private JSlider timeSlider = new MySlider(TIME_MIN, TIME_MAX, TIME_INIT);
    private JLabel timePrinted = new JLabel();
    private JLabel chooseTime = new JLabel("Choose time");
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
        this.timeLabel.setBounds(562,350,475,400);
        this.timeLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.timeLabel.setBackground(new Color(0x96a6b3));
        this.timeLabel.setVerticalAlignment(JLabel.CENTER);  
        this.timeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.timeLabel.setOpaque(true);
        this.timeLabel.setLayout(null);

        this.timeSlider.setBounds(25,150,425,75);
        this.timeSlider.setPaintTrack(true);    
        this.timeSlider.setMajorTickSpacing(5);
        this.timeSlider.setPaintLabels(true);  
        this.timeSlider.setFont(new Font("Press start 2P", Font.PLAIN, 20));
        this.timeSlider.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));   
        this.timeSlider.setMinorTickSpacing(5); 
        this.timeSlider.setSnapToTicks(true);
        this.timeSlider.setBackground(new Color(0x96a6b3));
        this.timeSlider.addChangeListener(this);

        this.chooseTime.setBounds(75,50,325,50);
        this.chooseTime.setFont(new Font("Press start 2P", Font.PLAIN, 25));
        this.chooseTime.setForeground(new Color(0x272b2e));
        this.chooseTime.setVerticalAlignment(JLabel.CENTER);  
        this.chooseTime.setHorizontalAlignment(JLabel.CENTER);
        
        this.timePrinted.setBounds(75,275,325,50);
        this.timePrinted.setFont(new Font("Press start 2P", Font.PLAIN, 25));
        this.timePrinted.setForeground(new Color(0x272b2e));
        this.timePrinted.setVerticalAlignment(JLabel.CENTER);  
        this.timePrinted.setHorizontalAlignment(JLabel.CENTER);
        this.timePrinted.setText(this.timeSlider.getValue()+" minutes");


        this.timeLabel.add(chooseTime);
        this.timeLabel.add(timeSlider);
        this.timeLabel.add(timePrinted);


        // Player labels :
        this.player1Label.setBounds(112,350,425,400);
        this.player1Label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.player1Label.setBackground(new Color(0x455565));
        this.player1Label.setOpaque(true);

        this.player2Label.setBounds(1062,350,425,400);
        this.player2Label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        this.player2Label.setBackground(new Color(0x455565));
        this.player2Label.setOpaque(true);

        //this.player1Label.add(TODO)
        //this.player2Label.add(TODO)


        // Start label :
        this.startButton.setText("Start"); 
        this.startButton.setBounds((this.getWidth()-175)/2,800,175,100);
        this.startButton.setFocusable(false);
        this.startButton.setHorizontalTextPosition(JButton.CENTER);
        this.startButton.setVerticalTextPosition(JButton.TOP);
        this.startButton.setFont(new Font("Comic Sans",Font.BOLD, 20));
        this.startButton.setBackground(new Color(0x616e7c));
        this.startButton.setForeground(new Color(0xc7ccd1));
        this.startButton.setEnabled(true);

        JComponent[] components = {startButton, logoLabel, timeLabel, player1Label, player2Label, mainLabel};
        for (JComponent label : components) {
            this.add(label);
        }


        // pass to game interface :
        startButton.addActionListener(     
            e -> {
                this.game.getLandingInterface().setVisible(false);
                this.game.getUserInterface().setVisible(false);
                this.game.getGameInterface().setVisible(true);
                }
            );   
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


    @Override
    public void stateChanged(ChangeEvent e) {
        this.timePrinted.setText(this.timeSlider.getValue()+" minutes");
        
    }








    
}
