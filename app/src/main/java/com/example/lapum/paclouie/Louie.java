package com.example.lapum.paclouie;

/**
 * Class to create Louie character.
 */
public class Louie {

    /** Integer value for Louie's health. **/
    private int health;

    /**
     * Louie the Laker constructor. X and y are coordinates of starting Louie.
     */
    Louie() {
        health = 3;
    }

    /**
     * Constructor for Louie to set the location and health.
     * @param louieHealth Louie's health.
     */
    Louie(final int louieHealth) {
        this.health = louieHealth;
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
}
