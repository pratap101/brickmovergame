          //Board.java
//This class creates game interface and	provide game controlling.	  
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Board extends JPanel { 
    private boolean next=false;    
	private boolean test=false;
	private final int OFFSET = 32;
    private final int SPACE = 40; 
    private final int LEFT_COLLISION = 2;  
    private final int RIGHT_COLLISION = 3;  
    private final int TOP_COLLISION = 4;    
    private final int BOTTOM_COLLISION = 5; 
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Baggage> baggs = new ArrayList<Baggage>();
    private ArrayList<Area> areas = new ArrayList<Area>();
    private Player soko;
    private int w = 0;
    private int h = 0;
    private boolean completed = false;
    private String level1=
			  "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $          ..#\n"
            + "###### ### #@##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";

   public Board() {
     addKeyListener(new TAdapter());
     addKeyListener(new TAdapter1());
	 setFocusable(true);
     initWorld();
    }
   public int getBoardWidth() {
     return this.w;
    }
   public int getBoardHeight() {
     return this.h;
    }
   public final void initWorld() {
     int x = OFFSET;
     int y = OFFSET;
     Wall wall;
     Baggage b;
     Area a;
     for (int i = 0; i < level1.length(); i++) {
          char item = level1.charAt(i);
                if (item == '\n') {
                y += SPACE;
                if (this.w < x) {
                    this.w = x;
                }
                x = OFFSET;
             } else if (item == '#') {
                wall = new Wall(x, y);
                walls.add(wall);
                x += SPACE;
            } else if (item == '$') {
                b = new Baggage(x, y);
                baggs.add(b);
                x += SPACE;
            } else if (item == '.') {
                a = new Area(x, y);
                areas.add(a);
                x += SPACE;
            } else if (item == '@') {
                soko = new Player(x, y);
                x += SPACE;
            } else if (item == ' ') {
                x += SPACE;
            }
			h = y;
        }
    }

    public void buildWorld(Graphics g) {
         g.setColor(Color.GRAY); 
         g.fillRect(0, 0, this.getWidth(), this.getHeight());
         ArrayList world = new ArrayList();
         world.addAll(walls);
         world.addAll(areas);
         world.addAll(baggs);
         world.add(soko);
         for (int i = 0; i < world.size(); i++) {
              Actor item = (Actor) world.get(i);
              if ((item instanceof Player)
                    || (item instanceof Baggage)) {
                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }
            if (completed) {
                String s = "Level Complete";
				String s1 = "Press Esc to Exit and Press N for next Level";
				try{
				g.setColor(new Color(0, 0, 0));
                g.setFont(new Font("Chiller",Font.BOLD,40));
				g.drawString(s, 40, 40);
                g.setFont(new Font("Chiller",Font.BOLD,30));
				g.drawString(s1,40 , 80);
				Thread.sleep(1);
				}
                catch(Exception e){}				
			    test=true;
				}
            }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter1 extends KeyAdapter {
       @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
			if(test){
			if(key == KeyEvent.VK_ESCAPE){
                      System.exit(0);
                       }
			if(key == KeyEvent.VK_N){
                       //new PlayGame().InitUI1();
					  }			
			}
			}
			}
	class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
              if (completed) {
                return;
            }
              int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                if (checkWallCollision(soko,
                        LEFT_COLLISION)) {
                    return;
                }
               if (checkBagCollision(LEFT_COLLISION)) {
                    return;
                }
                soko.move(-SPACE, 0);
                }  if (key == KeyEvent.VK_RIGHT) {
                if (checkWallCollision(soko,
                        RIGHT_COLLISION)) {
                    return;
                }
                if (checkBagCollision(RIGHT_COLLISION)) {
                    return;
                }
                soko.move(SPACE, 0);
                }  if (key == KeyEvent.VK_UP) {
                if (checkWallCollision(soko,
                        TOP_COLLISION)) {
                    return;
                }
                if (checkBagCollision(TOP_COLLISION)) {
                    return;
                }
                soko.move(0, -SPACE);
                }  if (key == KeyEvent.VK_DOWN) {
				     if (checkWallCollision(soko,
                        BOTTOM_COLLISION)) {
                    return;
                }
                 if (checkBagCollision(BOTTOM_COLLISION)) {
                    return;
                }
               soko.move(0, SPACE);
                }  if (key == KeyEvent.VK_R) {
                restartLevel();
            }
               if(key == KeyEvent.VK_ESCAPE)
                           {
						   Object option[]={"END GAME","PLAY GAME"};
						   JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showOptionDialog(null, "ARE YOU SURE DO YOU WANT TO QUIT THE GAME?", "ALERT",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null,option,option[1]);
            if (response == JOptionPane.YES_OPTION)
                              {
                              System.exit(0);
	                          }
						  
						   }
			 repaint();
        }
    }

    private boolean checkWallCollision(Actor actor, int type) {
            if (type == LEFT_COLLISION) {
                 for (int i = 0; i < walls.size(); i++) {
                   Wall wall = (Wall) walls.get(i);
                    if (actor.isLeftCollision(wall)) {
                    return true;
                }
            }
            return false;
                  } else if (type == RIGHT_COLLISION) {
                      for (int i = 0; i < walls.size(); i++) {
                       Wall wall = (Wall) walls.get(i);
                       if (actor.isRightCollision(wall)) {
                    return true;
                }
            }
            return false;
           } else if (type == TOP_COLLISION) {
                for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isTopCollision(wall)) {
                    return true;
                }
            }
            return false;
            } else if (type == BOTTOM_COLLISION) {
                for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isBottomCollision(wall)) {
                    return true;
                }
            }
            return false;
        }
        return false;
		
    }

    private boolean checkBagCollision(int type) {
             if (type == LEFT_COLLISION) {
               for (int i = 0; i < baggs.size(); i++) {
                Baggage bag = (Baggage) baggs.get(i);
                if (soko.isLeftCollision(bag)) {
                     for (int j=0; j < baggs.size(); j++) {
                        Baggage item = (Baggage) baggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.isLeftCollision(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                LEFT_COLLISION)) {
                            return true;
                        }
                    }
                    bag.move(-SPACE, 0);
                    isCompleted();
                }
            }
            return false;
            
        } else if (type == RIGHT_COLLISION) {
                for (int i = 0; i < baggs.size(); i++) {
                  Baggage bag = (Baggage) baggs.get(i);
                  if (soko.isRightCollision(bag)) {
                    for (int j=0; j < baggs.size(); j++) {
                       Baggage item = (Baggage) baggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.isRightCollision(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                RIGHT_COLLISION)) {
                            return true;
                        }
                    }
                    bag.move(SPACE, 0);
                    isCompleted();                   
                }
            }
            return false;
            
			 } else if (type == TOP_COLLISION) {
                  for (int i = 0; i < baggs.size(); i++) {
                   Baggage bag = (Baggage) baggs.get(i);
                    if (soko.isTopCollision(bag)) {
                    for (int j = 0; j < baggs.size(); j++) {
                        Baggage item = (Baggage) baggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.isTopCollision(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                TOP_COLLISION)) {
                            return true;
                        }
                    }
                    bag.move(0, -SPACE);
                    isCompleted();
                }
            }

            return false;
            } else if (type == BOTTOM_COLLISION) {
                 for (int i = 0; i < baggs.size(); i++) {
                  Baggage bag = (Baggage) baggs.get(i);
                  if (soko.isBottomCollision(bag)) {
                    for (int j = 0; j < baggs.size(); j++) {
                        Baggage item = (Baggage) baggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.isBottomCollision(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                BOTTOM_COLLISION)) {
                            return true;
                        }
                    }
                    bag.move(0, SPACE);
                    isCompleted();
                }
            }
        }

        return false;
	}
    public void isCompleted() {
        int num = baggs.size();
        int compl = 0;
           for (int i = 0; i < num; i++) {
            Baggage bag = (Baggage) baggs.get(i);
            for (int j = 0; j < num; j++) {
                Area area = (Area) areas.get(j);
                if (bag.x() == area.x()
                        && bag.y() == area.y()) {
                    compl += 1;
                }
            }
        }
		if (compl == num) {
            completed = true;
            repaint();
        }   
	}
     
	public void restartLevel() {
        areas.clear();
        baggs.clear();
        walls.clear();
        initWorld();
        if (completed) {
            completed = false;
        }
    }
}