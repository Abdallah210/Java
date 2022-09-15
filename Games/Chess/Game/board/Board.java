package Game.board;


import javax.swing.JPanel;


import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Board's class
 */
public class Board implements MouseListener {

    private Cell[][] cells =  new Cell[8][8];
    private List<Cell> cellList =  new ArrayList<Cell>();
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


        //Mouse Listener :

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                this.getCell(x, y).getCellLabel().addMouseListener(this);
                cellList.add(this.getCell(x, y));
            }
        }


    }

    private boolean isPair(int number) {
        return number % 2 == 0;
    }

    public Cell getCell(int x, int y) {
            return this.cells[x][y];
    }

    public List<Cell> getCellList(){
        return this.cellList;
    }

    public JPanel getBoardPanel() {
        return this.boardPanel;
    }

    public void resetCellsColor() {

        for (Cell cell : cellList) {
            if (this.isPair(cell.getX()) == this.isPair(cell.getY())) {
                cell.setCellLabelColor(new Color(0x455565));
            }
            else {
                cell.setCellLabelColor(new Color(0xf6f6f6));
            }
        }

    }





    // Mouse listener :



    @Override
    public void mouseClicked(MouseEvent e) {

        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Cell cell : cellList) {

            if (e.getSource()==cell.getCellLabel() && cell.isFull() && (cell.getCellLabelColor().getRGB() != new Color(0xe59494).getRGB() && cell.getCellLabelColor().getRGB() != new Color(0x7b333d).getRGB())) {
                for (Cell cell2 : cellList) {
                    if (cell2.isClicked()) {
                        cell2.setClicked(false);
                        resetCellsColor();
                    }
                }
                cell.setClicked(true);
                if (cell.getCellLabelColor().getRGB() == new Color(0x455565).getRGB() && cell.getCellLabelColor().getRGB() == new Color(0x455565).getRGB()) {
                    cell.setCellLabelColor(new Color(0x296364));
                } else {
                    cell.setCellLabelColor(new Color(0x94c4bb));
                }
                

                for (Cell cellToMove : cell.getPiece().destinationsCells()) {

                    for (Cell boardCell : cellList) {
                        if (cellToMove.getX()==boardCell.getX() && cellToMove.getY()==boardCell.getY()) {
                            if (cellToMove.getCellLabelColor().getRGB() == new Color(0x455565).getRGB()) {
                                if (cellToMove.isFull() && cellToMove.getPiece().getTeamColor()!=cell.getPiece().getTeamColor()) {
                                    cellToMove.setCellLabelColor(new Color(0x7b333d));   //dark red
                                } else {
                                    cellToMove.setCellLabelColor(new Color(0x296364));   //dark green
                                }
                            } else {
                                if (cellToMove.isFull() && cellToMove.getPiece().getTeamColor()!=cell.getPiece().getTeamColor()) {
                                    cellToMove.setCellLabelColor(new Color(0xe59494));    //light red
                                } else {
                                    cellToMove.setCellLabelColor(new Color(0x94c4bb));    //light green
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Cell currentCell : cellList) {
            if (currentCell.isFull() && (currentCell.getCellLabelColor().getRGB() == new Color(0x296364).getRGB() || currentCell.getCellLabelColor().getRGB() == new Color(0x94c4bb).getRGB())) {
                Point currentCoords = new Point(currentCell.getX(), currentCell.getY());
            for (Cell newCell : cellList) {
                if (e.getSource()==newCell.getCellLabel() && newCell.isEmpty() && (newCell.getCellLabelColor().getRGB()==new Color(0x296364).getRGB() || newCell.getCellLabelColor().getRGB()==new Color(0x94c4bb).getRGB())) {
                    
                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().moveTo(newCell.getX(), newCell.getY());
                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).setCellLabelIcon(null);
                    this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setHorizontalAlignment(JLabel.CENTER);
                    this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setVerticalAlignment(JLabel.CENTER);
                    this.getCell(newCell.getX(), newCell.getY()).setCellLabelIcon(this.getCell((int)newCell.getX(), (int)newCell.getY()).getPiece().getImage());

                    this.resetCellsColor();
                }

                if (e.getSource()==newCell.getCellLabel() && newCell.isFull() && (newCell.getCellLabelColor().getRGB()==new Color(0xe59494).getRGB() || newCell.getCellLabelColor().getRGB()==new Color(0x7b333d).getRGB())) {
                    
                    this.getCell((int)newCell.getX(), (int)newCell.getY()).getPiece().getPlayer().addToDeathList(this.getCell(newCell.getX(), newCell.getY()).getPiece());    
                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().moveTo(newCell.getX(), newCell.getY());
                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).setCellLabelIcon(null);
                    this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setHorizontalAlignment(JLabel.CENTER);
                    this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setVerticalAlignment(JLabel.CENTER);
                    this.getCell(newCell.getX(), newCell.getY()).setCellLabelIcon(this.getCell((int)newCell.getX(), (int)newCell.getY()).getPiece().getImage());

                    this.resetCellsColor();
                }
            }



            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


}