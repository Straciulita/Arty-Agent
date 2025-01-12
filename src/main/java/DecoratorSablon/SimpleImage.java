
package DecoratorSablon;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SimpleImage implements Drawable {
    private Image image;
    private int x, y, width, height;

    public SimpleImage(ImageIcon icon, int x, int y, int width, int height) {
        this.image = icon.getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, width, height, null);
    }
}