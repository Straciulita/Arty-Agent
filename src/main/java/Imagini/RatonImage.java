
package Imagini;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;


public class RatonImage {
    public List<ImageIcon> createImages() {
        return Arrays.asList(
            new ImageIcon(getClass().getResource("/raton/raton1.jpg")),
            new ImageIcon(getClass().getResource("/raton/raton2.jpg")),
            new ImageIcon(getClass().getResource("/raton/raton3.jpg")),
            new ImageIcon(getClass().getResource("/raton/raton4.jpg"))
        );
    }
}
