package com.mycompany.artyagent;

import ObserverSablon.Observer;
import java.util.ArrayList;
import java.util.List;

public class Score {
    private int score;
    private List<Observer> observers; // Listă de observatori

    public Score() {
        this.score = 0;
        this.observers = new ArrayList<>();
    }

    // Adăugăm un observator
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Eliminăm un observator
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notificăm toți observatorii despre schimbarea scorului
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(score);
        }
    }

    // Creștem scorul și notificăm observatorii
    public void increaseScore(int value) {
        this.score += value;
        notifyObservers(); // Notificăm observatorii despre schimbarea scorului
    }

    // Obținem scorul curent
    public int getScore() {
        return score;
    }
}
