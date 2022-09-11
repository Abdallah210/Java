package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Player;
import Game.board.Board;
import Game.board.Cell;

/**
 * King's class 
 */
public class King extends Piece{


    public King(int x, int y, Board board, Player player){

        this.x = x;
        this.y = y;
        this.turns = 0;
        this.name = "King";
        this.symbol = "K";
        this.kingProtector = null;
        this.killed = false;
        this.teamColor = "white";
        this.board = board;
        this.player = player;
        this.cell = this.board.getCell(this.x, this.y);
        
        this.image = new ImageIcon("./images/Chess_klt60.png");
        
        if (this.getPlayer().getPositionChosen()) {
            this.x++;
        } else if(!this.getPlayer().getPositionChosen()){
            this.x--;
        }

    }


    @Override
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
        this.image = new ImageIcon("./images/Chess_kdt60.png");
    }


    public List<Cell> destinationsCells() {

        List<Cell> cells = new ArrayList<Cell>(); 

        // move direction 1 (foward) :
        if (this.getY() < 7) {
            
            if (this.board.getCell(this.getX(), this.getY()+1).isEmpty())  {
                cells.add(this.board.getCell(this.getX(), this.getY()+1));
            }    
                
            if (this.board.getCell(this.getX(), this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX(), this.getY()+1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX(), this.getY()+1));
            }
        }

        // move direction 2 :
        if (this.getY() < 7 && this.getX() < 7) {
            
            if (this.board.getCell(this.getX()+1, this.getY()+1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+1, this.getY()+1));
            }    
                
            if (this.board.getCell(this.getX()+1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()+1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+1, this.getY()+1));
            }
        }


        // move direction 3 (right) :
        if (this.getX() < 7) {
            
            if (this.board.getCell(this.getX()+1, this.getY()).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+1, this.getY()));
            }    
                
            if (this.board.getCell(this.getX()+1, this.getY()).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+1, this.getY()));
            }
        }


        // move direction 4 :
        if (this.getX() < 7 && this.getY() > 0) {
            
            if (this.board.getCell(this.getX()+1, this.getY()-1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()+1, this.getY()-1));
            }    
                
            if (this.board.getCell(this.getX()+1, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()+1, this.getY()-1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()+1, this.getY()-1));
            }
        }


        // move direction 5 (back) :
        if (this.getY() > 0) {
            
            if (this.board.getCell(this.getX(), this.getY()-1).isEmpty())  {
                cells.add(this.board.getCell(this.getX(), this.getY()-1));
            }    
                
            if (this.board.getCell(this.getX(), this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX(), this.getY()-1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX(), this.getY()-1));
            }
        }


        // move direction 6 :
        if (this.getY() > 0 && this.getX() > 0) {
            
            if (this.board.getCell(this.getX()-1, this.getY()-1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-1, this.getY()-1));
            }    
                
            if (this.board.getCell(this.getX()-1, this.getY()-1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()-1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-1, this.getY()-1));
            }
        }


        // move direction 7 (left) :
        if (this.getX() > 0) {
            
            if (this.board.getCell(this.getX()-1, this.getY()).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-1, this.getY()));
            }    
                
            if (this.board.getCell(this.getX()-1, this.getY()).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-1, this.getY()));
            }
        }


        // move direction 8 :
        if (this.getX() > 0 && this.getY() < 7) {
            
            if (this.board.getCell(this.getX()-1, this.getY()+1).isEmpty())  {
                cells.add(this.board.getCell(this.getX()-1, this.getY()+1));
            }    
                
            if (this.board.getCell(this.getX()-1, this.getY()+1).isFull() && this.getTeamColor() != this.board.getCell(this.getX()-1, this.getY()+1).getPiece().getTeamColor()) {
                cells.add(this.board.getCell(this.getX()-1, this.getY()+1));
            }
        }

        //castling :


        return cells;
    }


}