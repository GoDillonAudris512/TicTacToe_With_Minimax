package Containers;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Board implements Drawable{
    private List<Integer> emptyPanel;
    private List<Panel> board;

    public Board() {
        this.emptyPanel = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        this.board = new ArrayList<>();
        
        for (Integer i = 0; i < 9; i++) {
            this.board.add(new Panel());
        }
    }

    public List<Integer> getEmptyPanel() {
        return this.emptyPanel;
    }

    public List<Panel> getBoard() {
        return this.board;
    }

    public Panel getPanel(Integer num) {
        return this.board.get(num - 1);
    }

    public void setPanel(Integer num, Panel panel) {
        this.board.set(num - 1, panel);
        if (panel.getClass().equals(Panel.class)) {
            this.emptyPanel.add(num);
        }
        else {
            this.emptyPanel.remove(num);
        }
    }

    public void draw() {
        System.out.println("                -----------");
        for (Integer i = 1; i < 10; i++) {
            if (i % 3 == 1) System.out.print("               |");
            this.board.get(i - 1).draw();
            System.out.print("|");
            if (i % 3 == 0) System.out.println("\n                -----------");
        }
    }
}
