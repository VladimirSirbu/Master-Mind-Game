package com.mastermind;

import java.util.Objects;

/**
 * It's a class that hold information about color
 */
public class Color {

    /**
     * {@code colorLetter} describe color with it's first letter
     */
    private final Character colorLetter;

    public Color(Character ch) {
        this.colorLetter = ch;
    }

    @Override
    public String toString() {
        return colorLetter.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(colorLetter, color.colorLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorLetter);
    }
}
