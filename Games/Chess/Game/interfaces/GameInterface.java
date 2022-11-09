package Game.interfaces;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Game.Game;
import Game.Player;
import Game.board.Board;
import Game.board.Cell;
import Game.pieces.Piece;

public class GameInterface extends JLabel implements MouseListener {

    private Game game;
    
    // Game interface :
    private Board board = new Board();
    private JPanel verticalPositions = new JPanel();
    private JPanel horizontalPositions = new JPanel();

    // Players :

    private Player player1 = new Player(new Color(0xf6f6f6), this.board, true, "a");
    private Player player2 = new Player(new Color(0x455565), this.board, false, "b");


    public GameInterface(Game game) {  // TODO... add 2 players in parameters
        
        this.addMouseListener(this);
        this.board.getBoardPanel().addMouseListener(this);
        this.verticalPositions.addMouseListener(this);
        this.horizontalPositions.addMouseListener(this);

        this.game = game;
        
        this.setBounds(this.game.getFrameSize());
        this.setVerticalAlignment(JLabel.CENTER);  
        this.setHorizontalAlignment(JLabel.CENTER);
        
        // Board :
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
            label.setForeground(new Color(0x455565));

            label2.setBounds(0, 25+i*92, 50, 60);
            label2.setText(letters[i]);
            label2.setHorizontalAlignment(JLabel.CENTER);
            label2.setVerticalAlignment(JLabel.CENTER);
            label2.setFont(new Font("Dubai", Font.BOLD, 30));
            label2.setForeground(new Color(0x455565));

            horizontalPositions.add(label);
            verticalPositions.add(label2);
            }

            this.add(horizontalPositions);
            this.add(verticalPositions);
            this.add(board.getBoardPanel());
    }

    public void printPlayerPanels() {
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
                this.player2.addToDeathList(dead);
            }
        }

        for (Player player : players) {
            this.add(player.getDeathPanel());
        }
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource()==this || e.getSource()==this.board.getBoardPanel() || e.getSource()==this.verticalPositions || e.getSource()==this.horizontalPositions) {

            List<Player> players = new ArrayList<Player>();

            for (Cell cell : this.board.getCellList()) {
                if (cell.isFull() && !players.contains(cell.getPiece().getPlayer())) {
                    players.add(cell.getPiece().getPlayer());
                }
            }

            for (Player player : players) {
                player.startStopCountdown();
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}

