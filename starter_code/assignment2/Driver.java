package assignment2;

import java.util.Scanner;
import java.util.Random;

public class Driver {

    public String wordle;

    public void start(GameConfiguration config) { //why can't it be statiiciccc
        //put the word to be compared to
        // TODO: complete this method
        // We will call this method from our JUnit test cases.
        //initialize new game here
        //initialize new scanner here and take it into the run game
        Scanner S = new Scanner(System.in);
        Game Wordle = new Game(config, S);
        Wordle.runGame();
    }

    public void start_hardmode(GameConfiguration config) {
        // TODO: complete this method for extra credit
        // We will call this method from our JUnit test cases.
    }

    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.
        //start();
        int length = 5;
        int guesses = 5;
        boolean mode = true;
        GameConfiguration WordleLimits = new GameConfiguration(length, guesses, mode);
        Driver test = new Driver();
        test.start(WordleLimits);
    }
}

