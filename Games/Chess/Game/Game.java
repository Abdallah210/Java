package Game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
//import java.awt.FlowLayout;

//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Game.board.Board;


public class Game extends JFrame {

    Board board = new Board();
                
    ImageIcon icon = new ImageIcon("images/icon.png");  

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    Game(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Chess");
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(new Color(0x455565));
        //this.getRootPane().setBorder(BorderFactory.createLineBorder(40, 5, 20, 5, Color.gray));

        this.setLayout(null);

        this.setSize(800,800);
        this.setLocation(500, 25);
        this.setBounds(0, 0,  1700, 1000);

        this.setResizable(false);   
        this.setVisible(true);

        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y-30);

        this.board.getBoardPanel().setBounds((this.getWidth()-802)/2, 28,  800, 800);


        this.add(board.getBoardPanel());


    
    }








}

