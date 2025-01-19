package com.mycompany.artyagent;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void testIncreaseScore() {
        // Creăm o instanță a clasei Score
        Score score = new Score();
        // Verificăm scorul inițial
        assertEquals(0, score.getScore());
        // Creștem scorul cu 10
        score.increaseScore(10);
        // Verificăm dacă scorul a fost actualizat corect
        assertEquals(10, score.getScore());
        // Creștem scorul cu încă 5
        score.increaseScore(5);
        // Verificăm dacă scorul a fost actualizat corect
        assertEquals(15, score.getScore());
    }
}
