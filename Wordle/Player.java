package Wordle;

public class Player 
{
    public int tries;
    public String word;

    public Player(int t, String w)
    {
        this.tries = t;
        this.word = w;
    }
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
}
