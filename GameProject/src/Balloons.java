import processing.core.*;

public class Balloons {
    private float x;
    private float y;
    private float speed;
    private PImage img;

    public Balloons(float x, float y, float speed, PImage img) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.img = img;
    }

    public void update() {
        y -= speed; // Move the balloon upward
    }

    public void draw(PApplet p) {
        p.image(img, x, y); // Draw the balloon image
    }
    
    public float getX() {
    	return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public float getWidth() {
    	return img.width;
    }
    
    public float getHeight() {
    	
    	return img.height;
    }
}