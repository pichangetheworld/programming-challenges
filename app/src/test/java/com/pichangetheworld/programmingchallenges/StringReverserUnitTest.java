package com.pichangetheworld.programmingchallenges;

import com.pichangetheworld.programmingchallenges.problems.stringreversal.StringReverser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class StringReverserUnitTest {

    /*
     * {@link StringReverser}:
     *
     * Returns the string input, but backwards
     *
     * e.g. If input = "bon"
     *      --> return "nob"
     *
     * e.g. If input = "onetwothree"
     *      --> return "eerhtowteno"
     *
     * e.g. If input = "aaa"
     *      --> return "aaa"
     *
     * e.g. If input = ""
     *      --> return ""
     */

    StringReverser stringReverser = new StringReverser();

    @Test
    public void caseA_isCorrect() throws Exception {
        String result = stringReverser.reverseString("bon");
        assertEquals(result, "nob");
    }

    @Test
    public void caseB_isCorrect() throws Exception {
        String result = stringReverser.reverseString("onetwothree");
        assertEquals(result, "eerhtowteno");
    }

    @Test
    public void palindrome() throws Exception {
        String result = stringReverser.reverseString("aaa");
        assertEquals(result, "aaa");
    }

    @Test
    public void emptyString() throws Exception {
        String result = stringReverser.reverseString("");
        assertEquals(result, "");
    }
}