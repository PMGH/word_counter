package com.example.peter.wordcounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


/**
 * Created by Peter on 06/11/2017.
 */

public class Phrase {

    private String phrase;
    private String[] words;
    private ArrayList<String> lowerCaseWords;
    private int wordCount;
    private HashMap wordsHash;

    public Phrase(String userPhrase) {
        this.phrase = userPhrase;
        removeSpecialCharacters();

        this.words = phrase.split(" ");
        this.lowerCaseWords = new ArrayList<>();
        this.wordCount = 0;
        this.wordsHash = new HashMap<String, Integer>();

        setLowerCaseWords();
        setWordsHash();
        setWordCount();
    }

    // getters
    public int getWordCount() {
        return wordCount;
    }

    public String getWordsHashAsString() {
        return wordsHash.toString();
    }

    public Set getWordsHashAsSet() {
        return wordsHash.entrySet();
    }


    // setters
    public void setWordCount(){
        this.wordCount = calculateWordCount();
    }

    public void setWordsHash(){
        this.wordsHash = calculateWordOccurrences();
    }

    public void setLowerCaseWords(){
        for (String word : words){
            lowerCaseWords.add(word.toLowerCase());
        }
    }


    // other behaviour
    public void removeSpecialCharacters(){
        // help with regex from javarevisited.blogspot and tutorialspoint
        phrase = phrase.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public int calculateWordCount(){
        Integer valuesTotal = 0;
        Collection values = wordsHash.values();
        for (Object value : values){
            valuesTotal += (Integer) value;
        }
        return valuesTotal;
    }

    public HashMap calculateWordOccurrences(){
        for (String word : lowerCaseWords){
            if (wordsHash.containsKey(word)){
                Integer wordsValue = (Integer) wordsHash.get(word);
                wordsHash.put(word, wordsValue+1);
            } else {
                wordsHash.put(word, 1);
            }
        }
        // remove spaces
        if (wordsHash.containsKey("")){
            wordsHash.remove("");
        }
        return wordsHash;
    }

}