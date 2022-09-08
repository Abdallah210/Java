package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.board.Board;
import Game.board.Cell;

/**
 * Bishop's class
 */
public class Bishop extends Piece {

    public Bishop(int x, int y, Board board){

        this.x = x;
        this.y = y;
        this.name = "Bishop";
        this.symbol = "B";
        this.death = false;
        this.teamColor = "white";
        this.board = board;
        this.image = new ImageIcon("./images/Chess_blt60.png");

    }


    public void move(String newPosition) {
        //TO DO...
    }
    

    @Override
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
        this.image = new ImageIcon("./images/Chess_bdt60.png");

    }

    
    public List<Cell> possibleCellsToMoveOn() {

        List<Cell> cells = new ArrayList<Cell>(); 
        
        // move north-east :
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
                
        // move north-west :
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

        // move south-east  :
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

        // move south-west :
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

        return cells;
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


}