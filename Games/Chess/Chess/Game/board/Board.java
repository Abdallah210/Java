package Game.board;
// destinationsCells

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

            if (e.getSource()==cell.getCellLabel() && cell.isFull() && (!cell.isLightRed() && !cell.isDarkRed()) && cell.getPiece().getPlayer().isMyTurn()) {
                for (Cell cell2 : cellList) {
                    if (cell2.isClicked()) {
                        cell2.setClicked(false);
                        resetCellsColor();
                    }
                }
                cell.setClicked(true);
                cell.changeToGreenColor();
                

                for (Cell cellToMove : cell.getPiece().destinationsCells()) {

                    for (Cell boardCell : cellList) {
                        if (cellToMove.getX()==boardCell.getX() && cellToMove.getY()==boardCell.getY()) {
                            if (cellToMove.isDark()) {
                                if (cellToMove.isFull() && cellToMove.getPiece().getTeamColor()!=cell.getPiece().getTeamColor()) {
                                    cellToMove.changeToDarkRed();
                                } else {
                                    cellToMove.changeToDarkGreen();
                                }
                            } else {
                                if (cellToMove.isFull() && cellToMove.getPiece().getTeamColor()!=cell.getPiece().getTeamColor()) {
                                    cellToMove.changeToLightRed();
                                } else {
                                    cellToMove.changeToLightGreen();
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Cell currentCell : cellList) {

            if (currentCell.isClicked()) {
                Point currentCoords = new Point(currentCell.getX(), currentCell.getY());
                for (Cell newCell : cellList) {
                    // Empty Cell
                    if (e.getSource()==newCell.getCellLabel() && newCell.isEmpty() && (newCell.isDarkGreen() || newCell.isLightGreen())) {
                        
                        for (Cell c : cellList) {
                            if (c.isFull() && this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getTeamColor()!= this.getCell(c.getX(), c.getY()).getPiece().getTeamColor()) {
                                
                                // set myTurn attribute
                                this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().setTurn(this.getCell(c.getX(), c.getY()).getPiece().getPlayer().isMyTurn());
                                this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().startStopCountdown();
                                this.getCell(c.getX(), c.getY()).getPiece().getPlayer().setTurn(!this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().isMyTurn());
                                this.getCell(c.getX(), c.getY()).getPiece().getPlayer().startStopCountdown();

                                //print the sentences :
                                if (this.getCell(c.getX(), c.getY()).getPiece().getPlayer().isMyTurn()) {
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setText("It's your turn");
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0x00822b));
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setText("Wait your turn");
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0xb80000));
                                } else {
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setText("Wait your turn");
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0xb80000));
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setText("It's your turn");
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0x00822b));
                                }
                                break;
                            }
                        }

                        // move & print piece in the new cell
                        this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().moveTo(newCell.getX(), newCell.getY());
                        this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).setCellLabelIcon(null);
                        this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setHorizontalAlignment(JLabel.CENTER);
                        this.getCell(newCell.getX(), newCell.getY()).getCellLabel().setVerticalAlignment(JLabel.CENTER);
                        this.getCell(newCell.getX(), newCell.getY()).setCellLabelIcon(this.getCell((int)newCell.getX(), (int)newCell.getY()).getPiece().getImage());

                        this.resetCellsColor();
                    }


                    // Cell with enemy 
                    if (e.getSource()==newCell.getCellLabel() && newCell.isFull() && (newCell.isLightRed() || newCell.isDarkRed())) {
                        
                        for (Cell c : cellList) {
                            if (c.isFull() && this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getTeamColor()!= this.getCell(c.getX(), c.getY()).getPiece().getTeamColor()) {
                                
                                // set myTurn attribute
                                this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().setTurn(this.getCell(c.getX(), c.getY()).getPiece().getPlayer().isMyTurn());
                                this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().startStopCountdown();
                                this.getCell(c.getX(), c.getY()).getPiece().getPlayer().setTurn(!this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().isMyTurn());
                                this.getCell(c.getX(), c.getY()).getPiece().getPlayer().startStopCountdown();


                                //print the sentences :
                                if (this.getCell(c.getX(), c.getY()).getPiece().getPlayer().isMyTurn()) {
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setText("It's your turn");
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0x00822b));
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setText("Wait your turn");
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0xb80000));
                                } else {
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setText("Wait your turn");
                                    this.getCell(c.getX(), c.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0xb80000));
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setText("It's your turn");
                                    this.getCell((int)currentCoords.getX(), (int)currentCoords.getY()).getPiece().getPlayer().turnLabel().setForeground(new Color(0x00822b));
                                }

                                break;
                            }
                        }

                        // move & print piece in the new cell
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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}