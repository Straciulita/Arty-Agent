package com.mycompany.artyagent;

import CommandSablon.PauseCommand;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickHandler implements MouseListener {

    private GamePanel gp;
    private boolean clickDetected; // Flag pentru a marca dacă un click a fost detectat
    public PauseCommand p ;
    // Constructor care primește referința la panoul de joc
    public ClickHandler(GamePanel gp) {
        this.gp = gp;
        this.clickDetected = false; // Inițializare
        p = new PauseCommand(gp);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(); // Coordonata X a click-ului
        int y = e.getY(); // Coordonata Y a click-ului

        System.out.println("Clicked at: " + x + ", " + y);
        clickDetected = true;
        // Verifică dacă utilizatorul a dat click pe o imagine
        if (gp.images != null) {
            int imgX = 200; // Poziția inițială X a imaginilor
            int imgY = 400; // Poziția inițială Y a imaginilor
            int imagesPerRow = 2; // Numărul de imagini pe rând

            for (int i = 0; i < gp.images.size(); i++) {
                // Calcularea coordonatelor fiecărei imagini
                int currentX = imgX + (i % imagesPerRow) * (gp.picW + 10);
                int currentY = imgY + (i / imagesPerRow) * (gp.picH + 10);

                // Verifică dacă click-ul este în zona imaginii
                if (x >= currentX && x <= currentX + gp.picW && y >= currentY && y <= currentY + gp.picH) {
                    System.out.println("Imagine selectată: " + i );
                     
                     if (i == gp.r.index) {
                        gp.score.increaseScore(1); //metoda de la observer
                         gp.sound.playSound("click");
                        if(gp.r.getRoundNumber()<=10)
                         gp.r.nextRound(); // Trecem la următoarea rundă cu observer
                        else{
                            System.out.println("Felicitari!");
                        }
                    }
                     else {
                        // o sa penalizez din timp
                        System.out.println("Imagine greșită.");
                    }
                    break;
                }
            }
        }
        if (x >= 600 && x <= 680 && y >= 20 && y <= 50) {
            //CLASA CLICK HANDLER
                    p.execute();
                if(gp.isPaused()){
                    gp.sound.pauseSound();
                }else{
                    gp.sound.resumeSound();
                }
            }

    }
    public boolean isClickDetected() {
        return clickDetected;
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
