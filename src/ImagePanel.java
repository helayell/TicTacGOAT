import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String resourcePath) {
        try {
            // Using getClass().getResource() to get the URL of the resource
            URL url = getClass().getResource(resourcePath);
            if (url != null) {
                backgroundImage = new ImageIcon(url).getImage();
            } else {
                System.err.println("Resource not found: " + resourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            // Optional: Set a default background color if the image fails to load
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
