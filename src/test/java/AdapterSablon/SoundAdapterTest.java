package AdapterSablon;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoundAdapterTest {

    @Test
    public void playSound() {
        SoundPlayer soundPlayer = new SoundAdapter();
        soundPlayer.playSound("fundal");

        // Adding a small delay to ensure sound has time to start
        try {
            Thread.sleep(500);  // Wait for 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(soundPlayer.isSoundPlaying());  // Check if sound is playing
    }
}