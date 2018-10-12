package com.example.lapum.paclouie;

import android.media.Image;

public class Louie {

    //Louie's health
    private int health;

    //X and Y coordinates
    private int x;
    private int y;

    //Louie sprite
    private Image sprite;

    int maxWidth = 100;
    int maxHeight = 100;


     /*
    Louie the Laker constructor. x and y are coordinates of starting Louie.
     */

    Louie(){
        int health = 3;
        setPosition(50, 50);
    }

    /*
    Louie custom constructor
     */
    Louie(int health, int x, int y){
        this.health = health;
        this.x = x;
        this.y = y;
    }

    /*
    Sets sprite to the louie.png
    TODO find how to load each image
     */
    private void loadImage(){

    }

    //return sprite
    public Image getSprite() {
        return sprite;
    }

    //return health
    public int getHealth(){

        return this.health;
    }

    //how much damage to take
    public void takeDamage(int health){

        this.health -= health;
    }

    //sets Louie's position
    private void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /*
    Updates the direction of the sprite to match the correct png
     */
    private void updateSprite( int dir ){
        if (dir == 0){
            //set sprite to standing png
        }
        if (dir == -1){
            //set sprite to left png
        }
        if (dir == 1){
            //set sprite to right png
        }
    }

    /*
    Updates the position of Louie
    TODO find what max width and height are
     */
    public void updatePosition(int dx, int dy){

        int direction = 0;

        if ( (x + dx ) > 0 && (x + dx) < maxWidth){
            this.x += dx;
        }

        if ((y + dy) > 0 && (y + dy) < maxHeight){
            this.y += dy;
        }

        if(dx > 0){
            direction = 1;
        }

        if(dx < 0){
            direction = -1;
        }

        updateSprite(direction);
        setPosition(x,y);
    }

}
