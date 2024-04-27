import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoPlayer extends Application {
    private static String videoPath;

    @Override
    public void start(Stage primaryStage) {
        // Ensure the JavaFX platform is initialized
        Platform.setImplicitExit(false);

        // Create a media player
        Media media = new Media(getClass().getResource(videoPath).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size and position of the media view
        mediaView.setFitWidth(800);
        mediaView.setFitHeight(600);
        mediaView.setPreserveRatio(true);

        // Play the video
        mediaPlayer.play();

        // Stop the video when the application is closed
        primaryStage.setOnCloseRequest(event -> mediaPlayer.stop());

        // Create the scene and put the media view on the stage
        Group root = new Group(mediaView);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Player");
        primaryStage.show();
    }

    public static void playVideo(String path) {
        videoPath = path;
        // Launch the JavaFX application
        new Thread(() -> Application.launch(VideoPlayer.class)).start();
    }
}
