package Algorithm;

import java.util.ArrayList;
import java.util.List;
import Containers.Board;
import Containers.Panel;
import Services.Checker;

public class Minimax {
    private Panel botPanel;
    private final Checker checker = new Checker();

    public Minimax() {
        this.botPanel = new Panel();
    }

    public void setPanel(Panel botPanel) {
        this.botPanel = botPanel;
    } 

    public Integer minimax(Board board, Boolean isBot, Integer depth, Integer alpha, Integer beta) {
        List<Integer> emptyPanel = new ArrayList<>(board.getEmptyPanel());
        
        if (checker.checkWinStatus(board, botPanel)) {
            return 10 - depth;
        }
        if (checker.checkWinStatus(board, botPanel.opposite())) {
            return -10 + depth;
        }
        if (emptyPanel.isEmpty()) {
            return 0;
        }

        if (isBot) {
            Integer bestValue = Integer.MIN_VALUE;
            for (Integer panelNum : emptyPanel) {
                board.setPanel(panelNum, botPanel);
                bestValue = Math.max(bestValue, minimax(board, !isBot, depth + 1, alpha, beta));
                board.setPanel(panelNum, new Panel());
                alpha = Math.max(alpha, bestValue);
                if (alpha >= beta) {
                    break;
                }
            }
            return bestValue;
        }
        else {
            Integer bestValue = Integer.MAX_VALUE;  
            for (Integer panelNum : emptyPanel) {
                board.setPanel(panelNum, botPanel.opposite());
                bestValue = Math.min(bestValue, minimax(board, !isBot, depth + 1, alpha, beta));
                board.setPanel(panelNum, new Panel());
                beta = Math.min(beta, bestValue);
                if (alpha >= beta) {
                    break;
                }
            }
            return bestValue;
        }
    }
}
