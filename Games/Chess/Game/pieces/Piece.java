package Game.pieces;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.board.Board;
import Game.board.Cell;

public abstract class Piece {

    protected int x;
    protected int y;
    protected String name;
    protected String symbol;
    protected String teamColor;
    protected boolean death;
    protected Board board;
    protected ImageIcon image;
    
    public abstract void move(String newPosition);
    public abstract List<Cell> possibleCellsToMoveOn();
    //public abstract List<String> nameOfPossibleCellsToMoveOn();
    //public abstract String getTeamColor();
    //public abstract void killed();


    public int getX() {
        return this.x;
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

    public boolean isDeath() {
        return this.death;
    }
    
    public void killed() {
        this.death = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }



    public JLabel getLabel() {

        JLabel label = new JLabel();

        ImageIcon pieceImage = this.image;
        label.setIcon(pieceImage);
        
        label.setVerticalAlignment(JLabel.CENTER); 
        label.setHorizontalAlignment(JLabel.CENTER);  

        return label;
    }


    public List<String> nameOfPossibleCellsToMoveOn() {
        List<String> names = new ArrayList<String>(); 
        List<Cell> cells = this.possibleCellsToMoveOn(); 

        for (Cell cell : cells) {
            names.add(cell.fullNameOfCell());
        }
        return names;
    }

}
