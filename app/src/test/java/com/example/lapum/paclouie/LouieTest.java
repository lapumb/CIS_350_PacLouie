package com.example.lapum.paclouie;

import org.junit.Test;

import static org.junit.Assert.*;

public class LouieTest {

    @Test
    public void testConstructor(){
        Louie louie = new Louie();
        assertEquals(3, louie.getHealth());
    }

    @Test
    public void testTakeDamage() {
        Louie louie = new Louie();
        louie.takeDamage(1);
        assertEquals(2, louie.getHealth());
    }
}