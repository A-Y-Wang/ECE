package assignment2;

public class GameConfiguration {

  /**
   * The length of the word used for the secret word and guesses.
   */
  public final int wordLength;

  /**
   * The number of guesses available to the user.
   */
  public final int numGuesses;

  /**
   * Indicates whether the program is being used in testing mode.
   */
  public final boolean testMode;
  //we want to be in test most for now
  //test mode will allow you to print debug and test your code for errors instead of commenting lines out

  public GameConfiguration(int wordLength, int numGuesses, boolean testMode) {
    this.wordLength = wordLength;
    this.numGuesses = numGuesses;
    this.testMode = testMode;
  }


}

