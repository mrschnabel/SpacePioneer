import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Obstacles {
    private int xPosition;
    private int yPosition;
    Random randGen = new Random();
    Rectangle rect;
    
    public Obstacles() {
        xPosition = randGen.nextInt(600);
        yPosition = randGen.nextInt(500); 
    }

    public void draw(Graphics2D g) {
  
        g.setColor(Color.red);
        g.fillRect(xPosition, yPosition, 50, 40);
    }
    public Rectangle rect() {
        rect = new Rectangle(xPosition, yPosition, 50, 40);
        return rect;
        
    }
}
