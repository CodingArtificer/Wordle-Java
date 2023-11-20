package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
// import Wordle.Functions;

public class Main{
    public class colors{
        public static String RED_TEXT = "\u001B[31m";
        public static String YELLOW_TEXT = "\u001B[33m";
        public static String RESET = "\u001B[0m";
        public static String GREEN_TEXT = "\u001B[32m";

        public static String BG_GREEN = "\u001b[42m";
        public static String BG_YELLOW = "\u001b[43m";
    }

    // Chooses a random number between the bounds of the number given.
    public static int randomNum(int sizeOfArray){
        Random rand = new Random();
        int randNum = rand.nextInt(1000) % sizeOfArray;
        return randNum;
    }

    // Reads the entirety of a .txt file into an ArrayList and returns it.
    public static ArrayList<String> readFileIntoArray(String FileName){
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FileName))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.toLowerCase());
            }
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        return words;
    }

    // Displays the rules of each particular difficulty.
    public static int displayRules(String mode){
        if(mode.equals("easy")){
            System.out.println("Worlde - Guess the word in 8 tries\n");
            return 8;
        }
        else if(mode.equals("normal")){
            System.out.println("Worlde - Guess the word in 6 tries\n");
            return 6;
        }
        else if(mode.equals("hard")){
            System.out.println("Worlde - Guess the word in 3 tries\n");
            return 3;
        }
        else{
            System.out.println("Default mode.");
            System.out.println("Worlde - Guess the word in 6 tries\n");
            return 6;
        }
    }



    public static void main(String[] args) throws Exception{
        try (Scanner input = new Scanner(System.in)) {
            int i;

            String userGuess;
            String playAgain = "y";
            ArrayList<String> words = readFileIntoArray("Data/words.txt");

            while(playAgain.equalsIgnoreCase("y")){
                String wordToGuess = words.get(randomNum(words.size()));
//                 System.out.println(wordToGuess);

                // Asks the user what difficulty they want to play and prints the rules for it.
                // If inputted difficulty doesn't match the one given, defaults to normal.
                System.out.println("What mode would you like to play? (easy/normal/hard)");
                String mode = input.nextLine();
                System.out.println();
                int tries = displayRules(mode);
                // Gives the user a number of tries to guess the word correctly.
                for(i = 0; i < tries; i++){
                    System.out.print("Enter word: ");
                    userGuess = input.nextLine();

                    while(userGuess.length() != wordToGuess.length()){
                        System.out.print("Guess a 5 letter word: ");
                        userGuess = input.nextLine();
                    }

                    if(userGuess.equalsIgnoreCase(wordToGuess)){
                        System.out.println(colors.BG_GREEN + userGuess + colors.RESET);
                        System.out.println();
                        System.out.println("Congratulations you got it correct! Would you like to play again? (y/n)");
                        playAgain = input.nextLine();
                        System.out.println();
                        break;
                    }
                    else{
                        int j = 0;
                        char[] letters = userGuess.toCharArray();
                        for(char c : letters){
                            if(c == wordToGuess.charAt(j)){
                                System.out.print(colors.BG_GREEN + c + colors.RESET);
                            }
                            else if(wordToGuess.contains(Character.toString(c))){
                                System.out.print(colors.BG_YELLOW + c + colors.RESET);
                            }
                            else{
                                System.out.print(c+colors.RESET);
                            }
                            j++;
                        }
                        System.out.println("\n");
                    }
                }
                
                if(i == tries){
                    System.out.println("You ran out of tries. The word was: " + wordToGuess);
                    System.out.println("Would you like to play again? (y/n)");
                    playAgain = input.nextLine();
                    System.out.println();
                }
            }
        }
    }
}

