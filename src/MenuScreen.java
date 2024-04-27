import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame implements ActionListener {

    private JButton playPvPButton;
    private JButton playBotsButton;
    private JButton settingsButton;
    private JButton exitButton;

    public MenuScreen() {

        setTitle("TICTACGOAT");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the background panel
        ImagePanel backgroundPanel = new ImagePanel("kaicenattongue.jpg");
        setLayout(new GridLayout(5, 1));
        setContentPane(backgroundPanel);
        MultiMedia.playBackgroundMusic("videoplayback.wav");
        JLabel titleLabel = new JLabel("TICTACGOAT", JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        add(titleLabel);

        playPvPButton = new JButton("Play PvP");
        playPvPButton.setForeground(new Color(102, 0, 153));
        playPvPButton.setBackground(Color.YELLOW);
        playPvPButton.setBorder(BorderFactory.createRaisedBevelBorder());
        playPvPButton.setFocusPainted(false);
        playBotsButton = new JButton("Play Bots");
        settingsButton = new JButton("Settings");
        exitButton = new JButton("Exit");


        // Set action commands to differentiate the buttons
        playPvPButton.setActionCommand("Play PvP");
        playBotsButton.setActionCommand("Play Bots");
        settingsButton.setActionCommand("Settings");
        exitButton.setActionCommand("Exit");

        // Register this class as an action listener for the buttons
        playPvPButton.addActionListener(this);
        playBotsButton.addActionListener(this);
        settingsButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add buttons to the JFrame
        add(playPvPButton);
        add(playBotsButton);
        add(settingsButton);
        add(exitButton);

        setVisible(true); // Make the frame visible

        playPvPButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playPvPButton.setBackground(new Color(0, 101, 204)); // Darker shade on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                playPvPButton.setBackground(new Color(0, 123, 255)); // Original color
            }
        });
    }



    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Play PvP".equals(command)) {
            // Open PvP mode
            new TicTacToe(false);
        } else if ("Play Bots".equals(command)) {
            // Open game against bots
            this.dispose();
            new BotsScreen();
            // You would need to implement this method
        } else if ("Settings".equals(command)) {
            // Open settings menu
            System.out.println("Settings button clicked"); // Implement settings logic
        } else if ("Exit".equals(command)) {
            System.exit(0); // Exit the application
        }


    }

    public static void main(String[] args) {
        new MenuScreen();
    }
}
