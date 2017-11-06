package com.example.peter.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 06/11/2017.
 */

public class PhraseTest {

    Phrase phrase;

    @Before
    public void before(){
        phrase = new Phrase("I know what you did last summer summer");
    }

    @Test
    public void hasWordCount(){
        assertEquals(8, phrase.getWordCount());
    }

    @Test
    public void hasWordsCounts(){
        HashMap testWordsHash = new HashMap();
        testWordsHash.put("i", 1);
        testWordsHash.put("know", 1);
        testWordsHash.put("what", 1);
        testWordsHash.put("you", 1);
        testWordsHash.put("did", 1);
        testWordsHash.put("last", 1);
        testWordsHash.put("summer", 2);

        assertEquals(testWordsHash.toString(), phrase.getWordsHashAsString());
    }
}