package AdapterSablon;

public interface SoundPlayer {
    void playSound(String soundName);       // Redare sunet normal
    void playSound(String soundName, boolean loop); // Redare sunet cu opțiunea de buclă
    void stopSound();                      // Oprire sunet
    void pauseSound();                     // Pauză sunet
    void resumeSound();                    // Reluare sunet
}
