package com.mastermind;

import java.util.*;

public class Game {
    private final int nrOfColors;
    private final ColorManager manager;
    private final Row secretRow;
    private List<Row> guesses;
    private boolean finish;

    public Game(ColorManager manager, int nrOfColors) {
        this.manager = manager;
        this.nrOfColors = nrOfColors;
        this.secretRow = generateSecretRow();
        this.guesses = new ArrayList<>();
        this.finish = false;
    }

    private Row generateSecretRow() {
        // Here I use a SET because the secret Row must contain different Colors every time
        Set<Color> generateColors = new HashSet<>();
        while(generateColors.size() < nrOfColors) {
            generateColors.add(manager.getRandomColor());
        }

        int i = 0;
        Color[] colors = new Color[nrOfColors];
        for (Color color : generateColors)
            colors[i++] = color;

        Row secretRow = new Row(colors);
        secretRow.setMatch(nrOfColors, 0);
        return secretRow;
    }

    public void addNewGuess(Row row) {

        final int positionMatch =
                secretRow.nrMatchingPositions(row.positions);
        final int colorMatch =
                secretRow.nrMatchingColors(row.positions);
        row.setMatch(positionMatch, colorMatch);
        row.printScore();
        guesses.add(row);

        if (positionMatch == nrOfColors){
            finish = true;
            System.out.println("Congratulation! You are win!!!");
        }

    }

    public boolean isFinish() {
        return finish;
    }

}
