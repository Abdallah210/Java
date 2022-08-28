package Game.pieces;



import java.util.ArrayList;
import java.util.List;

import Game.board.Board;
import Game.board.Cell;

/**
 * Knight's class 
 */
public class Knight extends Piece{


    public Knight(int x, int y, Board board){
        this.x = x;
        this.y = y;
        this.name = "Knight";
        this.symbol = "N";
        this.death = false;
        this.teamColor = "white";
        this.board = board;
    }


    public List<Cell> possibleCellsToMoveOn() {

        List<Cell> cells = new ArrayList<Cell>(); 

        // move direction 1 (foward 1) :
        if (this.getY() < 6 && this.getX() > 0) {
            
            if (this.board.getCell(this.getX()-1, this.getY()+2).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-1, this.getY()+2));
            }    
                
            if (this.board.getCell(this.getX()-1, this.getY()+2).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()+2).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-1, this.getY()+2));
            }
        }

        // move direction 2 (foward 2) :
        if (this.getY() < 6 && this.getX() < 7) {
            
            if (this.board.getCell(this.getX()+1, this.getY()+2).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+1, this.getY()+2));
            }    
                
            if (this.board.getCell(this.getX()+1, this.getY()+2).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()+2).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+1, this.getY()+2));
            }
        }


        // move direction 3 (right 1) :
        if (this.getY() < 7 && this.getX() < 6) {
            
            if (this.board.getCell(this.getX()+2, this.getY()+1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+2, this.getY()+1));
            }    
                
            if (this.board.getCell(this.getX()+2, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+2, this.getY()+1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+2, this.getY()+1));
            }
        }


        // move direction 4 (right 2) :
        if (this.getY() > 0 && this.getX() < 6) {
            
            if (this.board.getCell(this.getX()+2, this.getY()-1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+2, this.getY()-1));
            }    
                
            if (this.board.getCell(this.getX()+2, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+2, this.getY()-1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+2, this.getY()-1));
            }
        }


        // move direction 5 (back 1) :
        if (this.getY() > 1 && this.getX() < 7) {
            
            if (this.board.getCell(this.getX()+1, this.getY()-2).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+1, this.getY()-2));
            }    
                
            if (this.board.getCell(this.getX()+1, this.getY()-2).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()-2).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+1, this.getY()-2));
            }
        }


        // move direction 6 (back 2) :
        if (this.getY() > 1 && this.getX() > 0) {
            
            if (this.board.getCell(this.getX()-1, this.getY()-2).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-1, this.getY()-2));
            }    
                
            if (this.board.getCell(this.getX()-1, this.getY()-2).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()-2).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-1, this.getY()-2));
            }
        }


        // move direction 7 (left 1) :
        if (this.getY() > 0 && this.getX() > 1) {
            
            if (this.board.getCell(this.getX()-2, this.getY()-1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-2, this.getY()-1));
            }    
                
            if (this.board.getCell(this.getX()-2, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-2, this.getY()-1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-2, this.getY()-1));
            }
        }


        // move direction 8 (left 2) :
        if (this.getY() < 7 && this.getX() > 1) {
            
            if (this.board.getCell(this.getX()-2, this.getY()+1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-2, this.getY()+1));
            }    
                
            if (this.board.getCell(this.getX()-2, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-2, this.getY()+1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-2, this.getY()+1));
            }
        }


        return cells;
    }


    public void move(String newPosition) {
        
    }


    
    public static void main(String[] args) {
        Board b = new Board();
        Knight k = new Knight(3, 4, b);
        List<Cell> cells = k.possibleCellsToMoveOn();
       for (Cell cell : cells) {System.out.println(cell.fullNameOfCell());}


    }


}