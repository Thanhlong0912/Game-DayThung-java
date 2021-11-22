/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokobanmain;

/**
 *
 * @author Admin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JPanel;



public class Board1 extends JPanel { 

    private final int OFFSET = 70;
    private final int SPACE = 50;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private final ArrayList walls = new ArrayList();
    private final ArrayList baggs = new ArrayList();
    private final ArrayList areas = new ArrayList();
    private Player soko;
    private int w = 0;
    private int h = 0;
    private boolean completed = false;
    
    private final String level =
              "#####    \n"
            + "#   #    \n"
            + "# $ # ###\n"
            + "#@$ # #.#\n"
            + "### ###.#\n"
            + " ##  $ .#\n"
            + " #   #  #\n"
            + " #   ####\n"
            + " #####   \n";
//# is wall
//$ is thung`  
//@ is player
//. is finalarea        
    public Board1() {

        addKeyListener(new TAdapter());
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
        


        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);
            Color color;
            switch (item) {
                case '\n':
                    y += SPACE;
                    if (this.w < x) {
                        this.w = x;
                    }   x = OFFSET;
                    break;
                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += SPACE;
                    break;
                case '$':
                    b = new Baggage(x, y);
                    baggs.add(b);
                    x += SPACE;
                    break;
                case '.':
                    a = new Area(x, y);
                    areas.add(a);
                    x += SPACE;
                    break;
                case '@':
                    soko = new Player(x, y);
                    x += SPACE;
                    break;
                case ' ':
                    x += SPACE;
                    break;
                case 1   :
                    color = Color.BLACK;
                default:
                    break;
            }

            h = y;
        }
    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
       g.setColor(new Color(0, 0, 0));
        g.drawString("Nhấn R để return", 30, 40);
        g.drawString("Nhấn N để nextlevel", 30, 60);
        ArrayList world = new ArrayList();
//        JButton btnnext = new JButton();
//        add(btnnext);
        world.addAll(walls);
        world.addAll(areas);
        world.addAll(baggs);
        world.add(soko);

        for (int i = 0; i < world.size(); i++) {

            Actor item = (Actor) world.get(i);

            if ((item instanceof Player)
                    || (item instanceof Baggage)) {
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            } else {
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            if (completed) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Ban da pha dao duoc cai map cui bap nay :))))", 25, 20);
//                JButton btnnext = new JButton("NEXT");
//                this.add(btnnext);
            }

        }
    }
    


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (completed) {
                return;
            }

            
            int key = e.getKeyCode();


            switch (key) {
                case KeyEvent.VK_LEFT:
                    if (checkWallCollision(soko,
                            LEFT_COLLISION)) {
                        return;
                    }   if (checkBagCollision(LEFT_COLLISION)) {
                        return;
                    }   soko.move(-SPACE, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    if (checkWallCollision(soko,
                            RIGHT_COLLISION)) {
                        return;
                    }   if (checkBagCollision(RIGHT_COLLISION)) {
                        return;
                    }   soko.move(SPACE, 0);
                    break;
                case KeyEvent.VK_UP:
                    if (checkWallCollision(soko,
                            TOP_COLLISION)) {
                        return;
                    }   if (checkBagCollision(TOP_COLLISION)) {
                        return;
                    }   soko.move(0, -SPACE);
                    break;
                case KeyEvent.VK_DOWN:
                    if (checkWallCollision(soko,
                            BOTTOM_COLLISION)) {
                        return;
                    }   if (checkBagCollision(BOTTOM_COLLISION)) {
                        return;
                    }   soko.move(0, SPACE);
                    break;
                case KeyEvent.VK_R:
                    restartLevel();
                    break;
                case KeyEvent.VK_N:
                    nextLevel();
                    break;
                default:
                    break;
            }

            repaint();
        }
    }

    private boolean checkWallCollision(Actor actor, int type) {

        switch (type) {
            case LEFT_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = (Wall) walls.get(i);
                    if (actor.isLeftCollision(wall)) {
                        return true;
                    }
                }
                return false;
            case RIGHT_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = (Wall) walls.get(i);
                    if (actor.isRightCollision(wall)) {
                        return true;
                    }
                }
                return false;
            case TOP_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = (Wall) walls.get(i);
                    if (actor.isTopCollision(wall)) {
                        return true;
                    }
                }
                return false;
            case BOTTOM_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = (Wall) walls.get(i);
                    if (actor.isBottomCollision(wall)) {
                        return true;
                    }
                }
                return false;
            default:
                break;
        }
        return false;
    }

    private boolean checkBagCollision(int type) {

        switch (type) {
            case LEFT_COLLISION:
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
            case RIGHT_COLLISION:
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
            case TOP_COLLISION:
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
            case BOTTOM_COLLISION:
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
                }   break;
            default:
                break;
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
            Sokobanlevel3 skblv3 = new Sokobanlevel3();
            skblv3.setVisible(true);
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
     public void nextLevel(){
        initWorld();
        areas.clear();
        baggs.clear();
        walls.clear();
        if(completed = true){
         Sokobanlevel3 skb = new Sokobanlevel3();
         skb.setVisible(true);
        }}
}

