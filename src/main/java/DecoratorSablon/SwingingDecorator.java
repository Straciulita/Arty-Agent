package DecoratorSablon;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SwingingDecorator extends ImageDecorator {
    private double angle; // Unghiul curent de rotație
    private double angularSpeed; // Viteza de schimbare a unghiului
    private double maxAngle; // Unghi maxim (în radiani)
    private int pivotX, pivotY; // Punctul de rotație

    public SwingingDecorator(Drawable decoratedImage, int pivotX, int pivotY, double maxAngle) {
        super(decoratedImage);
        this.angle = 0;
        this.angularSpeed = 0.05; // Schimbare mică în unghi
        this.maxAngle = maxAngle;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    // Metoda care actualizează animația
    public void update() {
        // Calculăm unghiul balansului
        angle = maxAngle * Math.sin(System.currentTimeMillis() * angularSpeed / 100.0);
    }

    @Override
    public void draw(Graphics2D g2) {
        // Salvăm transformările curente
        AffineTransform originalTransform = g2.getTransform();

        // Aplicăm rotația
        AffineTransform transform = new AffineTransform();
        transform.rotate(angle, pivotX, pivotY);
        g2.setTransform(transform);

        // Desenăm imaginea decorată
        super.draw(g2);

        // Restaurăm transformările originale
        g2.setTransform(originalTransform);
    }
}
