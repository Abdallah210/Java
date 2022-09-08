package Game.board;


import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.GridLayout;
import java.awt.Color;




/**
 * Board's class
 */
public class Board {

    private Cell[][] cells =  new Cell[8][8];
    private JPanel boardPanel;

    public Board() {

        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(8,8));
        this.boardPanel.setBorder(BorderFactory.createLineBorder(new Color(0x8fabc0), 4));
         
        //Cells :
        for (int i = 0; i < 8; i++) {
              for (int j = 0; j < 8; j++) {

                this.cells[i][j] = new Cell(i, j);

                //Color :
                if (this.isPair(i) == this.isPair(j)) {
                    cells[i][j].setCellLabelColor(new Color(0x455565));
                }
 
                //Panel :
                this.cells[i][j].getCellLabel().setLayout(null);
                boardPanel.add(this.cells[i][j].getCellLabel());
            }
        }
    }

    private boolean isPair(int number) {
        return number % 2 == 0;
    }

    public Cell getCell(int x, int y) {
            return this.cells[x][y];
    }

    public JPanel getBoardPanel() {
        return this.boardPanel;
    }


}