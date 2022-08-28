package Game.board;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

/**
 * Board's class
 */
public class Board {

    private Cell[][] cells =  new Cell[8][8];
    private JFrame frame;

    public Board() {

        //Frame :
        this.frame = new JFrame();
        this.frame.setTitle("Chess");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        //frame.setResizable(false);   
        ImageIcon icon = new ImageIcon("./images/icon.png");  
        this.frame.setIconImage(icon.getImage());

        //Cells :
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                this.cells[i][j] = new Cell(i, j);

                //Color :
                if (this.isPair(i) == this.isPair(j)) {
                    cells[i][j].setColor("black");
                }

                //Panel :
                frame.add(this.cells[i][j].cellDesign());
            }
        }

        this.frame.setBounds(0, 0,  908, 987);
        this.frame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 5, 20, 5, Color.gray));
        this.frame.setLocation(500, 25);
    }

    private boolean isPair(int number) {
        return number % 2 == 0;
    }



    public Cell getCell(int x, int y) {
            return this.cells[x][y];
    }

    public JFrame getFrame() {
        return this.frame;
    }











    public static void main(String[] args) {
        Board b = new Board();


    }


}