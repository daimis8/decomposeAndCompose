import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        //Creating String string so I could read out user's input
        String string1 = "";
        String string2 = "";
        
        //User input using try so it would be safer
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input string to compress it");
            string1 = scanner.nextLine();
            System.out.println("Input string to decompress it");
            string2 = scanner.nextLine();
        }

        System.out.println("Results:");
        supressString(string1);
        System.out.println();
        expandString(string2);
        System.out.println();
        
        
    }

    //1 method supressString
    public static void supressString(String string) {
        /*Two ArrayLists: One for dividing the string to chars, 
        * another one which has CharNumber class type for getting the result.
        */
        ArrayList<Character> stringChar = new ArrayList<>();
        ArrayList<CharNumber> charNumber = new ArrayList<>();
        //count = 1 because when you start for loop there is already one letter which by we check next and next letter
        int count = 1;
        
        //if string is empty we end the proccess and output the empty string otherwise we initialize and divide the string to Char ArrayList
        if(string.isEmpty()){
            System.out.println(string);
            System.exit(0);
        }
        else{
            for (char c : string.toCharArray()) {
                stringChar.add(c);
            }
        }

        /*
         * I use nested for loops so I could go through all the characters of the string
         *  In the first for loop from 0 to size - 1 because i will never get to the end it's not needed 
         * because of j checking the next character
         * That's why the second loop goes from i+1(the next character) to the end of the string
         */
        for (int i = 0; i <= stringChar.size()-1; i++) {
            count = 1;//So everytime there's a new letter count would go back to 1
            for(int j = i+1; j < stringChar.size(); j++){
                if(stringChar.get(i) == stringChar.get(j)) {
                    count++;//Adds 1 to the count because program found two equal symbols
                    i++;//Adds 1 to i because I'm not changing the original ArrayList and other repeating symbols won't be deleted
                }
                else {
                    //if they are not equal we break of the loop
                    break;
                }
            }
            //So when the nested for loop is broken or ended by itself it creates a new class where I hold the letter I need to output and the number of times it repeated
            charNumber.add(new CharNumber(stringChar.get(i), count));
        }
        //Printing out the ArrayList<CharNumber> where the result is held, in the class using toString() method so the answer would be an output and not the adresses of the classes
        for(int i = 0; i < charNumber.size(); i++) {
            System.out.print(charNumber.get(i));
        }
    }

    public static void expandString(String string) {
        int count = 0;
        /*Two ArrayLists: One for dividing the string to chars, 
        * another one which has OnlyChar class type for getting the result.
        */
        ArrayList<Character> stringChar = new ArrayList<>();
        ArrayList<OnlyChar> onlyChar = new ArrayList<>();

        //If string is empty we end the proccess and output the empty string otherwise we initialize and divide the string to Char ArrayList
        if(string.isEmpty()){
            System.out.println(string);
            System.exit(0);
        }
        else{
            for (char c : string.toCharArray()) {
                stringChar.add(c);
            }
        }
        /*
         * For loops:
         * First for loop going through the array 2 spaces per time because we get letter and number and then we move on to next combination
         * Second for loop for creating classes for each letter how many times it has to be output
         */
        for (int i = 0; i < stringChar.size(); i=i+2) {
            count = stringChar.get(i+1) - '0';//Converting char number to int so we could know how many letter we should printout
            for(int j = 0; j < count; j++){
                onlyChar.add(new OnlyChar(stringChar.get(i)));
            }
        }
        //Printing out the results
        for(int i = 0; i < onlyChar.size(); i++) {
            System.out.print(onlyChar.get(i));
        }
    }
}