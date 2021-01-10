package com.chpok.anagrams;

public class AnagramMaker {
    
    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validate(sentence);
        
        final String[] words = sentence.split(SPACE_DELIMITER);
        final String[] reversedWords = new String[words.length];
        
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }
        
        return concat(reversedWords);
    }
    
    private void validate(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("The string is null");
        }
        
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("The string contains only spaces or tabs");
        }
    }
    
    private String reverseWord(String word) {       
        char[] symbolsArray = word.toCharArray();
        int startIndex = 0, endIndex = symbolsArray.length - 1;
        
        while (startIndex < endIndex) {
            if (!Character.isAlphabetic(symbolsArray[startIndex])) {
                startIndex++;
                continue;
            }
            if (!Character.isAlphabetic(symbolsArray[endIndex])) {
                endIndex--;
                continue;
            }
            
            swap(symbolsArray, startIndex, endIndex);
            
            startIndex++;
            endIndex--;
        }
        
        return String.valueOf(symbolsArray);
    }
    
    private void swap(char[] symbols, int firstIndex, int secondIndex) {     
        char tempSym = symbols[firstIndex];
        symbols[firstIndex] = symbols[secondIndex];
        symbols[secondIndex] = tempSym;        
    }
    
    private String concat(String[] words) {        
        return String.join(SPACE_DELIMITER, words);
    }
    
}
