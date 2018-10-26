package com.example.lapum.paclouie;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void testConstructor1(){
        Professor prof = new Professor();
        assertEquals(1, prof.getSpeed());
    }

    @Test
    public void testConstructor2(){
        Professor prof = new Professor();
        assertEquals(0, prof.getX());
    }

    @Test
    public void testConstructor3(){
        Professor prof = new Professor();
        assertEquals(0, prof.getY());
    }

    @Test
    public void testConstructor4(){
        Professor prof = new Professor(50, 50, 2);
        assertEquals(2, prof.getSpeed());
    }

    @Test
    public void testConstructor5(){
        Professor prof = new Professor(50, 55, 2);
        assertEquals(50, prof.getX());
    }

    @Test
    public void testConstructor6(){
        Professor prof = new Professor(50, 55, 2);
        assertEquals(55, prof.getY());
    }

    @Test
    public void testMoveX(){
        Professor prof = new Professor();
        prof.move();
        assertEquals(1, prof.getX());
    }

    @Test
    public void testMoveY(){
        Professor prof = new Professor();
        prof.move();
        assertEquals(1, prof.getY());
    }
}