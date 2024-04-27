import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotsScreen extends JFrame implements ActionListener {

    private JButton randomButton;
    private JButton defensiveButton;
    private JButton offensiveButton;
    private JButton minimaxAlgorithmButton;
    private JButton mainMenuButton;
    private JButton helpButton;
    private JButton exitButton;

    public BotsScreen() {

        setTitle("CHOOSE YOUR BOT... HUMAN");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the background panel
        ImagePanel backgroundPanel = new ImagePanel("kaicenattongue.jpg");
        setLayout(new GridLayout(5, 1));
        setContentPane(backgroundPanel);
        //MultiMedia.playBackgroundMusic("videoplayback.wav");
        JLabel titleLabel = new JLabel("CHOOSE YOUR BOT... HUMAN", JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        add(titleLabel);

        randomButton = new JButton("Random Bot");
        defensiveButton = new JButton("Defensive Bot");
        offensiveButton = new JButton("Offensive Bot");
        minimaxAlgorithmButton = new JButton("THE ALGORITHM");
        mainMenuButton = new JButton("Main Menu");
        helpButton = new JButton("Help");
        exitButton = new JButton("Exit");

        randomButton.addActionListener(this);
        defensiveButton.addActionListener(this);
        offensiveButton.addActionListener(this);
        minimaxAlgorithmButton.addActionListener(this);
        mainMenuButton.addActionListener(this);
        helpButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(randomButton);
        add(defensiveButton);
        add(offensiveButton);
        add(minimaxAlgorithmButton);
        add(mainMenuButton);
        add(helpButton);
        add(exitButton);

        setVisible(true);


    }
    private void goToMainMenu() {
        // Dispose of the current screen and open the main menu
        this.dispose();
        new MenuScreen();
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Random Bot".equals(command)) {
            new TicTacToe(true);
        }else if ("Defensive Bot".equals(command)) {

        }else if ("Offensive Bot".equals(command)) {

        }else if ("Minimax Algorithm".equals(command)) {

        }else if ("Main Menu".equals(command)) {
            goToMainMenu();
        }else if ("Help".equals(command)) {
            VideoPlayer.playVideo("lebronmyking.mp4");
            MultiMedia.stopBackgroundMusic();


        }else if ("Exit".equals(command)) {
            System.exit(0);
        }

    }
}
