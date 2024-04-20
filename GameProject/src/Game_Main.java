import processing.core.*;
import java.util.ArrayList;


public class Game_Main extends PApplet {
    private Level1 level1;
    private Level2 level2;
    private Archer archer;
    private Arrows[] arrows;
    private ArrayList<Balloons> balloons;
    private int numArrows = 20;
    private int gameState;
    private int score;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        PImage redBalloonImage = loadImage("pic/ballon.png"); 
        PImage yellowBalloonImage = loadImage("pic/ballon_yellow.png");
        PImage arrowImg = loadImage("pic/arrow.png");
        
      
        level1 = new Level1(this, 15, 3, redBalloonImage);
        level2 = new Level2(this, 12, 3, 3, new float[]{3.5f, 3.0f, 4.5f, 4.0f}, redBalloonImage, yellowBalloonImage);
        archer = new Archer(this);
        arrows = new Arrows[20];
        for (int i =0; i < arrows.length; i++) {
            arrows[i] = new Arrows(this, arrowImg);
        }
        balloons = level1.setBalloons();     
        gameState = 1;
        score = 0;
    }

    public void draw() {
        background(0,255,0);
        if (gameState == 1) {
        	level1.show();
        }
        else if (gameState == 2 ){
        	level2.show();
        }
        archer.display();
        displayArrow();
        displayText();
        
        if (gameState == 1 && level1.isAllHit()) {
        	switchToLevel2();
        }
        
        
    }
    
    public void displayText() {
    	textSize(25);
    	text("Remaining Arrows: " + numArrows, 15, 25);
    	if (numArrows == 0) {
    		fill(255,0,0);
    		textSize(60);
    		text("Game Over", 600, 400);
    	}
    }

    public void displayArrow() {
        for (Arrows arrow : arrows) {
            arrow.display();
            arrow.move(balloons);
            
        }
    }

    public void mousePressed() {
        archer.mousePressed();
        for (Arrows arrow : arrows) {
            if (!arrow.isActive() && mouseButton == LEFT) {
                arrow.shoot(archer.getX(), archer.getY());
                numArrows --;
                break;
            }
        }
    }

    public void mouseDragged() {
        archer.mouseDragged();
    }
    
    public void switchToLevel2() {
    	gameState = 2;
    	balloons = level2.setBalloons();
    }
    

    public static void main(String[] args) {
        String[] processingArgs = {"Game_Main"};
        PApplet.runSketch(processingArgs, new Game_Main());
    }
}