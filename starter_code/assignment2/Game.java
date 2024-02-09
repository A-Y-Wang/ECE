package assignment2;

//history.class

import java.util.Scanner;
public class Game {
//TODO: Design a Game.java class to handle top-level gameplay
//You may add whatever constructor or methods you like
//create a constructor that takes in the game limitation and usage of the imported scanner
//rungame will be maybe a 3 mested for-loop that start with taking in inpyts from the scanner
    int guesscount = 0;
    int lword = 0;
    char[] greens;
    char[] yellows;
    String wordChoice;
    String wordGoal;
    String replay = "y";
    Scanner Scanny;

    public Game(GameConfiguration GameStart, Scanner S){
        this.lword = GameStart.wordLength;
        this.guesscount = GameStart.numGuesses;
        this.greens = new char[GameStart.wordLength];
        this.yellows = new char[GameStart.wordLength];
        this.Scanny = S;

        if (this.lword == 4){this.wordChoice = "4_letter_words.txt";}
        else if (this.lword == 5) { this.wordChoice = "5_letter_words.txt";}
        else {this.wordChoice = "6_letter_words.txt";}
    }
    public void runGame(){

        Dictionary Book = new Dictionary(wordChoice);//maybe put this in the constructor??
        System.out.println("Hello! Welcome to Wordle.\n" + "Do you want to play a new game? (y/n)");
        while(true){
            String input = Scanny.nextLine();
            if (input.equals("n")){
                return;
            }
            else if(input.equals("y")){
                break;
            }
        }

        while (replay.equals("y")){
            wordGoal = Book.getRandomWord();


        }





    }








}
