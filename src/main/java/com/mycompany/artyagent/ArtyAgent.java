
//metoda main pt a declara fereastra


package com.mycompany.artyagent;

import javax.swing.JFrame;


public class ArtyAgent {
    
    public static void main(String[] args) {
        JFrame fereastra = new JFrame();//fereastra de joc
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// sa se incchida cand apas X
        fereastra.setResizable(false);// sa nu o pot redimensiona
        fereastra.setTitle("Arty Agent");//titlul
        
        GamePanel gamePanel = new GamePanel();
        fereastra.add(gamePanel);
        
        fereastra.pack();
 
        fereastra.setLocationRelativeTo(null);
        fereastra.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
        
    }
}
