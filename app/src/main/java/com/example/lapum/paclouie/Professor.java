package com.example.lapum.paclouie;

import android.widget.ImageView;

import java.util.Random;

public class Professor {

    private int speed;
    private ImageView sprite;
    private int x;
    private int y;
    private Random random = new Random();

    //base constructor
    Professor(){
        this.speed = 1;
        //this.sprite = sprite path;
        int x = 0;
        int y = 0;

    }

    //custom constructor
    Professor(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

    public int getSpeed(){
        return speed;
    }

    public ImageView getSprite(){
        return this.sprite;
    }


    //moves the sprite by one tile based on RNG
    //TODO make sure the new spot is not out of bounds and make sure it is moving 1 FPS
    public void move(){
        int dx = 0;
        int dy = 0;

        dx = random.nextInt(2);
        dy = random.nextInt(2);

        if (dx == 1) {
            this.x++;
        }
        if  (dx == 0){
            this.x--;
        }
        if (dy == 1) {
            this.y++;
        }
        if  (dy == 0){
            this.y--;
        }
    }
}
