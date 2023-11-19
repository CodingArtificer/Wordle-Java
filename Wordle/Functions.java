package Wordle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class Functions {
    public static int randomNum(int x){
        Random rand = new Random();
        int randNum = rand.nextInt(1000) %x;
        return randNum;
    }
    
    public static ArrayList<String> readFileIntoArray(String FileName){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("trail");
        arr.add("train");
        arr.add("heart");
        return arr;
    }
}