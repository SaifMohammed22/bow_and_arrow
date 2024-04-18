import processing.core.*;
import java.util.ArrayList;

public class Level2 {
    private PApplet parent;
    private ArrayList<Balloons> balloons;
    private int numRedBalloons;
    private int numYellowBalloons;
    private float redBalloonSpeed;
    private float[] yellowBalloonSpeeds;
    private PImage redBalloonImg;
    private PImage yellowBalloonImg;

    public Level2(PApplet parent, int numRedBalloons, int numYellowBalloons, float redBalloonSpeed, float[] yellowBalloonSpeeds, PImage redBalloonImg, PImage yellowBalloonImg) {
        this.parent = parent;
        this.numRedBalloons = numRedBalloons;
        this.numYellowBalloons = numYellowBalloons;
        this.redBalloonSpeed = redBalloonSpeed;
        this.yellowBalloonSpeeds = yellowBalloonSpeeds;
        this.redBalloonImg = redBalloonImg;
        this.yellowBalloonImg = yellowBalloonImg;
        balloons = new ArrayList<Balloons>();
        setBalloons();
    }

    public void setBalloons() {
        // Add red balloons
        for (int i = 0; i < numRedBalloons; i++) {
            float x = parent.random(parent.width /2, parent.width - 35*(i+1));
            float y = parent.random(parent.height);
            balloons.add(new Balloons(x, y, redBalloonSpeed, redBalloonImg));
        }
        // Add yellow balloons
        for (int i = 0; i < numYellowBalloons; i++) {
            float x = parent.random(parent.width /2, parent.width - 35*(i+1));
            float y = parent.random(parent.height);
            float speed = yellowBalloonSpeeds[i % yellowBalloonSpeeds.length];
            balloons.add(new Balloons(x, y, speed, yellowBalloonImg));
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
