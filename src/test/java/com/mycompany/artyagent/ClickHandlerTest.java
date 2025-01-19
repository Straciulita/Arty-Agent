package com.mycompany.artyagent;

import org.junit.Test;

import javax.swing.ImageIcon; // Importă ImageIcon
import java.util.ArrayList; // Importă ArrayList
import java.awt.event.MouseEvent;

import static org.junit.Assert.assertTrue;

public class ClickHandlerTest {

    @Test
    public void mouseClicked() {
        // Simulează un GamePanel cu imagini
        GamePanel gamePanel = new GamePanel();
        gamePanel.picW = 50; // Lățimea imaginii
        gamePanel.picH = 50; // Înălțimea imaginii
        gamePanel.images = new ArrayList<>(); // Inițializează lista de imagini
       // gamePanel.images.add(new ImageIcon("dummyPath1.png")); // Adaugă un ImageIcon fictiv



        // Creează un ClickHandler
        ClickHandler clickHandler = new ClickHandler(gamePanel);

        // Creează un eveniment MouseEvent
        MouseEvent mouseEvent = new MouseEvent(
                gamePanel, // Componenta sursă
                MouseEvent.MOUSE_CLICKED, // Tipul evenimentului
                System.currentTimeMillis(), // Timestamp-ul evenimentului
                0, // Modificatori (Shift, Ctrl etc.)
                210, 410, // Coordonatele X și Y ale click-ului
                1, // Numărul de click-uri
                false
        );

        // Apelează metoda mouseClicked
        clickHandler.mouseClicked(mouseEvent);

        // Verifică dacă click-ul a fost procesat
        assertTrue("Click-ul ar fi trebuit să fie detectat!", clickHandler.isClickDetected());
    }
}
