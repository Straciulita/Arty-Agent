package com.mycompany.artyagent;

import AdapterSablon.SoundAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable {

    // Setări fereastră
    public final int ScreenW = 700;
    public final int ScreenH = 800;
    public final int picW = 150;
    public final int picH = 150;
    private Thread gameThread; // Pentru implementarea noțiunii de timp și repetare
    private final int FPS = 60; // Frames per second

    // Stare pauză
    private boolean isPaused = false;

    // Setări joc
    public final Round r = new Round(this); // Runda
    public final ClickHandler ch = new ClickHandler(this); // Detectarea de click-uri
    public final UI u; // Interfața

    // Variabile joc
    public final Score score = new Score();
    public SoundAdapter sound = new SoundAdapter();



    // Variabile pentru imagini
    public List<ImageIcon> images = new ArrayList<>();

    // Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenW, ScreenH));
        this.setBackground(Color.decode("#030126"));
        this.setDoubleBuffered(true); // Pentru o randare mai bună a jocului

        this.addMouseListener(ch);
        score.addObserver(u = new UI(this)); // Adaugă UI ca observator pentru scor
        sound.playSound("fundal", true);
    }

    public void setupGame() {
        // Inițializează elementele de joc, dacă este necesar
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000 / FPS; // Timp pentru fiecare frame (~0.01666 secunde)
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // Game loop - bucla principală a jocului
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // Update doar dacă jocul nu este în pauză
                if (!isPaused) {
                    update();
                }

                // Desenează frame-ul actualizat
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // Actualizează starea jocului
    public void update() {
        if (images == null) {
            images = new ArrayList<>();
        }
        r.update();
    }

    // Desenează componentele jocului
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        r.draw(g2d);
        u.draw(g2d); // Desenează UI-ul
    }

    // Metodă pentru a comuta starea de pauză
    public void togglePause() {
        isPaused = !isPaused;
        System.out.println("Paused: " + isPaused);
    }

    // Getter pentru starea de pauză
    public boolean isPaused() {
        return isPaused;
    }




}
