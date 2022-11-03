package Game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.board.Board;
import Game.interfaces.FirstInterface;
import Game.interfaces.UserInterface;
import Game.pieces.Piece;


public class Game extends JFrame {

    private ImageIcon icon = new ImageIcon("images/icon.png");  
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Game interface :
    private Board board = new Board();
    private JPanel verticalPositions = new JPanel();
    private JPanel horizontalPositions = new JPanel();

    // Players :
    private Player player1 = new Player(new Color(0xf6f6f6), this.board, true);
    private Player player2 = new Player(new Color(0x455565), this.board, false);
          

    // Interfaces :
    private FirstInterface firstInterface = new FirstInterface();

    private boolean firstInterfaceVisibility;
    private boolean secondInterfaceVisibility;
    private boolean gameInterfaceVisibility;



    Game(){

        this.firstInterfaceVisibility = firstInterface.isVisible();
        this.secondInterfaceVisibility = false;
        this.gameInterfaceVisibility = false;

        if (firstInterfaceVisibility) {
            this.gameWindow();
            this.getContentPane().setBackground(new Color(0x8f99a3));

            JButton button = firstInterface.getButton();
            JLabel logo = firstInterface.getLogo();
            JLabel logoEFA = firstInterface.getLogoEFA();

            button.setBounds((this.getWidth()-350)/2, (this.getHeight()+200)/2, 350, 175);
            logo.setBounds((this.getWidth()-840)/2, (this.getHeight()-850)/2, 840, 500);
            logoEFA.setBounds(this.getWidth()-325, -25, 350, 175);

            this.add(logo);
            this.add(button);
            this.add(logoEFA);
            this.setVisible(true);

            // pass to user interface :
            button.addActionListener(     
                e -> {
                    this.firstInterfaceVisibility = false;
                    this.secondInterfaceVisibility = false;
                    this.gameInterfaceVisibility = true;
                    }
                );   
        }



        if (secondInterfaceVisibility) {
            this.gameWindow();
            this.setVisible(true);
        }

        if (gameInterfaceVisibility) { 
            this.gameWindow();
            this.board.getBoardPanel().setBounds((this.getWidth()-702)/2, 75,  750, 750);

            // Print Positions :
            horizontalPositions.setBounds((this.getWidth()-702)/2, 835, 750, 50);
            horizontalPositions.setOpaque(false);
            horizontalPositions.setLayout(null);

            verticalPositions.setBounds(390, 75, 50, 750);
            verticalPositions.setOpaque(false);
            verticalPositions.setLayout(null);

            for (int i = 0; i < 8; i++) {

                String[] letters = {"h","g","f","e","d","c","b","a"};
                String[] numbers = {"1","2","3","4","5","6","7","8"};
                JLabel label = new JLabel();
                JLabel label2 = new JLabel();

                label.setBounds(25+i*92, 0, 60, 50);
                label.setText(numbers[i]);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setFont(new Font("Dubai", Font.BOLD, 30));
                label.setForeground(new Color(0x96a6b3));

                label2.setBounds(0, 25+i*92, 50, 60);
                label2.setText(letters[i]);
                label2.setHorizontalAlignment(JLabel.CENTER);
                label2.setVerticalAlignment(JLabel.CENTER);
                label2.setFont(new Font("Dubai", Font.BOLD, 30));
                label2.setForeground(new Color(0x96a6b3));

                horizontalPositions.add(label);
                verticalPositions.add(label2);
            }

            // Players :
            Player[] players = {player1, player2};

            for (Player player : players) {  
                for (int i = 0; i < player.getPositions().length; i++) {
                    //if not killed
                    this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).addPieceInCell(player.getPieces()[i]);

                    this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).setCellLabelIcon(this.board.getCell((int)player.getPositions()[i].getX(), (int)player1.getPositions()[i].getY()).getPiece().getImage());
                    this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).getCellLabel().setHorizontalAlignment(JLabel.CENTER);
                    this.board.getCell((int)player.getPositions()[i].getX(), (int)player.getPositions()[i].getY()).getCellLabel().setVerticalAlignment(JLabel.CENTER);
                }
            }

            for (Piece dead : player1.getDeadPieces()) {
                if (dead!=null) {
                    this.player1.addToDeathList(dead);
                }
            }

            for (Piece dead : player2.getDeadPieces()) {
                if (dead!=null) {
                    this.player1.addToDeathList(dead);
                }
            }

            for (Player player : players) {
                this.add(player.getDeathPanel());
            }

            this.add(horizontalPositions);
            this.add(verticalPositions);
            this.add(board.getBoardPanel());
            this.setVisible(true);
        }
    }


    public void setFirstInterfaceVisibility() {
        this.firstInterfaceVisibility = !this.firstInterfaceVisibility;
    }
    

    public void setGameInterfaceVisibility() {
        this.gameInterfaceVisibility = !this.gameInterfaceVisibility;
    }
    

    public void gameWindow() {

        // Frame (game's window):

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0x3f4953));
        this.setLayout(null);
        this.setSize(800,800);
        this.setLocation(500, 25);
        this.setBounds(0, 0,  1600, 1000);
        this.setResizable(false);   
                    
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y-30);

    }
}

