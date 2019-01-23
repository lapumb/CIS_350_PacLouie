package com.example.lapum.paclouie;

import java.util.Random;

/**
 * Class to create the games professors.
 */
public class Professor {

    /** Integer value for profs speed. **/
    private int speed;
    /** Integer value for profs X location. **/
    private int x;
    /** Integer value for profs Y location. **/
    private int y;
    /** Value to create new random value. **/
    private Random random = new Random();

    /**
     * Default constructor for Professor class.
     */
    Professor() {
        this.speed = 1;
        //this.sprite = sprite path;
        this.x = 0;
        this.y = 0;

    }

    /**
     * Constructor to set x, y, and speed instance variables.
     * @param xLoc X location to prof.
     * @param yLoc Y location of prof.
     * @param profSpeed Prof's speed.
     */
    Professor(final int xLoc, final int yLoc, final int profSpeed) {
        this.x = xLoc;
        this.y = yLoc;
        this.speed = profSpeed;
    }

    /**
     * Get method for the X location.
     * @return The X location.
     */
    int getX() {
        return x;
    }

    /**
     * Get method for the Y location.
     * @return The Y location.
     */
    int getY() {
        return y;
    }

    /**
     * Get method for the profs speed.
     * @return The profs speed.
     */
    public int getSpeed() {
        return speed;
    }


    //TODO make sure the new spot is not out of bounds and make sure
    // TODO it is moving 1 FPS

    /**
     * Moves the sprite by one tile based on RNG.
     */
    public void move() {
        int dx = 0;
        int dy = 0;

        dx = random.nextInt(2);
        dy = random.nextInt(2);

        if (dx == 1) {
            this.x++;
        }
        if  (dx == 0) {
            this.x--;
        }
        if (dy == 1) {
            this.y++;
        }
        if  (dy == 0) {
            this.y--;
        }
    }

    /**
     * Method returns the actual speed we want the profs to move.
     * @param speed The current speed of the prof.
     * @return The speed the prof needs to move at.
     */
    public static int getRealSpeed(final int speed) {
        //variable to manipulate speed selected
        int realSpeed = 0;

        //setting physical speed
        if (speed == 1) {
            realSpeed = 900;
        } else if (speed == 2) {
            realSpeed = 850;
        } else if (speed == 3) {
            realSpeed = 800;
        } else if (speed == 4) {
            realSpeed = 750;
        } else if (speed == 5) {
            realSpeed = 700;
        } else if (speed == 6) {
            realSpeed = 650;
        } else if (speed == 7) {
            realSpeed = 600;
        } else if (speed == 8) {
            realSpeed = 550;
        } else if (speed == 9) {
            realSpeed = 500;
        }
        return realSpeed;
    }
}
