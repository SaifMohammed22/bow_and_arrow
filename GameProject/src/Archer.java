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
		//parent.background(0,255,0);
		parent.image(img, x, y);
	}
	
	public void arm() {
		//parent.background(0,255,0); //clear background
		img = parent.loadImage("pic/hero_armed.png");
	}
	
	public void shoot() {
		//parent.background(0,255,0);
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
        } else if (parent.mouseButton == PConstants.LEFT) {
            shoot();
        }
	}
	
	public void mouseDragged() {
        if (parent.mouseButton == PConstants.LEFT) {
            float newY = parent.mouseY;
            updatePosition(x, newY);
        }
    }
	
}