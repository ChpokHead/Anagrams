package com.chpok.anagrams;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AnagramMakerTest {
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    private final AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    public void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The string is null");
       
        anagramMaker.makeAnagram(null);
    }
    
    @Test
    public void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceIsEmpty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The string is empty");
        
        anagramMaker.makeAnagram("");
    }
    
    @Test
    public void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceContainsOnlyTabulationSyms() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The string contains only spaces or tabs");
        
        anagramMaker.makeAnagram("      ");
    }

    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithOneNonLetterSym() {
        final String expected = "d1cba";
        final String actual = anagramMaker.makeAnagram("a1bcd");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithOneLetterSym() {
        final String expected = "123a45";
        final String actual = anagramMaker.makeAnagram("123a45");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithTheSameLetterSyms() {
        final String expected = "aaaaa";
        final String actual = anagramMaker.makeAnagram("aaaaa");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithTheSameNonLetterSyms() {
        final String expected = "11111";
        final String actual = anagramMaker.makeAnagram("11111");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithDifferentLetterSyms() {
        final String expected = "edcba";
        final String actual = anagramMaker.makeAnagram("abcde");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithDifferentNonLetterSyms() {
        final String expected = "12345";
        final String actual = anagramMaker.makeAnagram("12345");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithLowAndUpperCasesSyms() {
        final String expected = "eDcBa";
        final String actual = anagramMaker.makeAnagram("aBcDe");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithOnlyLetterSyms() {
        final String expected = "edcba hgf lkji";
        final String actual = anagramMaker.makeAnagram("abcde fgh ijkl");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithOnlyNonLetterSyms() {
        final String expected = "123 4567 893";
        final String actual = anagramMaker.makeAnagram("123 4567 893");
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithDifferentSyms() {
        final String expected = "d1cba hgf!e eg12fa";
        final String actual = anagramMaker.makeAnagram("a1bcd efg!h af12ge");
        
        assertEquals(expected, actual);
    }
}
