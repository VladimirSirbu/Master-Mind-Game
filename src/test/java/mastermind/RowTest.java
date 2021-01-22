package mastermind;

import com.mastermind.Color;
import com.mastermind.ColorManager;
import com.mastermind.Row;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class RowTest {

    private final int nrOfColorsToGuees = 4;
    private final ColorManager manager = new ColorManager();
    private final Color[] colors = new Color[nrOfColorsToGuees];
    private static Row row = Row.none;

    @Before
    public void initGuessColorsAndRow() {
        for (int i = 0; i < colors.length; i++) {
            colors[i] = manager.getAllColors().get(i);
        }
        row = new Row(colors);
    }

    @Test
    public void allColorsAndPositionsMatch() {
        int matchingColor = row.nrMatchingColors(colors);
        int matchingPositions = row.nrMatchingPositions(colors);

        Assert.assertEquals(nrOfColorsToGuees, matchingPositions);
        Assert.assertEquals(0,matchingColor);
    }

    @Test
    public void justTwoColorAndTwoPositionMatch() {
        Color[] wrongGuess = swapElements(colors);

        int matchingColor = row.nrMatchingColors(wrongGuess);
        int matchingPositions = row.nrMatchingPositions(wrongGuess);

        Assert.assertEquals(nrOfColorsToGuees - 2, matchingPositions);
        Assert.assertEquals(nrOfColorsToGuees - 2,matchingColor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAForInvalidMatchParameters() {
        Row row = new Row(new Color[nrOfColorsToGuees]);
        row.setMatch(nrOfColorsToGuees, 1);
    }

    private Color[] swapElements(Color colors[]) {
        // In this method we are swaping last two element from the secret row "colors"
        Color[] wrongGuess = Arrays.copyOf(colors, colors.length);

        Color temp = wrongGuess[nrOfColorsToGuees - 2];
        wrongGuess[nrOfColorsToGuees - 2] = wrongGuess[nrOfColorsToGuees - 1];
        wrongGuess[nrOfColorsToGuees - 1] = temp;

        return wrongGuess;
    }
}
