import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MultiMedia {
    private static Clip audioClip;
    private static Clip musicClip;

    /**
     * Play a sound effect from a resource path.
     *
     * @param resourcePath The classpath resource path of the audio file.
     */
    public static void playAudio(String resourcePath) {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop(); // Stop any currently playing audio
        }
        audioClip = loadClip(resourcePath);
        if (audioClip != null) {
            audioClip.start();
        }
    }

    /**
     * Play background music from a resource path, looping indefinitely.
     *
     * @param resourcePath The classpath resource path of the music file.
     */
    public static void playBackgroundMusic(String resourcePath) {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop(); // Stop any currently playing music
        }
        musicClip = loadClip(resourcePath);
        if (musicClip != null) {
            musicClip.loop(Clip.LOOP_CONTINUOUSLY); // Set music to loop indefinitely
        }
    }

    /**
     * Stop the currently playing background music.
     */
    public static void stopBackgroundMusic() {
        if (musicClip != null) {
            musicClip.stop();
        }
    }

    /**
     * Load audio clip from a resource path.
     *
     * @param resourcePath The classpath resource path of the audio file.
     * @return Clip Loaded audio clip or null if an error occurs
     */
    private static Clip loadClip(String resourcePath) {
        try {
            URL url = MultiMedia.class.getResource(resourcePath);
            if (url == null) {
                throw new RuntimeException("Resource not found: " + resourcePath);
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error loading sound from: " + resourcePath);
            e.printStackTrace();
            return null;
        }
    }
}
