package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.board.Board;
import Game.board.Cell;

/**
 * Rook's class
 */
public class Rook extends Piece {

    public Rook(int x, int y, Board board){
        this.x = x;
        this.y = y;
        this.name = "Rook";
        this.symbol = "R";
        this.death = false;
        this.teamColor = "white";
        this.board = board;

        if (this.teamColor == "white") {
            this.image = new ImageIcon("./images/Chess_rlt60.png");
        } else {
            this.image = new ImageIcon("./images/Chess_rdt60.png");
        }
    }



    public List<Cell> possibleCellsToMoveOn() {

        List<Cell> cells = new ArrayList<Cell>(); 
        
        // move foward :
        if (this.getY() != 7) {

            for (int i = 1; this.getY()+i <= 7; i++) {
                if (this.board.getCell(this.getX(), this.getY()+i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX(), this.getY()+i));
                }

                if (this.board.getCell(this.getX(), this.getY()+i).isFull() && this.getTeamColor() != this.board.getCell(this.getX(), this.getY()+i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX(), this.getY()+i));
                        break;
                    }
                }
            }        
                
        // move back :
        if (this.getY() != 0) {

            for (int i = 1; this.getY()-i >= 0; i++) {
                if (this.board.getCell(this.getX(), this.getY()-i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX(), this.getY()-i));
                }

                if (this.board.getCell(this.getX(), this.getY()-i).isFull() && this.getTeamColor() != this.board.getCell(this.getX(), this.getY()-i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX(), this.getY()-i));
                        break;
                    }
                }
            }   

        // move right  :
        if (this.getX() != 7) {

            for (int i = 1; this.getX()+i <= 7; i++) {
                if (this.board.getCell(this.getX()+i, this.getY()).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()+i, this.getY()));
                }

                if (this.board.getCell(this.getX()+i, this.getY()).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+i, this.getY()).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()+i, this.getY()));
                        break;
                    }
                }
            }   

        // move left :
        if (this.getX() != 0) {

            for (int i = 1; this.getX()-i >= 0; i++) {
                if (this.board.getCell(this.getX()-i, this.getY()).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()-i, this.getY()));
                }

                if (this.board.getCell(this.getX()-i, this.getY()).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()));
                        break;
                    }
                }
            }  

        return cells;
    }


    public void move(String newPosition) {
        
    }


    public static void main(String[] args) {
        Board b = new Board();
        Rook r = new Rook(3, 5, b);
        List<Cell> cells = r.possibleCellsToMoveOn();
       for (Cell cell : cells) {System.out.println(cell.fullNameOfCell());}
    }

}