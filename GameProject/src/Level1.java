import processing.core.*;
import java.util.ArrayList;

public class Level1 {
    private PApplet parent;
    private ArrayList<Balloons> balloons;
    private int numBalloons;
    private float speed;
    private PImage img;

    public Level1(PApplet parent, int numBalloons, float speed, PImage img) {
        this.parent = parent;
        this.numBalloons = numBalloons;
        this.speed = speed;
        this.img = img;
        balloons = new ArrayList<Balloons>();
        setBalloons();
    }

    public void setBalloons() {
        for (int i = 0; i <= numBalloons; i++) {
            balloons.add(new Balloons(parent.width - 35 * (i + 1), parent.height, speed, img));
        }
    }

    public void show() {
        //parent.background(0, 255, 0); // Clear the background
        for (Balloons balloon : balloons) {
            balloon.update();
            balloon.draw(parent);
            // Reset the position if the balloon goes out of the window
            if (balloon.getY() < -10) {
                balloon.setY(parent.height); // Set the y position to the bottom of the sketch window
            }
        }
    }
}
