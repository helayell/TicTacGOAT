import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeBotRandom {
    private Random random;

    public TicTacToeBotRandom() {
        random = new Random();
    }

    // Decide the move for the bot
    public int decideMove(JButton[] buttons) {
        List<Integer> emptyPositions = new ArrayList<>();
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals("")) {
                emptyPositions.add(i);
            }
        }
        if (!emptyPositions.isEmpty()) {
            return emptyPositions.get(random.nextInt(emptyPositions.size()));
        }
        return -1; // Return -1 if no moves are possible
    }
}
