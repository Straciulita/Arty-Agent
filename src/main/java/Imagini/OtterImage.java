
package Imagini;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class OtterImage {
     public List<ImageIcon> createImages() {
        return Arrays.asList(
            new ImageIcon(getClass().getResource("/otter/otter1.jpg")),
            new ImageIcon(getClass().getResource("/otter/otter2.jpg")),
            new ImageIcon(getClass().getResource("/otter/otter3.jpg")),
            new ImageIcon(getClass().getResource("/otter/otter4.jpg"))
        );
    }
}
