package Game;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;

import Game.board.Board;
import Game.pieces.Bishop;
import Game.pieces.King;
import Game.pieces.Knight;
import Game.pieces.Pawn;
import Game.pieces.Piece;
import Game.pieces.Queen;
import Game.pieces.Rook;

public class Player {


    private Board board;

    private String color;
    private String name;

    private int nbrOfDeath;

    private boolean PositionChooser;
    private Point[] positions = new Point[16];

    private Piece[] pieces = new Piece[16];
    private Piece[] deadPieces = new Piece[16];

    private JPanel DeathPanel = new JPanel();
    


    Player(String color, Board board, boolean downPosition){
        
        this.board = board;
        this.color = color;
        this.name = "plaaaaayer";

        // true for down positions and false for up positions
        this.PositionChooser = !downPosition;

        int i = 0;
        while (i<16) {

            if (this.PositionChooser==true) {
                for (int y = 0; y < 2; y++) {
                    for (int x = 0; x < 8; x++) {
                        positions[i] = new Point(y,x);
                        i++;
                    }
                }
            }


            if (this.PositionChooser==false) {
                for (int y = 7; y > 5; y--) {
                    for (int x = 0; x < 8; x++) {
                        positions[i] = new Point(y,x);
                        i++;
                    }
                }
            }

        }


        for (int index = 0; index < 9; index++) {
            //Pawns :
                if(index<8) {

                Rook rook1 = new Rook((int)positions[8].getX(), (int)positions[8].getY(), this.board);
                pieces[index] = rook1;
                index++;

                Knight knight1 = new Knight((int)positions[9].getX(), (int)positions[9].getY(), this.board);
                pieces[index] = knight1;
                index++;

                Bishop bishop1 = new Bishop((int)positions[10].getX(), (int)positions[10].getY(), this.board);
                pieces[index] = bishop1;
                index++;

                Queen queen = new Queen((int)positions[11].getX(), (int)positions[11].getY(), this.board);
                pieces[index] = queen;
                index++;

                King king = new King((int)positions[12].getX(), (int)positions[12].getY(), this.board);
                pieces[index] = king;
                index++;

                Bishop bishop2 = new Bishop((int)positions[13].getX(), (int)positions[13].getY(), this.board);
                pieces[index] = bishop2;
                index++;

                Knight knight2 = new Knight((int)positions[14].getX(), (int)positions[14].getY(), this.board);
                pieces[index] = knight2;
                index++;
                
                Rook rook2 = new Rook((int)positions[15].getX(), (int)positions[15].getY(), this.board);
                pieces[index] = rook2;
                index++;

                }

                if (index == 8) {
                    for (int j = 0; j < 8; j++) {
                        Pawn pawn = new Pawn((int)positions[index+j].getX(), (int)positions[index+j].getY(), this.board);
                        pieces[index+j] = pawn;
                    }
                }

            }
        


        if (this.color=="black") {
            for (Piece piece : pieces) {
                piece.setTeamColor("black");
            }
        }

    }



    // Getters :
    public Board getBoard() {
        return this.board;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public Piece[] getDeadPieces() {
        return this.deadPieces;
    }

    public boolean getPositionChosen() {
        return this.PositionChooser;
    }

    public Point[] getPositions() {
        return this.positions;
    }

    public Piece[] getPieces() {
        return this.pieces;
    }

    public int getNbrOfDeath() {
        return this.nbrOfDeath;
    }
    //--


    //Setters :
    public void setName(String name) {
        this.name = name;
    }

    public void addToDeadPieces(Piece newPiece) {
        for (int i = 0; i < deadPieces.length; i++) {
            if (deadPieces[i]==null) {
                deadPieces[i] = newPiece;
                break;
            }
        }
    }

    public void setPositionChooser() {
        this.PositionChooser = !this.PositionChooser;
    }

    //--



    public int numberOfDeadPieces() {
        int counter = 0;
        for (Piece piece : deadPieces) {
            if (piece!=null) {
                counter++;
            }
        }
        return counter;
    }


    public JLabel numOfDeath() {
        return new JLabel();
    }


    public JPanel getDaethPanel(){

        
        ImageIcon image = new ImageIcon("images/deathIcon.png");
        JLabel deathLabel = new JLabel();
        JLabel nameLabel = new JLabel();
        JLabel timerPanel = new JLabel();
        
        //Panel :
        if (PositionChooser==true) {
            DeathPanel.setBounds(1225, 50, 300, 850);
        } else {
            DeathPanel.setBounds(75, 50, 300, 850);
        }
        DeathPanel.setBackground(new Color(0x96a6b3));
        DeathPanel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 3));
        DeathPanel.setLayout(null);

        //Death pieces :
        deathLabel.setIcon(image);
        deathLabel.setBounds(114, 275, 65, 65);
        deathLabel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));

        int[] cols = {25, 88, 151, 214};
        int[] rows = {360, 423, 486, 549};
        int counter = 0;

        JLabel[] labelWithoutImage = new JLabel[16];
        
        for (int c : cols) {
            for (int r : rows) {
                JLabel label = new JLabel();
                label.setBounds(c, r, 60, 60);
                label.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));
                label.setOpaque(true);
                labelWithoutImage[counter] = label;
                label.setBackground(new Color(0x455565));
                counter++;
            }
        }

        for (int i = 0; i < 16; i++) {
            if (deadPieces[i]!=null) {
                ImageIcon icon = deadPieces[i].getImage();
                labelWithoutImage[i].setIcon(icon);
            }
        }

        //Name :
        nameLabel.setBackground(new Color(0x96a6b3));
        nameLabel.setOpaque(true);
        nameLabel.setBounds(25, 630, 250, 150);
        nameLabel.setText(this.getName());
        nameLabel.setFont(new Font("Dubai", Font.BOLD, 25));
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);



        //Timer
        timerPanel.setBackground(Color.white);
        timerPanel.setOpaque(true);
        timerPanel.setBounds(75, 95, 150, 100);
        timerPanel.setBorder(BorderFactory.createLineBorder(new Color(0x272b2e), 1));


        for (JLabel label : labelWithoutImage) {
            DeathPanel.add(label);
        }

        DeathPanel.add(timerPanel);
        DeathPanel.add(nameLabel);
        DeathPanel.add(deathLabel);

        return DeathPanel;
    }

}
