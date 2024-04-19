import processing.core.*;

public class Archer{
	private PApplet parent;
	private float x;
	private float y;
	private PImage img;
	
	public Archer(PApplet parent) {
		this.parent = parent;
		x = 50;
		y = 50;
		img = parent.loadImage("pic/hero_stand.png");
	}
	
	public void display() {
		parent.image(img, x, y);
	}
	
	public void arm() {
		img = parent.loadImage("pic/hero_armed.png");
	}
	
	public void shoot() {
		img = parent.loadImage("pic/hero_without_arrow.png");
	}
	
	public void updatePosition(float newX, float newY) {
		x = newX;
		y = newY;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() { //getter funtion
		return y;
	}
	
	public void mousePressed() {
		if (parent.mouseButton == PConstants.RIGHT) {
			arm();
        } 
		else if (parent.mouseButton == PConstants.LEFT) {
	            shoot();
		}
	}
	
	public void mouseDragged() {
        if (parent.mouseButton == PConstants.RIGHT) {
            float newY = parent.mouseY;
            updatePosition(x, newY);
        }
    }
	
}