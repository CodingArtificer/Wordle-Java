package Wordle;

import java.util.ArrayList;

public class Player 
{
    // Number of tries left.
    public int tries;
    // The current word.
    public String word;
    // The win streak of this player.
    public int winStreak;
    // The words already used.
    public ArrayList<String> wordsUsed = new ArrayList<String>();

    // Player constructor.
    public Player(int t, String w, int s)
    {
        this.tries = t;
        this.word = w;
        this.winStreak = s;
    }

// Tries functions.

    // Gets the number of tries from the Player object.
    public int getTries()
    {
        return tries;
    }
    // Sets the amount of tries for the Player object.
    public void setTries(int num)
    {
        tries = num;
    }

// Word functions.

    // Gets the word for the Player object.
    public String getWord()
    {
        return word;
    }
    // Sets the word for the Player object.
    public void setWord(String w)
    {
        word = w;
    }

// Win Streak functions.

    // Gets the win streak of the Player.
    public int getWinStreak()
    {
        return winStreak;
    }
    // Increases the win streak of the Player by one.
    public void increaseWinStreak()
    {
        winStreak++;
    }
    // Sets win streak for Player to i.
    public void setWinStreak(int i)
    {
        winStreak = i;
    }

// Words Used functions.

    // Adds a word to the list of used words.
    public void addUsedWord(String w)
    {
        wordsUsed.add(w);
    }
    // Gets the list of words used by the Player.
    public void showUsedWords()
    {
        System.out.println("Words Used: ");
        for(int i = 0; i < wordsUsed.size(); i++)
        {
            System.out.println(wordsUsed.get(i));
        }
    }
    // Goes through the entire list of words used and see if the word given has been used already.
    public boolean hasUsedWord(String s)
    {
        boolean v = false;
        for(int i = 0; i < wordsUsed.size(); i++)
        {
            if(s == wordsUsed.get(i))
            {
                v = true;
            }
        }

        return v;
    }


}
