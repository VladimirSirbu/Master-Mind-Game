package com.mastermind;

import java.util.Arrays;

public class Row {

    protected Color[] positions;
    protected int matchedPositions;
    protected int matchedColors;
    public static final Row none = new Row();

    public Row() {}

    public Row(Color[] newGuess){
        this.positions = Arrays.copyOf(newGuess, newGuess.length);
        this.matchedColors = 0;
        this.matchedPositions = 0;
    }

    public void setMatch(int matchedPositions, int matchedColors) {
        if (matchedColors + matchedPositions > positions.length)
            throw new IllegalArgumentException("Number of matches can not be more that the position.");
        this.matchedColors = matchedColors;
        this.matchedPositions = matchedPositions;
    }

    public int nrMatchingColors(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++)
            for (int j = 0; j < positions.length; j++)
                if (i != j && guess[i].equals(positions[j]))
                    count++;
        return count;
    }

    public int nrMatchingPositions(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i].equals(positions[i])) {
                count++;
            }
        }
        return count;
    }

    public void printScore() {
        System.out.println(matchedColors + " / " + matchedPositions);
    }
}
