package hw6;

import java.util.ArrayList;

public class info {

    // The number of words in the set ( which also corresponds to number of occurences of the letter .)
    protected int count = 0;

    // An ArrayList of the words in the set
    protected ArrayList<String> words = new ArrayList<String>();

    /**
     * Adds a new word to the set and increments the count.
     *
     * @param newWord The new word to add to the set
     * @throws IllegalArgumentException If the input word is null
     */
    protected void push(String newWord) throws IllegalArgumentException{

        if (newWord == null) {
            throw new IllegalArgumentException("Input word cannot be null");
        }

        words.add(newWord);
        count++;

    }
    /**
     * Returns a string representation of an info object.
     *
     * @return A string representation of the array of words with the letter's count value
     */

    @Override
    public String toString(){
        return "Count: " + count + " - " +" Words: " + words.toString() + " ";
    }
}
