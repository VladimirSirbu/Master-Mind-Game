package com.mastermind;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static int nrColors = 0;

    public static void main(String[] args) {

        System.out.print("Enter the number of colors to guess (0<n<=7): ");
        nrColors = readNrOfColors();
        Game game = new Game(new ColorManager(), nrColors);
        System.out.println("The secret row of " + nrColors + " colors was generated! Now try to guess them: ");
        System.out.println();

        while(!game.isFinish()) {
            Color[] guess = readGuess();
            game.addNewGuess(new Row(guess));
        }
    }

    private static boolean checkValidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')){
                System.err.println("The input must have " + nrColors + " upper case letter!");
                return false;
            }
        }

        if (input.length() != nrColors){
            System.err.println("Hey! Check your length of input! You can enter just " + nrColors + " colors");
            return false;
        }

        return true;
    }
    
    private static Color[] readGuess() {
        String input;
        do {
            input = in.nextLine();
        } while (!checkValidInput(input));


        Color[] guess = new Color[nrColors];
        for (int i = 0; i < input.length(); i++) {
            guess[i] = new Color(input.charAt(i));
        }
        return guess;
    }

    private static int readNrOfColors() {
        int input = 0;
        boolean done = false;
        do {
            try {
                input = Integer.parseInt(in.nextLine());
                if (input < 1 || input > 7)
                    throw new IllegalArgumentException();
                done = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. You can enter just a number. Try again: ");
            } catch (IllegalArgumentException e) {
                System.err.println("The number of colors can't be less to 1 or greater than 7!");
            }
        } while(!done);

        return input;
    }
}
