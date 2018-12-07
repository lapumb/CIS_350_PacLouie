package com.example.lapum.paclouie;

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
}
