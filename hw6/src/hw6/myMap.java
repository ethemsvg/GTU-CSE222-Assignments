package hw6;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * A class for creating and storing a custom map that holds
 * String, info pairs.
 *
 */
public class myMap {
    /**
     * Preprocesses the input string by removing all non-alphabetic characters and converting
     * the string to lowercase. Returns the preprocessed string.
     *
     * @param input the input string to preprocess
     * @return the preprocessed string
     * @throws IllegalArgumentException if the input string is null
     */
    protected String preProcessString(String input) throws IllegalArgumentException {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        input = input.replaceAll("[^a-zA-Z ]", "");
        input = input.toLowerCase();

        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Preprocessed string contains no characters.");
        }
        return input;

    }
    /**
     * Constructs an empty myMap object.
     */
    protected myMap(){

    }
    /**
     * Constructs a myMap object and fills it with letter-info pairs..
     *
     * @param sentence the sentence to be processed for producing letter-info pairs for the map.
     * @throws IllegalArgumentException if the input sentence is null
     */
    protected myMap(String sentence) throws IllegalArgumentException {
        if (sentence == null) {
            throw new IllegalArgumentException("Input sentence cannot be null.");
        }

        str = this.preProcessString(sentence);
        // the string is divided into words and stored as an array.
        str_as_words = str.split(" ");

        // Traversing the array that holds the words forming the input string.
        for(String word: str_as_words){

            char[] word_as_chars = word.toCharArray();
            // Traversing each letter of each word.
            for(Character c: word_as_chars){
                // If the current letter is present in the map, the word is pushed in the array of the info object.
                if( map.containsKey(Character.toString(c)) ){

                    map.get(Character.toString(c)).push(word);

                    // If the current letter is not present in the map, the letter,word pair are used to create a new
                    // info object and the info object is then pushed into the myMap object.
                }else{

                    info newEntry = new info();
                    newEntry.push(word);
                    map.put(String.valueOf(Character.toString(c)), newEntry);

                }

            }

        }

    }
    LinkedHashMap<String, info> map = new LinkedHashMap<>();
    String str;
    String[] str_as_words;

    /**
     * Prints the contents of the myMap.
     */
    protected void printMap(){

        for(Map.Entry<String,info> entry: map.entrySet()){

            System.out.println( "Letter: " + entry.getKey() + " - " + entry.getValue().toString());

        }

    }



}
