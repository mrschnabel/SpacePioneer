import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
public class Enemy {
    private int xPosition;
    private int yPosition;
    private int xDir;
    private int yDir;
    private int speed;
    Random randGen = new Random();
    Rectangle rect;
    public Enemy(int level) {
        switch(level) {
            case 1: speed = 1; break;
            case 2: speed = 1; break;
            case 3: speed = 2; break;
        }
        xPosition = randGen.nextInt(600);
        yPosition = randGen.nextInt(500); 
    }
    
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(xPosition, yPosition, 20, 20);
    }
    
    public Rectangle rect() {
        rect = new Rectangle(xPosition, yPosition, 20, 20);
        return rect;
        
    }
    
    public int getXPosition(){
        return this.xPosition;
        
    }
    public int getYPosition() {
        return this.yPosition;
    }
    public void addX() {
       xPosition+=speed;
       xDir = 1;
    }
    public void subX() {
        xPosition-=speed;
        xDir = -1;
     }
    public void addY() {
        yPosition+=speed;
        yDir = 1;
     }
    public void subY() {
        yPosition-=speed;
        yDir = -1;
     }
    public int getXDir() {
        return this.xDir;
    }
    public int getYDir() {
        return this.yDir;
    }
    
    
    
}
