package Containers;
 
public class OPanel extends Panel {
    public OPanel() {}   

    public void draw() {
        System.out.print(" O ");
    }

    public Panel opposite() {
        return new XPanel();
    }
}
