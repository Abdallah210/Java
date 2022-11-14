package Game.pieces;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Game;
import Game.Player;
import Game.board.Board;
import Game.board.Cell;

/**
 * King's class 
 */
public class King extends Piece{

    private List<Cell> warningCells =  new ArrayList<Cell>();


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
        this.cell = this.board.getCell(x, y);
        
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

    public void updateWarningCells() {
        for (Cell cell : board.getCellList()) {
            if (cell.isFull() && cell.getPiece().getTeamColor()!=this.getTeamColor()) {    
                for (Cell warningCell : cell.getPiece().destinationsCells()) {
                    this.warningCells.add(warningCell);
                }
            }
        }
    }

    public List<Cell> getWarningCells() {
        return this.warningCells;
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

        // Can't move to :
        this.updateWarningCells();

        for (Cell warningCell : this.warningCells) {
            for (Cell cell : cells) {
                if (cell==warningCell) {
                    cells.remove(cell);
                }
            }
        }

        // Castling :


            System.out.println(cells.size());
        


        return cells;
    }


    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(new Color(0xf6f6f6), board, true, "a");
        Player player2 = new Player(new Color(0x455565), board, false, "b");
        Rook r = new Rook(0, 0, board, player2);
        King k = new King(3, 4, board, player1);

        for (Cell cell : board.getCellList()) {
            System.out.println(cell.isFull());
        }


        k.updateWarningCells();
            System.out.println(k.getWarningCells());
            System.out.println(k.destinationsCells());


}
}