package homework4;

import java.util.Stack;
public class SecurityControlMethods {
    /**
     * The login method takes the inputs username, password1 (string password) and password2(integer password) from
     * the user, and checks their validity to decide whether to open the door or not by calling all the necessary
     * control methods.
     *
     * It is designed to keep the control order from the lowest complexity to the highest complexity in order to
     * make the program more efficient.
     *
     * @param username
     * @param password1
     * @param password2
     * @return
     */
    protected boolean login(String username, String password1, int password2){

        int[] denominations = {4,17,29};

        if( checkIfValidUsername(username)  ){

            if( isBalancedPassword(password1)  ){

                if( containsUserNameSpirit(username,password1)  ){

                    if( isPalindromePossible(password1)  ){

                        if( isExactDivision(password2,denominations) ){
                            System.out.println("The username and the passwords are valid. The door is opening, please wait...");
                            return true;
                        }



                    }

                }

            }

        }

        return false;

    }

    /**
     * A checks if it contains only letters, and the minimum length is 1.
     * @param username
     * @return
     */
    protected boolean checkIfValidUsername(String username){

        if (username.length() == 0) {
            // If the username length is 0, it is invalid.
            System.out.println("The username is invalid due to being shorter than 1 character.");
            return false;
        }

        if ( Character.isLetter(username.charAt(0)) == false ){
            System.out.println("The username is invalid due to including other characters other than letters.");
            return false;
        }
        // If the username passed the if statement above, and consists of only 1 characters. It means it is valid.
        if ( username.length() == 1 ){
            return true;
        }

        return checkIfValidUsername(username.substring(1)); // The method is called again with the first letter shifted.

    }

    /**
     * A function which checks if the string password contains at least one letter of the username.
     * @param username
     * @param password
     * @return
     */
    protected boolean containsUserNameSpirit(String username, String password){

        // Used a object wrapper for char (Character).
        Stack<Character> myStack = new Stack<>();
        boolean containsUname = false;

        for(int i=0;i<password.length();i++){
            myStack.push(password.charAt(i));
        }

        for(int i=0;i<username.length();i++){

            if( myStack.contains(username.charAt(i)) ){
                containsUname = true;
                return containsUname;
            }

        }

        System.out.println("The password1 is invalid due to not containing a letter(s) from the username.");
        return containsUname;

    }

    /**
     * In the given string sequence, the function considers two brackets to be matching if the first bracket is an open
     * bracket, (ex: (, {, or [), and the next bracket is a closed bracket of the same type. String cannot
     * start with a closed bracket. There can be letters between any two brackets.
     * @param password1
     * @return
     */
    protected boolean isBalancedPassword( String password1 ){

        if(password1.length() < 8){
            System.out.println("The password1 is invalid due to being shorter than 8 characters.");
            return false;
        }

        Stack<Character> myStack = new Stack<>();

        String opens = "{[(";
        String closes = "}])";

        int bracketCounter = 0;

        for(int i=0;i<password1.length();i++){
            if(opens.indexOf(password1.charAt(i)) != -1 || closes.indexOf(password1.charAt(i)) != -1 ){
                bracketCounter++;
            }
        }

        if(bracketCounter < 2 ){
            System.out.println("The password1 is invalid due to having less than 2 brackets.");
            return false;
        }

        for(int i=0;i<password1.length();i++){
            if( opens.indexOf( password1.charAt(i) ) >= 0 ){
                myStack.push(password1.charAt(i));
                //System.out.println("open found index: " + i);
            }else if( closes.indexOf(password1.charAt(i)) >= 0 ){
                //System.out.println("close found index: " + i);
                if(myStack.empty() == false &&  opens.indexOf(myStack.peek()) == closes.indexOf(password1.charAt(i))){
                    myStack.pop();
                }else{
                    System.out.println("The password1 is invalid due to the password being unbalanced.");
                    return false;
                }
            }
        }

        if(myStack.size() == 0){
            //System.out.println("Statement balanced!");
            return true;
        }else{
            System.out.println("The password1 is invalid due to the password being unbalanced.");
            return false;

        }

    }

    /**
     * In the given string sequence, the function considers if it is possible to obtain a palindrome by rearranging the
     * letters in the string.
     * @param password1
     * @return
     */
    private boolean isPalindromePossibleRec(String password1) {
        // Base case, if the string consists of only one letter, it's a palindrome
        if (password1.length() == 1 || password1.length() == 0) {
            return true;
        }

        // Recursive cas, looks for a character that has a matching pair
        for (int i = 0; i < password1.length(); i++) {
            char c = password1.charAt(i);
            int pairIndex = password1.indexOf(c, i + 1);

            if (pairIndex != -1) {
                // If a pair character is found, remove the 2 occurences of the pair characters from the string and call the method again with the modified string.
                String newString = password1.replaceFirst(String.valueOf(c),"");
                newString = newString.replaceFirst(String.valueOf(c),"");
                return isPalindromePossibleRec(newString);
            }
        }

        // If no matching pair is found, the string can only be a palindrome if it has a single character
        //return password1.length() == 1;
        return false;
    }

    /**
     * A Wrapper method for the recursive isPalindromePossibleRec method.
     * @return
     */
    protected boolean isPalindromePossible(String password1){

            String passwordWithoutBrackets = removeBrackets(password1);

            if(isPalindromePossibleRec(passwordWithoutBrackets) == false){
                System.out.println("The password1 is invalid due to not being able to become a Palindrome.");
                return false;
            }

            return true;


    }

    /**
     * Removes the brackets from the given string.
     * @param password1
     * @return
     */
    private String removeBrackets(String password1){

        password1 = password1.replace("(","");
        password1 = password1.replace(")","");
        password1 = password1.replace("[","");
        password1 = password1.replace("]","");
        password1 = password1.replace("{","");
        password1 = password1.replace("}","");

        return password1;

    }

    /**
     * A wrapper for isExactDivision Recursive method.
     * @param password2
     * @param denominations
     * @return
     */

    protected boolean isExactDivision(int password2, int[] denominations){

        if(password2Checker(password2) == false){
            return false;
        }

        if(isExactDivisionRec(password2,denominations,0) == false){
            System.out.println("The password2 is invalid due to not being compatible with the denominations");
            return false;
        }
        return true;
    }

    /**
     * Considering the given list of the denominations, this method determines if it is possible to obtain
     * the password by the summation of denominations along with arbitrary coefficients, which are
     * non-negative integers.
     *
     * @param remaining the number to be checked.
     * @param denominations the divisors.
     * @param index an index variable for determining which divisor to be checked at that moment.
     * @return
     */
    private boolean isExactDivisionRec(int remaining, int[] denominations, int index) {
        if (remaining == 0) {
            // If the remaining number is zero, it means that we have found valid coefficents to give the goal password.
            return true;
        }
        if (index == denominations.length) {
            // If we have used all denominations, and the remainder is still not zero, there is no valid coeficient combination
            return false;
        }
        for (int i = 0; i <= remaining / denominations[index]; i++) {
            // For each possible coefficient for the current denomination, recursively check if the remainder can be further subtracted.
            if (isExactDivisionRec(remaining - i * denominations[index], denominations, index + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the input password is between the [10,10000] range.
     * @param password2 password to be controlled.
     * @return
     */
    private boolean password2Checker(int password2){
        if(password2 < 0){
            throw new IllegalArgumentException("The password2 can not be a negative number.");
        }
        if( password2 >= 10 && password2 <= 10000){
            return true;
        }
        System.out.println("The password2 is invalid due to not being between 10 and 10000");
        return false;
    }


}



