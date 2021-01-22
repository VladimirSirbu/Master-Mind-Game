package mastermind;

import com.mastermind.Color;
import com.mastermind.ColorManager;
import com.mastermind.Game;
import com.mastermind.Row;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private final int nrOfColorsToGuees = 4;
    private final ColorManager manager = new ColorManager();

    @Test
    public void canAddNewGuess() {
        Game game = new Game(manager, nrOfColorsToGuees);
        game.addNewGuess(new Row(generateGuess()));
    }

    private Color[] generateGuess() {
        Color[] guess = new Color[nrOfColorsToGuees];
        int i = 0;
        while(i < guess.length) {
            guess[i++] = manager.getRandomColor();
        }
        return guess;
    }
}
