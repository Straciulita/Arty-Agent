package AdapterSablon;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundAdapter implements SoundPlayer {
    private Clip clip;

    @Override
    public void playSound(String soundName) {
        playSound(soundName, false); // Apel implicit fără buclă
    }

    @Override
    public void playSound(String soundName, boolean loop) {
        try {
            // Încarcă fișierul audio ca resursă
            URL soundURL = getClass().getResource("/Sound/" + soundName + ".wav");
            if (soundURL == null) {
                throw new IOException("Sunetul nu a fost găsit: " + soundName);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Activează buclă
            } else {
                clip.start(); // Redă o singură dată
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Eroare la redarea sunetului: " + e.getMessage());
        }
    }

    @Override
    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    @Override
    public void pauseSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // Oprește redarea fără a închide resursele
        }
    }

    @Override
    public void resumeSound() {
        if (clip != null && !clip.isRunning()) {
            clip.start(); // Reia redarea
        }
    }
}
