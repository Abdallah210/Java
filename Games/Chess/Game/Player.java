package Game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Point;

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

    private boolean PositionChooser;
    private Point[] positions = new Point[16];

    private Piece[] pieces = new Piece[16];
    private List<Piece> deadPieces;
    


    Player(String color, Board board, boolean downPosition){
        
        this.board = board;
        this.color = color;
        this.name = "";

        this.deadPieces = new ArrayList<Piece>();

        // true for down positions and false for up positions
        this.PositionChooser = downPosition;

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

    public List<Piece> getDeadPieces() {
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
    //--


    //Setters :
    public void setName(String name) {
        this.name = name;
    }

    public void addToDeadPieces(Piece piece) {
        this.deadPieces.add(piece);
    }

    public void setPositionChooser() {
        this.PositionChooser = !this.PositionChooser;
    }
    //--



    public int numberOfDeadPieces() {
        return this.deadPieces.size();
    }

    public JPanel deadPanel() {
        return new JPanel();
    }

    
    public JLabel deadLabel() {
        return new JLabel();
    }


    public JLabel numOfDeath() {
        return new JLabel();
    }

}
