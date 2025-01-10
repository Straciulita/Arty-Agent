package com.mycompany.artyagent;

import Imagini.ImageFactory;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel implements Runnable {
    // Setari fereastra
    public final int ScreenW = 700;
    public final int ScreenH = 800;
    public final int picW = 150;
    public final int picH = 150;
    Thread gameThread; // pentru implementarea notiunii de timp si repetare
    int FPS = 60; // frames per second

    // Variabile pentru imagini
    private List<ImageIcon> images;

    // Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenW, ScreenH));
        this.setBackground(Color.decode("#030126"));
        this.setDoubleBuffered(true); // pentru o rendare mai buna a jocului

        // Încărcarea imaginilor din fabrica
        this.images = ImageFactory.getImages("PAHAREL"); // Poți înlocui cu alt tip de imagine
    }

    public void setupGame() {

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000 / FPS; // o să desenez ecranul pentru 0.0166666
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // Game loop - punctul principal al jocului
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // Update - actualizam informatiile
                update();

                // Deseneaza- frame-ul actualizat
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // Folosim Graphics2D pentru a desena
    Graphics2D g2d = (Graphics2D) g;
    if (images != null) {
        int x = 50; // Poziția X pentru prima imagine
        int y = 50; // Poziția Y pentru prima imagine
        int imagesPerRow = 2; // Numărul de imagini pe un rând

        // Desenează fiecare imagine din listă folosind Graphics2D
        for (int i = 0; i < images.size(); i++) {
            ImageIcon image = images.get(i);
            // Redimensionează imaginea la dimensiunile picW și picH
            g2d.drawImage(image.getImage(), x, y, picW, picH, this); 
            
            // Modifică coordonatele pentru următoarea imagine
            if ((i + 1) % imagesPerRow == 0) {
                x = 50;  // Resetează poziția X la începutul rândului
                y += picH + 10;  // Mărește poziția Y pentru următorul rând
            } else {
                x += picW + 10; // Adaugă un spațiu între imagini pe același rând
            }
        }
    }
}

}
