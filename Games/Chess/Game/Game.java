package Game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Game.board.Board;


public class Game extends JFrame {

    private Board board = new Board();
                
    private ImageIcon icon = new ImageIcon("images/icon.png");  

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private Player player1 = new Player("white", this.board, false);
    private Player player2 = new Player("black", this.board, true);


    Game(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Chess");
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(new Color(0x3f4953));

        this.setLayout(null);

        this.setSize(800,800);
        this.setLocation(500, 25);
        this.setBounds(0, 0,  1700, 1000);

        this.setResizable(false);   
        this.setVisible(true);

        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y-30);

        this.board.getBoardPanel().setBounds((this.getWidth()-702)/2, 75,  700, 700);

        Player[] players = {player1, player2};

        for (Player player : players) {
            
            for (int i = 0; i < player.getPositions().length; i++) {
                this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).addPieceInCell(player.getPieces()[i]);

                this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).setCellLabelIcon(this.board.getCell((int)player.getPositions()[i].getX(), (int)player1.getPositions()[i].getY()).getPiece().getImage());
                this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).getCellLabel().setHorizontalAlignment(JLabel.CENTER);
                this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).getCellLabel().setVerticalAlignment(JLabel.CENTER);
            }
        }

        this.add(board.getBoardPanel());


    
    }




}

