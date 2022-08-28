package Game.pieces;

import java.util.ArrayList;
import java.util.List;

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
    }



    //Pawn method :
    public void promotion() {  
        // todo
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


    public void move(String newPosition) {
        
    }


    
    public static void main(String[] args) {
        Board b = new Board();
        Pawn p1 = new Pawn(2, 7, b);
        List<Cell> cells = p1.possibleCellsToMoveOn();
       for (Cell cell : cells) {System.out.println(cell.fullNameOfCell());}
       System.out.println("---------------");
       Pawn p2 = new Pawn(1, 1, b);
       List<Cell> cells2 = p2.possibleCellsToMoveOn();
      for (Cell cell : cells2) {System.out.println(cell.fullNameOfCell());}

    }


}