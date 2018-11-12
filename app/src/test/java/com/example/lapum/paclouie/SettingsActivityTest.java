package com.example.lapum.paclouie;

import org.junit.Test;

import static org.junit.Assert.*;

public class SettingsActivityTest {
    @Test
    public void testCurrentNumLives(){
        SettingsActivity.setCurrentNumLives(2);
        assertEquals(2, SettingsActivity.getCurrentNumLives());
        SettingsActivity.setCurrentNumLives(SettingsActivity.getCurrentNumLives() + 3);
        assertEquals(5, SettingsActivity.getCurrentNumLives());
    }
    @Test
    public void testCurrentNumProfs(){
        SettingsActivity.setCurrentNumProfs(3);
        assertEquals(3, SettingsActivity.getCurrentNumProfs());
    }
    @Test
    public void testCurrentNumRange(){
        SettingsActivity.setCurrentNumRange(2);
        assertEquals(2, SettingsActivity.getCurrentNumRange());
    }
    @Test
    public void testCurrentNumSpeed(){
        SettingsActivity.setCurrentNumSpeed(1);
        assertEquals(1, SettingsActivity.getCurrentNumSpeed());
    }
}
