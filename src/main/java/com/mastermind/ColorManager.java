package com.mastermind;

import java.util.ArrayList;
import java.util.List;
/**
 * It's a class that perform colors.
 * This class have an list where hold 7 colors of rainbow.
 */
public class ColorManager {

    /**
     * List to hold colors objects
     */
    private final List<Color> allColors = new ArrayList<>();

    /**
     * In constructor call method to initialize list of {@code allColors}
     */
    public ColorManager() {
        initBoxOfColors();
    }

    /**
     * Initialize {@code allColors} list with objects {@code Color}
     */
    private void initBoxOfColors() {
        allColors.add(new Color('R'));
        allColors.add(new Color('G'));
        allColors.add(new Color('Y'));
        allColors.add(new Color('B'));
        allColors.add(new Color('O'));
        allColors.add(new Color('I'));
        allColors.add(new Color('V'));
    }

    /**
     * Generate random color from {@code allColors} list
     * @return {@code Color} object
     */
    public Color getRandomColor() {
        int random = (int)(Math.random() * 7); // get an integer number in a range [0,7)
        return allColors.get(random);
    }

    /**
     * @return {@code List} of all colors.
     */
    public List<Color> getAllColors() {
        return allColors;
    }

}
