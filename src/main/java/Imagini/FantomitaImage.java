
package Imagini;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;


public class FantomitaImage implements Image {
    @Override
    public List<ImageIcon> createImages() {
        return Arrays.asList(
            new ImageIcon(getClass().getResource("/fantomita/fantomita1.jpg")),
            new ImageIcon(getClass().getResource("/fantomita/fantomita2.jpg")),
            new ImageIcon(getClass().getResource("/fantomita/fantomita3.jpg")),
            new ImageIcon(getClass().getResource("/fantomita/fantomita4.jpg"))
        );
    }
}
