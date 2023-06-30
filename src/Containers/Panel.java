package Containers;
 
public class Panel implements Drawable {
    public Panel() {}

    public void draw() {
        System.out.print("   ");
    }

    public Panel opposite() {
        return new Panel();
    }
}