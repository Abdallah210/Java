package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.board.Board;
import Game.board.Cell;

/**
 * Queen's class
 */
public class Queen extends Piece {

    public Queen(int x, int y, Board board){
        this.x = x;
        this.y = y;
        this.name = "Queen";
        this.symbol = "Q";
        this.death = false;
        this.teamColor = "white";
        this.board = board;

        if (this.teamColor == "white") {
            this.image = new ImageIcon("./images/Chess_qlt60.png");
        } else {
            this.image = new ImageIcon("./images/Chess_qdt60.png");
        }
    }

    
    public List<Cell> possibleCellsToMoveOn() {

        List<Cell> cells = new ArrayList<Cell>(); 
        
        // Bishop :
        if (this.getY() < 7 && this.getX() < 7) {
            int greaterCoord = greaterBetween(this.getX(), this.getY());

            for (int i = 1; greaterCoord+i <= 7; i++) {
                if (this.board.getCell(this.getX()+i, this.getY()+i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()+i, this.getY()+i));
                }

                if (this.board.getCell(this.getX()+i, this.getY()+i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+i, this.getY()+i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()+i, this.getY()+i));
                        break;
                    }
                }
            }        
        if (this.getY() < 7 && this.getX() > 0) {

            for (int i = 1; this.getY()+i <= 7 && this.getX()-i >= 0; i++) {
                if (this.board.getCell(this.getX()-i, this.getY()+i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()-i, this.getY()+i));
                }

                if (this.board.getCell(this.getX()-i, this.getY()+i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()+i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()+i));
                        break;
                    }
                }
            }  
        if (this.getX() < 7 && this.getY() > 0) {

            for (int i = 1; this.getX()+i <= 7 && this.getY()-i >= 0; i++) {
                if (this.board.getCell(this.getX()+i, this.getY()-i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()+i, this.getY()-i));
                }

                if (this.board.getCell(this.getX()+i, this.getY()-i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+i, this.getY()-i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()+i, this.getY()-i));
                        break;
                    }
                }
            }  
        if (this.getY() > 0 && this.getX() > 0) {
            int smallerCoord = smallerBetween(this.getX(), this.getY());

            for (int i = 1; smallerCoord-i >= 0; i++) {
                if (this.board.getCell(this.getX()-i, this.getY()-i).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()-i, this.getY()-i));
                }

                if (this.board.getCell(this.getX()-i, this.getY()-i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()-i).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()-i));
                        break;
                    }
                }
            }  

            // Rook :
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

    private int greaterBetween(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    private int smallerBetween(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        } else {
            return num2;
        }
    }

    
    public static void main(String[] args) {
        Board b = new Board();
        Queen r = new Queen(3, 5, b);
        List<Cell> cells = r.possibleCellsToMoveOn();
       for (Cell cell : cells) {System.out.println(cell.fullNameOfCell());}
    }

}
