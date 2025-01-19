package com.mycompany.artyagent;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    @Test
    public void update() {
        Round round = new Round(new GamePanel());
        round.update();
        assertTrue(round.isUpdated());  // Verifică dacă runda s-a actualizat
    }
}