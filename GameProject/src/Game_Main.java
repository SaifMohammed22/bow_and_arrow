import processing.core.*;
import java.util.ArrayList;


public class Game_Main extends PApplet {
    private Level1 level1;
    //private Level2 level2;
    private Archer archer;
    private Arrows[] arrows ;
    private ArrayList<Balloons> balloons;
    
    
    
    public void settings() {
        fullScreen();
    }

    public void setup() {
        PImage redBalloonImage = loadImage("pic/ballon.png"); 
        //PImage yellowBalloonImage = loadImage("pic/ballon_yellow.png");
        PImage arrowImg = loadImage("pic/arrow.png");
        
        level1 = new Level1(this, 15, 3, redBalloonImage);
        //level2 = new Level2(this, 12, 3, 3, new float[]{3.5f, 3.0f, 4.5f, 4.0f}, redBalloonImage, yellowBalloonImage);
        archer = new Archer(this);
        arrows = new Arrows[20];
        for (int i =0; i < arrows.length; i++) {
            arrows[i] = new Arrows(this, arrowImg);
        }
        balloons = new ArrayList<Balloons>();
    }
        

    

    public void draw() {
    	background(0,255,0);
        level1.show();
        //level2.show();
        archer.display();
        displayArrow();
        
    }
    
    
 
    public void displayArrow() {
    	for (Arrows arrow : arrows){
    		arrow.display();
    		arrow.move(balloons);
    	}
    	
    }
    
    public void mousePressed() {
    	archer.mousePressed();
    	for (Arrows arrow: arrows) {
    		if (!arrow.isActive()) {
	    		arrow.shoot(archer.getX(), archer.getY());
	    		break;
	    	}
    	}
    }
    
    public void mouseDragged() {
    	archer.mouseDragged();
    }
    
    
    


    public static void main(String[] args) {
        String[] processingArgs = {"Game_Main"};
        PApplet.runSketch(processingArgs, new Game_Main());
    }
}
