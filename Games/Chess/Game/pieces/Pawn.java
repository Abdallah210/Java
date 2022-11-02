package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Player;
import Game.board.Board;
import Game.board.Cell;



/**
 * Pawn's class 
 */
public class Pawn extends Piece{


    


    public Pawn(int x, int y, Board board, Player player){

        this.x = x;
        this.y = y;
        this.turns = 0;
        this.name = "Pawn";
        this.symbol = "";
        this.kingProtector = false;
        this.killed = false;
        this.teamColor = "white";
        this.board = board;
        this.player = player;
        this.cell = this.board.getCell(this.x, this.y);
        
        this.image = new ImageIcon("./images/Chess_plt60.png");

    }


    //Pawn method :
    public void promotion() {  
        if (this.player.getPositionChosen()) {
            if (this.getX()==0) {
                this.board.getCell(0, 0); // display panel promotion
            }
        } else {
            if (this.getX()==7) {
                this.board.getCell(0, 0); // display panel promotion
            }
        }
    }


    @Override
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
        this.image = new ImageIcon("./images/Chess_pdt60.png");
    }


    public List<Cell> destinationsCells() {

        List<Cell> cells = new ArrayList<Cell>(); 

        if (this.getPlayer().getPositionChosen()) {

            // move foward :
            if (this.getX() > 0) {
            
                if (this.board.getCell(this.getX()-1, this.getY()).isEmpty())  {

                    cells.add(this.board.getCell(this.getX()-1, this.getY()));
                
                    // en passant :
                    if (this.getX() == 6 && this.board.getCell(this.getX()-2, this.getY()).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()-2, this.getY()));
                    }    
                }


            // move right :
            if (this.getY() < 7) {
                if (this.board.getCell(this.getX()-1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()+1).getPiece().getTeamColor() ) {
                    cells.add(this.board.getCell(this.getX()-1, this.getY()+1));
                }
            }

            // move left :
            if (this.getY() > 0) {
                if (this.board.getCell(this.getX()-1, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()-1).getPiece().getTeamColor() ) {
                    //this.board.getCell(this.getX()-1, this.getY()+1).getPiece().killed();
                    cells.add(this.board.getCell(this.getX()-1, this.getY()-1));
                }
            }
        }

        } else {

            // move foward :
            if (this.getX() < 7) {
                
                if (this.board.getCell(this.getX()+1, this.getY()).isEmpty())  {

                    cells.add(this.board.getCell(this.getX()+1, this.getY()));
                    
                    // en passant :
                    if (this.getX() == 1 && this.board.getCell(this.getX()+2, this.getY()).isEmpty()) {
                        cells.add(this.board.getCell(this.getX()+2, this.getY()));
                    }    
                }


                // move right :
                if (this.getY() > 0) {
                    if (this.board.getCell(this.getX()+1, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()-1).getPiece().getTeamColor() ) {
                        cells.add(this.board.getCell(this.getX()+1, this.getY()-1));
                    }
                }

                // move left :
                if (this.getY() < 7) {
                    if (this.board.getCell(this.getX()+1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()+1).getPiece().getTeamColor() ) {
                        cells.add(this.board.getCell(this.getX()+1, this.getY()+1));
                    }
                }
            }
        }
        
        
        if (this.isProtector()) {
            cells.removeAll(cells);
        }

        return cells;
    }


}