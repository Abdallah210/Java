package Game.board;

import java.awt.Color;

//import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.pieces.Piece;


/**
 * Cell's class
 */
public class Cell {

    private int number; 
    private int x; 
    private int y; 
    private String letter; 
    private String color; 
    private boolean empty; 
    private Piece piece;

    public Cell(int x, int y) {

        this.x = x;
        this.y = y;
        this.empty = true;
        this.color = "white";
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

    public String getColor() {
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

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFull() {
        return !(this.empty);
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setStatueOfCell() {
        this.empty = !this.empty;
        if (this.empty == false) {
            this.piece = null;
        }
    }

    public void addPieceInCell(Piece piece) {
        this.piece = piece;
    }

    public void setLetter(String newLetter) {
        this.letter = newLetter;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    public String fullNameOfCell() {
        return this.letter + this.number;
    }

    public JPanel cellDesign() {
        JPanel square = new JPanel();

        if (this.color == "white") {
            Color squareColor = new Color(255, 255, 255);
            square.setBackground(squareColor);

        } else {
            Color squareColor = new Color(0, 0, 0);
            square.setBackground(squareColor);
        }

        square.setBounds(110*this.x, 110*this.y, 110, 110);
        return square;
    }


    public static void main(String[] args) {
        //Cell c1 = new Cell(2, 3);
        //Cell c2 = new Cell(0, 0);

        /* 
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960, 960);
        frame.add(c1.cellDesign());
        frame.add(c2.cellDesign());
        */
    }

}