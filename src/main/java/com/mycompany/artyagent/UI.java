package com.mycompany.artyagent;

import ObserverSablon.Observer; // Asigură-te că folosești Observer corect
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class UI extends JPanel implements Observer {
    private int score;

    public UI() {
        this.score = 0; // Scor inițial
        this.setBackground(Color.decode("#030126")); // Fundal potrivit pentru UI
    }

    @Override
    public void update(int score) {
        this.score = score; // Actualizează scorul
        repaint(); // Cere redesenarea componentului UI
    }

    protected void draw(Graphics g) {
        super.paintComponent(g); // Apelăm metoda originală pentru a curăța ecranul

        Graphics2D g2d = (Graphics2D) g;

        // Configurăm stilul textului
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));

        // Desenăm textul
        g2d.drawString("Score: " + score, 10, 30); // Poziționează textul la coordonatele (10, 30)
    }
}
