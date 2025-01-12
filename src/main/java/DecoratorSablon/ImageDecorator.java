package DecoratorSablon;

import java.awt.Graphics2D;

public abstract class ImageDecorator implements Drawable {
    protected Drawable decoratedImage;

    public ImageDecorator(Drawable decoratedImage) {
        this.decoratedImage = decoratedImage;
    }

    @Override
    public void draw(Graphics2D g2) {
        decoratedImage.draw(g2);
    }
}
