package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.board.Board;
import Game.board.Cell;

/**
 * Pawn's class 
 */
public class Pawn extends Piece{


    public Pawn(int x, int y, Board board){

        this.x = x;
        this.y = y;
        this.name = "Pawn";
        this.symbol = "";
        this.death = false;
        this.teamColor = "white";
        this.board = board;
        this.image = new ImageIcon("./images/Chess_plt60.png");

    }


    //Pawn method :
    public void promotion() {  
        // TO DO...
    }


    public void move(String newPosition) {
        //TO DO...
    }


    @Override
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
        this.image = new ImageIcon("./images/Chess_pdt60.png");
    }


    public List<Cell> possibleCellsToMoveOn() {

        List<Cell> cells = new ArrayList<Cell>(); 
        // move foward :
        if (this.getY() < 7) {
            
            if (this.board.getCell(this.getX(), this.getY()+1).isEmpty())  {

                cells.add(this.board.getCell(this.getX(), this.getY()+1));
                
                // en passant :
                if (this.getY() == 1 && this.board.getCell(this.getX(), this.getY()+2).isEmpty()) {
                    cells.add(this.board.getCell(this.getX(), this.getY()+2));
                }    
            }


            // move right :
            if (this.getX() < 7) {
                if (this.board.getCell(this.getX()+1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()+1).getPiece().getTeamColor() ) {
                    //this.board.getCell(this.getX()+1, this.getY()+1).getPiece().killed();
                    cells.add(this.board.getCell(this.getX()+1, this.getY()+1));
                }
            }

            // move left :
            if (this.getX() > 0) {
                if (this.board.getCell(this.getX()-1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()+1).getPiece().getTeamColor() ) {
                    //this.board.getCell(this.getX()-1, this.getY()+1).getPiece().killed();
                    cells.add(this.board.getCell(this.getX()-1, this.getY()+1));
                }
            }
        }


        return cells;
    }


}