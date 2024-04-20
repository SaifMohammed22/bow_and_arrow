import java.util.ArrayList;
import processing.core.*;

public class Arrows {
    private PApplet parent;
    private PImage img;
    private float x;
    private float y;
    private boolean isActive;
    private int speed;
    
    public Arrows(PApplet parent, PImage img) {
        this.parent = parent;
        this.img = img;
        x = -100; // Initial position off-screen
        y = -100; // Initial position off-screen
        isActive = false;
    }

    public void update(float x, float y) {
        this.x = x;
        this.y = y;
        isActive = true;
        speed = 6;
    }

    public void display() {
        if (isActive) {
            parent.image(img, x, y);
        }
    }

    public boolean isActive() {
        return isActive;
    }


    public void shoot(float archerX, float archerY) {
        if (parent.mouseButton == PConstants.LEFT && !isActive) {
            update(archerX + 40, archerY + 40);
        }
    }

    public void move(ArrayList<Balloons> balloons) {
        if (isActive) {
            x += speed;
            PVector arrowTopLeft = new PVector(x, y);
            PVector arrowBottomRight = new PVector(x + img.width, y + img.height);

            // Iterate over balloons
            for (int i = balloons.size() - 1; i >= 0; i--) { // Iterate backwards to safely remove elements
                Balloons balloon = balloons.get(i);

                // Calculate bounding box for balloon
                PVector balloonTopLeft = new PVector(balloon.getX(), balloon.getY());
                PVector balloonBottomRight = new PVector(balloon.getX() + balloon.getWidth(), balloon.getY() + balloon.getHeight());

                // Check for intersection
                if (intersect(arrowTopLeft, arrowBottomRight, balloonTopLeft, balloonBottomRight)) {
                    // Remove collided balloon
                    balloons.remove(i);
                }
            }
        }
    }
    
   
    public boolean intersect(PVector rect1TopLeft, PVector rect1BottomRight, PVector rect2TopLeft, PVector rect2BottomRight) {
        return rect1TopLeft.x < rect2BottomRight.x && rect1BottomRight.x > rect2TopLeft.x && rect1TopLeft.y < rect2BottomRight.y && rect1BottomRight.y > rect2TopLeft.y;
    }


    public float getX(){
    	return x;
    }
    
    public float getY() {
    	return y;
    }
    
    public float getWidth() {
    	return img.width;
    }
    
    public float getHeight() {
    	return img.height;
    }
    
    
}
