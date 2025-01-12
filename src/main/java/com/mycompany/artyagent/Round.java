
package com.mycompany.artyagent;

// clasa pt a genera fiecare runda 
// runa = afisarea pozelor. daca utilizatorul da click pe cea corecata trece mai departe


import DecoratorSablon.Drawable;
import DecoratorSablon.SimpleImage;
import DecoratorSablon.SwingingDecorator;
import Imagini.ImageFactory;
import ObserverSablon.Observable;
import ObserverSablon.Observer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Round implements Observable {
    
    GamePanel gp;
    String tip="";
    int index=Rand();
    private int roundNumber; // Runda curentă
    private List<Drawable> images; // Listă de imagini decorate
    
     private List<Observer> observers; // Listă de observatori
    //constructor
    public Round(GamePanel gp) {
        this.gp = gp;
        this.roundNumber = 1; // Începe de la runda 1
        images = new ArrayList<>();
        observers = new ArrayList<>(); // Inițializarea listei de observatori
    
        setTip();
        loadImages();
        index = Rand();
        System.out.println("Index: " + index);

        
       
    }
    public int Rand(){
       Random random = new Random();
       int randomNumber = random.nextInt(4) ; 
   
       return randomNumber;
    }
    
    public void setTip() {
    // Toate tipurile posibile
    List<String> allTypes = List.of("RATON", "GALBENUS", "PAHAREL", "FANTOMITA", "CIUPERCA", "OTTER");

    // Creează o listă modificabilă
    List<String> types = new ArrayList<>(allTypes);

    // Elimină tipul curent din lista posibilă, dacă există
    if (!tip.isEmpty()) {
        types.remove(tip);
    }

    // Generează un tip aleatoriu din lista rămasă
    Random random = new Random();
    tip = types.get(random.nextInt(types.size()));
}

     // Metoda care avansează la runda următoare
    public void nextRound() {
        roundNumber++; // Crește contorul de runde
        
        setTip(); // Generează un nou tip pentru runda curentă
        index=Rand();
        System.out.println("Index: "+index);
        gp.images = ImageFactory.getImages(tip); // Actualizează imaginile
        loadImages();
        gp.repaint(); // Re-redesenează panoul cu imaginile noi
    }
    
   private void loadImages() {
       gp.images = ImageFactory.getImages(tip); //alegem tipul imaginilor
    if (gp.images == null) {
        System.err.println("Lista gp.images este null! Verifică inițializarea.");
        return;
    }

    for (int i = 0; i < gp.images.size(); i++) {
        ImageIcon icon = gp.images.get(i);
        int x = 250 + (i % 2) * (gp.picW + 50);
        int y = 550 + (i / 2) * (gp.picH + 50);

        Drawable simpleImage = new SimpleImage(icon, x, y, 170, 170);
        

        Drawable swingingImage = new SwingingDecorator(simpleImage, x + gp.picW /2, y, Math.PI / 12);

        images.add(swingingImage);
    }
}

   public void update() {
    for (Drawable image : images) {
        if (image instanceof SwingingDecorator) {
            ((SwingingDecorator) image).update(); // Actualizează poziția imaginii oscilante
        }
    }
}


    public void draw(Graphics2D g2){
  
        gp.images = ImageFactory.getImages(tip); //alegem tipul imaginilor
     if (gp.images != null && !gp.images.isEmpty()) {
        ImageIcon img = gp.images.get(index);
        g2.drawImage(img.getImage(), 280, 240, gp.picW, gp.picH, null);
    } else {
        System.err.println("Lista de imagini este goală sau null!");
    }

 
     for (Drawable image : images) {
            image.draw(g2); // Desenează fiecare imagine decorată
        }
    }
    
    public int getRoundNumber() {
        return roundNumber;
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(roundNumber);  // Notifică toți observatorii
        }
    }
}
