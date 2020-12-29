package com.chpok.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class AnagramMakerTest {

    private final AnagramMaker anagramMaker = new AnagramMaker();
    
    @Test
    void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceIsNull() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> anagramMaker.makeAnagram(null));
        final String expected = "The string is null";
        final String actual = exception.getMessage();
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceIsEmpty() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> anagramMaker.makeAnagram(""));
        final String expected = "The string is empty";
        final String actual = exception.getMessage();
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldThrowIllegalArgumentExceptionIfSentenceContainsOnlyTabulationSyms() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> anagramMaker.makeAnagram("   "));
        final String expected = "The string contains only spaces or tabs";
        final String actual = exception.getMessage();
       
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithOneNonLetterSym() {
        final String expected = "d1cba";
        final String actual = anagramMaker.makeAnagram("a1bcd");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithOneLetterSym() {
        final String expected = "123a45";
        final String actual = anagramMaker.makeAnagram("123a45");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithTheSameLetterSyms() {
        final String expected = "aaaaa";
        final String actual = anagramMaker.makeAnagram("aaaaa");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithTheSameNonLetterSyms() {
        final String expected = "11111";
        final String actual = anagramMaker.makeAnagram("11111");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithDifferentLetterSyms() {
        final String expected = "edcba";
        final String actual = anagramMaker.makeAnagram("abcde");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithDifferentNonLetterSyms() {
        final String expected = "12345";
        final String actual = anagramMaker.makeAnagram("12345");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsOneWordWithLowAndUpperCasesSyms() {
        final String expected = "eDcBa";
        final String actual = anagramMaker.makeAnagram("aBcDe");
       
        assertThat(actual, is(equalTo(expected)));
    }
   
    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithOnlyLetterSyms() {
        final String expected = "edcba hgf lkji";
        final String actual = anagramMaker.makeAnagram("abcde fgh ijkl");
       
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithOnlyNonLetterSyms() {
        final String expected = "123 4567 893";
        final String actual = anagramMaker.makeAnagram("123 4567 893");
       
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    void makeAnagramShouldReturnReversedSentenceWhenItContainsWordsWithDifferentSyms() {
        final String expected = "d1cba hgf!e eg12fa";
        final String actual = anagramMaker.makeAnagram("a1bcd efg!h af12ge");
       
        assertThat(actual, is(equalTo(expected)));
    }
}
