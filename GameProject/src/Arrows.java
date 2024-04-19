import java.util.ArrayList;

import processing.core.*;


public class Arrows {
    private PApplet parent;
    private PImage img;
    private float x;
    private float y;
    private boolean isActive;
    private int speed = 4;
    

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
    }

    public void display() {
        if (isActive) {
            parent.image(img, x, y);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }

    public void shoot(float archerX, float archerY) {
        if (parent.mouseButton == PConstants.LEFT && !isActive) {
            update(archerX + 40, archerY + 40);
        }
    }

    public void move(ArrayList<Balloons> balloons) {
        if (isActive) {
            x += speed;
            
            for (Balloons balloon : balloons) { 
            	if (collide(balloon)) {
                	balloons.remove(balloon);
                }
            	System.out.println(collide(balloon)); 	
            }
        }
      }

    public boolean collide(Balloons balloon) {
    	float distance = PApplet.dist(x, y, balloon.getX(), balloon.getY());
    	return distance < 5;
    }
}
