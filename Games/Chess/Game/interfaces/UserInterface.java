package Game.interfaces;


import java.awt.Color;
import java.awt.Font;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Game.board.util.MySlider;

import java.awt.event.KeyListener;

import Game.Game;

public class UserInterface extends JLabel implements ChangeListener, ActionListener, KeyListener{

    static final int TIME_MIN = 5;
    static final int TIME_MAX = 30;
    static final int TIME_INIT = 10;  //initial time

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

    private JLabel plyr1Title = new JLabel("Player 1"); 
    private JLabel plyr2Title = new JLabel("Player 2");
    private JButton plyr1Btn = new JButton(); 
    private JButton plyr2Btn = new JButton(); 
    private JButton plyr1BackBtn = new JButton(); 
    private JButton plyr2BackBtn = new JButton();
    private JTextPane plyr1Text = new JTextPane(); 
    private JTextPane plyr2Text = new JTextPane();
    private ImageIcon plyr1Icon = new ImageIcon("./images/Chess_qlt60.png");
    private ImageIcon plyr2Icon = new ImageIcon("./images/Chess_qdt60.png");
    private ImageIcon whiteGarbage = new ImageIcon("./images/whiteGarbage.png");
    private ImageIcon blackGarbage = new ImageIcon("./images/blackGarbage.png");
    private JLabel plyr1Image = new JLabel();
    private JLabel plyr2Image = new JLabel();
    private JLabel enter1Name = new JLabel("Enter your name :"); 
    private JLabel enter2Name = new JLabel("Enter your name :"); 
    private String player1;
    private String player2;
    private ImageIcon logo = new ImageIcon("./images/miniLogo.png");



    public UserInterface(Game game) {
        
        this.game = game;
        this.time = this.timeSlider.getValue();
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
        this.player1Label.setBorder(BorderFactory.createLineBorder(new Color(0xe6e6e6), 3));
        this.player1Label.setBackground(new Color(0x262626));
        this.player1Label.setOpaque(true);

        this.player2Label.setBounds(1062,350,425,400);
        this.player2Label.setBorder(BorderFactory.createLineBorder(new Color(0x262626), 3));
        this.player2Label.setBackground(new Color(0xe6e6e6));
        this.player2Label.setOpaque(true);

        this.plyr1Image.setIcon(plyr1Icon);
        this.plyr2Image.setIcon(plyr2Icon);

        this.enter1Name.setBounds(30, 150, 325, 50);
        this.enter2Name.setBounds(30, 150, 325, 50);

        this.plyr1Image.setBounds(75, 45, 60, 60);
        this.plyr1Title.setBounds(160, 55, 215, 50);
        this.plyr1Btn.setBounds(100, 275, 100, 75);
        this.plyr1BackBtn.setBounds(250, 275, 75, 75);
        this.plyr1Text.setBounds(25, 200, 375, 35);
        this.plyr2Image.setBounds(75, 45, 60, 60);
        this.plyr2Title.setBounds(160, 55, 215, 50);
        this.plyr2Btn.setBounds(100, 275, 100, 75);
        this.plyr2BackBtn.setBounds(250, 275, 75, 75);
        this.plyr2Text.setBounds(25, 200, 375, 35);

        this.plyr1Title.setFont(new Font("Press start 2P", Font.PLAIN, 25));
        this.plyr1Title.setForeground(new Color(0xe6e6e6));
        this.plyr2Title.setFont(new Font("Press start 2P", Font.PLAIN, 25));
        this.plyr2Title.setForeground(new Color(0x262626));

        this.enter1Name.setFont(new Font("Press start 2P", Font.PLAIN, 15));
        this.enter1Name.setForeground(new Color(0xe6e6e6));
        this.enter2Name.setFont(new Font("Press start 2P", Font.PLAIN, 15));
        this.enter2Name.setForeground(new Color(0x262626));

        this.plyr1Text.setFont(new Font("Press start 2P", Font.PLAIN, 25)); 
        this.plyr1Text.setBackground(new Color(0xe6e6e6));
        this.plyr1Text.setCaretColor(new Color(0x262626)); 
        this.plyr1Text.setForeground(new Color(0x262626));
        this.plyr1Text.addKeyListener(this);
        this.plyr1Text.setName("plyr1Text");
        this.plyr2Text.setFont(new Font("Press start 2P", Font.PLAIN, 25)); 
        this.plyr2Text.setBackground(new Color(0x262626));
        this.plyr2Text.setCaretColor(new Color(0xe6e6e6)); 
        this.plyr2Text.setForeground(new Color(0xe6e6e6));
        this.plyr2Text.addKeyListener(this);
        this.plyr2Text.setName("plyr2Text");



        JTextPane[] textPanes = {plyr1Text, plyr2Text};

        for (JTextPane textPane : textPanes) {
            StyledDocument doc = textPane.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        }

        //Typing Enter:
        /* InputMap iMap1 = plyr1Text.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap aMap1 = plyr1Text.getActionMap();
        InputMap iMap2 = plyr2Text.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap aMap2 = plyr2Text.getActionMap();
        iMap1.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        iMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");

        aMap1.put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               System.out.println("enter pressed");
            }
         });

         aMap2.put("enter", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               System.out.println("enter pressed");
            }
         }); */

        this.plyr1Btn.setText("OK"); 
        this.plyr1Btn.setFocusable(false);
        this.plyr1Btn.setHorizontalTextPosition(JButton.CENTER);
        this.plyr1Btn.setVerticalTextPosition(JButton.TOP);
        this.plyr1Btn.setFont(new Font("Press start 2P",Font.BOLD, 20));
        this.plyr1Btn.setBackground(new Color(0xe6e6e6));
        this.plyr1Btn.setForeground(new Color(0x262626));
        this.plyr1Btn.setEnabled(true);

        this.plyr2Btn.setText("OK"); 
        this.plyr2Btn.setFocusable(false);
        this.plyr2Btn.setHorizontalTextPosition(JButton.CENTER);
        this.plyr2Btn.setVerticalTextPosition(JButton.TOP);
        this.plyr2Btn.setFont(new Font("Press start 2P",Font.BOLD, 20));
        this.plyr2Btn.setBackground(new Color(0x262626));
        this.plyr2Btn.setForeground(new Color(0xe6e6e6));
        this.plyr2Btn.setEnabled(true);

        this.plyr1BackBtn.setFocusable(false);
        this.plyr1BackBtn.setIcon(blackGarbage);
        this.plyr1BackBtn.setBackground(new Color(0xe6e6e6));
        this.plyr1BackBtn.setEnabled(true);

        this.plyr2BackBtn.setFocusable(false);
        this.plyr2BackBtn.setIcon(whiteGarbage);
        this.plyr2BackBtn.setBackground(new Color(0x262626));
        this.plyr2BackBtn.setEnabled(true);

        this.plyr1Btn.addActionListener(this);
        this.plyr2Btn.addActionListener(this);
        this.plyr1BackBtn.addActionListener(this);
        this.plyr2BackBtn.addActionListener(this);
        this.startButton.addActionListener(this);

        JComponent[] plyr1components = {enter1Name, plyr1Image, plyr1Title, plyr1Btn, plyr1BackBtn, plyr1Text};
        JComponent[] plyr2components = {enter2Name, plyr2Image, plyr2Title, plyr2Btn, plyr2BackBtn, plyr2Text};

        for (JComponent component : plyr1components) {
            this.player1Label.add(component);
        }

        for (JComponent component : plyr2components) {
            this.player2Label.add(component);
        }

        // Start label :
        this.startButton.setText("Start"); 
        this.startButton.setBounds((this.getWidth()-175)/2,800,175,100);
        this.startButton.setFocusable(false);
        this.startButton.setHorizontalTextPosition(JButton.CENTER);
        this.startButton.setVerticalTextPosition(JButton.TOP);
        this.startButton.setFont(new Font("Press start 2P",Font.BOLD, 20));
        this.startButton.setBackground(new Color(0x96a6b3));
        this.startButton.setForeground(new Color(0xe6e6e6));
        this.startButton.setEnabled(false);

        JComponent[] components = {startButton, logoLabel, timeLabel, player1Label, player2Label, mainLabel};
        for (JComponent label : components) {
            this.add(label);
        }


    }


    public String getPlayerName1() {
        return this.player1;
    }

    public String getPlayerName2() {
        return this.player2;
    }

    public int getTime() {
        return this.time;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        this.timePrinted.setText(this.timeSlider.getValue()+" minutes");
        this.time = this.timeSlider.getValue();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==this.startButton) {
            this.game.getGameInterface().getPlayer1().setName(this.getPlayerName1());
            this.game.getGameInterface().getPlayer2().setName(this.getPlayerName2());

            this.game.getGameInterface().getPlayer1().getTimerPanel().setMinutes(this.getTime());
            this.game.getGameInterface().getPlayer2().getTimerPanel().setMinutes(this.getTime());
            
            this.game.getGameInterface().printPlayerPanels();

            this.game.getLandingInterface().setVisible(false);
            this.game.getUserInterface().setVisible(false);
            this.game.getGameInterface().setVisible(true);
        }

        if (e.getSource()==this.plyr1BackBtn) {
            this.plyr1Text.setText("");
            this.plyr1Btn.setEnabled(true);
            this.startButton.setEnabled(false);
            this.plyr1Text.setEditable(true);          
        }

        if (e.getSource()==this.plyr2BackBtn) {
            this.plyr2Text.setText("");
            this.plyr2Btn.setEnabled(true);
            this.startButton.setEnabled(false);
            this.plyr2Text.setEditable(true);
        }

        if (e.getSource()==this.plyr1Btn) {
            if (this.plyr1Text.getText().length()!=0) {
                String player1Name = this.plyr1Text.getText();
                this.plyr1Text.setEditable(false);
                this.plyr1Btn.setEnabled(false);
                this.player1 = player1Name;
                if (!(plyr1Btn.isEnabled() || plyr2Btn.isEnabled())) {
                    this.startButton.setEnabled(true);
                }
            }
        }

        if (e.getSource()==this.plyr2Btn) {
            if (this.plyr2Text.getText().length()!=0) {
                String player2Name = this.plyr2Text.getText();
                this.plyr2Text.setEditable(false);
                this.plyr2Btn.setEnabled(false);
                this.player2 = player2Name;
                if (!(plyr1Btn.isEnabled() || plyr2Btn.isEnabled())) {
                    this.startButton.setEnabled(true);
                }
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void keyPressed(KeyEvent e) {

        //Enter button :
        if (e.getKeyCode()==10) {
            if (e.getComponent().getName()=="plyr1Text") {
                this.plyr1Btn.doClick();
            } else {
                e.consume();
            }
    
            if (e.getComponent().getName()=="plyr2Text") {
                this.plyr2Btn.doClick();
            } else {
                e.consume();
            }
        }

        // ESC button :
        if (e.getKeyCode()==27) {
            if (e.getComponent().getName()=="plyr1Text") {
                this.plyr1BackBtn.doClick();
            }
    
            if (e.getComponent().getName()=="plyr2Text") {
                this.plyr2BackBtn.doClick();
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }








    
}
