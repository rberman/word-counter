package edu.macalester.comp124.wordcounter;

import java.util.Set;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;
    SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS];


    /**
     * Counts the number of distinct words.
     * @return
     */
    public int getNumWords() {
        int numWords = 0;
        for (int i = 0; i < MAX_WORDS; i++) {
            if (counters[i] != null) {
                numWords ++;
            }
        }
        return numWords;
    }
	
	/**
	 * Increments the count for the specified word.
     * If the word is new, adds the word to the array and increments it.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if(counters[i].wordMatches(word)) {
                counters[i].incrementCount();
                return;
            }
        }
        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if(counters[i].wordMatches(word)) {
                return counters[i].getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        int n = getNumWords();
        String words[] = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = counters[i].getWord();
        }
        return words;
	}
}
