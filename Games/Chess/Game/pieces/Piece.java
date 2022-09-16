package Game.pieces;


import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.Player;
import Game.board.Board;
import Game.board.Cell;

public abstract class Piece {

    protected int x;
    protected int y;
    protected int turns;
    protected String name;
    protected String symbol;
    protected String teamColor;
    protected Boolean kingProtector;
    protected Boolean killed;
    protected Board board;
    protected Player player;
    protected Cell cell;
    protected ImageIcon image;
    protected JLabel label;
    
    public abstract void setTeamColor(String newColor);
    public abstract List<Cell> destinationsCells();


    public int getX() {
        return this.x;
    }

    public int getTurns() {
        return this.turns;
    }

    public int getY() {
        return this.y;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Board getBoard() {
        return this.board;
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public ImageIcon getImage() {
        return this.image;
    }
    
    public Player getPlayer() {
        return this.player;
    } 

    public Cell getCell() {
        return this.board.getCell(this.x, this.y);
    }

    public boolean isKilled() {
        return this.killed;
    }

    public boolean isProtector() {
        return this.kingProtector;
    }
    
    public void killPiece() {
        this.killed = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setTurns() {
        this.turns++;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setProtection() {
        this.kingProtector = !this.kingProtector;
    }


    public void moveTo(int newX, int newY){
        if (this.getBoard().getCell(newX, newY).isEmpty()) {
            this.getBoard().getCell(newX, newY).addPieceInCell(this);
            this.getBoard().getCell(this.x, this.y).deletePieceInCell();
            this.x = newX;
            this.y = newY;
        } else if (this.getBoard().getCell(newX, newY).isFull()) {
            this.getBoard().getCell(newX, newY).getPiece().killPiece();
            this.getBoard().getCell(newX, newY).addPieceInCell(this);
            this.getBoard().getCell(this.x, this.y).deletePieceInCell();
            this.x = newX;
            this.y = newY;
        }

        this.setTurns();
        //is protector

    }
    

}
