package Services;

import Containers.Board;
import Containers.Panel;

public class Checker {
    private Panel panelToCheck;

    public Checker() {
        this.panelToCheck = new Panel();
    }

    private Boolean isWinInRow(Board board) {
        for (Integer i = 0; i < 3; i++) {
            if (board.getPanel(1 + 3*i).getClass().equals(panelToCheck.getClass()) &&
                board.getPanel(1 + 3*i).getClass().equals(board.getPanel(2 + 3*i).getClass()) &&
                board.getPanel(2 + 3*i).getClass().equals(board.getPanel(3 + 3*i).getClass())) {
                return true;
            }
        }
        return false;
    }

    private Boolean isWinInColumn(Board board) {
        for (Integer i = 0; i < 3; i++) {
            if (board.getPanel(i + 1).getClass().equals(panelToCheck.getClass()) &&
                board.getPanel(i + 1).getClass().equals(board.getPanel(i + 4).getClass()) &&
                board.getPanel(i + 4).getClass().equals(board.getPanel(i + 7).getClass())) {
                return true;
            }     
        }

        return false;
    }

    private Boolean isWinInDiagonal(Board board) {
        if (!board.getPanel(5).getClass().equals(panelToCheck.getClass())) {
            return false;
        }
        
        if (board.getPanel(1).getClass().equals(board.getPanel(5).getClass()) &&
            board.getPanel(5).getClass().equals(board.getPanel(9).getClass())) {
            return true;
        }  
        
        if (board.getPanel(3).getClass().equals(board.getPanel(5).getClass()) &&
            board.getPanel(5).getClass().equals(board.getPanel(7).getClass())) {
            return true;
        }  

        return false;
    }

    public Boolean checkWinStatus(Board board, Panel panel) {
        this.panelToCheck = panel;
        return this.isWinInRow(board) || this.isWinInColumn(board) || this.isWinInDiagonal(board);
    }
}
