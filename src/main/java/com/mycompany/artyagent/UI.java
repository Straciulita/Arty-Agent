package com.mycompany.artyagent;

import ObserverSablon.Observer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class UI extends JPanel implements Observer {
    private int score; // Scorul curent
    private final GamePanel gamePanel; // Referință către GamePanel pentru interacțiuni
    private boolean paused = false; // Starea pauzei

    // Constructor
    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel; // Initializează referința către GamePanel
        this.score = 0; // Scor inițial
        this.setBackground(Color.decode("#030126")); // Fundal potrivit pentru UI
    }

    @Override
    public void update(int score) {
        this.score = score; // Actualizează scorul
        repaint(); // Cere redesenarea componentului UI
    }

    // Setează starea de pauză și cere redesenarea
    public void setPaused(boolean paused) {
        this.paused = paused;
        repaint();
    }

    // Metodă pentru desenarea UI-ului
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Configurăm stilul textului pentru scor
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("Score: " + score, 10, 30); // Poziționează textul la coordonatele (10, 30)

        // Desenăm butonul de pauză
        drawPauseButton(g2d);

        // Dacă jocul este pe pauză, afișăm mesajul "Game is paused"
        if (gamePanel.isPaused() ) {
            g2d.setColor(new Color(0, 0, 0, 150)); // Fundal semi-transparent
            g2d.fillRect(0, 0, gamePanel.ScreenW, gamePanel.ScreenH);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("Arial", Font.BOLD, 48));
            String message = "Game is paused";
            int textWidth = g2d.getFontMetrics().stringWidth(message);
            g2d.drawString(message, (gamePanel.ScreenW - textWidth) / 2, gamePanel.ScreenH / 2);
        }
    }

    // Metodă pentru desenarea butonului de pauză
    private void drawPauseButton(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(600, 20, 80, 30); // Dimensiunea și poziția butonului

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Pause", 620, 40); // Textul butonului
    }


}
