package com.example.lapum.paclouie;

public class Louie {

    private int health;

    private int x;

    private int y;

    /*
    Louie the Laker constructor. x and y are coordinates of starting Louie.
     */
    Louie(){
        int health = 3;
        //int x = middle Coordinate;
        //int y = middle Coordinate;
    }

    Louie(int health, int x, int y){
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void updatePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

}
