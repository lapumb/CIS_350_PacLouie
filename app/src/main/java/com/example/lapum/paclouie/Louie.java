package com.example.lapum.paclouie;

import android.widget.ImageView;

/**
 * Class to create Louie character.
 */
public class Louie {

    /** Integer value for Louie's health. **/
    private int health;

    /** Integer value for Louie's x location. **/
    private int x;

    /** Integer value for Louie's y location. **/
    private int y;

    /** Louie's sprite. **/
    private ImageView sprite;

    /** Integer value for the maximum width of Louie. **/
    private int maxWidth = 100;

    /** Integer value for the maximum height of Louie. **/
    private int maxHeight = 100;

    /**
     * Louie the Laker constructor. X and y are coordinates of starting Louie.
     */
    Louie() {
        health = 3;
        setPosition(50, 50);
    }

    /**
     * Constructor for Louie to set the location and health.
     * @param louieHealth Louie's health.
     * @param xLoc X location of Louie.
     * @param yLoc Y location of Louie.
     */
    Louie(final int louieHealth, final int xLoc, final int yLoc) {
        this.health = louieHealth;
        this.x = xLoc;
        this.y = yLoc;
    }

    //TODO find how to load each image

    /**
     * Sets sprite to the louie.png.
     */
    private void loadImage() {

    }

    /**
     * Get method for the sprite.
     * @return The Louie sprite.
     */
    public ImageView getSprite() {
        return sprite;
    }

    /**
     * Get method for Louie's health.
     * @return Louie's health.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * How much damage to take.
     * @param damage Damage to Louie.
     */
    public void takeDamage(final int damage) {
        this.health -= damage;
    }

    /**
     * Sets Louie's position.
     * @param xLoc X location of Louie.
     * @param yLoc Y location of Louie.
     */
    private void setPosition(final int xLoc, final int yLoc) {
        this.x = xLoc;
        this.y = yLoc;
    }

    /**
     * Updates the direction of the sprite to match the correct png.
     * @param dir //TODO
     */
    private void updateSprite(final int dir) {
        if (dir == 0) {
            //set sprite to standing png
        }
        if (dir == -1) {
            //set sprite to left png
        }
        if (dir == 1) {
            //set sprite to right png
        }
    }

    //TODO find what max width and height are
    /**
     * Updates the position of Louie.
     * @param dx New X location of Louie.
     * @param dy New Y location of Louie.
     */
    public void updatePosition(final int dx, final int dy) {

        int direction = 0;

        if ((x + dx) > 0 && (x + dx) < maxWidth) {
            this.x += dx;
        }

        if ((y + dy) > 0 && (y + dy) < maxHeight) {
            this.y += dy;
        }

        if (dx > 0) {
            direction = 1;
        }

        if (dx < 0) {
            direction = -1;
        }

        updateSprite(direction);
        setPosition(x, y);
    }

}
