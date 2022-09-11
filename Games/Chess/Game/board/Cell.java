package Game.board;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.pieces.Piece;


/**
 * Cell's class
 */
public class Cell {

    private int x; 
    private int y; 
    private int number; 
    private String letter; 
    private Color color; 
    private boolean empty; 
    private boolean clicked; 
    private Piece piece;
    private JLabel cellLabel;


    public Cell(int x, int y) {

        this.x = x;
        this.y = y;

        this.empty = true;
        this.clicked = false;
        this.piece = null;

        this.color = new Color(0xf6f6f6);

        this.cellLabel = new JLabel();
        cellLabel.setBounds(100*this.x, 100*this.y, 100, 100);
        this.cellLabel.setBackground(this.color);
        if (this.isFull()) {
            this.cellLabel.setIcon(this.getPiece().getImage());
        }
        this.cellLabel.setOpaque(true); 

        this.number = this.x + 1;

        switch (this.y) {
            case 0:
                this.letter = "a";
                break;
            case 1:
                this.letter = "b";
                break;
            case 2:
                this.letter = "c";
                break;
            case 3:
                this.letter = "d";
                break;
            case 4:
                this.letter = "e";
                break;
            case 5:
                this.letter = "f";
                break;
            case 6:
                this.letter = "g";
                break;
            default:
                this.letter = "h";
                break;
        }
    }


    //Getter and setter :

    public Color getColor() {
        return this.color;
    }

    public String getLetter() {
        return this.letter;
    }

    public int getNumber() {
        return this.number;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Piece getPiece() {
        return this.piece;
    }
    
    public JLabel getCellLabel() {
        return cellLabel;
    }

    public Color getCellLabelColor() {
        return this.cellLabel.getBackground();
    }

    public Icon getCellLabelIcon() {
        return this.cellLabel.getIcon();
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFull() {
        return !(this.empty);
    }

    public boolean isClicked() {
        return this.clicked;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public void deletePieceInCell() {
        this.piece = null;
        this.empty = true;
    }

    public void addPieceInCell(Piece piece) {
        this.piece = piece;
        this.empty = false;
    }

    public void setClicked(boolean value) {
        this.clicked = value;
    }

    public String fullNameOfCell() {
        return this.letter + this.number;
    }

    public void setCellLabelIcon(ImageIcon newImage) {
        this.cellLabel.setIcon(newImage);
        this.cellLabel.setOpaque(true); 
    }    
    
    public void setCellLabelColor(Color newColor) {
        this.cellLabel.setBackground(newColor);
        this.cellLabel.setOpaque(true); 
    }

}