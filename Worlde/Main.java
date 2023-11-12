package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static int randomNum(int sizeOfArray){
        Random rand = new Random();
        int randNum = rand.nextInt(1000) % sizeOfArray;
        return randNum;
    }
    
    public static ArrayList<String> readFileIntoArray(ArrayList words, String FileName){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            String line;
            while((line = reader.readLine()) != null){
                words.add(line);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("File not found");
        }
        return words;
    }

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
            // System.out.println("Each guess must be a valid word.");
            // System.out.println("The color of the letter will change to show how close your guess was to the word.");
            // System.out.println("Examples:");
            // System.out.println(colors.GREEN_TEXT+"W"+colors.RESET+"hile");
            return 3;
        }
        else{
            System.out.println("Deafult mode.");
            System.out.println("Worlde - Guess the word in 6 tries\n");
            return 6;
        }
    }



    public static void main(String[] args) throws Exception{
        try (Scanner input = new Scanner(System.in)) {
            int i;

            String userGuess;
            String playAgain = "y";
            ArrayList<String> words = new ArrayList<>();

            // words = Wordle.Functions.readFileIntoArray("words.txt");
            words = readFileIntoArray(words, "words.txt");
            // for(i = 0; i < words.size(); i++){
            //     System.out.println(words.get(i));
            // }
            while(playAgain.equalsIgnoreCase("y")){

                String wordToGuess = words.get(randomNum(words.size()));
                // System.out.println(wordToGuess);

                System.out.println("What mode would you like to play? (easy/normal/hard)");
                String mode = input.nextLine();
                System.out.println();
                int tries = displayRules(mode);

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

