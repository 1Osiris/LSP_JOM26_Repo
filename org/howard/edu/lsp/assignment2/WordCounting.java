package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// assignment 2

public class WordCounting {
    public static void main(String[] args) throws IOException {

        // initializing variables & objects
        BufferedReader bufferedReader;
        HashMap<String, Integer> wordMap = new HashMap<>();
        Set<Integer> digits;
        File textFile;
        String fileEcho;
        String currLine;
        String[] currLineOfWords;
        String[] allWords = {};
        
           

        // obtaining text file
        textFile = new File("./org/howard/edu/lsp/assignment2/words.txt");

        // creating a Buffered Reader object to read the text file
        bufferedReader = new BufferedReader(new FileReader(textFile));

        // putting all the words in the text file into one large array
        fileEcho = "";
        currLine = "";
        while ((currLine = bufferedReader.readLine()) != null) {
            fileEcho += currLine + "\n";
            currLineOfWords = currLine.split("\\s+");
            allWords = combineArrays(currLineOfWords, allWords);
            
        }
        bufferedReader.close();

        // creating a set of digits to recognize if a caputred word is actually a word or a number
        digits = new HashSet<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        // inserting every word into the dictionary
        for (String word: allWords) {

            // checking if a number is encountered, or if a word is "trivial" 
            if (digits.contains(Character.getNumericValue(word.charAt(0))) || word.length() <= 3) {
                continue;
            }

            /* 
               checking to see if the current word is present in the dictionary. if not then the word is added,
               if so then the word's associated counter is incrimented by one.
            */

            if (wordMap.get(word.toLowerCase()) == null) {
                wordMap.put(word.toLowerCase(), 1);
            } else {
                int num = wordMap.get(word.toLowerCase()) + 1;
                wordMap.replace(word.toLowerCase(), num);
            }
        }


        // preparing formatted output
        System.out.println("Original text: \n" + fileEcho);

        System.out.println("Formatted Output:");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        
    }

    // helper function that combines two arrays into one
    public static String[] combineArrays(String[] arr1, String[] arr2) {

        int aLen = arr1.length;
        int bLen = arr2.length;
        String[] newArr = new String[aLen + bLen];

        System.arraycopy(arr1, 0, newArr, 0, aLen);
        System.arraycopy(arr2, 0, newArr, aLen, bLen);

        return newArr;
    }
}
