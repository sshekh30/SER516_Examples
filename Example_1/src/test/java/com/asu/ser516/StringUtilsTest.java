package com.asu.ser516;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * JUnit tests for StringUtils class
 * 
 * Taiga Task: TG-4 - Write Unit Tests for String Utilities
 * Tests verify all string operations work correctly
 */
public class StringUtilsTest {

    private StringUtils stringUtils;

    @Before
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    public void testReverse() {
        // Taiga Issue: TG-4.1 - Test string reversal
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("54321", stringUtils.reverse("12345"));
        assertEquals("", stringUtils.reverse(""));
    }

    @Test
    public void testReverseNull() {
        // Taiga Issue: TG-4.2 - Test reverse with null input
        assertNull(stringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        // Taiga Issue: TG-4.3 - Test palindrome detection
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("A man a plan a canal Panama"));
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindromeNull() {
        // Taiga Issue: TG-4.4 - Test palindrome with null input
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    public void testCountVowels() {
        // Taiga Issue: TG-4.5 - Test vowel counting
        assertEquals(2, stringUtils.countVowels("hello"));
        assertEquals(5, stringUtils.countVowels("aeiou"));
        assertEquals(5, stringUtils.countVowels("AEIOU"));
        assertEquals(0, stringUtils.countVowels("xyz"));
        assertEquals(0, stringUtils.countVowels(""));
    }

    @Test
    public void testCountVowelsNull() {
        // Taiga Issue: TG-4.6 - Test vowel count with null input
        assertEquals(0, stringUtils.countVowels(null));
    }

    @Test
    public void testCapitalizeWords() {
        // Taiga Issue: TG-4.7 - Test word capitalization
        assertEquals("Hello World", stringUtils.capitalizeWords("hello world"));
        assertEquals("The Quick Brown Fox", stringUtils.capitalizeWords("the quick brown fox"));
        assertEquals("A", stringUtils.capitalizeWords("a"));
    }

    @Test
    public void testCapitalizeWordsEmpty() {
        // Taiga Issue: TG-4.8 - Test capitalize with empty string
        assertEquals("", stringUtils.capitalizeWords(""));
    }

    @Test
    public void testCapitalizeWordsNull() {
        // Taiga Issue: TG-4.9 - Test capitalize with null input
        assertNull(stringUtils.capitalizeWords(null));
    }

    @Test
    public void testCountWords() {
        // Taiga Issue: TG-4.10 - Test word counting
        assertEquals(2, stringUtils.countWords("hello world"));
        assertEquals(5, stringUtils.countWords("the quick brown fox jumps"));
        assertEquals(1, stringUtils.countWords("hello"));
        assertEquals(0, stringUtils.countWords(""));
        assertEquals(0, stringUtils.countWords("   "));
    }

    @Test
    public void testCountWordsNull() {
        // Taiga Issue: TG-4.11 - Test word count with null input
        assertEquals(0, stringUtils.countWords(null));
    }

    @Test
    public void testMultipleSpaces() {
        // Taiga Issue: TG-4.12 - Test handling of multiple spaces
        assertEquals(3, stringUtils.countWords("hello    world    test"));
        assertEquals("Hello World Test", stringUtils.capitalizeWords("hello    world    test"));
    }
}
