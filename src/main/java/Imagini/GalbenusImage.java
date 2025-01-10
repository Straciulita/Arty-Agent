
package Imagini;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;


public class GalbenusImage implements Image {

    
    @Override
    public List<ImageIcon> createImages() {
        return Arrays.asList(
            new ImageIcon(getClass().getResource("/galbenus/galbenus1.jpg")),
            new ImageIcon(getClass().getResource("/galbenus/galbenus2.jpg")),
            new ImageIcon(getClass().getResource("/galbenus/galbenus3.jpg")),
            new ImageIcon(getClass().getResource("/galbenus/galbenus4.jpg"))
        );
    }
}