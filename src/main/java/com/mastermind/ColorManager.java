package com.mastermind;

import java.util.ArrayList;
import java.util.List;

public class ColorManager {
    /**
     * com.mastermind.ColorManager have in it's box 7 base color of rainbow
     */
    private final List<Color> allColors = new ArrayList<>();

    public ColorManager() {
        initBoxOfColors();
    }

    private void initBoxOfColors() {
        allColors.add(new Color('R'));
        allColors.add(new Color('G'));
        allColors.add(new Color('Y'));
        allColors.add(new Color('B'));
        allColors.add(new Color('O'));
        allColors.add(new Color('I'));
        allColors.add(new Color('V'));
    }

    public Color getRandomColor() {
        int random = (int)(Math.random() * 7);
        return allColors.get(random);
    }

    public List<Color> getAllColors() {
        return allColors;
    }

}
