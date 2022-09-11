package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Player;
import Game.board.Board;
import Game.board.Cell;

/**
 * Queen's class
 */
public class Queen extends Piece {

    public Queen(int x, int y, Board board, Player player){
        this.x = x;
        this.y = y;
        this.turns = 0;
        this.name = "Queen";
        this.symbol = "Q";
        this.kingProtector = false;
        this.killed = false;
        this.teamColor = "white";
        this.board = board;
        this.player = player;
        this.cell = this.board.getCell(this.x, this.y);

        this.image = new ImageIcon("./images/Chess_qlt60.png");
        
        if (this.getPlayer().getPositionChosen()) {
            this.x++;
        } else if(!this.getPlayer().getPositionChosen()){
            this.x--;
        }

    }


    @Override
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
        this.image = new ImageIcon("./images/Chess_qdt60.png");

    }

    
    public List<Cell> destinationsCells() {

        List<Cell> cells = new ArrayList<Cell>(); 
        
        // Bishop :
                
            // move north-east :
            if (this.getY() < 7 && this.getX() > 0) {

                for (int i = 1; this.getY()+i <= 7 && this.getX()-i >= 0; i++) {
                    if (this.board.getCell(this.getX()-i, this.getY()+i).isFull() && this.getTeamColor() == this.board.getCell(this.getX()-i, this.getY()+i).getPiece().getTeamColor()) {
                        break;
                    }

                    if (this.board.getCell(this.getX()-i, this.getY()+i).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()+i));
                    }

                    if (this.board.getCell(this.getX()-i, this.getY()+i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()+i).getPiece().getTeamColor()) {
                            cells.add(this.board.getCell(this.getX()-i, this.getY()+i));
                            break;
                    }
                }
            }        
               
                    
            // move north-west :
            if (this.getY() > 0 && this.getX() > 0) {
                int smaller = smallerBetween(this.getX(), this.getY());

                for (int i = 1; smaller-i >= 0; i++) {

                    if (this.board.getCell(this.getX()-i, this.getY()-i).isFull() && this.getTeamColor() == this.board.getCell(this.getX()-i, this.getY()-i).getPiece().getTeamColor()) {
                        break;
                    }

                    if (this.board.getCell(this.getX()-i, this.getY()-i).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()-i));
                    }

                    if (this.board.getCell(this.getX()-i, this.getY()-i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()-i).getPiece().getTeamColor()) {
                            cells.add(this.board.getCell(this.getX()-i, this.getY()-i));
                            break;
                    }
                }
            }  

            // move south-east  :
            if (this.getX() < 7 && this.getY() < 7) {
                int greater = greaterBetween(this.getX(), this.getY());

                for (int i = 1; greater+i <= 7 ; i++) {

                    if (this.board.getCell(this.getX()+i, this.getY()+i).isFull() && this.getTeamColor() == this.board.getCell(this.getX()+i, this.getY()+i).getPiece().getTeamColor()) {
                        break;
                    }

                    if (this.board.getCell(this.getX()+i, this.getY()+i).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()+i, this.getY()+i));
                    }

                    if (this.board.getCell(this.getX()+i, this.getY()+i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+i, this.getY()+i).getPiece().getTeamColor()) {
                            cells.add(this.board.getCell(this.getX()+i, this.getY()+i));
                            break;
                    }
                }
            }  

            // move south-west :
            if (this.getY() > 0 && this.getX() < 7) {

                for (int i = 1; this.getY()-i >= 0 && this.getX()+i <= 7; i++) {

                    if (this.board.getCell(this.getX()+i, this.getY()-i).isFull() && this.getTeamColor() == this.board.getCell(this.getX()+i, this.getY()-i).getPiece().getTeamColor()) {
                        break;
                    }

                    if (this.board.getCell(this.getX()+i, this.getY()-i).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()+i, this.getY()-i));
                    }

                    if (this.board.getCell(this.getX()+i, this.getY()-i).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+i, this.getY()-i).getPiece().getTeamColor()) {
                            cells.add(this.board.getCell(this.getX()+i, this.getY()-i));
                            break;
                    }
                }
            }  

        // Rook :
        
        // move foward :
        if (this.getY() != 7) {

            for (int i = 1; this.getY()+i <= 7; i++) {

                if (this.board.getCell(this.getX(), this.getY()+i).isFull() && this.getTeamColor() == this.board.getCell(this.getX(), this.getY()+i).getPiece().getTeamColor()) {
                    break;
                }

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

                if (this.board.getCell(this.getX(), this.getY()-i).isFull() && this.getTeamColor() == this.board.getCell(this.getX(), this.getY()-i).getPiece().getTeamColor()) {
                    break;
                }

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

                if (this.board.getCell(this.getX()+i, this.getY()).isFull() && this.getTeamColor() == this.board.getCell(this.getX()+i, this.getY()).getPiece().getTeamColor()) {
                    break;
                }

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

                if (this.board.getCell(this.getX()-i, this.getY()).isFull() && this.getTeamColor() == this.board.getCell(this.getX()-i, this.getY()).getPiece().getTeamColor()) {
                    break;
                }

                if (this.board.getCell(this.getX()-i, this.getY()).isEmpty()) {
                    cells.add(this.board.getCell(this.getX()-i, this.getY()));
                }

                if (this.board.getCell(this.getX()-i, this.getY()).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-i, this.getY()).getPiece().getTeamColor()) {
                        cells.add(this.board.getCell(this.getX()-i, this.getY()));
                        break;
                    }
                }
            } 

            if (this.isProtector()) {
                cells.removeAll(cells);
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
