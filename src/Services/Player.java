package Services;

import Containers.Panel;

public class Player {
    private Panel panel;

    public Player() {};

    public void assignPanel(Panel panel) {
        this.panel = panel;
    }

    public Panel tellPanel() {
        return this.panel;
    }
}