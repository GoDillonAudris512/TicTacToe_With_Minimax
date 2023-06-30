package Containers;
 
public class XPanel extends Panel {
    public XPanel() {}   

    public void draw() {
        System.out.print(" X ");
    }

    public Panel opposite() {
        return new OPanel();
    }
}
