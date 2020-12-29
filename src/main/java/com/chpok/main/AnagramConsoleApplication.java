package com.chpok.main;
import com.chpok.anagrams.AnagramMaker;

public class AnagramConsoleApplication {

    public static void main(String[] args) {
        AnagramMaker anagramMaker = new AnagramMaker();
        System.out.println(anagramMaker.makeAnagram("a1bcd efg!h af12ge"));
    }

}
