package edu.macalester.comp124.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author Shilad Sen
 */
public class TestAllWordsCounter {

    @Test
    public void testInitial() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        assertEquals(0, counter.getCount("bar"));
        assertEquals(0, counter.getCount("baz"));
        assertEquals(0, counter.getNumWords());
    }

    @Test
    public void testIncrement() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0,counter.getCount("foo"));
        counter.count("foo");
        assertEquals(1, counter.getCount("foo"));
        counter.count("foo");
        counter.count("foo");
        counter.count("bar");
        counter.count("bar");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
    }

    @Test
    public void testCaseInsensitive() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        counter.count("foO");
        counter.count("fOo");
        counter.count("fo-o");
        counter.count("bar");
        counter.count("bar!");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
    }



    @Test
    public void testGetAllWords() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        counter.count("foo");
        counter.count("fOo");
        counter.count("fo-o");
        counter.count("bar");
        counter.count("bar!");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
        assertEquals(counter.getAllWords(), new String[] { "foo", "bar"});
    }

}
