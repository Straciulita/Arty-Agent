package Imagini;

import Imagini.Image;
import javax.swing.ImageIcon;
import java.util.Arrays;
import java.util.List;

public class PaharelImage implements Image {
    public List<ImageIcon> createImages() {
        return Arrays.asList(
            new ImageIcon(getClass().getResource("/paharel/paharel1.jpg")),
            new ImageIcon(getClass().getResource("/paharel/paharel2.jpg")),
            new ImageIcon(getClass().getResource("/paharel/paharel3.jpg")),
            new ImageIcon(getClass().getResource("/paharel/paharel4.jpg"))
        );
    }
}



