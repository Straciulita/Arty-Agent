package com.mycompany.artyagent;

import org.junit.Test;

import static org.junit.Assert.*;

public class GamePanelTest {

    @org.junit.Test
    public void togglePause() {
        GamePanel gamePanel = new GamePanel();
        gamePanel.togglePause();
        assertTrue(gamePanel.isPaused());  // Verifică dacă jocul este pe pauză
        gamePanel.togglePause();
        assertFalse(gamePanel.isPaused());  // Verifică dacă jocul nu mai este pe pauză
    }



    @Test
    public void setupGame() {
        GamePanel gamePanel = new GamePanel();
        gamePanel.update();
        assertNotNull(gamePanel.images); // Verifică dacă lista de imagini a fost inițializată
    }
}