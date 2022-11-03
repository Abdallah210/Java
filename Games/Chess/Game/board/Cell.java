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

    public void changeToGreenColor() {
        if (this.getCellLabelColor().getRGB() == new Color(0x455565).getRGB()) {
            this.setCellLabelColor(new Color(0x296364));
        } else {
            this.setCellLabelColor(new Color(0x94c4bb));
        }
    }

    public void changeToDarkGreen() {
        this.setCellLabelColor(new Color(0x296364)); 
    }
    
    public void changeToLightGreen() {
        this.setCellLabelColor(new Color(0x94c4bb)); 
    }
    
    public void changeToDarkRed() {
        this.setCellLabelColor(new Color(0x7b333d)); 
    }
    
    public void changeToLightRed() {
        this.setCellLabelColor(new Color(0xe59494)); 
    }    

    public boolean isDarkGreen() {
        return this.getCellLabelColor().getRGB()==new Color(0x296364).getRGB();
    }
    
    public boolean isLightGreen() {
        return this.getCellLabelColor().getRGB()==new Color(0x94c4bb).getRGB();
    }
    
    public boolean isDarkRed() {
        return this.getCellLabelColor().getRGB()==new Color(0x7b333d).getRGB();
    }
    
    public boolean isLightRed() {
        return this.getCellLabelColor().getRGB()==new Color(0xe59494).getRGB();
    }    
    
    public boolean isDark() {
        return this.getCellLabelColor().getRGB() == new Color(0x455565).getRGB();
    }    
        
    public boolean isLight() {
        return this.getCellLabelColor().getRGB() == new Color(0xffffff).getRGB();
    }    

    
}