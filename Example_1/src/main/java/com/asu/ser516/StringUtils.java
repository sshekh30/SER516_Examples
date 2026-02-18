package com.asu.ser516;

/**
 * String manipulation utility class.
 * 
 * Taiga Task: TG-2 - Implement String Utilities
 * User Story: As a user, I want to perform common string operations
 */
public class StringUtils {

    /**
     * Reverses a string
     * @param input the string to reverse
     * @return reversed string
     */
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Checks if a string is a palindrome
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
    }

    /**
     * Counts the number of vowels in a string
     * @param input the string to analyze
     * @return number of vowels
     */
    public int countVowels(String input) {
        if (input == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Capitalizes the first letter of each word
     * @param input the string to capitalize
     * @return string with each word capitalized
     */
    public String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                result.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    result.append(words[i].substring(1).toLowerCase());
                }
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

    /**
     * Counts word occurrences in a string
     * @param input the string to analyze
     * @return number of words
     */
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }
}
