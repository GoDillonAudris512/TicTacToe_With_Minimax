package Services;

import java.util.ArrayList;
import Algorithm.Minimax;
import Containers.Board;
import Containers.Panel;

public class Bot extends Player {
    private final Minimax algorithm = new Minimax();

    public Bot() {
        super();
    };

    public void assignPanel(Panel panel) {
        super.assignPanel(panel);
        algorithm.setPanel(panel);
    }

    public Integer chooseAction(Board board) {
        Integer bestVal = Integer.MIN_VALUE;
        Integer bestPanelNum = 0;

        for (Integer panelNum : new ArrayList<>(board.getEmptyPanel())) {
            board.setPanel(panelNum, this.tellPanel());
            Integer val = this.algorithm.minimax(board, false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            board.setPanel(panelNum, new Panel());
            if (val > bestVal) {
                bestVal = val;
                bestPanelNum = panelNum;
            }
        }

        return bestPanelNum;
    }
}
