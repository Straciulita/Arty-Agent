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
    
    //setari joc
    Round r= new Round(this);//runda
    ClickHandler ch= new ClickHandler(this);// detectarea de click uri
    UI u= new UI();//interfata
    
    //variabile joc
     Score score = new Score();
     
    // Variabile pentru imagini
    public List<ImageIcon> images;

    // Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenW, ScreenH));
        this.setBackground(Color.decode("#030126"));
        this.setDoubleBuffered(true); // pentru o rendare mai buna a jocului
        
        
        
        this.addMouseListener(ch);
        score.addObserver(u); // Adaugă UI ca observator pentru scor //metoda de la observer
       
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
    
    
    Graphics2D g2d = (Graphics2D) g;
    r.draw(g2d);
    u.draw(g2d);
}

}
