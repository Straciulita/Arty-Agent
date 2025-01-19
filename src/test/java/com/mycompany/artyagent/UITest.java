package com.mycompany.artyagent;

import org.junit.Test;

import static org.junit.Assert.*;

public class UITest {

    @Test
    public void update() {
        GamePanel gamePanel = new GamePanel();
        UI ui = new UI(gamePanel);
        ui.update(50);  // Actualizează scorul

        assertEquals(50, ui.getScore());  // Verifică dacă scorul s-a actualizat correct
    }
}