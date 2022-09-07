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
    private Point[] piecesPosition = new Point[16];

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
                        piecesPosition[i] = new Point(x,y);
                        i++;
                    }
                }
            }


            if (this.PositionChooser==false) {
                for (int y = 7; y > 5; y--) {
                    for (int x = 0; x < 8; x++) {
                        piecesPosition[i] = new Point(x,y);
                        i++;
                    }
                }
            }

        }


        for (int index = 0; index < 9; index++) {
            //Pawns :
            if (index < 8) {
                Pawn pawn = new Pawn((int)piecesPosition[8+index].getX(), (int)piecesPosition[8+index].getY(), this.board);
                pieces[index] = pawn;
            } else {

                Rook rook1 = new Rook((int)piecesPosition[0].getX(), (int)piecesPosition[0].getY(), this.board);
                pieces[index] = rook1;
                index++;

                Knight knight1 = new Knight((int)piecesPosition[1].getX(), (int)piecesPosition[1].getY(), this.board);
                pieces[index] = knight1;
                index++;

                Bishop bishop1 = new Bishop((int)piecesPosition[2].getX(), (int)piecesPosition[2].getY(), this.board);
                pieces[index] = bishop1;
                index++;

                Queen queen = new Queen((int)piecesPosition[3].getX(), (int)piecesPosition[3].getY(), this.board);
                pieces[index] = queen;
                index++;

                King king = new King((int)piecesPosition[4].getX(), (int)piecesPosition[4].getY(), this.board);
                pieces[index] = king;
                index++;

                Rook rook2 = new Rook((int)piecesPosition[5].getX(), (int)piecesPosition[5].getY(), this.board);
                pieces[index] = rook2;
                index++;

                Knight knight2 = new Knight((int)piecesPosition[6].getX(), (int)piecesPosition[6].getY(), this.board);
                pieces[index] = knight2;
                index++;

                Bishop bishop2 = new Bishop((int)piecesPosition[7].getX(), (int)piecesPosition[7].getY(), this.board);
                pieces[index] = bishop2;
                index++;
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

    public Point[] getPiecesPosition() {
        return this.piecesPosition;
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


    public static void main(String[] args) {

        Board board = new Board();
        Player p1 = new Player("white", board, true);
        Player p2 = new Player("black", board, false);

        /*for (Point p : p1.getPiecesPosition()) {
            System.out.println((int)p.getX() + "  " + (int)p.getY());
            
        }*/


         System.out.println("White team :");
        for (Piece piece : p1.getPieces()) {
            System.out.println(piece.getName() +" "+ piece.getX()+" "+ piece.getY()+" "+ piece.getTeamColor());
        }

        System.out.println("Black team :");
        for (Piece piece : p2.getPieces()) {
            System.out.println(piece.getName() +" "+ piece.getX()+" "+ piece.getY()+" "+ piece.getTeamColor());
        }

    }


}
