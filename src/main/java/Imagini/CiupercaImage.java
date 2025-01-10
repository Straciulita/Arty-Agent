
package Imagini;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;


public class CiupercaImage implements Image {
    @Override
    public List<ImageIcon> createImages() {
        return Arrays.asList(
           new ImageIcon(getClass().getResource("/ciuperca/ciuperca1.jpg")),
           new ImageIcon(getClass().getResource("/ciuperca/ciuperca2.jpg")),
           new ImageIcon(getClass().getResource("/ciuperca/ciuperca3.jpg")),
           new ImageIcon(getClass().getResource("/ciuperca/ciuperca4.jpg"))
        );
    }
}

