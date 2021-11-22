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
import java.awt.Image;

public class Actor {

    private final int SPACE = 50;

    private int x;
    private int y;
    private Image image;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image img) {
        image = img;
//        image.getScaledInstance(100, 100, 50);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeftCollision(Actor actor) {
        if (((this.x() - SPACE) == actor.x()) &&
            (this.y() == actor.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightCollision(Actor actor) {
        if (((this.x() + SPACE) == actor.x())
                && (this.y() == actor.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTopCollision(Actor actor) {
        if (((this.y() - SPACE) == actor.y()) &&
            (this.x() == actor.x())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBottomCollision(Actor actor) {
        if (((this.y() + SPACE) == actor.y())
                && (this.x() == actor.x())) {
            return true;
        } else {
            return false;
        }
    }
}

