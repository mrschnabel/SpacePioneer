import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Game extends JPanel implements KeyListener, ActionListener {
    private int score = 0;
    private int level = 1;
 
    boolean play = false;
    private int shipPosX = 310;
    private int shipPosY = 550;
    private Timer time;
    private int delay = 8;
    private boolean hit = false;
    private boolean startMenu;
    
    Obstacles barrier1;
    Obstacles barrier2;
    Obstacles barrier3;
    Obstacles barrier4;
    Obstacles barrier5;
    Obstacles barrier6;
    Obstacles barrier7;
    Obstacles barrier8;
    
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    
    
    public Game() {
        barrier1 = new Obstacles();
        barrier2 = new Obstacles();
        barrier3 = new Obstacles();
        barrier4 = new Obstacles();
        barrier5 = new Obstacles();
        barrier6 = new Obstacles();
        barrier7 = new Obstacles();
        barrier8 = new Obstacles();
        
        enemy1 = new Enemy(level);
        //enemy2 = new Enemy(level);
        
        startMenu = true;
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }
    

    
    public void paint(Graphics g) {
        
        //background
        switch(level) {
            case 1:
                g.setColor(Color.black);
                g.fillRect(1, 1, 692, 592);
                break;
            case 2:
                g.setColor(Color.CYAN);
                g.fillRect(1, 1, 692, 592);
                break;
            case 3:
                g.setColor(Color.green);
                g.fillRect(1, 1, 692, 592);
                break;
        }
 
        
        
        //player ship
        g.setColor(Color.blue);
        g.fillRect(shipPosX, shipPosY, 20, 20);
        
       //drawing map
        barrier1.draw((Graphics2D) g);
        barrier2.draw((Graphics2D) g);
        barrier3.draw((Graphics2D) g);
        barrier4.draw((Graphics2D) g);
        barrier5.draw((Graphics2D) g);
        barrier6.draw((Graphics2D) g);
        barrier7.draw((Graphics2D) g);
        barrier8.draw((Graphics2D) g);
        
        switch(level) {
            case 1:
                enemy1.draw((Graphics2D) g);
                break;
            case 2:
                enemy1.draw((Graphics2D) g);
                enemy2.draw((Graphics2D) g);
                break;
            case 3:
                enemy1.draw((Graphics2D) g);
                enemy2.draw((Graphics2D) g);
                break;
        }
    
        
        
        //score
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString("" + score, 640, 30);
        
        
        if(hit) {
            play = false;
            g.setColor(Color.black);
            g.fillRect(1, 1, 692, 592);
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, score: " + score, 190, 300);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to restart", 230, 350);
        }
        if(startMenu) {
            g.setColor(Color.black);
            g.fillRect(1, 1, 692, 592);
            g.setColor(Color.magenta);
            g.setFont(new Font("serif", Font.BOLD, 70));
            g.drawString("Space Pioneer", 150, 150);
            g.setFont(new Font("serif", Font.BOLD, 10));
            g.drawString("Created by Matt Schnabel, 9-10-2018", 250, 200);
            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to start", 250, 350);
        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        time.start();
       
        Rectangle player = new Rectangle(shipPosX, shipPosY, 20, 20);
        if(play) {
            if(barrier1.rect().intersects( enemy1.rect()) ||
                barrier2.rect().intersects( enemy1.rect()) || 
                barrier3.rect().intersects( enemy1.rect()) || 
                barrier4.rect().intersects( enemy1.rect()) || 
                barrier5.rect().intersects( enemy1.rect()) || 
                barrier6.rect().intersects( enemy1.rect()) || 
                barrier7.rect().intersects( enemy1.rect()) || 
                barrier8.rect().intersects( enemy1.rect())
                ) {
                if(enemy1.getXDir() == 1 && enemy1.getYDir() == 1) {
                    enemy1.subX();
                    enemy1.subY();
                }
                else if(enemy1.getXDir() == 1 && enemy1.getYDir() == -1) {
                    enemy1.subX();
                    enemy1.addY();
                }
                else if(enemy1.getXDir() == -1 && enemy1.getYDir() == 1) {
                    enemy1.addX();
                    enemy1.subY();
                }
                else if(enemy1.getXDir() == -1 && enemy1.getYDir() == -1) {
                    enemy1.addX();
                    enemy1.addY();
                }
            }
            if(level > 1) {
            if(barrier1.rect().intersects( enemy2.rect()) ||
                barrier2.rect().intersects( enemy2.rect()) || 
                barrier3.rect().intersects( enemy2.rect()) || 
                barrier4.rect().intersects( enemy2.rect()) || 
                barrier5.rect().intersects( enemy2.rect()) || 
                barrier6.rect().intersects( enemy2.rect()) || 
                barrier7.rect().intersects( enemy2.rect()) || 
                barrier8.rect().intersects( enemy2.rect())
                ) {
       
                if(enemy2.getXDir() == 1 && enemy2.getYDir() == 1) {
                    enemy2.subX();
                    enemy2.subY();
                }
                else if(enemy2.getXDir() == 1 && enemy2.getYDir() == -1) {
                    enemy2.subX();
                    enemy2.addY();
                }
                else if(enemy2.getXDir() == -1 && enemy2.getYDir() == 1) {
                    enemy2.addX();
                    enemy2.subY();
                }
                else if(enemy2.getXDir() == -1 && enemy2.getYDir() == -1) {
                    enemy2.addX();
                    enemy2.addY();
                }
            }
                
            }
            if(barrier1.rect().intersects(player) ||
                barrier2.rect().intersects(player) || 
                barrier3.rect().intersects(player) || 
                barrier4.rect().intersects(player) || 
                barrier5.rect().intersects(player) || 
                barrier6.rect().intersects(player) || 
                barrier7.rect().intersects(player) || 
                barrier8.rect().intersects(player)|| 
                enemy1.rect().intersects(player)
                ) {
                
                play = false;
                hit = true;
            }
            if(level > 1) {
            if(barrier1.rect().intersects(player) ||
                barrier2.rect().intersects(player) || 
                barrier3.rect().intersects(player) || 
                barrier4.rect().intersects(player) || 
                barrier5.rect().intersects(player) || 
                barrier6.rect().intersects(player) || 
                barrier7.rect().intersects(player) || 
                barrier8.rect().intersects(player)|| 
                enemy1.rect().intersects(player)||enemy2.rect().intersects(player) 
                ) {
                
                play = false;
                hit = true;
            }
            }
            //enemy1 movement
            if(enemy1.getXPosition() < shipPosX) {
                enemy1.addX();
            }
            if(enemy1.getXPosition() > shipPosX) {
                enemy1.subX();
            }
            if(enemy1.getYPosition() < shipPosY) {
                enemy1.addY();
            }
            if(enemy1.getYPosition() > shipPosY) {
                enemy1.subY();
            }
            //enemy2 movement
            if(level >1) {
            if(enemy2.getXPosition() < shipPosX) {
                enemy2.addX();
            }
            if(enemy2.getXPosition() > shipPosX) {
                enemy2.subX();
            }
            if(enemy2.getYPosition() < shipPosY) {
                enemy2.addY();
            }
            if(enemy2.getYPosition() > shipPosY) {
                enemy2.subY();
            }
            
            }
            switch(level) {
                case 1:
                    shipPosY-=1;
                    break;
                case 2:
                    shipPosY-=1;
                    break;
                case 3:
                    shipPosY-=2;
                    break;
            }
           
           if(shipPosY == 0) {
               score+=20;
               if(score >= 100) {
                   level = 2;
               }
               if(score >= 200) {
                   level = 3;
               }
               /*if(score >= 300) { //add 4th level in future
                   level = 4;
               }*/
               shipPosY = 550;
               barrier1 = new Obstacles();
               barrier2 = new Obstacles();
               barrier3 = new Obstacles();
               barrier4 = new Obstacles();
               barrier5 = new Obstacles();
               barrier6 = new Obstacles();
               barrier7 = new Obstacles();
               barrier8 = new Obstacles();
               
               switch(level) {
                   case 1:
                       enemy1 = new Enemy(level);
                      
                       break;
                   case 2:
                       enemy1 = new Enemy(level);
                       enemy2 = new Enemy(level);
                       break;
                   case 3:
                       enemy1 = new Enemy(level);
                       enemy2 = new Enemy(level);
                       break;
                   /*case 4: 
                       enemy1 = new Enemy(level);
                       enemy2 = new Enemy(level);
                       enemy3 = new Enemy(level);*/ //add 4th level in future
               }
              
               
               repaint();
           }
       }
        
        
        repaint();
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(shipPosX >= 670) {
                shipPosX = 670;
            }
            else {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(shipPosX <= 10) {
                shipPosX = 10;
            }
            else {
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(shipPosY >= 600) {
                shipPosY = 600;
            }
            else {
                moveDown();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!play) {
                shipPosY = 550;
                play = true;
                startMenu = false;
                hit = false;
                score = 0;
                level = 1;
                barrier1 = new Obstacles();
                barrier2 = new Obstacles();
                barrier3 = new Obstacles();
                barrier4 = new Obstacles();
                barrier5 = new Obstacles();
                barrier6 = new Obstacles();
                barrier7 = new Obstacles();
                barrier8 = new Obstacles();
                
                
                switch(level) {
                    case 1:
                        enemy1 = new Enemy(level);
                        enemy2 = null;
                        break;
                    case 2:
                        enemy1 = new Enemy(level);
                        enemy2 = new Enemy(level);
                        break;
                    case 3:
                        enemy1 = new Enemy(level);
                        enemy2 = new Enemy(level);
                        break;
                }
                
                repaint();
            }
        }
        
    }

    private void moveRight() {
        play = true;
        shipPosX+=20;
    }
    private void moveLeft() {
        play = true;
        shipPosX-=20;
    }
    private void moveDown() {
        play = true;
        
        if(level >= 3) {
            shipPosY+= 30;
        }
        else {
        shipPosY+=20;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
