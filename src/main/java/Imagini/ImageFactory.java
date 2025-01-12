package Imagini;

import java.util.List;
import javax.swing.ImageIcon;

public class ImageFactory {
    // Factory method pentru obținerea imaginilor pe baza tipului
    public static List<ImageIcon> getImages(String imageType) {
        if (imageType == null) {
            throw new IllegalArgumentException("Image type cannot be null.");
        }

        switch (imageType.toUpperCase()) {
            case "PAHAREL":
                return new PaharelImage().createImages();
            case "GALBENUS":
                return new GalbenusImage().createImages();
            case "CIUPERCA":
                return new CiupercaImage().createImages();
            case "FANTOMITA":
                return new FantomitaImage().createImages();
            case "RATON":
                return new RatonImage().createImages();
            case "OTTER":
                return new OtterImage().createImages();
            default:
                throw new IllegalArgumentException("Invalid image type: " + imageType);
        }
    }
}
