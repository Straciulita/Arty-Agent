
package com.mycompany.artyagent;

// clasa pt a genera fiecare runda 
// runa = afisarea pozelor. daca utilizatorul da click pe cea corecata trece mai departe


import Imagini.ImageFactory;
import ObserverSablon.Observable;
import ObserverSablon.Observer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;


public class Round implements Observable {
    
    GamePanel gp;
    String tip="";
    int index=Rand();
    private int roundNumber; // Runda curentă
    
     private List<Observer> observers; // Listă de observatori
    //constructor
    public Round(GamePanel gp) {
        this.gp = gp;
        this.roundNumber = 1; // Începe de la runda 1
         
        setTip();
        index=Rand();
        System.out.println("Index: "+index);
       
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
        gp.repaint(); // Re-redesenează panoul cu imaginile noi
    }

    public void draw(Graphics2D g2){
     // Încărcarea imaginilor din fabrica
     gp.images = ImageFactory.getImages(tip); //alegem tipul imaginilor
     
     //alegem poza de sus
    
     int x;
     int y;
      ImageIcon img = gp.images.get(index);
      g2.drawImage(img.getImage(), 280, 240, gp.picW, gp.picH, null); 

        //desenez imaginile sub forma de matrice 2X2
        if (gp.images != null) {
         x = 200; // Poziția X pentru prima imagine
         y = 400; // Poziția Y pentru prima imagine
        int imagesPerRow = 2; // Numărul de imagini pe un rând

        // Desenează fiecare imagine din listă folosind Graphics2D
        for (int i = 0; i < gp.images.size(); i++) {
            ImageIcon image = gp.images.get(i);
            // Redimensionează imaginea la dimensiunile picW și picH
            g2.drawImage(image.getImage(), x, y, gp.picW, gp.picH, null); 
            
            // Modifică coordonatele pentru următoarea imagine
            if ((i + 1) % imagesPerRow == 0) {
                x = 200;  // Resetează poziția X la începutul rândului
                y += gp.picH + 10;  // Mărește poziția Y pentru următorul rând
            } else {
                x += gp.picW + 10; // Adaugă un spațiu între imagini pe același rând
            }
        }
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
